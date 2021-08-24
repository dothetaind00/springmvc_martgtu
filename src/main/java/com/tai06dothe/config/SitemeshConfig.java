package com.tai06dothe.config;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

public class SitemeshConfig extends ConfigurableSiteMeshFilter {

	@Override
	protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
		builder.addDecoratorPath("/*", "/decorators/web.jsp")
				.addDecoratorPath("/admin*", "/decorators/admin.jsp")
				.addDecoratorPath("/account/**", "/decorators/account.jsp")
				.addExcludedPath("/api/**");
	}

}
