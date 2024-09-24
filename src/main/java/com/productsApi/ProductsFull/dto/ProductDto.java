package com.productsApi.ProductsFull.dto;

import com.productsApi.ProductsFull.enums.Category;
import com.productsApi.ProductsFull.model.ProductEntity;

import lombok.Data;

@Data
public class ProductDto {
	
	private Long id;
	private String name;
	private String description;
	private String price;
	private Category category;
	
	public ProductDto() {
		
	}
	
	public ProductDto(ProductEntity entity) {
		
		this.id = entity.getId();
		this.name = entity.getName();
		this.description = entity.getDescription();
		this.price = entity.getPrice();
		this.category = entity.getCategory();
	}
	
	
	
}
