package com.calculator.solution.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.calculator.solution.model.User;


public interface UserRepository extends JpaRepository<User, Integer>{


	/*
	 * Method to retrieve user with userName and password
	 */
	@Query("from User where userName=?1 and password=?2")
	List<User> findByNameAndPassword(String userName, String password);
	
	
	/*
	 * Method to retrieve user with given userName.
	 * 
	 */
	 Optional<User> findByUserName(String userName);
}
