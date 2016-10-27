package com.chartboxapp.controller;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.chartboxapp.dto.RegisterDto;
import com.chartboxapp.form.LoginForm;
import com.chartboxapp.form.RegisterForm;
import com.chartboxapp.service.AccountService;

@Controller
public class LoginController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value="/",method = RequestMethod.GET)
	public ModelAndView redirectToLogin() {
		System.out.println("[com.chartboxapp.controller.LoginController]"
				+ "[loginView][ login Page Loaded]");
		return new ModelAndView("redirect:login");
	}
	
	@RequestMapping(value="login",method = RequestMethod.GET)
	public ModelAndView loginView() {
		System.out.println("[com.chartboxapp.controller.LoginController]"
				+ "[loginView][ login Page Loaded]");
		return new ModelAndView("login","LoginModel",new LoginForm() );
	}
	
	@RequestMapping(value="login",method = RequestMethod.POST)
	public ModelAndView LoginProcess(@ModelAttribute("LoginModel") LoginForm loginForm) {
		System.out.println("[com.chartboxapp.controller.LoginController]"
				+ "[LoginProcess][ Trying To Load Profile Page Loaded]");
		System.out.println(loginForm);
		return new ModelAndView("profile");
	}
	
	@RequestMapping(value="register",method = RequestMethod.GET)
	public ModelAndView registerView() {
		System.out.println("[com.chartboxapp.controller.LoginController]"
				+ "[registerView][ register Page Loaded]");
		return new ModelAndView("register","RegesterModel",new RegisterDto());
	}
	
	@RequestMapping(value="register",method = RequestMethod.POST)
	public ModelAndView registerProcess(@ModelAttribute("RegesterModel") RegisterDto registerDto) {
		System.out.println("[com.chartboxapp.controller.LoginController]"
				+ "[registerProcess][ register Page Loaded]");
		
		accountService.addUser(registerDto);
		System.out.println(registerDto);
		return new ModelAndView("redirect:login");
	}

}
