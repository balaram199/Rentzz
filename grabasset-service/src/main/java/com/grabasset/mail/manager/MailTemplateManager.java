package com.grabasset.mail.manager;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import com.grabasset.exception.MailTemplateNotFoundException;
import com.grabasset.mail.bindings.MailTemplate;
import com.grabasset.mail.bindings.MailTemplates;

@Component
public class MailTemplateManager implements InitializingBean {

	private Map<String, MailTemplate> mailTemplates;

	public void afterPropertiesSet() {

		String template = null;
		JAXBContext context = null;
		Unmarshaller unmarshal = null;
		MailTemplates templates = null;

		mailTemplates = new ConcurrentHashMap<String, MailTemplate>();

		try {

			context = JAXBContext.newInstance(MailTemplates.class);
			unmarshal = context.createUnmarshaller();

			templates = (MailTemplates) unmarshal.unmarshal(MailTemplateManager.class.getClassLoader()
					.getResourceAsStream("META-INF/mail-templates/grabasset-mail-templete.xml"));
			for (MailTemplate mailTemplate : templates.getMailTemplate()) {
				template = mailTemplate.getName();
				mailTemplates.put(mailTemplate.getName(), mailTemplate);
			}
		} catch (Exception e) {
			throw new MailTemplateNotFoundException(template + " not found", e);
		}

	}

	public MailTemplate getmailTemplate(String templateName) {
		return mailTemplates.get(templateName);
	}

}
