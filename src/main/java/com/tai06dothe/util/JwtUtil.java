package com.tai06dothe.util;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtUtil {
	public static final Logger LOG = LoggerFactory.getLogger(JwtUtil.class);
	
	private final long expires = System.currentTimeMillis() + 1000L * 60 * 60;
	private final String secret = "martgtu";
	
	public String generateJwtToken(UserDetails userDetails) {
//		SecurityUtil.getPrincipal().getUsername()
		JwtBuilder jwtBuilder = Jwts.builder()
									.setSubject(userDetails.getUsername())
									.setIssuedAt(new Date(System.currentTimeMillis()))
									.setExpiration(new Date(expires))
									.signWith(SignatureAlgorithm.HS256, secret);
		String jwt = jwtBuilder.compact();
		return jwt;
	}
	
	public String getUsernameFromToken(String token) {
		String username = null;
		try {
			JwtParser jwtParser = Jwts.parser().setSigningKey(secret);
			Claims claims = jwtParser.parseClaimsJws(token).getBody();
			username = claims.getSubject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return username;
	}
	
	public Date generateExpirationDate() {
		return new Date(System.currentTimeMillis() + expires);
	}
	
	public boolean validateJwtToken(String token) {
		try {
			Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
			return true;
		} catch (SignatureException e) {
			LOG.error("Invalid JWT signature: {}",e.getMessage());
		} catch (MalformedJwtException e) {
			LOG.error("Invalid JWT token: {}",e.getMessage());
		} catch (ExpiredJwtException e) {
			LOG.error("JWT token is expiried: {}",e.getMessage());
		} catch (UnsupportedJwtException e) {
			LOG.error("JWT token is unsupported: {}",e.getMessage());
		} catch (IllegalArgumentException e) {
			LOG.error("JWT claims string is empty: {}",e.getMessage());
		}
		return false;
	}
}
