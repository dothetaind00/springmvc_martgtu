package com.tai06dothe.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.tai06dothe.security.CustomAccessDeniedHandler;
import com.tai06dothe.security.CustomAuthSuccessHandler;
import com.tai06dothe.security.CustomLogoutSuccessHandler;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	@Qualifier("userDetailsService")
	private UserDetailsService customUserDetailService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
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
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/trang-chu","/account/**").permitAll()
				.antMatchers("/admin","/thanh-toan").authenticated()
				.antMatchers("/admin").hasAuthority("ADMIN")
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
				.csrf().disable()
				.exceptionHandling()
				.accessDeniedHandler(accessDeniedHandler());
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/template/**");
	}
	
}
