package stps.gob.mx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stps.gob.mx.dto.DisponibilidadDTO;
import stps.gob.mx.service.DisponibilidadService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/Disponibilidad"})
public class DisponibilidadController {
	
	@Autowired
	DisponibilidadService service;
	

	@PostMapping("/alta")
    public @ResponseBody DisponibilidadDTO alta(@RequestBody DisponibilidadDTO dto){
		return service.alta(dto);
    }
	

	@PostMapping("/baja")
    public @ResponseBody DisponibilidadDTO baja(@RequestBody DisponibilidadDTO dto){
		return  service.baja(dto);
    }
	

	@PostMapping("/consulta")
    public @ResponseBody List<DisponibilidadDTO> consulta(@RequestBody DisponibilidadDTO dto){
		return service.consulta(dto);
    }
	

	@PostMapping("/consultaId")
    public @ResponseBody List<DisponibilidadDTO> consultaId(@RequestBody DisponibilidadDTO dto){
		return service.consultaId(dto);
    }
	

	@PostMapping("/modificacion")
    public @ResponseBody DisponibilidadDTO modificacion(@RequestBody DisponibilidadDTO dto){
		return service.modificacion(dto);
    }

}
