package com.calculator.solution.service;

import com.calculator.solution.model.User;

public interface UserService {
	
	/*
	 * Add new user in to H2 db
	 */
	public User addNewUser(User user);
	
	/*
     * Authenticate a user
     * 
     * */
	public boolean authenticate(String userName, String password);
}

