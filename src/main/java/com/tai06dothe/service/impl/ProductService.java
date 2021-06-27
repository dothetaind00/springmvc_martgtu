package com.tai06dothe.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tai06dothe.dto.CategoryDTO;
import com.tai06dothe.dto.DetailProductDTO;
import com.tai06dothe.dto.ProductDTO;
import com.tai06dothe.dto.SaleDTO;
import com.tai06dothe.entity.CategoryEntity;
import com.tai06dothe.entity.DetailProductEntity;
import com.tai06dothe.entity.ProductEntity;
import com.tai06dothe.entity.SaleEntity;
import com.tai06dothe.repository.CategoryRepository;
import com.tai06dothe.repository.DetailProductRepository;
import com.tai06dothe.repository.ProductRepository;
import com.tai06dothe.repository.SaleRepository;
import com.tai06dothe.service.IProductService;

@Service
public class ProductService implements IProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private DetailProductRepository detailProductRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private SaleRepository saleRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Transactional
	@Override
	public List<ProductDTO> findAll(Pageable pageable) {
		List<ProductEntity> listEntity = productRepository.findAll(pageable).getContent();
		
		List<ProductDTO> results = listEntity.stream()
											.map(entity -> {
												ProductDTO productDTO = new ProductDTO();
												productDTO.setId(entity.getId());
												productDTO.setName(entity.getName());
												productDTO.setPrice(entity.getPrice());
												productDTO.setQuantity(entity.getQuantity());
												
												CategoryDTO categoryDTO = new CategoryDTO();
												categoryDTO.setId(entity.getCategory().getId());
												categoryDTO.setCode(entity.getCategory().getCode());
												categoryDTO.setName(entity.getCategory().getName());
												productDTO.setCategory(categoryDTO);
												
												SaleDTO saleDTO = new SaleDTO();
												saleDTO.setId(entity.getSale().getId());
												productDTO.setSale(saleDTO);
												
												List<DetailProductDTO> details = entity.getDetails().stream()
																						.map(detail -> {
																							return modelMapper.map(detail, DetailProductDTO.class);
																						}).collect(Collectors.toList());
												productDTO.setDetails(details);
												return productDTO;
											}).collect(Collectors.toList());
		return results;
	}
	
	@Transactional
	@Override
	public ProductDTO findOne(Long id) {
		
		ProductEntity productEntity = productRepository.findOne(id);
		
		return modelMapper.map(productEntity,ProductDTO.class);
	}

	@Transactional
	@Override
	public List<ProductDTO> findByName(String name) {
		if (name != null && name.length() > 0) {
			String[] keywords = name.split(" ");
			Set<ProductEntity> setEntity = new HashSet<>();
			
			for (String str : keywords) {
				productRepository.findByName(str).stream()
												  .map(product -> {
													  setEntity.add(product);
													  return null;
												  }).collect(Collectors.toList());
			}
			List<ProductDTO> results = setEntity.stream()
												 .map(entity -> {
													 return toDTO(entity);
												 }).collect(Collectors.toList());
			return results;
		}
		return null;
	}

	@Transactional
	@Override
	public List<ProductDTO> findByCategory(Long id) {
		
		CategoryEntity categoryEntity = categoryRepository.findOne(id);
		
		List<ProductEntity> listEntity = productRepository.findByCategory(categoryEntity);
		
		List<ProductDTO> results = listEntity.stream()
											.map(entity -> {
												return toDTO(entity);
											}).collect(Collectors.toList());

		return results;
	}

	@Override
	public Integer getTotalItem() {
		return (int) productRepository.count();
	}
	
	@Transactional
	@Override
	public ProductDTO save(ProductDTO productDTO) {
		
		CategoryEntity categoryEntity = categoryRepository.findOne(productDTO.getCategory().getId());
		SaleEntity saleEntity = saleRepository.findOne(productDTO.getSale().getId());
		ProductEntity productEntity = new ProductEntity();
		
		if (productDTO.getId() != null) {
			ProductEntity productEntityOld = productRepository.findOne(productDTO.getId());
			productEntityOld.setCategory(categoryEntity);
			productEntityOld.setSale(saleEntity);
			productEntity = toEntity(productEntityOld, productDTO);
			
			DetailProductEntity detailProductEntity = detailProductRepository.findOne(productDTO.getDetails().get(0).getId());
			detailProductEntity.setImage("upload/thumbnail/"+productDTO.getDetails().get(0).getImage());
			detailProductRepository.save(detailProductEntity);
		}
		
		return modelMapper.map(productRepository.save(productEntity),ProductDTO.class);
	}
	
	private ProductDTO toDTO(ProductEntity entity) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(entity.getId());
		productDTO.setName(entity.getName());
		productDTO.setPrice(entity.getPrice());
		productDTO.setQuantity(entity.getQuantity());
		List<DetailProductDTO> details = entity.getDetails().stream()
												.map(detail -> {
													return modelMapper.map(detail, DetailProductDTO.class);
												}).collect(Collectors.toList());
		productDTO.setDetails(details);
		return productDTO;
	}
	
	private ProductEntity toEntity(ProductEntity productEntity,ProductDTO productDTO) {
		productEntity.setName(productDTO.getName());
		productEntity.setPrice(productDTO.getPrice());
		productEntity.setQuantity(productDTO.getQuantity());
		productEntity.setStatus(productDTO.getStatus());
//		List<DetailProductEntity> details = productDTO.getDetails().stream()
//																	.map(dto -> {
//																		DetailProductEntity entity = new DetailProductEntity();
//																		entity = modelMapper.map(dto, DetailProductEntity.class);
//																		entity.setImage("upload/thumbnail/"+dto.getImage());
//																		return entity;
//																	}).collect(Collectors.toList());
//		productEntity.setDetails(details);
		return productEntity;
	}

}
