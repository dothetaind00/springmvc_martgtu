package com.tai06dothe.controller.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tai06dothe.dto.ItemDTO;
import com.tai06dothe.dto.ProductDTO;
import com.tai06dothe.service.ICartService;
import com.tai06dothe.service.IProductService;

@Controller(value = "cartOfWeb")
@RequestMapping("cart")
public class CartController {
	
	@Autowired
	private ICartService cartService;
	
	@Autowired
	private IProductService productService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String loadCart(HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		@SuppressWarnings("unchecked")
		Map<Long, ItemDTO> mapItem = (Map<Long, ItemDTO>) session.getAttribute("cart");
		
		Float sum = 0.0f;
		if (mapItem != null) {
			for(Map.Entry<Long, ItemDTO> entry : mapItem.entrySet()) {
				sum += entry.getValue().getSummoney() == null ? 0.0f : entry.getValue().getSummoney();
			}
		}
		
		session.setAttribute("totalQuantity", mapItem.size());
		session.setAttribute("totalMonney", sum);
		
		Boolean isCheckAuth = SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
		if (isCheckAuth) {
			session.setAttribute("requestURI", request.getRequestURI().substring(request.getContextPath().length()));
			//System.out.println(request.getServletPath());
		}
		
		return "web/cart";
	}
	
	@RequestMapping(value = "/add-cart/{id}", method = RequestMethod.GET)
	public String addCart(@PathVariable(value = "id", required = true) Long id, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		ProductDTO productDTO = productService.findOne(id);
		Map<Long, ItemDTO> mapItem = cartService.addToCart(session, productDTO, id);
		session.setAttribute("cart", mapItem);
		
		return "redirect:/cart";
	}
	
}
