package com.tai06dothe.service;

import java.util.List;

import com.tai06dothe.dto.ProductDTO;

public interface IProductService {
	ProductDTO findOne(Long id);
	List<ProductDTO> findByName(String name);
	List<ProductDTO> findByCategory(Long id);
}
