package com.productsApi.ProductsFull.enums;

public enum Category {
	ACESSORIO("Acessorio"),
	MODA("Moda"),
	ELETRONICOS("Eletronicos"),
	CASA("Casa"),
	ESPORTE("Esporte");
	
	private String category;
	
	Category(String category) {
		this.category = category;
	}

	public String getCategory() {
		return category;
	}
	
	
	
}
