package com.chartboxapp.dao;

import com.chartboxapp.dto.RegisterDto;

public interface AccountDao {
	
	public void addUser(RegisterDto registerDto);
	
	public RegisterDto getUser(String EmailID);
	

}
