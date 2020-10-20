package stps.gob.mx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stps.gob.mx.dto.CurriculumConocimientoHerramientaDTO;
import stps.gob.mx.service.CurriculumConocimientoHerramientaService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/CurriculumConocimientoHerramienta"})
public class CurriculumConocimientoHerramientaController {
	
	@Autowired
	CurriculumConocimientoHerramientaService service;
	

	@PostMapping("/alta")
    public @ResponseBody CurriculumConocimientoHerramientaDTO alta(@RequestBody CurriculumConocimientoHerramientaDTO dto){
		return service.alta(dto);
    }
	

	@PostMapping("/baja")
    public @ResponseBody CurriculumConocimientoHerramientaDTO baja(@RequestBody CurriculumConocimientoHerramientaDTO dto){
		return  service.baja(dto);
    }
	

	@PostMapping("/consulta")
    public @ResponseBody List<CurriculumConocimientoHerramientaDTO> consulta(@RequestBody CurriculumConocimientoHerramientaDTO dto){
		return service.consulta(dto);
    }
	

	@PostMapping("/consultaId")
    public @ResponseBody List<CurriculumConocimientoHerramientaDTO> consultaId(@RequestBody CurriculumConocimientoHerramientaDTO dto){
		return service.consultaId(dto);
    }
	

	@PostMapping("/modificacion")
    public @ResponseBody CurriculumConocimientoHerramientaDTO modificacion(@RequestBody CurriculumConocimientoHerramientaDTO dto){
		return service.modificacion(dto);
    }

}
