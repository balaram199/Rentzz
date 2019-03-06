package com.grabasset.exception;

public class UserActivationFailedException extends GrabassetException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserActivationFailedException() {
		super();
	}

	public UserActivationFailedException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserActivationFailedException(String message) {
		super(message);
	}

	public UserActivationFailedException(Throwable cause) {
		super(cause);
	}

}
