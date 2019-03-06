package com.grabasset.csr.initializer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.grabasset.csr.config.MVCConfig;
import com.grabasset.service.config.RootConfig;

public class GrabassetApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		return new Class<?>[]{RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class<?>[]{MVCConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"*.htm"};
	}

}
