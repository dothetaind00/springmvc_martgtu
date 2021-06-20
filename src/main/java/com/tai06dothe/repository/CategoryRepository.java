package com.tai06dothe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tai06dothe.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{
	
	@Query("SELECT c FROM CategoryEntity c")
	List<CategoryEntity> loadMenu();
}
