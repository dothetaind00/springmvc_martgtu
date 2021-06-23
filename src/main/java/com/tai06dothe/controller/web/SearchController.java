package com.tai06dothe.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tai06dothe.service.IProductService;

@Controller(value = "searchOfWeb")
public class SearchController {
	
	@Autowired
	private IProductService productService;
	
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String postSearchPage(@RequestParam(name = "name") String name, Model model) {
		
		model.addAttribute("products", productService.findByName(name));
		
		return "web/products";
	}
	
}
