package com.ChartBoxAppTest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.chartboxapp.domain.RegisterBO;

public class AccountDaoTest {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		

		RegisterBO registerDto = new RegisterBO();
		registerDto.setUserEmail("satya");
		registerDto.setUserName("demo");;
		registerDto.setUserPassword("demo");
		session.save(registerDto);
		session.getTransaction().commit();
		session.close();

	}

}
