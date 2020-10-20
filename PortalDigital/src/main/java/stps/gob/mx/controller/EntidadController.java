package stps.gob.mx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stps.gob.mx.dto.EntidadDTO;
import stps.gob.mx.service.EntidadService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/Entidad"})
public class EntidadController {
	
	@Autowired
	EntidadService service;
	

	@PostMapping("/alta")
    public @ResponseBody EntidadDTO alta(@RequestBody EntidadDTO dto){
		return service.alta(dto);
    }
	

	@PostMapping("/baja")
    public @ResponseBody EntidadDTO baja(@RequestBody EntidadDTO dto){
		return  service.baja(dto);
    }
	

	@PostMapping("/consulta")
    public @ResponseBody List<EntidadDTO> consulta(@RequestBody EntidadDTO dto){
		return service.consulta(dto);
    }
	

	@PostMapping("/consultaId")
    public @ResponseBody List<EntidadDTO> consultaId(@RequestBody EntidadDTO dto){
		return service.consultaId(dto);
    }
	

	@PostMapping("/modificacion")
    public @ResponseBody EntidadDTO modificacion(@RequestBody EntidadDTO dto){
		return service.modificacion(dto);
    }

}
