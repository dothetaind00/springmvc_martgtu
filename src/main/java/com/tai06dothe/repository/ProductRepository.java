package com.tai06dothe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tai06dothe.entity.CategoryEntity;
import com.tai06dothe.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long>{

	List<ProductEntity> findByNameIgnoreCaseContaining(String name);
	
	List<ProductEntity> findByCategory(CategoryEntity categoryEntity);
	
	@Query("SELECT e FROM ProductEntity e WHERE lower(e.name) LIKE lower(concat('%', CONVERT(:search, BINARY) , '%')) ")
    List<ProductEntity> findByName(@Param("search") String search);
	
}
