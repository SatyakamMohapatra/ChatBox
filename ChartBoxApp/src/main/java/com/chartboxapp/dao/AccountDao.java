package com.chartboxapp.dao;

import com.chartboxapp.domain.RegisterBO;
import com.chartboxapp.dto.RegisterDTO;

public interface AccountDao {
	
	public void addUser(RegisterDTO registerDTO);
	
	public RegisterBO getUser(String EmailID);
	

}
