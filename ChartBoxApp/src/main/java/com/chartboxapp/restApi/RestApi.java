package com.chartboxapp.restApi;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.chartboxapp.domain.RegisterBO;

@RestController
public class RestApi {
	
	@RequestMapping(produces="application/json",method=RequestMethod.GET,path="/api/getuserapi/{id}")
	public RegisterBO getUserApi(@PathVariable("id") Integer userID){
		RegisterBO dto = new RegisterBO();
		dto.setUserID(userID);
		dto.setUserEmail("satya@gmail.com");
		dto.setUserName("satya");
		dto.setUserPassword("satya");
		return dto;
	}
	
	
	@RequestMapping(method=RequestMethod.POST,path="/api/setuserapi")
	public ResponseEntity<RegisterBO> setUserApi(@RequestBody Integer userID) throws URISyntaxException{	
		System.out.println("setUserApi [RESTfull api called ]" + userID);
		
		RegisterBO dto = new RegisterBO();
		dto.setUserID(userID);
		dto.setUserEmail("satya@gmail.com");
		dto.setUserName("satya");
		dto.setUserPassword("satya");
		
		HttpHeaders responseHeaders = new HttpHeaders();
		URI uri = new URI("/api/setuserapi/"+userID);
		responseHeaders.setLocation(uri);
		
		return new ResponseEntity<RegisterBO>(dto,responseHeaders,HttpStatus.OK);
		/*if(dto.getUserID()==10){
			System.out.println(dto);
			return new ResponseEntity<RegisterDto>(dto,HttpStatus.OK);
		}else{
			throw new UserNotFoundException(dto.getUserID());*/
		}
	
		
	}

