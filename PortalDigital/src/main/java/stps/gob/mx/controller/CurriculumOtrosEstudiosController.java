package stps.gob.mx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stps.gob.mx.dto.CurriculumOtrosEstudiosDTO;
import stps.gob.mx.service.CurriculumOtrosEstudiosService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/CurriculumOtrosEstudios"})
public class CurriculumOtrosEstudiosController {
	
	@Autowired
	CurriculumOtrosEstudiosService service;
	

	@PostMapping("/alta")
    public @ResponseBody CurriculumOtrosEstudiosDTO alta(@RequestBody CurriculumOtrosEstudiosDTO dto){
		return service.alta(dto);
    }
	

	@PostMapping("/baja")
    public @ResponseBody CurriculumOtrosEstudiosDTO baja(@RequestBody CurriculumOtrosEstudiosDTO dto){
		return  service.baja(dto);
    }
	

	@PostMapping("/consulta")
    public @ResponseBody List<CurriculumOtrosEstudiosDTO> consulta(@RequestBody CurriculumOtrosEstudiosDTO dto){
		return service.consulta(dto);
    }
	

	@PostMapping("/consultaId")
    public @ResponseBody List<CurriculumOtrosEstudiosDTO> consultaId(@RequestBody CurriculumOtrosEstudiosDTO dto){
		return service.consultaId(dto);
    }
	

	@PostMapping("/modificacion")
    public @ResponseBody CurriculumOtrosEstudiosDTO modificacion(@RequestBody CurriculumOtrosEstudiosDTO dto){
		return service.modificacion(dto);
    }

}
