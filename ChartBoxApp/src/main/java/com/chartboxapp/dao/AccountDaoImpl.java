package com.chartboxapp.dao;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chartboxapp.dto.RegisterDto;
import com.chartboxapp.form.RegisterForm;

@Repository
public class AccountDaoImpl implements AccountDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addUser(RegisterDto registerDto) {
		sessionFactory.getCurrentSession().save(registerDto);
		
	}

	@Override
	public RegisterDto getUser(RegisterDto RegisterDto) {
		Query query=sessionFactory.getCurrentSession().createQuery("from RegisterDto where userName"
				+ " = :userName");
		//query.setParameter("userName", value)
		return null;
	}

}
