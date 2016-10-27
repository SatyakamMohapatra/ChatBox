package com.chartboxapp.dao;

import com.chartboxapp.dto.RegisterDto;
import com.chartboxapp.form.RegisterForm;

public interface AccountDao {
	
	void addUser(RegisterDto registerDto);

}
