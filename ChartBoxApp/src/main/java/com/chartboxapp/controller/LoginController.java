package com.chartboxapp.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.chartboxapp.domain.RegisterBO;
import com.chartboxapp.dto.LoginDTO;
import com.chartboxapp.dto.RegisterDTO;
import com.chartboxapp.service.AccountService;

@Controller
public class LoginController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value="/",method = RequestMethod.GET)
	public ModelAndView redirectToLogin() {
		System.out.println("[com.chartboxapp.controller.LoginController]"
				+ "[redirectToLogin][ login Page Loaded]");
		return new ModelAndView("redirect:login");
		
	}
	
	@RequestMapping(value="login",method = RequestMethod.GET)
	public ModelAndView loginView() {
		System.out.println("[com.chartboxapp.controller.LoginController]"
				+ "[loginView][ login Page Loaded]");
		return new ModelAndView("login","LoginVO",new LoginDTO() );
	}
	
	@RequestMapping(value="login",method = RequestMethod.POST)
	public ModelAndView LoginProcess(@ModelAttribute("LoginDTO") LoginDTO loginDTO) {
		System.out.println("[com.chartboxapp.controller.LoginController]"
				+ "[LoginProcess][ Trying To Load Profile Page Loaded]");
		
		System.out.println(loginDTO);
		return new ModelAndView("profile");
	}
	
	@RequestMapping(value="register",method = RequestMethod.GET)
	public ModelAndView registerView() {
		System.out.println("[com.chartboxapp.controller.LoginController]"		
							   + "[registerView][ register Page Loaded]");		
		return new ModelAndView("register","RegisterDTO",new RegisterDTO());
	}
	
	@RequestMapping(value="register",method = RequestMethod.POST)
	public ModelAndView registerProcess(@ModelAttribute("RegisterDTO") RegisterDTO registerDTO) {
		System.out.println("[com.chartboxapp.controller.LoginController]"
			              	+ "[registerProcess][ register Page Loaded]");		
		accountService.addUser(registerDTO);
		System.out.println(registerDTO);
		return new ModelAndView("redirect:login");
	}
	
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logoutPage(HttpServletRequest request ,HttpServletResponse response){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication != null){
			new SecurityContextLogoutHandler().logout(request, response, authentication);
		}
		return "redirect:/login?logout";
	}
	

}
