package com.tai06dothe.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.tai06dothe.dto.ProductDTO;

public interface IProductService {
	List<ProductDTO> findAll(Pageable pageable);

	ProductDTO findOne(Long id);

	List<ProductDTO> findByName(String name);

	List<ProductDTO> findByCategory(Long id);

	Integer getTotalItem();
	
	ProductDTO save(ProductDTO productDTO);
}
