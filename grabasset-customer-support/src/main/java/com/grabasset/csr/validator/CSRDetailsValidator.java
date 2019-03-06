
package com.grabasset.csr.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;

import com.grabasset.csr.form.CSRRegistrationForm;
import com.grabasset.user.service.ManageUserService;

import com.grabasset.util.GrabAssetValidator;

public class CSRDetailsValidator implements Validator {

	@Autowired
	private ManageUserService manageUserService;

	@Override
	public boolean supports(Class<?> clazz) {

		if (clazz.isAssignableFrom(CSRRegistrationForm.class)) {

			return true;
		}
		return false;

	}

	@Override
	public void validate(Object obj, Errors err) {
		CSRRegistrationForm addCSRForm = null;
		addCSRForm = (CSRRegistrationForm) obj;
		if (GrabAssetValidator.isEmpty(addCSRForm.getFirstName())) {
			err.rejectValue("firstName", "blank");
		}
		if (GrabAssetValidator.isEmpty((addCSRForm.getLastName()))) {
			err.rejectValue("lastName", "blank");
		}
		if (GrabAssetValidator.isEmpty((addCSRForm.getMobileNo()))) {
			err.rejectValue("MobileNo", "blank");
		}
		if (GrabAssetValidator.isEmpty(addCSRForm.getUserName())) {
			err.rejectValue("userName", "blank");
		} else if (!GrabAssetValidator.validateEmail(addCSRForm.getUserName())) {
			err.rejectValue("userName", "userName.format");
		} else if (manageUserService.isUserNameExists(addCSRForm.getUserName())) {
			err.rejectValue("userName", "userName.exists");
		}

		if (GrabAssetValidator.isEmpty(addCSRForm.getPassword())) {
			err.rejectValue("password", "blank");
		}

		if (GrabAssetValidator.isEmpty(addCSRForm.getReEnterPassword())) {
			err.rejectValue("reEnterPassword", "blank");
		}

	}

}
