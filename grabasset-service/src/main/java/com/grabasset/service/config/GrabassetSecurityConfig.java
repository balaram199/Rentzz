package com.grabasset.service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.grabasset.user.login.authentication.GrabAssetWebAuthenticationDetailsSource;
import com.grabasset.user.login.provider.AuthenticationProviderImpl;
import com.grabasset.user.login.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = { "com.grabasset.user.login.provider", "com.grabasset.user.login.service",
		"com.grabasset.user.login.authentication" })
public class GrabassetSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthenticationProviderImpl authenticationProvider;

	@Autowired
	private GrabAssetWebAuthenticationDetailsSource authenticationDetailsSource;

	@Autowired
	private UserDetailsServiceImpl userDetailsSerivce;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider).userDetailsService(userDetailsSerivce);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/user-login.htm").failureUrl("/user-login.htm?error").loginProcessingUrl("/grabasset-process-login.htm")
		.usernameParameter("j_username").passwordParameter("j_password").authenticationDetailsSource(authenticationDetailsSource)
		.and()
		.logout().invalidateHttpSession(true).logoutSuccessUrl("/logout.htm").and().csrf().disable();
	}

}
