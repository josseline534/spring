package com.tecniRec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/categoria")
public class CategoriaController {

	//@GetMapping("/index)
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String mostrarIndex (Model model) {
		return "categoria/listaCategoria";
	}
	
	//@GetMapping("/create)
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String crear () {
		return "categoria/formCategoria";
	}
	
	//@PostMapping("/index)
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String guardar (@RequestParam("nombre") String nombre, @RequestParam("descripcion") String descripcion) {
		System.out.println("Categoria" + nombre);
		System.out.println("Categoria" + descripcion);
		return "categoria/listaCategoria";
	}
	
}
