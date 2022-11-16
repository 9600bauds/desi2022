package com.tsti.smn.capaServicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsti.smn.capaDaos.IPronosticoRepo;
import com.tsti.smn.pojos.Pronostico;

@Service
public class PronosticoServiceImpl implements PronosticoService {

	@Autowired
	IPronosticoRepo repo;
	
	@Override
	public Pronostico getById(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public List<Pronostico> getAll() {
		return repo.findAll();
	}

}
