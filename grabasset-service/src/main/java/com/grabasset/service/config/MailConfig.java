package com.grabasset.service.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@ComponentScan(basePackages = { "com.grabasset.mail.service", "com.grabasset.mail.sender",
		"com.grabasset.mail.manager" })
public class MailConfig {

	@Bean
	public JavaMailSenderImpl javaMailImpl() {

		Properties props = null;
		JavaMailSenderImpl javaMailImpl = null;

		props = new Properties();
		props.put("mail.smtp.host", "mail.s-force.org");
		props.put("mail.smtp.port", "2525");
		props.put("mail.smtp.auth", true);

		javaMailImpl = new JavaMailSenderImpl();
		javaMailImpl.setJavaMailProperties(props);
		javaMailImpl.setUsername("raju.vathadi@s-force.org");
		javaMailImpl.setPassword("Raju@123");

		return javaMailImpl;

	}
}
