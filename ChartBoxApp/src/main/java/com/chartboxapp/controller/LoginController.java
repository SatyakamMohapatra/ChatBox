package com.chartboxapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@RequestMapping(path="hello",method = RequestMethod.GET)
	public ModelAndView loginRedirect() {
		System.out.println("first print");
		return new ModelAndView("register");
	}

}
