package com.grabasset.user.mapper;

import org.springframework.stereotype.Component;

import com.grabasset.user.bo.UserBo;
import com.grabasset.user.registration.form.RegistrationForm;

@Component
public class UserMapper {

	public UserBo mapUserFormToUserBo(RegistrationForm form) {
		UserBo userBo = null;

		userBo = new UserBo();
		userBo.setFirstName(form.getFirstName());
		userBo.setLastName(form.getLastName());
		userBo.setMobileNo(form.getMobileNo());
		userBo.setUserName(form.getUserName());
		userBo.setPassword(form.getPassword());

		return userBo;
	}
}
