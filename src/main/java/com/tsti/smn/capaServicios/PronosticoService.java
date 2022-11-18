package com.tsti.smn.capaServicios;

import java.util.Date;
import java.util.List;

import com.tsti.smn.pojos.Ciudad;
import com.tsti.smn.pojos.Pronostico;

public interface PronosticoService {
	
	List<Pronostico> getAll();
	
	Pronostico getById(Long id);

	public List<Pronostico> pronosticosPorCiudadYFecha(Ciudad ciudad, Date fechaInicio, Date fechaFin);
}
