package com.productsApi.ProductsFull.dto;

import com.productsApi.ProductsFull.enums.Category;

import lombok.Data;

@Data
public class ProductDto {
	
	private Long id;
	private String name;
	private String description;
	private String price;
	private Category category;
	
}
