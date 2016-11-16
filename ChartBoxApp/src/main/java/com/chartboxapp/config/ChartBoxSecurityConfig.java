package com.chartboxapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebSecurity
public class ChartBoxSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//auth
		/*.inMemoryAuthentication()
		.withUser("satya").password("qwaszx").roles("USER")        
		.and()
		.withUser("ram").password("ram").roles("USER","ADMIN");*/
		//.jdbcAuthentication().dataSource(dataSource);
	}

}
