package com.productsApi.ProductsFull.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productsApi.ProductsFull.Exceptions.BadRequestException;
import com.productsApi.ProductsFull.model.ProductEntity;
import com.productsApi.ProductsFull.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Optional<ProductEntity> findProductById(Long id){
		var product = productRepository.findById(id);
		if(!product.isPresent()) {
			//throw new ObjectNotFoundException(product.get().getId(), ProductEntity.class.getName());
			throw new ObjectNotFoundException(id, ProductEntity.class.getName());
		}
		return product;
	}
	
	public List<ProductEntity> findAllProducts(){
		return productRepository.findAll();
	}
	
	
	public ProductEntity createProduct(ProductEntity product) {
		if(product.getName().isEmpty() || product.getName().isBlank()) {
			throw new BadRequestException("O nome precisa estar presente!");
		}
		if(product.getPrice() == null || product.getPrice().isBlank()) {
			throw new BadRequestException("O produto precisa ter preço!");
		}
		return productRepository.save(product);
	}
	
	
	public ProductEntity updateProduct(ProductEntity product, Long id) {
		
		if(product.getName().isEmpty() || product.getName().isBlank()) {
            throw new BadRequestException("O nome precisa estar presente!");
		}
		if(product.getPrice() == null || product.getPrice().isBlank()) {
            throw new BadRequestException("O produto precisa ter um preço válido!");
		}
			
		var productAlt = productRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id, ProductEntity.class.getName()));
		
		productAlt.setName(product.getName());
		productAlt.setDescription(product.getDescription());
		productAlt.setCategory(product.getCategory());
		productAlt.setPrice(product.getPrice());
		
		
		return productRepository.save(productAlt);
		
	}
	
	public String deleteProductPyId(Long id) {
		
		var product = productRepository.findById(id);
		
		if(!product.isPresent()) {
			throw new ObjectNotFoundException(id, ProductEntity.class.getName());
		}
		
		productRepository.deleteById(id);
		
		return "Produto: "+ product.get().getName()  +", foi deletado com sucesso";
	}
	
	
	
	
}
