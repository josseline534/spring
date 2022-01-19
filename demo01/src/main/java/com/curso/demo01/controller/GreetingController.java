package com.curso.demo01.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.curso.demo01.entidad.Greeting;

@RestController
@RequestMapping( value = "greeting")
public class GreetingController {
	private final AtomicLong counter = new AtomicLong();
	private static final String template = "Hola, %s";
	
	@GetMapping
	public Greeting greeting (@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
