package stps.gob.mx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stps.gob.mx.dto.CurriculumHabilidadCompetenciaDTO;
import stps.gob.mx.service.CurriculumHabilidadCompetenciaService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/CurriculumHabilidadCompetencia"})
public class CurriculumHabilidadCompetenciaController {
	
	@Autowired
	CurriculumHabilidadCompetenciaService service;
	

	@PostMapping("/alta")
    public @ResponseBody CurriculumHabilidadCompetenciaDTO alta(@RequestBody CurriculumHabilidadCompetenciaDTO dto){
		return service.alta(dto);
    }
	

	@PostMapping("/baja")
    public @ResponseBody CurriculumHabilidadCompetenciaDTO baja(@RequestBody CurriculumHabilidadCompetenciaDTO dto){
		return  service.baja(dto);
    }
	

	@PostMapping("/consulta")
    public @ResponseBody List<CurriculumHabilidadCompetenciaDTO> consulta(@RequestBody CurriculumHabilidadCompetenciaDTO dto){
		return service.consulta(dto);
    }
	

	@PostMapping("/consultaId")
    public @ResponseBody List<CurriculumHabilidadCompetenciaDTO> consultaId(@RequestBody CurriculumHabilidadCompetenciaDTO dto){
		return service.consultaId(dto);
    }
	

	@PostMapping("/modificacion")
    public @ResponseBody CurriculumHabilidadCompetenciaDTO modificacion(@RequestBody CurriculumHabilidadCompetenciaDTO dto){
		return service.modificacion(dto);
    }

}
