package com.chartboxapp.service;

import com.chartboxapp.domain.RegisterBO;
import com.chartboxapp.dto.RegisterDTO;

public interface AccountService {
	void addUser(RegisterDTO registerDTO);
	public RegisterBO getUser(String EmailID);
	
}
