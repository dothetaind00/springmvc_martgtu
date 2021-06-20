package com.tai06dothe.dto;

public class ItemDTO extends BaseDTO {

	private BillDTO bill;
	private ProductDTO product;
	private Float price;
	private Integer quantity;
	private Float summoney;

	public BillDTO getOrder() {
		return bill;
	}

	public void setOrder(BillDTO bill) {
		this.bill = bill;
	}

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
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

	public Float getSummoney() {
		return summoney;
	}

	public void setSummoney(Float summoney) {
		this.summoney = summoney;
	}

}
