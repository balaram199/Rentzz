package com.grabasset.user.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.grabasset.user.bo.UserBo;
import com.grabasset.user.dao.UserDao;
import com.grabasset.user.login.dto.UserDetailsImpl;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		UserBo userBo = null;

		userBo = userDao.findAuthenticatedUser(userName);

		UserDetails userDetails = new UserDetailsImpl(userBo.getUserName(), userBo.getPassword(), userBo.getStatus(),
				userBo.getRoleId());

		return userDetails;
	}

}
