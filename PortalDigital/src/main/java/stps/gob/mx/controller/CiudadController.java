package stps.gob.mx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stps.gob.mx.dto.CiudadDTO;
import stps.gob.mx.service.CiudadService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/Ciudad"})
public class CiudadController {
	
	@Autowired
	CiudadService service;
	

	@PostMapping("/alta")
    public @ResponseBody CiudadDTO alta(@RequestBody CiudadDTO dto){
		return service.alta(dto);
    }
	

	@PostMapping("/baja")
    public @ResponseBody CiudadDTO baja(@RequestBody CiudadDTO dto){
		return  service.baja(dto);
    }
	

	@PostMapping("/consulta")
    public @ResponseBody List<CiudadDTO> consulta(@RequestBody CiudadDTO dto){
		return service.consulta(dto);
    }
	

	@PostMapping("/consultaId")
    public @ResponseBody List<CiudadDTO> consultaId(@RequestBody CiudadDTO dto){
		return service.consultaId(dto);
    }
	

	@PostMapping("/modificacion")
    public @ResponseBody CiudadDTO modificacion(@RequestBody CiudadDTO dto){
		return service.modificacion(dto);
    }

}
