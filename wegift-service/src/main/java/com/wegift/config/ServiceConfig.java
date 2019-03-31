package com.wegift.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.wegift.mail.config.MailerConfig;

@Configuration
@ComponentScan(basePackages = { "com.wegift.service", "com.wegift.dao", "com.wegift.validation" })
@Import(value = { MailerConfig.class })
public class ServiceConfig {

}
