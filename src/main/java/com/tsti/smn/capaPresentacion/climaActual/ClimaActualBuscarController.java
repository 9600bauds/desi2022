package com.tsti.smn.capaPresentacion.climaActual;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tsti.smn.capaServicios.CiudadService;
import com.tsti.smn.capaServicios.ClimaActualService;

@Controller
@RequestMapping("/climaActualBuscar")
public class ClimaActualBuscarController {
	@Autowired
	private CiudadService serviceCiudad;
	
	@Autowired
	private ClimaActualService serviceClimaActual;
	
	//@RequestMapping(method=RequestMethod.GET)
	//TODO: Falta hacer un GET
	
	//@RequestMapping( method=RequestMethod.POST)
	//TODO: Falta hacer un POST
	
	

}
