package com.tsti.smn.capaPresentacion.climaActual;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tsti.smn.capaServicios.CiudadService;
import com.tsti.smn.capaServicios.ClimaActualService;

@Controller
@RequestMapping("/climaActualEditar")
public class ClimaActualEditarController {
	@Autowired
	private CiudadService serviceCiudad;
	
	@Autowired
	private ClimaActualService serviceClimaActual;
	
	//@RequestMapping(path = {"", "/{id}"},method=RequestMethod.GET)
	//TODO: Falta un GET
	
	//@RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
	//TODO: Falta un GET para borrar
	
	//@RequestMapping( method=RequestMethod.POST)
	//TODO: Falta un POST
	
}
