package com.calculator.solution.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calculator.solution.model.User;
import com.calculator.solution.repository.UserRepository;
import com.calculator.solution.service.UserService;



@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public User addNewUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public boolean authenticate(String userName, String password) {
		List<User> userList = userRepo.findByNameAndPassword(userName, password);
		if (userList.isEmpty())
		    return false;
		else
			return true;
	} 
	

}
