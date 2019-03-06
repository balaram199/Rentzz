package com.grabasset.csr.mapper;

import com.grabasset.csr.bo.AddressBo;
import com.grabasset.csr.bo.CSRDetailsBo;
import com.grabasset.csr.bo.UserDetailsBo;
import com.grabasset.csr.form.CSRRegistrationForm;

import org.springframework.stereotype.Component;

import com.grabasset.user.bo.UserBo;

@Component
public class CSRMapper {

	public CSRDetailsBo mapCSRFormToCsrDetailsBo(CSRRegistrationForm form) {
		CSRDetailsBo csrDetailsBo = null;
		csrDetailsBo = new CSRDetailsBo();

		csrDetailsBo.setAddressBo(mapCsrFormToAddressBo(form));
		csrDetailsBo.setUserBo(mapCsrFormToUserBo(form));
		csrDetailsBo.setUserDetailsBo(mapCsrFormUserDetailsBo(form));

		return csrDetailsBo;
	}

	private UserBo mapCsrFormToUserBo(CSRRegistrationForm form) {
		UserBo userbo = new UserBo();
		userbo.setFirstName(form.getFirstName());
		userbo.setLastName(form.getLastName());
		userbo.setMobileNo(form.getMobileNo());
		userbo.setUserName(form.getUserName());
		userbo.setPassword(form.getPassword());

		return userbo;
	}

	private AddressBo mapCsrFormToAddressBo(CSRRegistrationForm form) {
		AddressBo addressBo = null;
		addressBo = new AddressBo();

		addressBo.setAddressLine1(form.getPlotNo());
		addressBo.setAddressLine2(form.getStreet());
		addressBo.setCity(form.getCity());
		addressBo.setState(form.getState());
		addressBo.setZip(form.getZip());
		addressBo.setCountry(form.getCountry());
		return addressBo;
	}

	private UserDetailsBo mapCsrFormUserDetailsBo(CSRRegistrationForm form) {
		UserDetailsBo userDetailsBo = null;
		userDetailsBo = new UserDetailsBo();

		userDetailsBo.setIdentificationNo(form.getIdentificationNo());
		userDetailsBo.setIdentifictionType(form.getIdentificationType());
		return userDetailsBo;
	}
}
