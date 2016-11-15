package com.chartboxapp.controller;

import org.springframework.web.client.RestTemplate;

import com.chartboxapp.dto.RegisterDto;

public class ConsumeRESTApi {
	
	static public RegisterDto putUserData(Integer id){
		RestTemplate template = new RestTemplate();
		
		/*RegisterDto dto =template.getForObject("http://localhost:8080/ChartBoxApp/api/getuserapi/{id}",RegisterDto.class,id);
		System.out.println("[ConsumeRESTApi][getForObject][Return------]"+dto);
		ResponseEntity<RegisterDto> dto1 =template.getForEntity("http://localhost:8080/ChartBoxApp/api/getuserapi/{id}",RegisterDto.class,id);
		System.out.println("[ConsumeRESTApi][getForObject][Return------]"+dto1.getBody());
		*/
		System.out.println(template.postForEntity("http://localhost:8980/ChartBoxApp/api/setuserapi",id,RegisterDto.class).getHeaders().getLocation().toString());
		System.out.println(template.postForLocation("http://localhost:8980/ChartBoxApp/api/setuserapi", id).toString());
		return null;
	}

}
