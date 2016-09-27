package com.chartboxapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.chartboxapp.form.LoginForm;

@Controller
public class LoginController {
	
	@RequestMapping(value="login",method = RequestMethod.GET)
	public ModelAndView loginRedirect() {
		System.out.println("[com.chartboxapp.controller.LoginController]"
				+ "[loginRedirect][ login Page Loaded]");
		return new ModelAndView("login","LoginModel",new LoginForm() );
	}
	
	@RequestMapping(value="login",method = RequestMethod.POST)
	public ModelAndView ProfileRedirect(@ModelAttribute("LoginModel") LoginForm loginForm) {
		System.out.println("[com.chartboxapp.controller.LoginController]"
				+ "[ProfileRedirect][ Trying To Load Profile Page Loaded]");
		System.out.println(loginForm);
		return new ModelAndView("profile");
	}
	
	@RequestMapping(value="register",method = RequestMethod.GET)
	public ModelAndView registerRedirect() {
		System.out.println("[com.chartboxapp.controller.LoginController]"
				+ "[registerRedirect][ register Page Loaded]");
		return new ModelAndView("register");
	}

}
