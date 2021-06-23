package com.tai06dothe.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tai06dothe.service.IProductService;

@Controller(value = "productOfWeb")
@RequestMapping("product")
public class ProductController {
	
	@Autowired
	private IProductService productService;
	
	@RequestMapping(value = "/product-detail/{id}", method = RequestMethod.GET)
	public String productDetail(@PathVariable(value = "id", required = true) Long id, Model model) {
		
		model.addAttribute("product", productService.findOne(id));
		
		return "web/productdetail";
	}
	
	@RequestMapping(value = "/list-product", method = RequestMethod.GET)
	public String productsPage() {
		return "web/products";
	}
	
	@RequestMapping(value = "/products-of-catgory/{id}", method = RequestMethod.GET)
	public String productsOfCategory(@PathVariable(value = "id", required = true) Long id ,Model model) {
		
		model.addAttribute("products", productService.findByCategory(id));
		
		return "forward:/product/list-product";
	}
	
}
