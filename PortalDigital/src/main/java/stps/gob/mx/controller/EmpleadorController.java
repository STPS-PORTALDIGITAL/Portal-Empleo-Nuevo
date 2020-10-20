package stps.gob.mx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stps.gob.mx.dto.EmpleadorDTO;
import stps.gob.mx.service.EmpleadorService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/Empleador"})
public class EmpleadorController {
	
	@Autowired
	EmpleadorService service;
	

	@PostMapping("/alta")
    public @ResponseBody EmpleadorDTO alta(@RequestBody EmpleadorDTO dto){
		return service.alta(dto);
    }
	

	@PostMapping("/baja")
    public @ResponseBody EmpleadorDTO baja(@RequestBody EmpleadorDTO dto){
		return  service.baja(dto);
    }
	

	@PostMapping("/consulta")
    public @ResponseBody List<EmpleadorDTO> consulta(@RequestBody EmpleadorDTO dto){
		return service.consulta(dto);
    }
	

	@PostMapping("/consultaId")
    public @ResponseBody List<EmpleadorDTO> consultaId(@RequestBody EmpleadorDTO dto){
		return service.consultaId(dto);
    }
	

	@PostMapping("/modificacion")
    public @ResponseBody EmpleadorDTO modificacion(@RequestBody EmpleadorDTO dto){
		return service.modificacion(dto);
    }

}
