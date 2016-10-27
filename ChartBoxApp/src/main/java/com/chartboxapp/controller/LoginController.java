package com.chartboxapp.controller;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.chartboxapp.form.LoginForm;
import com.chartboxapp.form.RegisterForm;

@Controller
public class LoginController {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
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
		//jdbcTemplate.execute("INSERT INTO hibernet.user_details (`home_city`, `home_pin_code`, `home_state`, `join_date`, `user_name`) VALUES ('satya', '789545', 'Odihaa', '2016-10-23', 'satya')");
		return new ModelAndView("profile");
	}
	
	@RequestMapping(value="register",method = RequestMethod.GET)
	public ModelAndView registerView() {
		System.out.println("[com.chartboxapp.controller.LoginController]"
				+ "[registerView][ register Page Loaded]");
		return new ModelAndView("register","RegesterModel",new RegisterForm());
	}
	
	@RequestMapping(value="register",method = RequestMethod.POST)
	public ModelAndView registerProcess(@ModelAttribute("RegesterModel") RegisterForm registerForm) {
		System.out.println("[com.chartboxapp.controller.LoginController]"
				+ "[registerProcess][ register Page Loaded]");
		System.out.println(registerForm);
		return new ModelAndView("redirect:login");
	}

}
