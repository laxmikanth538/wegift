package com.wegift.member.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.wegift.config.PersistencyConfig;
import com.wegift.config.ServiceConfig;


@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@Import(value = { ServiceConfig.class, PersistencyConfig.class, SecurityConfig.class })
@ComponentScan(basePackages = { "com.wegift.member.validator", "com.wegift.member.controller" })
public class RootConfig {

}
