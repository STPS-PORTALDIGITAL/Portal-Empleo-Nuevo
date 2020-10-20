package stps.gob.mx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stps.gob.mx.dto.TipoInstitucionEducativaDTO;
import stps.gob.mx.service.TipoInstitucionEducativaService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/TipoInstitucionEducativa"})
public class TipoInstitucionEducativaController {
	
	@Autowired
	TipoInstitucionEducativaService service;
	

	@PostMapping("/alta")
    public @ResponseBody TipoInstitucionEducativaDTO alta(@RequestBody TipoInstitucionEducativaDTO dto){
		return service.alta(dto);
    }
	

	@PostMapping("/baja")
    public @ResponseBody TipoInstitucionEducativaDTO baja(@RequestBody TipoInstitucionEducativaDTO dto){
		return  service.baja(dto);
    }
	

	@PostMapping("/consulta")
    public @ResponseBody List<TipoInstitucionEducativaDTO> consulta(@RequestBody TipoInstitucionEducativaDTO dto){
		return service.consulta(dto);
    }
	

	@PostMapping("/consultaId")
    public @ResponseBody List<TipoInstitucionEducativaDTO> consultaId(@RequestBody TipoInstitucionEducativaDTO dto){
		return service.consultaId(dto);
    }
	

	@PostMapping("/modificacion")
    public @ResponseBody TipoInstitucionEducativaDTO modificacion(@RequestBody TipoInstitucionEducativaDTO dto){
		return service.modificacion(dto);
    }

}
