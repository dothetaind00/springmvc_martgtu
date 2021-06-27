package com.tai06dothe.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class SaleDTO extends BaseDTO<SaleDTO> {

	private Integer salePercent;
	@JsonIgnore
	private List<ProductDTO> products = new ArrayList<>();

	public Integer getSalePercent() {
		return salePercent;
	}

	public void setSalePercent(Integer salePercent) {
		this.salePercent = salePercent;
	}

	public List<ProductDTO> getProducts() {
		return products;
	}

	public void setProducts(List<ProductDTO> products) {
		this.products = products;
	}

}
