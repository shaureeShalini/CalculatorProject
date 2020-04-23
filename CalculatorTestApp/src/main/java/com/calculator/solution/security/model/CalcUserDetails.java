package com.calculator.solution.security.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.calculator.solution.model.User;



public class CalcUserDetails implements UserDetails {
	
	private String userId;
	private String userName;
	private String password;
	
	public CalcUserDetails(User user) {
		this.userName = user.getUserName();
		this.password = user.getPwd();
		this.userId = user.getUserId();		
	}
	
	public CalcUserDetails() {}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
