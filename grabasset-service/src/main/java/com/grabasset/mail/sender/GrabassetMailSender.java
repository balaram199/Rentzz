package com.grabasset.mail.sender;

import com.grabasset.mail.dto.MailMessage;

public interface GrabassetMailSender {
	public void send(MailMessage mailMessage);
}
