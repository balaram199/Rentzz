package com.grabasset.exception;

public class UserAlreadyActivatedException extends GrabassetException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserAlreadyActivatedException() {
		super();
	}

	public UserAlreadyActivatedException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserAlreadyActivatedException(String message) {
		super(message);
	}

	public UserAlreadyActivatedException(Throwable cause) {
		super(cause);
	}

}
