package com.tai06dothe.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tai06dothe.dto.ProductDTO;
import com.tai06dothe.entity.ProductEntity;
import com.tai06dothe.repository.ProductRepository;
import com.tai06dothe.service.IProductService;

@Service
public class ProductService implements IProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Transactional
	@Override
	public ProductDTO findOne(Long id) {
		
		ProductEntity productEntity = productRepository.findOne(id);
		
		return modelMapper.map(productEntity,ProductDTO.class);
	}

}
