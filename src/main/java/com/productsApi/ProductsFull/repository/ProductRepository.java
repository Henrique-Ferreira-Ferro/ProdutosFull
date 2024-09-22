package com.productsApi.ProductsFull.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productsApi.ProductsFull.model.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long >{

}
