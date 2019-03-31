package com.wegift.admin.initializer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.wegift.support.config.RootConfig;
import com.wegift.support.config.ServletConfig;

public class WegiftAdminInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { RootConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { ServletConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "*.htm", "*.json" };
	}

}
