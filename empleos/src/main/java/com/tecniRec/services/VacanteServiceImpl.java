package com.tecniRec.services;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tecniRec.model.Vacantes;

@Service
public class VacanteServiceImpl implements IVacanteService{
	
	private List<Vacantes> lista = null;
	
	public VacanteServiceImpl() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		lista = new LinkedList<Vacantes>();	
		try {
			Vacantes vacante1 = new Vacantes ();
			vacante1.setId(1);
			vacante1.setNombre("Ingeniero Civil");
			vacante1.setDescripcion("Se solicita ingeniero civil para diseñar puente peatonal");
			vacante1.setFecha(sdf.parse("08-05-2021"));
			vacante1.setSalario(8500.00);
			vacante1.setDestacado(1);
			vacante1.setImagen("empresa1.png");
			
			lista.add(vacante1);
			
			Vacantes vacante2 = new Vacantes ();
			vacante2.setId(2);
			vacante2.setNombre("Ingeniero en sistemas");
			vacante2.setDescripcion("Se solicita ingeniero en Sistema para liderar proyecto");
			vacante2.setFecha(sdf.parse("15-12-2020"));
			vacante2.setSalario(9700.00);
			vacante2.setDestacado(0);
			vacante2.setImagen("empresa2.jpg");
			
			lista.add(vacante2);
			
			Vacantes vacante3 = new Vacantes ();
			vacante3.setId(3);
			vacante3.setNombre("Contador público");
			vacante3.setDescripcion("Empresa importantes solicita contador con 5 años de experiencia titulado");
			vacante3.setFecha(sdf.parse("18-06-2021"));
			vacante3.setSalario(600.00);
			vacante3.setDestacado(0);
			
			lista.add(vacante3);
			
			Vacantes vacante4 = new Vacantes ();
			vacante4.setId(4);
			vacante4.setNombre("Desarrollador");
			vacante4.setDescripcion("Se solicita desarrollador en frameworks de JS");
			vacante4.setFecha(sdf.parse("11-02-2019"));
			vacante4.setSalario(700.00);
			vacante4.setDestacado(1);
			vacante4.setImagen("empresa4.png");
			
			lista.add(vacante4);
			
		}catch(Exception e) {
			
		}
	}

	@Override
	public List<Vacantes> buscarTodas() {
		return lista;
	}

	@Override
	public Vacantes buscarPorId(Integer idVacante) {
		for(Vacantes v : lista) {
			if(v.getId() == idVacante) {
				return v;
			}
		}
		return null;
	}

	@Override
	public void guardar(Vacantes vacante) {
		// TODO Auto-generated method stub
		lista.add(vacante);
	}

}
