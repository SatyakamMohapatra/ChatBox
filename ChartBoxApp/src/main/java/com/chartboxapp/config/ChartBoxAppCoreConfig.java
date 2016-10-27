package com.chartboxapp.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.sun.org.apache.regexp.internal.recompile;

@Configuration
@ComponentScan(basePackages   ={"com.chartboxapp"},
			   excludeFilters ={
							   @Filter(type  = FilterType.ANNOTATION,
									   value = EnableWebMvc.class)})
@PropertySource(value="classpath:/resource/chartboxapp.properties",ignoreResourceNotFound=true)
public class ChartBoxAppCoreConfig {
	
	@Autowired
    private Environment environment;
	
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		System.out.println("[ChartBoxAppCoreConfig.class][dataSource()][DB Driver Loaded]");
		dataSource.setDriverClassName(environment.getProperty("db.classLoader"));
		dataSource.setUrl(environment.getProperty("db.url"));
		dataSource.setUsername(environment.getProperty("db.username"));
		dataSource.setPassword(environment.getProperty("db.password"));
		return dataSource;	
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer placeholderConfigurer(){
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	private Properties hibernateProperties(){
		Properties properties = new Properties();
		properties.put("hibernate.dialect",environment.getProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql",environment.getProperty("hibernate.show_sql"));
		properties.put("hibernate.hbm2ddl.autot",environment.getProperty("hibernate.hbm2ddl.auto"));
		properties.put("hibernate.connection.pool_size",environment.getProperty("hibernate.connection.pool_size"));
		return properties;
	}
	
	@Bean(name="sessionFactory")
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource){
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setPackagesToScan(new String[]{"com.chartboxapp.form"});
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}
}
