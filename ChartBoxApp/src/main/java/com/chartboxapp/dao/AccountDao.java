package com.chartboxapp.dao;

import com.chartboxapp.domain.RegisterBO;

public interface AccountDao {
	
	public void addUser(RegisterBO registerBO);
	
	public RegisterBO getUser(String EmailID);
	

}
