package com.tai06dothe.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tai06dothe.service.ICategoryService;

@Controller(value = "homeOfWeb")
public class HomeController {
	
	@Autowired
	private ICategoryService categoryService;
	
	@RequestMapping(value = "/trang-chu", method = RequestMethod.GET)
	public String homePage(Model model) {
		model.addAttribute("lstProductOfCategory", categoryService.findAll());
		return "web/home";
	}
	
	@RequestMapping(value = "/account/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView error403() {
		return new ModelAndView("error/403");
	}
	
}
