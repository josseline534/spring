package com.tecniRec.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tecniRec.model.Vacantes;
import com.tecniRec.services.IVacanteService;

@Controller
public class HomeController {
	
	@Autowired
	private IVacanteService serviceVacantes;
	
	@GetMapping("/tabla")
	public String mostrarTabla (Model model) {
		List<Vacantes> lista = serviceVacantes.buscarTodas();
		model.addAttribute("vacantes",lista);
		return "tabla";
	}
	
	@GetMapping("/detalle")
	public String mostrarDetalle(Model model) {
		Vacantes vacante = new Vacantes ();
		vacante.setNombre("Ingeniero de Comunicaciones");
		vacante.setDescripcion("Se solicita ingeniero para dar soporte a internet");
		vacante.setFecha(new Date());
		vacante.setSalario(9700.00);
		model.addAttribute("vacante", vacante);
		return "detalle";
	}
	
	@GetMapping("/listado")
	public String mostrarLista(Model model) {
		List<String> lista = new LinkedList<String>();
		lista.add("Ingeniero de Sistemas");
		lista.add("Auxiliar contable");
		lista.add("Vendedor");
		lista.add("Arquitecto");
		model.addAttribute("empleos", lista);
		return "empleos";
	}
	
	/*
	 * Retorna vista html
	 */

	@GetMapping("/")
	public String mostrarHome(Model model) {
		/*
		 * Pasar variable a la vista
		model.addAttribute("mensaje", "Bienvenidos a la App");
		model.addAttribute("fecha", new Date());
		
		String nombre = "Auxiliar de Contabilidad";
		Date fechaPub = new Date();
		double salario = 9000.00;
		boolean vigencia = true;
		
		model.addAttribute("nombre", nombre);
		model.addAttribute("fecha", fechaPub);
		model.addAttribute("salario", salario);
		model.addAttribute("vigencia", vigencia);
		*/
		List<Vacantes> lista = serviceVacantes.buscarTodas();
		model.addAttribute("vacantes",lista);
		return "home";
	}
	
}
