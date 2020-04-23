package com.calculator.solution.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.calculator.solution.model.User;
import com.calculator.solution.repository.UserRepository;
import com.calculator.solution.security.model.CalcUserDetails;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<User> user = userRepo.findByUserName(userName);
		user.orElseThrow(()-> new UsernameNotFoundException("Not found user:"+userName));
    	return user.map(CalcUserDetails::new).get();
	}

}

