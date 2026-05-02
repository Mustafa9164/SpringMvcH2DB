package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

}
