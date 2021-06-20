package com.tai06dothe.dto;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class DetailProductDTO {

	private Long id;
	private String image;
	private CommonsMultipartFile[] imageFiles;
	private String description;
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
	
	public CommonsMultipartFile[] getImageFiles() {
		return imageFiles;
	}

	public void setImageFiles(CommonsMultipartFile[] imageFiles) {
		this.imageFiles = imageFiles;
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
