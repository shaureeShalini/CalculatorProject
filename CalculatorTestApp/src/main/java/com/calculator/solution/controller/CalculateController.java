package com.calculator.solution.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.calculator.solution.dto.CalculatorDto;
import com.calculator.solution.service.CalculatorService;

@RestController
public class CalculateController {
	
	@Autowired 
	CalculatorService calcService;
	
	/*
     * API to add numbers
     * 
     */
	@PostMapping("/api/add")
	public Integer sum(@RequestBody CalculatorDto calcdto) {
			return calcService.sum(calcdto);
		
	}
	
	/*
     * API to subtract numbers
     * 
     */
	@PostMapping("/api/diff")
	public Integer diff(@RequestBody CalculatorDto calcdto) {
		return calcService.diff(calcdto);
	
}

}
