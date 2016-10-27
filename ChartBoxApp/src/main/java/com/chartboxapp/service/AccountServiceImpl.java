package com.chartboxapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chartboxapp.dao.AccountDao;
import com.chartboxapp.dto.RegisterDto;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountDao accountDao;
	
	@Override
	public void addUser(RegisterDto registerDto) {
		accountDao.addUser(registerDto);
	}

}
