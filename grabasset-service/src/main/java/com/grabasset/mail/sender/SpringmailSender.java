package com.grabasset.mail.sender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.grabasset.exception.MailSenderFailedException;
import com.grabasset.mail.dto.MailMessage;

@Component
public class SpringmailSender implements GrabassetMailSender {

	@Autowired
	private JavaMailSenderImpl javaMailSender;

	public void send(MailMessage mailMessage) {

		SimpleMailMessage message = null;

		message = new SimpleMailMessage();
		message.setFrom(mailMessage.getFrom());
		message.setTo(mailMessage.getTo());
		message.setSubject(mailMessage.getSubject());
		message.setText(mailMessage.getMessage());
		if (mailMessage.getBcc() != null) {
			message.setBcc(mailMessage.getBcc());
		}
		try {
			javaMailSender.send(message);
		} catch (Exception e) {
			throw new MailSenderFailedException("failed to send a mail", e);
		}

		System.out.println("success");

	}

	public void setJavaMailSender(JavaMailSenderImpl javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

}
