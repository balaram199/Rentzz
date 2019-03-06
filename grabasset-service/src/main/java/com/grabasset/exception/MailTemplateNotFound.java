package com.grabasset.exception;

public class MailTemplateNotFound extends GrabassetException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MailTemplateNotFound() {
	}

	public MailTemplateNotFound(String message, Throwable cause) {
		super(message, cause);
	}

	public MailTemplateNotFound(String message) {
		super(message);
	}

}
