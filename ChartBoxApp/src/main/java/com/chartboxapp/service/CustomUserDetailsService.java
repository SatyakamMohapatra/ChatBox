package com.chartboxapp.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.chartboxapp.dto.RegisterDto;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	AccountService accountService;
	@Override
	public UserDetails loadUserByUsername(String emailID) throws UsernameNotFoundException {
		RegisterDto user = accountService.getUser(emailID);
		System.out.println("CustomUserDetailsService[loadUserByUsername][UserDetails:-][]"+ user);
		if (user == null) {
			System.out.println("CustomUserDetailsService[loadUserByUsername][UserDetails:-][UserNotFound]");	
			throw new UsernameNotFoundException("User Email ID NotFound");
		}
		//Add and active and inactive colume in database and change 3rd Para
		return new org.springframework.security.core.userdetails.User(user.getUserEmail(),user.getUserPassword(),true,true,true,true,getGrantedAuthorities(user));
		
	}
	
	private List<GrantedAuthority> getGrantedAuthorities(RegisterDto user){
		System.out.println("[CustomUserDetailsService][getGrantedAuthorities] "+user) ;
		List<GrantedAuthority> authority = new ArrayList<GrantedAuthority>();
				authority.add(new SimpleGrantedAuthority("ROLE_USER"));
		return authority;
		
	}
	

}
