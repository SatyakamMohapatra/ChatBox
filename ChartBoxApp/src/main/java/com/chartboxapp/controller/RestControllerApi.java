package com.chartboxapp.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chartboxapp.dto.RegisterDto;

@RestController
@RequestMapping("/rest/")
public class RestControllerApi {

	@RequestMapping(value="getuser",method = RequestMethod.GET)
	public RegisterDto getUser(){
		RegisterDto dto = new RegisterDto();
		dto.setUserEmail("sagtya");
		dto.setUserID(2);
		dto.setUserName("sagtya");
		dto.setUserPassword("sagtya");
		return dto;	
	}
	@RequestMapping(value="getuser/{id}/{name}",method = RequestMethod.GET)
	public RegisterDto getOneUser(@PathVariable(value="id") Integer id,
								  @PathVariable(value="name") String name){
		RegisterDto dto = new RegisterDto();
		dto.setUserEmail("sagtya");
		dto.setUserID(id);
		dto.setUserName(name);
		dto.setUserPassword("sagtya");
		return dto;	
	}
	@RequestMapping(value="setuser",method = RequestMethod.PUT)
	public RegisterDto setUser(@RequestBody RegisterDto dto){
		System.out.println(dto);
		return dto;	
	}
}
