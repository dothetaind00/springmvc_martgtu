package com.tai06dothe.config;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializeConfig implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		createAppRootContext(servletContext, context);
		addSitemeshFilterToServletContext(servletContext);
		registerDispatcherServlet(servletContext, context);
	}

	private void createAppRootContext(ServletContext servletContext,AnnotationConfigWebApplicationContext context) {
		context.register(WebAppConfig.class);
		context.setServletContext(servletContext);
		servletContext.addListener(new ContextLoaderListener(context));
	}
	
	private void addSitemeshFilterToServletContext(ServletContext servletContext) {
		FilterRegistration.Dynamic sitemesh = servletContext.addFilter("sitemesh", new SitemeshConfig());
		EnumSet<DispatcherType> sitemeshDispatcherTypes = EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD);
		sitemesh.addMappingForUrlPatterns(sitemeshDispatcherTypes, true, "/*");
	}
	
	private void registerDispatcherServlet(ServletContext servletContext,AnnotationConfigWebApplicationContext context) {
		ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
	}
}
