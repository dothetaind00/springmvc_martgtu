package com.tai06dothe.service;

import java.util.List;
import java.util.Map;

import com.tai06dothe.dto.CategoryDTO;

public interface ICategoryService {
	List<CategoryDTO> findAll();
	Map<Long, String> loadMenu();
}
