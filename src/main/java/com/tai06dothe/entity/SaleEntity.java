package com.tai06dothe.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sale")
public class SaleEntity extends BaseEntity{
	
	@Column(name = "salepercent")
	private Integer salePercent;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sale")
	private List<ProductEntity> products = new ArrayList<>();

	public Integer getSalePercent() {
		return salePercent;
	}

	public void setSalePercent(Integer salePercent) {
		this.salePercent = salePercent;
	}

	public List<ProductEntity> getProducts() {
		return products;
	}

	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}
	
}
