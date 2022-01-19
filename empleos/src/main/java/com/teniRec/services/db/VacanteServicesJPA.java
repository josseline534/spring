package com.teniRec.services.db;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.tecniRec.model.Vacantes;
import com.tecniRec.repository.VacantesRepository;
import com.tecniRec.services.IVacanteService;

@Service
@Primary
public class VacanteServicesJPA implements IVacanteService {
	
	@Autowired
	private VacantesRepository vacanteRepo;

	@Override
	public List<Vacantes> buscarTodas() {
		// TODO Auto-generated method stub
		vacanteRepo.findAll();
		return null;
	}

	@Override
	public Vacantes buscarPorId(Integer idVacante) {
		// TODO Auto-generated method stub
		Optional<Vacantes> optional = vacanteRepo.findById(idVacante);
		if(optional.isPresent()) {
			optional.get();
		}
		return null;
	}

	@Override
	public void guardar(Vacantes vacante) {
		// TODO Auto-generated method stub
		vacanteRepo.save(vacante);
	}

}
