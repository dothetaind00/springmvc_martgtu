package com.tai06dothe.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.tai06dothe.dto.ItemDTO;
import com.tai06dothe.dto.ProductDTO;
import com.tai06dothe.service.ICartService;

@Service
public class CartService implements ICartService{

	@Override
	public Map<Long, ItemDTO> addToCart(HttpSession session, ProductDTO productDTO, Long id) {
		
		@SuppressWarnings("unchecked")
		Map<Long, ItemDTO> mapItem = (Map<Long, ItemDTO>) session.getAttribute("cart");
		if (mapItem == null) {
			mapItem = new HashMap<>();
		}
		if (productDTO != null) {
			if (mapItem.containsKey(id)) {
				ItemDTO item = mapItem.get(id);
				item.setProduct(productDTO);
				item.setPrice(productDTO.getPrice());
				item.setQuantity(item.getQuantity() + 1);
				item.setSummoney(item.getPrice() * item.getQuantity());
				mapItem.put(id, item);
			}else {
				ItemDTO item = new ItemDTO();
				item.setProduct(productDTO);
				item.setPrice(productDTO.getPrice());
				item.setQuantity(1);
				item.setSummoney(item.getPrice() * item.getQuantity());
				mapItem.put(id, item);
			}
		}
		return mapItem;
	}

}
