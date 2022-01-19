package com.tecniRec.services;

import java.util.List;

import com.tecniRec.model.Vacantes;

public interface IVacanteService {

	List<Vacantes> buscarTodas();
	
	Vacantes buscarPorId (Integer idVacante);
	
	void guardar (Vacantes vacante);
}