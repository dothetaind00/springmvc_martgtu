package com.tai06dothe.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tai06dothe.dto.BillDTO;
import com.tai06dothe.dto.ItemDTO;
import com.tai06dothe.entity.BillEntity;
import com.tai06dothe.entity.ItemEntity;
import com.tai06dothe.repository.BillRepository;
import com.tai06dothe.repository.ItemRepository;
import com.tai06dothe.repository.ProductRepository;
import com.tai06dothe.repository.UserRepository;
import com.tai06dothe.service.IBillService;
import com.tai06dothe.util.SecurityUtil;

@Service
public class BillService implements IBillService{
	
	@Autowired
	private BillRepository billRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private ProductRepository productRepository;

	@Transactional
	@Override
	public BillDTO saveBill(HttpSession session, BillDTO billDTO) {
		
		BillEntity billEntity = modelMapper.map(billDTO, BillEntity.class);
		
		billEntity.setUser(userRepository.findOneByUserName(SecurityUtil.getPrincipal().getUsername()));
		
		@SuppressWarnings("unchecked")
		Map<Long, ItemDTO> mapItem = (Map<Long, ItemDTO>) session.getAttribute("cart");
		
		if (mapItem != null) {
			List<ItemEntity> items = mapItem.entrySet().stream()
							  								.map(entry -> {
							  									ItemEntity itemEntity = new ItemEntity();
							  									itemEntity = modelMapper.map(entry.getValue(),ItemEntity.class);
							  									itemEntity.setProduct(productRepository.findOne(entry.getValue().getProduct().getId()));
							  									return itemEntity;
							  								})
							  								.collect(Collectors.toList());
			billEntity.setItems(items);
			BillEntity bill = billRepository.save(billEntity);
			
			items.forEach(item -> {
				item.setBill(bill);
				itemRepository.save(item);
			});
			
			mapItem.clear();
			session.setAttribute("cart", mapItem);
			
			return modelMapper.map(bill, BillDTO.class);
		}
		
		return null;
	}

}
