package com.tai06dothe.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller(value = "homeOfAdmin")
public class HomeController {

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String homeAdmin() {
		return "admin/home";
	}
	
}
