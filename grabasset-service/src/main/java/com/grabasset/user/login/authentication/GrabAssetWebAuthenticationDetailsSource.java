package com.grabasset.user.login.authentication;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;

@Component
public class GrabAssetWebAuthenticationDetailsSource extends WebAuthenticationDetailsSource{

	@Override
	public WebAuthenticationDetails buildDetails(HttpServletRequest request) {
		WebAuthenticationDetails authenticationDetails=new GrabAssetWebAuthenticationDetails(request);
		return authenticationDetails;
	}

}
