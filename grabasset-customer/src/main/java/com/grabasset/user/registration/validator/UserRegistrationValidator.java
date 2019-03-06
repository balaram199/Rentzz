package com.grabasset.user.registration.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.grabasset.user.registration.form.RegistrationForm;
import com.grabasset.user.service.ManageUserService;
import com.grabasset.util.GrabAssetValidator;

@Component
public class UserRegistrationValidator implements Validator {

	@Autowired
	private ManageUserService manageUserService;

	@Override
	public boolean supports(Class<?> clazz) {
		if (clazz.isAssignableFrom(RegistrationForm.class)) {
			return true;
		}
		return false;
	}

	@Override
	public void validate(Object obj, Errors errors) {
		RegistrationForm registrationForm = null;

		registrationForm = (RegistrationForm) obj;
		if (GrabAssetValidator.isEmpty(registrationForm.getFirstName())) {
			errors.rejectValue("firstName", "blank");
		}
		if (GrabAssetValidator.isEmpty(registrationForm.getLastName())) {
			errors.rejectValue("lastName", "blank");
		}
		if (GrabAssetValidator.isEmpty(registrationForm.getMobileNo())) {
			errors.rejectValue("mobileNo", "blank");
		} else if (!GrabAssetValidator.validateMobileNumber(registrationForm.getMobileNo())) {
			errors.rejectValue("mobileNo", "mobileNo.format");
		}
		if (GrabAssetValidator.isEmpty(registrationForm.getUserName())) {
			errors.rejectValue("userName", "blank");
		} else if (!GrabAssetValidator.validateEmail(registrationForm.getUserName())) {
			errors.rejectValue("userName", "userName.format");
		} else if (manageUserService.isUserNameExists(registrationForm.getUserName())) {
			errors.rejectValue("userName", "userName.exists");
		}

		if (GrabAssetValidator.isEmpty(registrationForm.getPassword())) {
			errors.rejectValue("password", "blank");
		}

		if (GrabAssetValidator.isEmpty(registrationForm.getReEnterPassword())) {
			errors.rejectValue("reEnterPassword", "blank");
		}
		if (!registrationForm.isTermsAndConditions()) {
			errors.rejectValue("termsAndConditions", "termsAndConditions");
		}
		if (!GrabAssetValidator.isEmpty(registrationForm.getReEnterPassword())
				&& !GrabAssetValidator.isEmpty(registrationForm.getPassword())) {
			if (!GrabAssetValidator.validatePassword(registrationForm.getPassword())) {
				errors.rejectValue("password", "password.format");
			}
			if (!GrabAssetValidator.validatePassword(registrationForm.getReEnterPassword())) {
				errors.rejectValue("reEnterPassword", "password.format");
			} else if (!registrationForm.getPassword().equals(registrationForm.getReEnterPassword())) {
				errors.rejectValue("reEnterPassword", "password.match");
			}
		}

	}
}