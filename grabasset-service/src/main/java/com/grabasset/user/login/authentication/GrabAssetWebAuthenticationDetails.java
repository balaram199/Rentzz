
package com.grabasset.user.login.authentication;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.WebAuthenticationDetails;

public class GrabAssetWebAuthenticationDetails extends WebAuthenticationDetails{
	private static final long serialVersionUID = 1L;

	private String source;
	
	public GrabAssetWebAuthenticationDetails(HttpServletRequest request) {
		super(request);
		this.source=request.getParameter("source");
	}
	public String getSource() {
		return source;
	}
	

}
