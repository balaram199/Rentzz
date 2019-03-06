package com.grabasset.user.login.provider;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.grabasset.user.login.service.UserDetailsServiceImpl;

@Component
public class AuthenticationProviderImpl implements AuthenticationProvider {

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String userName = null;
		String password = null;

		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
		userName = token.getName();
		UserDetails user = userDetailsService.loadUserByUsername(userName);
		System.out.println(token.getDetails());

		System.out.println(userName+"   "+user.getUsername());
		
/*		if (userName == null || !user.getUsername().equalsIgnoreCase(userName)) {
			throw new GrabassetBadCredentialsException("credential is not correct");
		}
*/
		password = (String) token.getCredentials();
		/*if (!user.getPassword().equals(password)) {
			throw new GrabassetBadCredentialsException("credential is not correct");
		}*/
		System.out.println(password+"  "+user.getPassword());

		Collection<? extends GrantedAuthority> authorities = token.getAuthorities();
		System.out.println(authorities+"  "+user.getAuthorities());

		return new UsernamePasswordAuthenticationToken(userName, password, authorities);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
