package com.tai06dothe.jwt.dto;

import java.io.Serializable;

public class JwtResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String jwtToken;
	
	public JwtResponse(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	public String getJwtToken() {
		return jwtToken;
	}
	
}
