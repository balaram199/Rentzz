package com.grabasset.user.dao;

import com.grabasset.csr.bo.AddressBo;
import com.grabasset.user.bo.UserBo;

public interface UserDao {

	int saveUser(UserBo userBo);

	boolean isUserNameExists(String userName);

	UserBo getUser(int userId);

	boolean updateUserStatus(UserBo userBo);

	int getRole(String roleCode);

	int saveAddress(AddressBo addressBo);
	
	UserBo findAuthenticatedUser(String userName);
}
