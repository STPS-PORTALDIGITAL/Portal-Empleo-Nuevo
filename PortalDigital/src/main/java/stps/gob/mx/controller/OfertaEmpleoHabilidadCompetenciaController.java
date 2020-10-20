package stps.gob.mx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stps.gob.mx.dto.OfertaEmpleoHabilidadCompetenciaDTO;
import stps.gob.mx.service.OfertaEmpleoHabilidadCompetenciaService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/OfertaEmpleoHabilidadCompetencia"})
public class OfertaEmpleoHabilidadCompetenciaController {
	
	@Autowired
	OfertaEmpleoHabilidadCompetenciaService service;
	

	@PostMapping("/alta")
    public @ResponseBody OfertaEmpleoHabilidadCompetenciaDTO alta(@RequestBody OfertaEmpleoHabilidadCompetenciaDTO dto){
		return service.alta(dto);
    }
	

	@PostMapping("/baja")
    public @ResponseBody OfertaEmpleoHabilidadCompetenciaDTO baja(@RequestBody OfertaEmpleoHabilidadCompetenciaDTO dto){
		return  service.baja(dto);
    }
	

	@PostMapping("/consulta")
    public @ResponseBody List<OfertaEmpleoHabilidadCompetenciaDTO> consulta(@RequestBody OfertaEmpleoHabilidadCompetenciaDTO dto){
		return service.consulta(dto);
    }
	

	@PostMapping("/consultaId")
    public @ResponseBody List<OfertaEmpleoHabilidadCompetenciaDTO> consultaId(@RequestBody OfertaEmpleoHabilidadCompetenciaDTO dto){
		return service.consultaId(dto);
    }
	

	@PostMapping("/modificacion")
    public @ResponseBody OfertaEmpleoHabilidadCompetenciaDTO modificacion(@RequestBody OfertaEmpleoHabilidadCompetenciaDTO dto){
		return service.modificacion(dto);
    }

}
