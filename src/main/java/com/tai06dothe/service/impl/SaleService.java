package com.tai06dothe.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tai06dothe.entity.SaleEntity;
import com.tai06dothe.repository.SaleRepository;
import com.tai06dothe.service.ISaleService;

@Service
public class SaleService implements ISaleService{

	@Autowired
	private SaleRepository saleRepository;

	@Override
	public Map<Long, Integer> loadSales() {
		
		Map<Long, Integer> results = new HashMap<>();
		
		for(SaleEntity sale : saleRepository.loadSales()) {
			results.put(sale.getId(), sale.getSalePercent());
		}
		
		return results;
	}
	
}
