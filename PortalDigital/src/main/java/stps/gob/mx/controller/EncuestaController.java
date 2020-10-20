package stps.gob.mx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stps.gob.mx.dto.EncuestaDTO;
import stps.gob.mx.service.EncuestaService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/Encuesta"})
public class EncuestaController {
	
	@Autowired
	EncuestaService service;
	

	@PostMapping("/alta")
    public @ResponseBody EncuestaDTO alta(@RequestBody EncuestaDTO dto){
		return service.alta(dto);
    }
	

	@PostMapping("/baja")
    public @ResponseBody EncuestaDTO baja(@RequestBody EncuestaDTO dto){
		return  service.baja(dto);
    }
	

	@PostMapping("/consulta")
    public @ResponseBody List<EncuestaDTO> consulta(@RequestBody EncuestaDTO dto){
		return service.consulta(dto);
    }
	

	@PostMapping("/consultaId")
    public @ResponseBody List<EncuestaDTO> consultaId(@RequestBody EncuestaDTO dto){
		return service.consultaId(dto);
    }
	

	@PostMapping("/modificacion")
    public @ResponseBody EncuestaDTO modificacion(@RequestBody EncuestaDTO dto){
		return service.modificacion(dto);
    }

}
