package com.grabasset.mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.grabasset.mail.bindings.MailTemplate;
import com.grabasset.mail.dto.MailMessage;
import com.grabasset.mail.dto.Message;
import com.grabasset.mail.manager.MailTemplateManager;
import com.grabasset.mail.preparator.MailTemplatePreparator;
import com.grabasset.mail.sender.GrabassetMailSender;
import com.grabasset.mail.sender.SpringmailSender;

@Component
public class GrabassetMailService {

	@Autowired
	private MailTemplateManager manager;

	@Autowired
	private GrabassetMailSender mailSender;

	public void sendMail(Message message) {
		MailMessage mailMessage = null;
		MailTemplate mailtemplate = null;

		mailtemplate = manager.getmailTemplate(message.getTemplateName());
		mailMessage = new MailTemplatePreparator(mailtemplate).from(message.getFrom()).to(message.getTo())
				.bcc(message.getBcc()).parameters(message.getProperties()).prepare();
		mailSender.send(mailMessage);
	}

	public void setManager(MailTemplateManager manager) {
		this.manager = manager;
	}

	public void setMailSender(SpringmailSender mailSender) {
		this.mailSender = mailSender;
	}

}
