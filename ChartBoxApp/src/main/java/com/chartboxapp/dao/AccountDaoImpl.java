package com.chartboxapp.dao;

import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chartboxapp.dto.RegisterDto;

@Repository
public class AccountDaoImpl implements AccountDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addUser(RegisterDto registerDto) {
		sessionFactory.getCurrentSession().save(registerDto);
		
	}

	@Override
	public RegisterDto getUser(String EmailID) {
		Query query=sessionFactory.getCurrentSession().createQuery("from RegisterDto where userEmail"
				+ " = :userEmail");
		System.out.println(EmailID);
		RegisterDto result =(RegisterDto) query.setParameter("userEmail", EmailID).getSingleResult();
	
		System.out.println(result);
		return result;
	}
}
