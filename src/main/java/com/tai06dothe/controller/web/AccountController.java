package com.tai06dothe.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tai06dothe.dto.UserDTO;
import com.tai06dothe.service.IUserService;

@Controller(value = "accountOfWeb")
@RequestMapping("account")
public class AccountController {
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerPage(Model model) {
		model.addAttribute("user", new UserDTO());
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") UserDTO user) {
		
		userService.save(user);
		
		return "login";
	}
	
}
