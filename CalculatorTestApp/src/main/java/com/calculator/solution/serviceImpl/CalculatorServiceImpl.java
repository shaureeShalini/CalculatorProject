package com.calculator.solution.serviceImpl;

import org.springframework.stereotype.Service;

import com.calculator.solution.dto.CalculatorDto;
import com.calculator.solution.service.CalculatorService;

@Service
public class CalculatorServiceImpl implements CalculatorService {

	@Override
	public Integer sum(CalculatorDto calc) {
		calc.setResult(calc.getnumOne()+calc.getnumTwo());
		return calc.getResult();
	}

	@Override
	public Integer diff(CalculatorDto calc) {
		calc.setResult(calc.getnumOne()-calc.getnumTwo());
		return calc.getResult();
	}

}

