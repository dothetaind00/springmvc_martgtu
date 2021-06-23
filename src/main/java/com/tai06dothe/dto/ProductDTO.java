package com.tai06dothe.dto;

import java.util.ArrayList;
import java.util.List;

public class ProductDTO extends BaseDTO {

	private String name;
	private Float price;
	private Integer quantity;
	private Boolean status;
	private CategoryDTO category;
	private SaleDTO sale;
	private List<DetailProductDTO> details = new ArrayList<>();
	private List<ItemDTO> items = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}

	public SaleDTO getSale() {
		return sale;
	}

	public void setSale(SaleDTO sale) {
		this.sale = sale;
	}

	public List<DetailProductDTO> getDetails() {
		return details;
	}

	public void setDetails(List<DetailProductDTO> details) {
		this.details = details;
	}

	public List<ItemDTO> getItems() {
		return items;
	}

	public void setItems(List<ItemDTO> items) {
		this.items = items;
	}

}
