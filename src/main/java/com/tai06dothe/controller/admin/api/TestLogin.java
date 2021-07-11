package com.tai06dothe.controller.admin.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tai06dothe.jwt.dto.JwtRequest;
import com.tai06dothe.jwt.dto.JwtResponse;
import com.tai06dothe.util.JwtUtil;

@RestController
@RequestMapping(value = "api")
public class TestLogin {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	@Qualifier("userDetailsService")
	private UserDetailsService customUserDetailService;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String getString() {
		return "Do The Tai";
	}

	@PostMapping("/test-login")
	public ResponseEntity<?> loadLogin(@RequestBody JwtRequest jwtRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}

		final UserDetails userDetails = customUserDetailService.loadUserByUsername(jwtRequest.getUsername());
		final String token = jwtUtil.generateJwtToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}
	
}
