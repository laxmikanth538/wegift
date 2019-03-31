package com.wegift.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import com.wegift.constants.WeGiftConstants;
import com.wegift.entities.Address;
import com.wegift.entities.Card;
import com.wegift.entities.Member;
import com.wegift.entities.Merchant;
import com.wegift.entities.MerchantEnquiryEntity;
import com.wegift.entities.MerchantTermsAndAgreement;
import com.wegift.entities.OnlineUser;
import com.wegift.entities.RegUnique;
import com.wegift.entities.UserRole;

@Configuration
public class PersistencyConfig {

	@Autowired
	Environment env;

	@Bean
	public DataSource newDataSource() {

		DataSource datasource = null;

		JndiDataSourceLookup lookup = new JndiDataSourceLookup();

		datasource = lookup.getDataSource(WeGiftConstants.WEGIFT_JNDI_NAME);

		return datasource;
	}

	@Bean(autowire = Autowire.BY_TYPE)
	public LocalSessionFactoryBean newSessionFactory() {
		LocalSessionFactoryBean sessionFactory = null;

		sessionFactory = new LocalSessionFactoryBean();
		Properties hibernateProperties = null;

		hibernateProperties = new Properties();

		hibernateProperties.setProperty("show_sql", "true");
		hibernateProperties.setProperty("hibernate.current_session_context_class", "thread");
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");

		sessionFactory.setHibernateProperties(hibernateProperties);
		sessionFactory.setAnnotatedClasses(
				new Class<?>[] { Address.class, Merchant.class, MerchantTermsAndAgreement.class, OnlineUser.class,
						UserRole.class, MerchantEnquiryEntity.class, Member.class, Card.class, RegUnique.class });

		return sessionFactory;

	}

	@Bean(autowire = Autowire.BY_TYPE)
	public HibernateTemplate newHibernateTemplate() {

		HibernateTemplate hibernateTemplate = null;

		hibernateTemplate = new HibernateTemplate();

		return hibernateTemplate;

	}

	@Bean(name = "transactionManager", autowire = Autowire.BY_TYPE)
	public HibernateTransactionManager newTransaction() {
		HibernateTransactionManager transactionManager = null;

		transactionManager = new HibernateTransactionManager();

		return transactionManager;
	}
}
