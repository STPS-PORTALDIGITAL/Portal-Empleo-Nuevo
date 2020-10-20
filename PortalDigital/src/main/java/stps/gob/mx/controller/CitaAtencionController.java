package stps.gob.mx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stps.gob.mx.dto.CitaAtencionDTO;
import stps.gob.mx.service.CitaAtencionService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/CitaAtencion"})
public class CitaAtencionController {
	
	@Autowired
	CitaAtencionService service;
	

	@PostMapping("/alta")
    public @ResponseBody CitaAtencionDTO alta(@RequestBody CitaAtencionDTO dto){
		return service.alta(dto);
    }
	

	@PostMapping("/baja")
    public @ResponseBody CitaAtencionDTO baja(@RequestBody CitaAtencionDTO dto){
		return  service.baja(dto);
    }
	

	@PostMapping("/consulta")
    public @ResponseBody List<CitaAtencionDTO> consulta(@RequestBody CitaAtencionDTO dto){
		return service.consulta(dto);
    }
	

	@PostMapping("/consultaId")
    public @ResponseBody List<CitaAtencionDTO> consultaId(@RequestBody CitaAtencionDTO dto){
		return service.consultaId(dto);
    }
	

	@PostMapping("/modificacion")
    public @ResponseBody CitaAtencionDTO modificacion(@RequestBody CitaAtencionDTO dto){
		return service.modificacion(dto);
    }

}
