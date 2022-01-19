package com.curso.demo01.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.curso.demo01.entidad.Numeros;
import com.curso.demo01.services.INumeros;

@RestController
@RequestMapping(value = "numeros")
public class NumerosController {
	
	@Autowired
	private INumeros serviceNumeros;
	
	private final AtomicLong counter = new AtomicLong();
	
	@GetMapping(path="suma")
	public Numeros numeroSuma(@RequestParam(value = "a") Integer a,
			@RequestParam(value= "b") Integer b
			) {
		return new Numeros (counter.incrementAndGet(), a, b, "suma", serviceNumeros.suma(a, b));
	}
	
	@GetMapping(path="resta")
	public Numeros numeroResta(@RequestParam(value = "a") Integer a,
			@RequestParam(value= "b") Integer b
			) {
		return new Numeros (counter.incrementAndGet(), a, b, "resta", serviceNumeros.resta(a, b));
	}
	
	@GetMapping(path="multiplicar")
	public Numeros numeroMult(@RequestParam(value = "a") Integer a,
			@RequestParam(value= "b") Integer b
			) {
		return new Numeros (counter.incrementAndGet(), a, b, "multiplicar", serviceNumeros.multiplicacion(a, b));
	}
	
	@GetMapping(path="dividir")
	public Numeros numeroDividir(@RequestParam(value = "a") Integer a,
			@RequestParam(value= "b") Integer b
			) {
		return new Numeros (counter.incrementAndGet(), a, b, "dividir", serviceNumeros.division(a, b));
	}
}
