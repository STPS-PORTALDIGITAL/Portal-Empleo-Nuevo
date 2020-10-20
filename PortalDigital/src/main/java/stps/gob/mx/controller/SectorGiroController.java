package stps.gob.mx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stps.gob.mx.dto.SectorGiroDTO;
import stps.gob.mx.service.SectorGiroService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/SectorGiro"})
public class SectorGiroController {
	
	@Autowired
	SectorGiroService service;
	

	@PostMapping("/alta")
    public @ResponseBody SectorGiroDTO alta(@RequestBody SectorGiroDTO dto){
		return service.alta(dto);
    }
	

	@PostMapping("/baja")
    public @ResponseBody SectorGiroDTO baja(@RequestBody SectorGiroDTO dto){
		return  service.baja(dto);
    }
	

	@PostMapping("/consulta")
    public @ResponseBody List<SectorGiroDTO> consulta(@RequestBody SectorGiroDTO dto){
		return service.consulta(dto);
    }
	

	@PostMapping("/consultaId")
    public @ResponseBody List<SectorGiroDTO> consultaId(@RequestBody SectorGiroDTO dto){
		return service.consultaId(dto);
    }
	

	@PostMapping("/modificacion")
    public @ResponseBody SectorGiroDTO modificacion(@RequestBody SectorGiroDTO dto){
		return service.modificacion(dto);
    }

}
