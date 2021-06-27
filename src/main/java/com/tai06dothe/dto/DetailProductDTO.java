package com.tai06dothe.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class DetailProductDTO {

	private Long id;
	private String image;
	private String base64;
	private String description;
	@JsonIgnore
	private ProductDTO product;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public String getBase64() {
		if (base64 != null) {
			return base64.split(",")[1];
		}
		return null;
	}

	public void setBase64(String base64) {
		this.base64 = base64;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

}
