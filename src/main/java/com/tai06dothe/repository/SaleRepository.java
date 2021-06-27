package com.tai06dothe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tai06dothe.entity.SaleEntity;

public interface SaleRepository extends JpaRepository<SaleEntity, Long>{
	
	@Query("SELECT s FROM SaleEntity s")
	List<SaleEntity> loadSales();
	
}
