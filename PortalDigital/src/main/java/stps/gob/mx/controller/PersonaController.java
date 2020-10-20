package stps.gob.mx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stps.gob.mx.dto.PersonaDTO;
import stps.gob.mx.service.PersonaService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/Persona"})
public class PersonaController {
	
	@Autowired
	PersonaService service;
	

	@PostMapping("/alta")
    public @ResponseBody PersonaDTO alta(@RequestBody PersonaDTO dto){
		return service.alta(dto);
    }
	

	@PostMapping("/baja")
    public @ResponseBody PersonaDTO baja(@RequestBody PersonaDTO dto){
		return  service.baja(dto);
    }
	

	@PostMapping("/consulta")
    public @ResponseBody List<PersonaDTO> consulta(@RequestBody PersonaDTO dto){
		return service.consulta(dto);
    }
	

	@PostMapping("/consultaId")
    public @ResponseBody List<PersonaDTO> consultaId(@RequestBody PersonaDTO dto){
		return service.consultaId(dto);
    }
	

	@PostMapping("/modificacion")
    public @ResponseBody PersonaDTO modificacion(@RequestBody PersonaDTO dto){
		return service.modificacion(dto);
    }

}
