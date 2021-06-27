package com.tai06dothe.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tai06dothe.dto.ProductDTO;
import com.tai06dothe.service.IProductService;
import com.tai06dothe.service.ISaleService;

@Controller(value = "productOfAdmin")
@RequestMapping("admin")
public class ProductController {
	
	@Autowired
	private IProductService productService;
	
	@Autowired
	private ISaleService saleService;
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String loadAllProduct(@RequestParam(value = "page", defaultValue = "1",required = false) Integer page, 
								@RequestParam(value = "limit", defaultValue = "10", required = false) Integer limit,
								@RequestParam(value = "sortName", defaultValue = "name", required = false) String sortName, 
								@RequestParam(value = "sortBy", defaultValue = "asc", required = false) String sortBy,
								Model model) {
		
		ProductDTO productDTO = new ProductDTO();
		productDTO.setPage(page);
		productDTO.setLimit(limit);
		productDTO.setTotalItem(productService.getTotalItem());
		productDTO.setTotalPage((int)Math.ceil((double)productDTO.getTotalItem()/productDTO.getLimit()));
		
		Pageable pageable = new PageRequest(page -1, limit, new Sort(sortBy.equals("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortName));
		productDTO.setListResult(productService.findAll(pageable));
		
		model.addAttribute("product", productDTO);
		
		return "admin/product/list";
	}
	
	@RequestMapping(value = "/edit-product/{id}", method = RequestMethod.GET)
	public String loadEditProduct(@PathVariable(value = "id", required = false) Long id, Model model) {
		
		if (id != null) {
			model.addAttribute("product", productService.findOne(id));
		}
		model.addAttribute("sales", saleService.loadSales());
		return "admin/product/edit";
	}
	
}
