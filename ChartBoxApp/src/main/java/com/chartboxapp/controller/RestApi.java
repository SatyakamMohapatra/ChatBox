package com.chartboxapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chartboxapp.dto.RegisterDto;
import com.chartboxapp.exception.UserNotFoundException;

@RestController
public class RestApi {
	
	@RequestMapping(produces="application/json",method=RequestMethod.GET,path="/api/getuserapi")
	public RegisterDto getUserApi(@RequestParam("userName") String username,
								  @RequestParam("userID") int userID){
		
		RegisterDto dto = new RegisterDto();
		dto.setUserID(userID);
		dto.setUserEmail("satya@gmail.com");
		dto.setUserName(username);
		dto.setUserPassword("satya");
		return dto;
	}
	
	@RequestMapping(method=RequestMethod.PUT,path="/api/setuserapi")
	public ResponseEntity<RegisterDto> setUserApi(@RequestBody RegisterDto dto){
		
		if(dto.getUserID()==10){
			System.out.println(dto);
			return new ResponseEntity<RegisterDto>(dto,HttpStatus.OK);
		}else{
			throw new UserNotFoundException(dto.getUserID());
		}
	
		
	}

}
