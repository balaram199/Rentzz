package com.grabasset.user.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grabasset.exception.GrabassetException;
import com.grabasset.user.service.ManageUserService;

@Controller
public class UserActivationController {

	@Autowired
	private ManageUserService manageUserService;

	@RequestMapping("/{userId}/{activationCode}/activateUser.htm")
	public String activateUser(@PathVariable("activationCode") String activationCode,
			@PathVariable("userId") int userId) {

		try {
			manageUserService.activateUser(activationCode, userId);
		} catch (GrabassetException e) {

		}

		return "user-activation-success";
	}

}
