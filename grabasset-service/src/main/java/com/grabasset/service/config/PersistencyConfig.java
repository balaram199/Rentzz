package com.grabasset.service.config;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jndi.JndiTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.jta.JtaTransactionManager;

@Configuration
@ComponentScan(basePackages = { "com.grabasset.user.dao" })
public class PersistencyConfig {

	@Bean
	public DataSource dataSource() throws NamingException {
		return (DataSource) new JndiTemplate().lookup("java:/grabassetds");
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		return new JtaTransactionManager();
	}

	@Bean(autowire = Autowire.BY_TYPE)
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = null;

		jdbcTemplate = new JdbcTemplate();

		return jdbcTemplate;
	}
}
