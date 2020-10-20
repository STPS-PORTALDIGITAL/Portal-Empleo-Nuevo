package stps.gob.mx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stps.gob.mx.dto.InstitucionEducativaDTO;
import stps.gob.mx.service.InstitucionEducativaService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/InstitucionEducativa"})
public class InstitucionEducativaController {
	
	@Autowired
	InstitucionEducativaService service;
	

	@PostMapping("/alta")
    public @ResponseBody InstitucionEducativaDTO alta(@RequestBody InstitucionEducativaDTO dto){
		return service.alta(dto);
    }
	

	@PostMapping("/baja")
    public @ResponseBody InstitucionEducativaDTO baja(@RequestBody InstitucionEducativaDTO dto){
		return  service.baja(dto);
    }
	

	@PostMapping("/consulta")
    public @ResponseBody List<InstitucionEducativaDTO> consulta(@RequestBody InstitucionEducativaDTO dto){
		return service.consulta(dto);
    }
	

	@PostMapping("/consultaId")
    public @ResponseBody List<InstitucionEducativaDTO> consultaId(@RequestBody InstitucionEducativaDTO dto){
		return service.consultaId(dto);
    }
	

	@PostMapping("/modificacion")
    public @ResponseBody InstitucionEducativaDTO modificacion(@RequestBody InstitucionEducativaDTO dto){
		return service.modificacion(dto);
    }

}
