package com.productsApi.ProductsFull.Exceptions;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ApiError {
	
	private int statusCode;
	private String description;
	private LocalDateTime date;
	public ApiError(int statusCode, String description, LocalDateTime date) {
		super();
		this.statusCode = statusCode;
		this.description = description;
		this.date = date;
	}
	
	
	
}
