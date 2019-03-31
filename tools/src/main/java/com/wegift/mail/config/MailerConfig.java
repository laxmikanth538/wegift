package com.wegift.mail.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.wegift.constants.WeGiftConstants;

@Configuration
@PropertySources({ @PropertySource({ "classpath:gmail-details.properties" }),
		@PropertySource({ "classpath:sforce-details.properties" }) })
@ComponentScan(basePackages = { "com.wegift.mailservice" })
public class MailerConfig {

	@Autowired
	private Environment env;

	@Bean("gmailSender")
	public JavaMailSender newJavaGMailSender() {
		JavaMailSenderImpl mailSender = null;

		mailSender = new JavaMailSenderImpl();

		Properties mailProperties = null;

		mailProperties = new Properties();

		mailProperties.put("mail.smtp.host", env.getProperty("gmail.mail.smtp.host"));
		mailProperties.put("mail.smtp.port", env.getProperty("gmail.mail.smtp.port"));
		mailProperties.put("mail.smtp.starttls.enable", env.getProperty("gmail.mail.smtp.starttls.enable"));
		mailProperties.put("mail.smtp.auth", env.getProperty("gmail.mail.smtp.auth"));

		mailSender.setJavaMailProperties(mailProperties);

		mailSender.setUsername(WeGiftConstants.GMAIL_USERNAME);
		mailSender.setPassword(WeGiftConstants.GMAIL_PASSWORD);

		return mailSender;
	}

	@Bean("sForceMailSender")
	public JavaMailSender newJavaSMailSender() {
		JavaMailSenderImpl mailSender = null;

		mailSender = new JavaMailSenderImpl();

		Properties mailProperties = null;

		mailProperties = new Properties();

		mailProperties.put("mail.smtp.host", env.getProperty("sforce.mail.smtp.host"));
		mailProperties.put("mail.smtp.port", env.getProperty("sforce.mail.smtp.port"));
		mailProperties.put("mail.smtp.starttls.enable", env.getProperty("sforce.mail.smtp.starttls.enable"));
		mailProperties.put("mail.smtp.auth", env.getProperty("sforce.mail.smtp.auth"));

		mailSender.setJavaMailProperties(mailProperties);

		mailSender.setUsername(WeGiftConstants.SFORCE_USERNAME);
		mailSender.setPassword(WeGiftConstants.SFORCE_PASSWORD);

		return mailSender;
	}

}
