package com.grabasset.exception;

public class MailTemplateNotFoundException extends GrabassetException {

	private static final long serialVersionUID = 1L;

	public MailTemplateNotFoundException() {
	}

	public MailTemplateNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public MailTemplateNotFoundException(String message) {
		super(message);
	}

}
