package com.chartboxapp.dao;

import com.chartboxapp.domain.RegisterBO;
import com.chartboxapp.dto.RegisterDTO;

public interface AccountDao {
	
	public void addUser(RegisterBO registerBO);
	
	public RegisterBO getUser(String EmailID);
	

}
