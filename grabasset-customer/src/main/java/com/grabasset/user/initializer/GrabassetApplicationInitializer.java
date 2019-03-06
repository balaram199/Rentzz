package com.grabasset.user.initializer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.grabasset.service.config.GrabassetSecurityConfig;
import com.grabasset.service.config.RootConfig;
import com.grabasset.user.config.MVCConfig;

public class GrabassetApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {

		return new Class<?>[] { RootConfig.class,GrabassetSecurityConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {

		return new Class<?>[] { MVCConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "*.htm" };
	}

}
