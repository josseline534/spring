package com.tecniRec.controller;


import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tecniRec.model.Vacantes;
import com.tecniRec.services.IVacanteService;
import com.tecniRec.util.Utileria;

@Controller
@RequestMapping(value="/vacante")
public class VacanteController {
	
	@Autowired
	private IVacanteService serviceVacantes;
	
	@GetMapping("/crear-vacante")
	public String create() {
		return "vacante/form";
	}

	@PostMapping("/save")
	public String save(
			Vacantes vacante,
			BindingResult result,
			RedirectAttributes attributes,
			@RequestParam("archivoImagen")MultipartFile multiPart,
			Model model
			) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		
		if(result.hasErrors()) {
			
			for(ObjectError error: result.getAllErrors()) {
				System.out.println("Ocurrio un error" + error.getDefaultMessage());
			}
			
			return "vacante/form";
		}
		
		if(!multiPart.isEmpty()) {
			String ruta = "C:/Users/josseline/OneDrive/Documentos/dw/spring/empleos/src/main/resources/static/images/";
			String nombreImagen = Utileria.guardarArchivo(multiPart, ruta);
			if(nombreImagen != null) {
				vacante.setImagen(nombreImagen);
			}
		}
		try {
			vacante.setFecha(date);
			
			serviceVacantes.guardar(vacante);
			attributes.addFlashAttribute("msg", "Vacante guardada");
			model.addAttribute("vacantes", serviceVacantes.buscarTodas());
		}catch(Exception e) {
			
		}
		return "vacante/listVacante"; 
		
	}
	
	
	@GetMapping("/delete")
	public String eliminar(@RequestParam("id") int idVacante, Model model ) {
		System.out.println("Borrando IdVacante: " + idVacante);
		model.addAttribute("idVacante", idVacante);
		return "mensaje";
	}

	@GetMapping("/view/{id}")
	public String mostrarDetalle( @PathVariable ("id") int idVacante, Model model) {
		Vacantes v =serviceVacantes.buscarPorId(idVacante);
		System.out.println("Vacante: " + v);
		model.addAttribute("vacante", v);
		return "detalle";
	}
	
	@InitBinder
	public void initBinder (WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	
}
