package com.tai06dothe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tai06dothe.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long>{

}
