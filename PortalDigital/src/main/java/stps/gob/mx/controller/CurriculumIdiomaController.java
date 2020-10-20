package stps.gob.mx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stps.gob.mx.dto.CurriculumIdiomaDTO;
import stps.gob.mx.service.CurriculumIdiomaService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/CurriculumIdioma"})
public class CurriculumIdiomaController {
	
	@Autowired
	CurriculumIdiomaService service;
	

	@PostMapping("/alta")
    public @ResponseBody CurriculumIdiomaDTO alta(@RequestBody CurriculumIdiomaDTO dto){
		return service.alta(dto);
    }
	

	@PostMapping("/baja")
    public @ResponseBody CurriculumIdiomaDTO baja(@RequestBody CurriculumIdiomaDTO dto){
		return  service.baja(dto);
    }
	

	@PostMapping("/consulta")
    public @ResponseBody List<CurriculumIdiomaDTO> consulta(@RequestBody CurriculumIdiomaDTO dto){
		return service.consulta(dto);
    }
	

	@PostMapping("/consultaId")
    public @ResponseBody List<CurriculumIdiomaDTO> consultaId(@RequestBody CurriculumIdiomaDTO dto){
		return service.consultaId(dto);
    }
	

	@PostMapping("/modificacion")
    public @ResponseBody CurriculumIdiomaDTO modificacion(@RequestBody CurriculumIdiomaDTO dto){
		return service.modificacion(dto);
    }

}
