package com.grabasset.exception;

public class GrabassetException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GrabassetException() {
		super();
	}

	public GrabassetException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public GrabassetException(String message, Throwable cause) {
		super(message, cause);
	}

	public GrabassetException(String message) {
		super(message);
	}

	public GrabassetException(Throwable cause) {
		super(cause);
	}

}
