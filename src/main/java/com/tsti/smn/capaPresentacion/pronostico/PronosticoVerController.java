package com.tsti.smn.capaPresentacion.pronostico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tsti.smn.capaServicios.PronosticoService;
import com.tsti.smn.pojos.Ciudad;
import com.tsti.smn.pojos.Pronostico;

@Controller
@RequestMapping("/pronosticoVer")
public class PronosticoVerController {
	@Autowired
	private PronosticoService servicioPronostico;
	
	@RequestMapping(path = {"", "/{id}"}, method=RequestMethod.GET)
	public String mostrarPronostico(ModelMap modelo, @PathVariable("id") Long idPronostico) {
		Pronostico elPronostico = servicioPronostico.getById(idPronostico);
		modelo.addAttribute("pronostico", elPronostico);
		
		Ciudad laCiudad = elPronostico.getCiudad();
		modelo.addAttribute("nombreCiudad", laCiudad.getNombre());
		modelo.addAttribute("idCiudad", laCiudad.getId());
		
		return "pronosticoVer";
	}
	
}
