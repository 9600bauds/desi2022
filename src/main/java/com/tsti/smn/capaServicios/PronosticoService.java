package com.tsti.smn.capaServicios;

import java.util.List;

import com.tsti.smn.pojos.Pronostico;

public interface PronosticoService {
	
	List<Pronostico> getAll();
	
	Pronostico getById(Long id);

}
