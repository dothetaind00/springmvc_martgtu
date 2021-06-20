package com.tai06dothe.dto;

import java.util.ArrayList;
import java.util.List;

public class CategoryDTO extends BaseDTO{
	
	private String name;
	private String code;
	private List<ProductDTO> products = new ArrayList<>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<ProductDTO> getProducts() {
		return products;
	}
	public void setProducts(List<ProductDTO> products) {
		this.products = products;
	}
	
}
