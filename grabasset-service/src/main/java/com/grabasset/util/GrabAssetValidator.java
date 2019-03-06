package com.grabasset.util;

public class GrabAssetValidator {

	public static boolean isEmpty(String name) {
		if (name == null || name.trim().length() == 0) {
			return true;
		}
		return false;
	}

	public static boolean validateMobileNumber(String phoneNo) {
		if (phoneNo.matches("(0\\91)?[7-9][0-9]{9}")) {
			return true;
		}
		return false;
	}

	public static boolean validateEmail(String email) {
		if (email.matches("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9-]+([.][a-zA-Z]+)+")) {
			return true;
		}
		return false;
	}

	public static boolean validatePassword(String password) {
		if (password.matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,15})")) {
			return true;
		}
		return false;
	}

	public static boolean isUserNameExists(String userName) {
		// TODO Auto-generated method stub
		return false;
	}
}
