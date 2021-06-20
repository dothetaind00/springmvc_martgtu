package com.tai06dothe.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.tai06dothe.dto.ItemDTO;
import com.tai06dothe.dto.ProductDTO;

public interface ICartService {
	Map<Long, ItemDTO> addToCart(HttpSession session,ProductDTO productDTO,Long id);
}
