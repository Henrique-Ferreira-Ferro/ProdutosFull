package com.productsApi.ProductsFull.model;

import com.productsApi.ProductsFull.enums.Category;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Table(name = "Product")
@Entity
public class ProductEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	@NotNull
	@Column(name = "name", length = 200, nullable = false)
	private String name;
	@Column(name = "description", length = 400, nullable = true)
	private String description;
	@NotBlank
	@NotNull
	@Column(name = "price", length = 200, nullable = false)
	private String price;
	
	@Column(name = "category", nullable = false)
	@Enumerated(EnumType.STRING)
	private Category category;
	
	
	
}
