package com.grabasset.user.service;

import com.grabasset.user.bo.UserBo;

public interface ManageUserService {

	void registerUser(UserBo userBo);

	boolean isUserNameExists(String userName);

	void activateUser(String activationCode, int userId);

}
