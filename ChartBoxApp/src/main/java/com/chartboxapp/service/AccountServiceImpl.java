package com.chartboxapp.service;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chartboxapp.dao.AccountDao;
import com.chartboxapp.domain.RegisterBO;
import com.chartboxapp.dto.RegisterDTO;
import com.chartboxapp.utility.ObjectBuilder;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountDao accountDao;
	
	@Override
	public void addUser(RegisterDTO registerDTO) {
		Date date = Calendar.getInstance().getTime();
		registerDTO.setUserCreateDate(date);
		RegisterBO registerBO  = new RegisterBO();
		registerBO = ObjectBuilder.DTO2BO(registerDTO);
		accountDao.addUser(registerBO);
	}

	@Override
	public RegisterDTO getUser(String EmailID) {
		RegisterBO registerBO = accountDao.getUser(EmailID);
		return ObjectBuilder.BO2DTO(registerBO);
		
	}

}
