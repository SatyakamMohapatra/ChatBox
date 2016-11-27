package com.chartboxapp.utility;

import com.chartboxapp.domain.RegisterBO;
import com.chartboxapp.dto.RegisterDTO;

public class ObjectBuilder {
	
	public static RegisterDTO BO2DTO(RegisterBO registerBO) {
		RegisterDTO registerDTO = new RegisterDTO();
		registerDTO.setUserCreateDate(registerBO.getUserCreateDate());
		registerDTO.setUserEmail(registerBO.getUserEmail());
		registerDTO.setUserID(registerBO.getUserID());
		registerDTO.setUserName(registerBO.getUserName());
		registerDTO.setUserPassword(registerBO.getUserPassword());
		return registerDTO;
		
	}
	
	public static RegisterBO DTO2BO(RegisterDTO registerDTO) {
		RegisterBO registerBO = new RegisterBO();
		registerBO.setUserCreateDate(registerDTO.getUserCreateDate());
		registerBO.setUserEmail(registerDTO.getUserEmail());
		registerBO.setUserID(registerDTO.getUserID());
		registerBO.setUserName(registerDTO.getUserName());
		registerBO.setUserPassword(registerDTO.getUserPassword());
		return registerBO;
		
	}

}
