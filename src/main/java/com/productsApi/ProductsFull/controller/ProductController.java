package com.productsApi.ProductsFull.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productsApi.ProductsFull.model.ProductEntity;
import com.productsApi.ProductsFull.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/{id}")
	public Optional<ProductEntity> findProductById(@PathVariable Long id){
		return productService.findProductById(id);
	}
	
	@GetMapping
	public List<ProductEntity> findAllProducts(){
		return productService.findAllProducts();
	}

	@PostMapping("/create")
	public ProductEntity createProduct(@RequestBody ProductEntity product) {
		return productService.createProduct(product);
	}

	@PutMapping("/update/{id}")
	public ProductEntity updateProduct(@RequestBody ProductEntity product, @PathVariable  Long id) {
		return productService.updateProduct(product, id);
	}

	@DeleteMapping("/{id}")
	public String deleteProductPyId(@PathVariable Long id) {
		return productService.deleteProductPyId(id);
	}

	
}
