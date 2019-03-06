package com.grabasset.mail.dto;

import java.util.Arrays;

public class MailMessage {

	private String from;
	private String to;
	private String[] bcc;
	private String subject;
	private String message;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String[] getBcc() {
		return bcc;
	}

	public void setBcc(String[] bcc) {
		this.bcc = bcc;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "MailMessage [from=" + from + ", to=" + to + ", bcc=" + Arrays.toString(bcc) + ", subject=" + subject
				+ ", message=" + message + "]";
	}

}
