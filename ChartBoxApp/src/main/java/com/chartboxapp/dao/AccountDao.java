package com.chartboxapp.dao;

import com.chartboxapp.domain.RegisterBO;

public interface AccountDao {
	
	public void addUser(RegisterBO registerDto);
	
	public RegisterBO getUser(String EmailID);
	

}
