package com.chartboxapp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chartboxapp.dto.RegisterDto;
import com.chartboxapp.form.RegisterForm;

@Repository
public class AccountDaoImpl implements AccountDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addUser(RegisterDto registerDto) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(registerDto);
		
	}

}
