package com.curso.demo01.services;

import org.springframework.stereotype.Service;

@Service
public class NumeroServiceImpl implements INumeros {

	@Override
	public Double suma(Integer a, Integer b) {
		Integer result = a+b;
		return Double.parseDouble(result.toString());
	}

	@Override
	public Double resta(Integer a, Integer b) {
		Integer result;
		if(a>b)
			result = a-b;
		else
			result = b-a;
		return Double.parseDouble(result.toString());
	}

	@Override
	public Double multiplicacion(Integer a, Integer b) {
		// TODO Auto-generated method stub
		Double result = Double.parseDouble(a.toString()) * Double.parseDouble(b.toString());
		return result;
	}

	@Override
	public Double division(Integer a, Integer b) {
		Double result;
		if(b>0)
			result = Double.parseDouble(a.toString()) / Double.parseDouble(b.toString());
		else
			result = 0.0;
		return result;
	}

}
