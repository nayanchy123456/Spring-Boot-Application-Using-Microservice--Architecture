package com.produt_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.produt_service.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
