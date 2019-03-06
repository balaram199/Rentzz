package com.grabasset.user.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grabasset.user.bo.UserBo;
import com.grabasset.user.mapper.UserMapper;
import com.grabasset.user.registration.form.RegistrationForm;
import com.grabasset.user.registration.validator.UserRegistrationValidator;
import com.grabasset.user.service.ManageUserService;

@Controller
@RequestMapping("user-register.htm")
public class UserRegistrationController {

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private ManageUserService manageUserService;
	@Autowired
	private UserRegistrationValidator userRegistrationValidator;

	@GetMapping
	public String showUserRegistrationForm(Model model) {

		model.addAttribute("userRegistration", new RegistrationForm());

		return "user-registration-form";
	}

	@PostMapping
	public String registerUser(Model model, @ModelAttribute("userRegistration") RegistrationForm registrationForm,
			BindingResult errors) {
		UserBo userBo = null;

		if (userRegistrationValidator.supports(registrationForm.getClass())) {
			userRegistrationValidator.validate(registrationForm, errors);
			if (errors.hasErrors()) {
				return "user-registration-form";
			}
		}
		userBo = userMapper.mapUserFormToUserBo(registrationForm);

		manageUserService.registerUser(userBo);

		return "user-registration-success";
	}

}
