package com.tai06dothe.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.tai06dothe.jwt.JwtAuthenticationEntryPoint;
import com.tai06dothe.jwt.JwtRequestFilter;
import com.tai06dothe.security.CustomAccessDeniedHandler;
import com.tai06dothe.security.CustomAuthSuccessHandler;
import com.tai06dothe.security.CustomLogoutSuccessHandler;

@Configuration
@EnableWebSecurity
public class TestConfigSecurity {
	
	@Autowired
	@Qualifier("userDetailsService")
	private UserDetailsService customUserDetailService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder);
	}
	
	@Configuration
	@Order(1)
	public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter{
		
//		@Autowired
//		@Qualifier("userDetailsService")
//		private UserDetailsService customUserDetailService;
//		
//		@Autowired
//		private PasswordEncoder passwordEncoder;
		
//		@Autowired
//		public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//			auth.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder);
//		}
		
		//JWT
		@Bean
		public JwtRequestFilter jwtRequestFilter() {
			return new JwtRequestFilter();
		}
		
		@Bean
		public JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint() {
			return new JwtAuthenticationEntryPoint();
		}
		
		@Bean
		@Override
		protected AuthenticationManager authenticationManager() throws Exception {
			return super.authenticationManager();
		}
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
				.antMatcher("/api/**")
				.authorizeRequests()
					.antMatchers(HttpMethod.GET, "/api/test").authenticated()
					.antMatchers(HttpMethod.POST, "/api/test-login").permitAll()
				.and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and()
				.exceptionHandling()
					.authenticationEntryPoint(jwtAuthenticationEntryPoint())
				.and()
				.addFilterBefore(jwtRequestFilter(), UsernamePasswordAuthenticationFilter.class);
		}
	}
	
	@Configuration
	public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter{
		
//		@Autowired
//		@Qualifier("userDetailsService")
//		private UserDetailsService customUserDetailService;
		
//		@Autowired
//		private PasswordEncoder passwordEncoder;
		
		@Bean
		public AuthenticationSuccessHandler authSuccessHandler() {
			return new CustomAuthSuccessHandler();
		}
		
		@Bean
		public LogoutSuccessHandler logoutSuccessHandler() {
			return new CustomLogoutSuccessHandler();
		}
		
		@Bean
		public AccessDeniedHandler accessDeniedHandler() {
			return new CustomAccessDeniedHandler();
		}
		
//		@Override
//		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//			auth.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder);
//		}
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http
				.csrf().disable()
				.authorizeRequests()
					.antMatchers(HttpMethod.GET,"/trang-chu","/account/**").permitAll()
					.antMatchers(HttpMethod.GET,"/admin","/thanh-toan").authenticated()
					.antMatchers(HttpMethod.GET,"/admin").hasAuthority("ADMIN")
				.and()
				.formLogin()
					.loginPage("/account/login")
					.loginProcessingUrl("/perform_login")
					.usernameParameter("username")
					.passwordParameter("password")
					.successHandler(authSuccessHandler())
					.failureUrl("/account/login?incorrectAccount")
				.and()
				.logout()
					.logoutUrl("/perform_logout")
					.deleteCookies("JSESSIONID")
					.logoutSuccessHandler(logoutSuccessHandler())
				.and()
					.exceptionHandling()
					.accessDeniedHandler(accessDeniedHandler());
		}
	}
}
