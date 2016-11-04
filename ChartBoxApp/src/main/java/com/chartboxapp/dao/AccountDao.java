package com.chartboxapp.dao;

import com.chartboxapp.dto.RegisterDto;

public interface AccountDao {
	
	void addUser(RegisterDto registerDto);

}
