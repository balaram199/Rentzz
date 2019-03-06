package com.grabasset.util;

import java.util.Base64;
/*
 * this class is used to encode and decode value in base64 format 
 */
public class Base64Converter {

	public static String base64Encoder(String statusCode) {
		byte[] bytes = statusCode.getBytes();
		final String encoded = Base64.getEncoder().encodeToString(bytes);
		return encoded;
	}

	public static String base64Decoder(String statusCode) {
		byte[] decodedBytes = Base64.getDecoder().decode(statusCode.getBytes());
		return new String(decodedBytes);
	}
}
