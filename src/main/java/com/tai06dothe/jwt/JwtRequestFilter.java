package com.tai06dothe.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.tai06dothe.util.JwtUtil;

@Component
public class JwtRequestFilter extends OncePerRequestFilter{
	public static final Logger LOG = LoggerFactory.getLogger(JwtRequestFilter.class);

	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	@Qualifier("userDetailsService")
	private UserDetailsService customUserDetailService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		if (request.getRequestURI().startsWith("/springmvc_martgtu/api")) {
			try {
				String jwt = getJwtFromRequest(request);
				if (StringUtils.hasText(jwt) && jwtUtil.validateJwtToken(jwt)) {
					String username = jwtUtil.getUsernameFromToken(jwt);
					
					if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
						UserDetails userDetails = customUserDetailService.loadUserByUsername(username);
						
						if (jwtUtil.validateJwtToken(jwt)) {
							UsernamePasswordAuthenticationToken authentication = 
									new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
							authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
							
							SecurityContextHolder.getContext().setAuthentication(authentication);
						}
					}
				}
			} catch (Exception e) {
				LOG.error("Failed on set user authentication",e.getMessage());
			}
		}
		filterChain.doFilter(request, response);
	}
	
	private String getJwtFromRequest(HttpServletRequest request) {
		String headerAuth = request.getHeader("Authorization");
		if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7);
        }
        return null;
	}
	
}
