package com.tsti.smn.capaPresentacion.pronostico;

import java.sql.Date;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tsti.smn.capaServicios.CiudadService;
import com.tsti.smn.capaServicios.ClimaActualService;
import com.tsti.smn.capaServicios.PronosticoService;
import com.tsti.smn.excepciones.Excepcion;
import com.tsti.smn.pojos.Ciudad;
import com.tsti.smn.pojos.ClimaActual;
import com.tsti.smn.pojos.Pronostico;

@Controller
@RequestMapping("/pronosticoBuscar")
public class PronosticoBuscarController {
	@Autowired
	private PronosticoService servicioPronostico;
	
	@Autowired
    private CiudadService servicioCiudad;
	
	@Autowired
	private ClimaActualService servicioClimaActual;
	
	@RequestMapping(value = {"", "/{idCiudad}"}, method=RequestMethod.GET)
	public String preparaForm(ModelMap modelo, @PathVariable Optional<Long> idCiudad) {
		PronosticoBuscarForm form = new PronosticoBuscarForm();
		modelo.addAttribute("formBean",form);
		
		if(idCiudad.isPresent()) {
    		modelo = llenarModelo(modelo, idCiudad.get());
		}
    	return "pronosticoBuscar";
 	}
	
    @ModelAttribute("allCiudades")
    public List<Ciudad> getAllProvincias() {
        return this.servicioCiudad.getAll();
    }

    @RequestMapping(method=RequestMethod.POST)
    public String submit(@ModelAttribute("formBean") @Valid PronosticoBuscarForm formBean, BindingResult result, 
    		ModelMap modelo, @RequestParam String action) throws Excepcion {
    	if(action.equals("Buscar"))
    	{			Long idCiudad = formBean.getCiudadSeleccionada();
			if(idCiudad != null) {;				return "redirect:/pronosticoBuscar/" + idCiudad.toString();
			};
			return "pronosticoBuscar";
    	}
    	
    	else if(action.equals("Cancelar"))
    	{
    		modelo.clear();
    		return "redirect:/";
    	}
    	return "redirect:/";
    }
    
    private ModelMap llenarModelo(ModelMap modelo, Long idCiudad) {
		Ciudad laCiudad = servicioCiudad.getById(idCiudad);
		
		modelo.addAttribute("nombreCiudad", laCiudad.getNombre());
		
		ClimaActual elClima = servicioClimaActual.getByCiudadId(idCiudad);
		modelo.addAttribute("climaActual", elClima);
		
		// Por motivos de simplicidad, como no s?? en qu?? fecha se va a calificar este TP, voy a usar una fecha fija.
		// Si la aplicaci??n fuera "de verdad", habr??a muchos pron??sticos y se usar??a la fecha actual.
		// Pero para solamente tener que generar 10 casos de prueba, voy a hacer de cuenta que hoy es 31/12/2021.
		Date fechaInicio = Date.valueOf("2021-01-01");
		Date fechaFinal = Date.valueOf("2022-01-10");
		
		//List<Pronostico> resultados = servicioPronostico.getAll();
		List<Pronostico> resultados = servicioPronostico.pronosticosPorCiudadYFecha(laCiudad, fechaInicio, fechaFinal);
		modelo.addAttribute("resultados", resultados);
		
		//modelo.addAttribute("fechaInicio", fechaInicio);
		//modelo.addAttribute("fechaFinal", fechaFinal);
    	
    	return modelo;
    }
}
