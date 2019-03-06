package com.grabasset.mail.preparator;

import java.util.Map;

import com.grabasset.mail.bindings.MailTemplate;
import com.grabasset.mail.dto.MailMessage;
import com.grabasset.util.MailMessageConverter;

public class MailTemplatePreparator {

	private String from;
	private String to;
	private String[] bcc;
	private String message;
	private String subject;
	private Map<String, String> parameters;

	public MailTemplatePreparator(MailTemplate mailTemplate) {

		this.subject = mailTemplate.getSubject();
		this.message = mailTemplate.getMessage();
	}

	public MailTemplatePreparator from(String from) {
		this.from = from;
		return this;
	}

	public MailTemplatePreparator to(String to) {
		this.to = to;
		return this;
	}

	public MailTemplatePreparator bcc(String[] bcc) {
		if (bcc != null) {
			this.bcc = bcc;
		}
		return this;
	}

	public MailTemplatePreparator parameters(Map<String, String> parameters) {
		this.message = MailMessageConverter.messageConvert(message, parameters);
		return this;
	}

	public MailMessage prepare() {

		MailMessage message = new MailMessage();
		message.setBcc(bcc);
		message.setFrom(from);
		message.setMessage(this.message);
		message.setSubject(subject);
		message.setTo(to);

		return message;
	}

}
