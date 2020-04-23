package com.calculator.solution.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.calculator.solution.model.User;
import com.calculator.solution.service.UserService;


@RestController
public class UserController {
	@Autowired
	UserService userService;
	
	/*
     * API to authenticate User
     * 
     */
	@PostMapping("/api/authenticate/{userName}{pwd}")
	public boolean authenticate(@PathVariable("userName")String userName,@PathVariable("pwd") String pwd)
	{
	return userService.authenticate(userName, pwd);		
	}
	
	/*
	 * API to add new user to H2 db
	 * 
	*/
	@PostMapping("/api/addUser")
	public User addUser(@RequestBody User user) {
		return userService.addNewUser(user);
	}	

}
