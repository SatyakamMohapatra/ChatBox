package com.chartboxapp.config;

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
@PropertySource(value="classpath:/com/chartboxapp/prop/chartboxapp.properties",ignoreResourceNotFound=true)
public class ChartBoxAppCoreConfig {
	
	/*
	 * DataSource Properties
	 */
	@Value(value = "${db.classLoader}") private String driverClass;
	@Value(value = "${db.url}")			private String url;
	@Value(value = "${db.username}")    private String username;
	@Value(value = "${db.password}")    private String Password;
	/*
	 * Hibernet Properties
	 */
	
	
	
	@Bean
	public JdbcTemplate JdbcTemplate(){
		return new JdbcTemplate(dataSource());
	}
	
	@Bean
	public DataSource dataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		System.out.println("[ChartBoxAppCoreConfig.class][dataSource()][DB Driver Loaded]");
		dataSource.setDriverClassName(driverClass);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(Password);
		return dataSource;	
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer placeholderConfigurer(){
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource){
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setPackagesToScan(new String[]{"com.chartboxapp.form"});
		//Add Properties
		return sessionFactory;
	}
}
