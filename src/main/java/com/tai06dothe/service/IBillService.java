package com.tai06dothe.service;

import javax.servlet.http.HttpSession;

import com.tai06dothe.dto.BillDTO;

public interface IBillService {
	
	BillDTO saveBill(HttpSession session, BillDTO billDTO);
	
}
