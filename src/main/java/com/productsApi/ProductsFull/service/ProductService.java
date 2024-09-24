package com.productsApi.ProductsFull.service;

import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productsApi.ProductsFull.Exceptions.BadRequestException;
import com.productsApi.ProductsFull.dto.ProductDto;
import com.productsApi.ProductsFull.model.ProductEntity;
import com.productsApi.ProductsFull.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public ProductDto findProductById(Long id){
		var product = productRepository.findById(id);
		if(!product.isPresent()) {
			//throw new ObjectNotFoundException(product.get().getId(), ProductEntity.class.getName());
			throw new ObjectNotFoundException(id, ProductEntity.class.getName());
		}
		
		ProductDto productDto = new ProductDto(product.get());
		
		return productDto;
	}
	
	public List<ProductDto> findAllProducts(){
	    var productEntities = productRepository.findAll();
	    // Converte lista de entidades para lista de DTOs
	    return productEntities.stream().map(ProductDto::new).toList();
	}

	
	
	public ProductDto createProduct(ProductDto productDto) {
		if(productDto.getName() == null || productDto.getName().isBlank()) {
			throw new BadRequestException("O nome precisa estar presente!");
		}
		if(productDto.getPrice() == null || productDto.getPrice().isBlank()) {
			throw new BadRequestException("O produto precisa ter preço!");
		}
		
		if(productDto.getCategory() == null) {
			throw new BadRequestException("Insira a categoria do produto!");
		}
		
		ProductEntity productEntity = new ProductEntity(productDto);
	    ProductEntity savedProduct = productRepository.save(productEntity);

		
		return new ProductDto(savedProduct);
	}
	
	
	public ProductDto updateProduct(ProductDto productDto, Long id) {
		
		if(productDto.getName().isBlank()) {
            throw new BadRequestException("O nome precisa estar presente!");
		}
		if(productDto.getPrice() == null || productDto.getPrice().isBlank()) {
            throw new BadRequestException("O produto precisa ter um preço válido!");
		}
			
		var productAlt = productRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, ProductEntity.class.getName()));
		
		productAlt.setName(productDto.getName());
		productAlt.setDescription(productDto.getDescription());
		productAlt.setCategory(productDto.getCategory());
		productAlt.setPrice(productDto.getPrice());
		
		ProductEntity updateProduct = productRepository.save(productAlt);
		
		return new ProductDto(updateProduct);
		
	}
	
	public String deleteProductPyId(Long id) {
		
		var product = productRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, ProductEntity.class.getName()));
		
		
		
		productRepository.deleteById(id);
		
		return "Produto: "+ product.getName()  +", foi deletado com sucesso";
	}
	
	
	
	
}
