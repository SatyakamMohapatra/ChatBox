package com.chartboxapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@RequestMapping(path="login",method = RequestMethod.GET)
	public ModelAndView loginRedirect() {
		System.out.println("[com.chartboxapp.controller.LoginController][loginRedirect][ login Page Loaded]");
		return new ModelAndView("login");
	}
	@RequestMapping(path="register",method = RequestMethod.GET)
	public ModelAndView registerRedirect() {
		System.out.println("[com.chartboxapp.controller.LoginController][registerRedirect][ register Page Loaded]");
		return new ModelAndView("register");
	}

}
