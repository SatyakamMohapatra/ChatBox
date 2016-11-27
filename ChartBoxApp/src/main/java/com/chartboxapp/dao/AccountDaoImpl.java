package com.chartboxapp.dao;

import javax.persistence.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chartboxapp.domain.RegisterBO;

@Repository
public class AccountDaoImpl implements AccountDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addUser(RegisterBO registerBO) {
		sessionFactory.getCurrentSession().save(registerBO);
	}

	@Override
	public RegisterBO getUser(String EmailID) {
		Query query=sessionFactory.getCurrentSession().createQuery("from RegisterBO where userEmail"
				+ " = :userEmail");
		System.out.println(EmailID);
		RegisterBO result =(RegisterBO) query.setParameter("userEmail", EmailID).getSingleResult();
	
		System.out.println(result);
		return result;
	}
}
