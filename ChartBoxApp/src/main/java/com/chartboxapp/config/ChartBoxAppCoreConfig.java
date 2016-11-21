package com.chartboxapp.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages   ={"com.chartboxapp"},
			   excludeFilters ={
					   @Filter(type  = FilterType.ANNOTATION,
										   value = EnableWebMvc.class)})
@PropertySource(value={"classpath:chartboxapp.properties"})
@EnableTransactionManagement
public class ChartBoxAppCoreConfig {
	
	@Autowired
	Environment environment;
	
    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory s) {
       HibernateTransactionManager txManager = new HibernateTransactionManager();
       txManager.setSessionFactory(s);
       return txManager;
       
    }
	
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
		properties.put("hibernate.hbm2ddl.auto",environment.getProperty("hibernate.hbm2ddl.auto"));
		properties.put("hibernate.connection.pool_size",environment.getProperty("hibernate.connection.pool_size"));
		return properties;
	}
	
	@Bean(name="sessionFactory")
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource){
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setPackagesToScan(new String[]{"com.chartboxapp.dto"});
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}
	

}
