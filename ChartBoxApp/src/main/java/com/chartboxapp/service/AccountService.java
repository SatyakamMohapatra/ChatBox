package com.chartboxapp.service;

import com.chartboxapp.dto.RegisterDTO;

public interface AccountService {
	void addUser(RegisterDTO registerDTO);
	public RegisterDTO getUser(String EmailID);
	
}
