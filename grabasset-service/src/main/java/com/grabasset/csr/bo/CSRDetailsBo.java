package com.grabasset.csr.bo;

import com.grabasset.user.bo.UserBo;

public class CSRDetailsBo {
	private UserBo userBo;
	private UserDetailsBo userDetailsBo;
	private AddressBo addressBo;

	public UserBo getUserBo() {
		return userBo;
	}

	public void setUserBo(UserBo userBo) {
		this.userBo = userBo;
	}

	public UserDetailsBo getUserDetailsBo() {
		return userDetailsBo;
	}

	public void setUserDetailsBo(UserDetailsBo userDetailsBo) {
		this.userDetailsBo = userDetailsBo;
	}

	public AddressBo getAddressBo() {
		return addressBo;
	}

	public void setAddressBo(AddressBo addressBo) {
		this.addressBo = addressBo;
	}

}
