package stps.gob.mx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stps.gob.mx.dto.CurriculumExperienciaLaboralDTO;
import stps.gob.mx.service.CurriculumExperienciaLaboralService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/CurriculumExperienciaLaboral"})
public class CurriculumExperienciaLaboralController {
	
	@Autowired
	CurriculumExperienciaLaboralService service;
	

	@PostMapping("/alta")
    public @ResponseBody CurriculumExperienciaLaboralDTO alta(@RequestBody CurriculumExperienciaLaboralDTO dto){
		return service.alta(dto);
    }
	

	@PostMapping("/baja")
    public @ResponseBody CurriculumExperienciaLaboralDTO baja(@RequestBody CurriculumExperienciaLaboralDTO dto){
		return  service.baja(dto);
    }
	

	@PostMapping("/consulta")
    public @ResponseBody List<CurriculumExperienciaLaboralDTO> consulta(@RequestBody CurriculumExperienciaLaboralDTO dto){
		return service.consulta(dto);
    }
	

	@PostMapping("/consultaId")
    public @ResponseBody List<CurriculumExperienciaLaboralDTO> consultaId(@RequestBody CurriculumExperienciaLaboralDTO dto){
		return service.consultaId(dto);
    }
	

	@PostMapping("/modificacion")
    public @ResponseBody CurriculumExperienciaLaboralDTO modificacion(@RequestBody CurriculumExperienciaLaboralDTO dto){
		return service.modificacion(dto);
    }

}
