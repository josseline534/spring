package com.pruebas.pasantias.entidad;

import org.springframework.data.repository.CrudRepository;

/*
 * CrudRepository 
 * Consultas de bases de datos
 * flush permite eliminar memoria en ingresos masivos
 * JPA
 * flush no es controlado
 */

public interface UserRepository extends CrudRepository<Usuarios, Integer> {
	
	/*
	 * Query nativo
	 * Funcion
	 */
	Usuarios findByNombreAndEstado (String nombre, char estado);
}
