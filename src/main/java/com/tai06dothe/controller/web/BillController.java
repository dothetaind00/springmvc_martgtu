package com.tai06dothe.controller.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tai06dothe.dto.BillDTO;
import com.tai06dothe.service.IBillService;

@Controller(value = "billOfWeb")
@RequestMapping("thanh-toan")
public class BillController {
	
	@Autowired
	private IBillService billService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String billForm(Model model) {
		
		model.addAttribute("bill", new BillDTO());
		
		return "web/checkout";
	}
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String billForm(HttpServletRequest request, @ModelAttribute("billDTO") BillDTO billDTO) {
		
		HttpSession session = request.getSession(false);
		if (session != null) {
			billService.saveBill(session,billDTO);
		}
		
		return "web/checkout";
	}
	
}
