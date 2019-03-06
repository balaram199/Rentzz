package com.grabasset.mail.test;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.grabasset.mail.dto.Message;
import com.grabasset.mail.service.GrabassetMailService;
import com.grabasset.service.config.RootConfig;

public class JavConfigMailTest {

	public static void main(String[] args) {
		Map<String, String> parameters = null;
		ApplicationContext context = null;

		parameters = new HashMap<>();
		parameters.put("username", "user");
		parameters.put("host", "localhost");
		parameters.put("port", "8080");
		parameters.put("activationcode", "5500");
		parameters.put("userid", "5674828");

		Message message = new Message();
		message.setProperties(parameters);
		message.setTemplateName("customer-registration");
		message.setTo("karthik.anthati@s-force.org");

		context = new AnnotationConfigApplicationContext(RootConfig.class);
		GrabassetMailService service = context.getBean("mailTemplateService", GrabassetMailService.class);
		service.sendMail(message);
	}
}
