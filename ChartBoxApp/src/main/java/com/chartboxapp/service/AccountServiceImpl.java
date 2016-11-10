package com.chartboxapp.service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chartboxapp.dao.AccountDao;
import com.chartboxapp.dto.RegisterDto;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountDao accountDao;
	
	@Override
	public void addUser(RegisterDto registerDto) {
		Date date = Calendar.getInstance().getTime();
		registerDto.setUserCreateDate(date);
		accountDao.addUser(registerDto);
	}

	@Override
	public RegisterDto getUser(String EmailID) {
		RegisterDto result = accountDao.getUser(EmailID);
		return result;
	}

}
