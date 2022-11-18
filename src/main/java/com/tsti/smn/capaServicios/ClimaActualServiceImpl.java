package com.tsti.smn.capaServicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsti.smn.capaDaos.IClimaActualRepo;
import com.tsti.smn.pojos.ClimaActual;

@Service
public class ClimaActualServiceImpl implements ClimaActualService {
	@Autowired
	IClimaActualRepo repo;
	
	public ClimaActual getByCiudadId(Long id) {
		return repo.climaActualFromCityID(id).get();
	}

}
