package com.tai06dothe.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tai06dothe.dto.CategoryDTO;
import com.tai06dothe.entity.CategoryEntity;
import com.tai06dothe.repository.CategoryRepository;
import com.tai06dothe.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Transactional
	@Override
	public List<CategoryDTO> findAll() {
		
		List<CategoryEntity> listEntity = categoryRepository.findAll();
		
		List<CategoryDTO> results = listEntity.stream()
											  .map(category -> modelMapper.map(category, CategoryDTO.class))
											  .collect(Collectors.toList());
		
		return results;
	}

	@Override
	public Map<String, String> loadMenu() {
		
		Map<String, String> result = new HashMap<>();
		List<CategoryEntity> entities = categoryRepository.loadMenu();
		
		for (CategoryEntity item : entities) {
			result.put(item.getCode(),item.getName());
		}
		
		return result;
	}

}
