package com.tai06dothe.service;

import com.tai06dothe.dto.ProductDTO;

public interface IProductService {
	ProductDTO findOne(Long id);
}
