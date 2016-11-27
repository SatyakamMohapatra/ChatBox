package com.chartboxapp.service;

import com.chartboxapp.domain.RegisterBO;

public interface AccountService {
	void addUser(RegisterBO registerDto);
	public RegisterBO getUser(String EmailID);
	
}
