package com.chartboxapp.restApi;

import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.chartboxapp.domain.RegisterBO;

public class ConsumeRESTApi {
	
	public static void main(String[] args) {
		
	
		RestTemplate template = new RestTemplate();
		List list;
		
		/*
		RegisterDto dto =template.getForObject("http://localhost:8080/ChartBoxApp/api/getuserapi/{id}",RegisterDto.class,id);
		System.out.println("[ConsumeRESTApi][getForObject][Return------]"+dto);
		ResponseEntity<RegisterDto> dto1 =template.getForEntity("http://localhost:8080/ChartBoxApp/api/getuserapi/{id}",RegisterDto.class,id);
		System.out.println("[ConsumeRESTApi][getForObject][Return------]"+dto1.getBody());
		*/

		//System.out.println(template.postForEntity("http://localhost:8980/ChartBoxApp/api/setuserapi",id,RegisterBO.class).getHeaders().getLocation().toString());
		//System.out.println(template.postForLocation("http://localhost:8980/ChartBoxApp/api/setuserapi", id).toString());


		country quote= (country)template.getForObject("http://services.groupkt.com/country/get/all",country.class);
          System.out.println(quote);

	}

}
