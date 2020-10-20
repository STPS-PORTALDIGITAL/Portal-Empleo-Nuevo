package stps.gob.mx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stps.gob.mx.dto.TipoPersonaDTO;
import stps.gob.mx.service.TipoPersonaService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/TipoPersona"})
public class TipoPersonaController {
	
	@Autowired
	TipoPersonaService service;
	

	@PostMapping("/alta")
    public @ResponseBody TipoPersonaDTO alta(@RequestBody TipoPersonaDTO dto){
		return service.alta(dto);
    }
	

	@PostMapping("/baja")
    public @ResponseBody TipoPersonaDTO baja(@RequestBody TipoPersonaDTO dto){
		return  service.baja(dto);
    }
	

	@PostMapping("/consulta")
    public @ResponseBody List<TipoPersonaDTO> consulta(@RequestBody TipoPersonaDTO dto){
		return service.consulta(dto);
    }
	

	@PostMapping("/consultaId")
    public @ResponseBody List<TipoPersonaDTO> consultaId(@RequestBody TipoPersonaDTO dto){
		return service.consultaId(dto);
    }
	

	@PostMapping("/modificacion")
    public @ResponseBody TipoPersonaDTO modificacion(@RequestBody TipoPersonaDTO dto){
		return service.modificacion(dto);
    }

}
