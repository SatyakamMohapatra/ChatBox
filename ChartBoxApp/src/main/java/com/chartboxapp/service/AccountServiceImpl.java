package com.chartboxapp.service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chartboxapp.dao.AccountDao;
import com.chartboxapp.domain.RegisterBO;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountDao accountDao;
	
	@Override
	public void addUser(RegisterBO registerBO) {
		Date date = Calendar.getInstance().getTime();
		registerBO.setUserCreateDate(date);
		accountDao.addUser(registerBO);
	}

	@Override
	public RegisterBO getUser(String EmailID) {
		RegisterBO result = accountDao.getUser(EmailID);
		return result;
		
	}

}
