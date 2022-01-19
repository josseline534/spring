package com.pruebas.pasantias.restController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebas.pasantias.entidad.Usuarios;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.pruebas.pasantias.entidad.UserRepository;
import com.pruebas.pasantias.models.Response;
import com.pruebas.pasantias.models.ResponseUsers;

/*
 * Indica que esta clase se va a convertir en un controlador
 */
@RestController
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-07-02T14:50:01.213-05:00")
@RequestMapping("/usuarios")

public class UserController {
	
	private static final Logger logger = LogManager.getLogger(UserController.class);
	
	/*
	 * Instanciar repositorio
	 * Inyectar la interfaz
	 */
	@Autowired
	UserRepository userRepository;
	/*
	 * Metodo de servicio
	 */
	@GetMapping(path="/getAllUsers", produces="application/json")
	public ResponseEntity<String> GetAllUsers() throws JsonProcessingException{
		logger.info("Inicio getAllUsuario");
		/*
		 * ObjectWriter
		 * Dependencia que permite transformar objeto en una cadena de texto
		 */
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		List<ResponseUsers> listUsers = new ArrayList<>();
		Response response = new Response();
		
		List<Usuarios> lista = new ArrayList<>();
		try {
			lista = (List<Usuarios>) userRepository.findAll();
			if(!lista.isEmpty()) {
				for(Usuarios user:lista) {
					ResponseUsers responseUsers = new ResponseUsers();
					responseUsers.setId(user.getId());
					responseUsers.setNombre(user.getNombre());
					responseUsers.setEstado(user.getEstado().toString());
					responseUsers.setFecha(new SimpleDateFormat("dd-MM-yyyy").format(user.getFecha()));
					listUsers.add(responseUsers);
				}
			}
			if(!listUsers.isEmpty()) {
				response.setResponse(listUsers);
			}
			response.setCode(200);
			response.setMessage("Transaccion Exitosa");
			logger.info(response);
			
		}catch(Exception e) {
			logger.error(e);
		}
		return new ResponseEntity<>(ow.writeValueAsString(response), HttpStatus.OK);
		
	}

}
