package stps.gob.mx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stps.gob.mx.dto.CurriculumEscolaridadDTO;
import stps.gob.mx.service.CurriculumEscolaridadService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/CurriculumEscolaridad"})
public class CurriculumEscolaridadController {
	
	@Autowired
	CurriculumEscolaridadService service;
	

	@PostMapping("/alta")
    public @ResponseBody CurriculumEscolaridadDTO alta(@RequestBody CurriculumEscolaridadDTO dto){
		return service.alta(dto);
    }
	

	@PostMapping("/baja")
    public @ResponseBody CurriculumEscolaridadDTO baja(@RequestBody CurriculumEscolaridadDTO dto){
		return  service.baja(dto);
    }
	

	@PostMapping("/consulta")
    public @ResponseBody List<CurriculumEscolaridadDTO> consulta(@RequestBody CurriculumEscolaridadDTO dto){
		return service.consulta(dto);
    }
	

	@PostMapping("/consultaId")
    public @ResponseBody List<CurriculumEscolaridadDTO> consultaId(@RequestBody CurriculumEscolaridadDTO dto){
		return service.consultaId(dto);
    }
	

	@PostMapping("/modificacion")
    public @ResponseBody CurriculumEscolaridadDTO modificacion(@RequestBody CurriculumEscolaridadDTO dto){
		return service.modificacion(dto);
    }

}
