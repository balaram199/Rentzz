package com.grabasset.service.config.test;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jndi.JndiTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.jta.JtaTransactionManager;

@Configuration
@ComponentScan(basePackages = { "com.grabasset.user.dao" })
@PropertySource(value = "classpath:db-config.properties")
public class PersistencyConfigTest {

	@Autowired
	private Environment environment;

	@Bean
	public DataSource dataSource() throws NamingException {
		DriverManagerDataSource datasource = null;

		datasource = new DriverManagerDataSource();
		datasource.setUsername(environment.getProperty("uName"));
		datasource.setDriverClassName(environment.getProperty("drivarClassName"));
		datasource.setUrl(environment.getProperty("url"));
		datasource.setPassword(environment.getProperty("password"));
		return datasource;
	}

	/*
	 * @Bean public PlatformTransactionManager transactionManager() { return new
	 * JtaTransactionManager(); }
	 */

	@Bean(autowire = Autowire.BY_TYPE)
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = null;

		jdbcTemplate = new JdbcTemplate();

		return jdbcTemplate;
	}
}
