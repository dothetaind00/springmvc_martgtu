package com.tai06dothe.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tai06dothe.dto.DetailProductDTO;
import com.tai06dothe.dto.ProductDTO;
import com.tai06dothe.entity.CategoryEntity;
import com.tai06dothe.entity.ProductEntity;
import com.tai06dothe.repository.CategoryRepository;
import com.tai06dothe.repository.ProductRepository;
import com.tai06dothe.service.IProductService;

@Service
public class ProductService implements IProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Transactional
	@Override
	public ProductDTO findOne(Long id) {
		
		ProductEntity productEntity = productRepository.findOne(id);
		
		return modelMapper.map(productEntity,ProductDTO.class);
	}

	@Transactional
	@Override
	public List<ProductDTO> findByName(String name) {
		if (name != null && name.length() > 0) {
			String[] keywords = name.split(" ");
			Set<ProductEntity> setEntity = new HashSet<>();
			
			for (String str : keywords) {
				productRepository.findByName(str).stream()
												  .map(product -> {
													  setEntity.add(product);
													  return null;
												  }).collect(Collectors.toList());
			}
			List<ProductDTO> results = setEntity.stream()
												 .map(entity -> {
													ProductDTO productDTO = new ProductDTO();
													productDTO.setId(entity.getId());
													productDTO.setName(entity.getName());
													productDTO.setPrice(entity.getPrice());
													productDTO.setQuantity(entity.getQuantity());
													List<DetailProductDTO> details = entity.getDetails().stream()
																							.map(detail -> {
																								return modelMapper.map(detail, DetailProductDTO.class);
																							}).collect(Collectors.toList());
													productDTO.setDetails(details);
													return productDTO;
												 }).collect(Collectors.toList());
			return results;
		}
		return null;
	}

	@Transactional
	@Override
	public List<ProductDTO> findByCategory(Long id) {
		
		CategoryEntity categoryEntity = categoryRepository.findOne(id);
		
		List<ProductEntity> listEntity = productRepository.findByCategory(categoryEntity);
		
		List<ProductDTO> results = listEntity.stream()
											.map(entity -> {
												ProductDTO productDTO = new ProductDTO();
												productDTO.setId(entity.getId());
												productDTO.setName(entity.getName());
												productDTO.setPrice(entity.getPrice());
												productDTO.setQuantity(entity.getQuantity());
												List<DetailProductDTO> details = entity.getDetails().stream()
																						.map(detail -> {
																							return modelMapper.map(detail, DetailProductDTO.class);
																						}).collect(Collectors.toList());
												productDTO.setDetails(details);
												return productDTO;
											}).collect(Collectors.toList());

		return results;
	}

}
