package stps.gob.mx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stps.gob.mx.dto.HabilidadCompetenciaDTO;
import stps.gob.mx.service.HabilidadCompetenciaService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/HabilidadCompetencia"})
public class HabilidadCompetenciaController {
	
	@Autowired
	HabilidadCompetenciaService service;
	

	@PostMapping("/alta")
    public @ResponseBody HabilidadCompetenciaDTO alta(@RequestBody HabilidadCompetenciaDTO dto){
		return service.alta(dto);
    }
	

	@PostMapping("/baja")
    public @ResponseBody HabilidadCompetenciaDTO baja(@RequestBody HabilidadCompetenciaDTO dto){
		return  service.baja(dto);
    }
	

	@PostMapping("/consulta")
    public @ResponseBody List<HabilidadCompetenciaDTO> consulta(@RequestBody HabilidadCompetenciaDTO dto){
		return service.consulta(dto);
    }
	

	@PostMapping("/consultaId")
    public @ResponseBody List<HabilidadCompetenciaDTO> consultaId(@RequestBody HabilidadCompetenciaDTO dto){
		return service.consultaId(dto);
    }
	

	@PostMapping("/modificacion")
    public @ResponseBody HabilidadCompetenciaDTO modificacion(@RequestBody HabilidadCompetenciaDTO dto){
		return service.modificacion(dto);
    }

}
