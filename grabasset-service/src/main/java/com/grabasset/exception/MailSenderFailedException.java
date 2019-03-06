package com.grabasset.exception;

public class MailSenderFailedException extends GrabassetException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MailSenderFailedException() {
		super();
	}

	public MailSenderFailedException(String message, Throwable cause) {
		super(message, cause);
	}

	public MailSenderFailedException(String message) {
		super(message);
	}

	public MailSenderFailedException(Throwable cause) {
		super(cause);
	}

}
