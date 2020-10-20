package stps.gob.mx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stps.gob.mx.dto.CurriculumDTO;
import stps.gob.mx.service.CurriculumService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/Curriculum"})
public class CurriculumController {
	
	@Autowired
	CurriculumService service;
	

	@PostMapping("/alta")
    public @ResponseBody CurriculumDTO alta(@RequestBody CurriculumDTO dto){
		return service.alta(dto);
    }
	

	@PostMapping("/baja")
    public @ResponseBody CurriculumDTO baja(@RequestBody CurriculumDTO dto){
		return  service.baja(dto);
    }
	

	@PostMapping("/consulta")
    public @ResponseBody List<CurriculumDTO> consulta(@RequestBody CurriculumDTO dto){
		return service.consulta(dto);
    }
	

	@PostMapping("/consultaId")
    public @ResponseBody List<CurriculumDTO> consultaId(@RequestBody CurriculumDTO dto){
		return service.consultaId(dto);
    }
	

	@PostMapping("/modificacion")
    public @ResponseBody CurriculumDTO modificacion(@RequestBody CurriculumDTO dto){
		return service.modificacion(dto);
    }

}
