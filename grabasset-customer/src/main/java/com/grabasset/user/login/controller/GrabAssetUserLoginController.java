package com.grabasset.user.login.controller;

	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;

	@Controller
	public class GrabAssetUserLoginController {

	@RequestMapping("/user-login.htm")
	public String showUserLoginForm(){
		return "user-login";
	}
	}
