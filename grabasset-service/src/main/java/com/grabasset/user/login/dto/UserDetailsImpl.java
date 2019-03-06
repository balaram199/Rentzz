package com.grabasset.user.login.dto;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 1L;

	protected String username;
	protected String password;
	protected List<GrantedAuthority> authorities;
	protected boolean enabled;
	protected boolean locked;
	protected int roleId;
	protected String roleCode;

	public UserDetailsImpl(String username, String password, String status, int roleId) {
		this.username = username;
		this.password = password;
		this.roleId = roleId;
		this.roleCode = getRoleById(roleId);
		authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(roleCode));
		if (status != null) {
			if (status.equals("a")) {
				enabled = true;
			} else if (status.equals("l")) {
				locked = true;
			}
		}

	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return !locked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}
	private String getRoleById(int roleId) {
		String roleCode=null;
		if(roleId == 1) {
			roleCode="adm";
		}else if(roleId == 2) {
			roleCode="csr";
		}else if(roleId == 3) {
			roleCode="mer";
		}
		return roleCode;
	}
}
