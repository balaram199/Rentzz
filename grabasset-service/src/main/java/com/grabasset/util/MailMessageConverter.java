package com.grabasset.util;

import java.util.Map;

/*
 * this class is used for replacing the place holders, that are defined in mail templates 
 */
public class MailMessageConverter {

	public static String messageConvert(String message, Map<String, String> params) {

		for (Map.Entry<String, String> replacement : params.entrySet()) {

			message = message.replace("${" + replacement.getKey() + "}", replacement.getValue());
		}
		return message;
	}

}
