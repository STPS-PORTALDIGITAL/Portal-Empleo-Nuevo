package stps.gob.mx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stps.gob.mx.dto.NivelEducativoDTO;
import stps.gob.mx.service.NivelEducativoService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/NivelEducativo"})
public class NivelEducativoController {
	
	@Autowired
	NivelEducativoService service;
	

	@PostMapping("/alta")
    public @ResponseBody NivelEducativoDTO alta(@RequestBody NivelEducativoDTO dto){
		return service.alta(dto);
    }
	

	@PostMapping("/baja")
    public @ResponseBody NivelEducativoDTO baja(@RequestBody NivelEducativoDTO dto){
		return  service.baja(dto);
    }
	

	@PostMapping("/consulta")
    public @ResponseBody List<NivelEducativoDTO> consulta(@RequestBody NivelEducativoDTO dto){
		return service.consulta(dto);
    }
	

	@PostMapping("/consultaId")
    public @ResponseBody List<NivelEducativoDTO> consultaId(@RequestBody NivelEducativoDTO dto){
		return service.consultaId(dto);
    }
	

	@PostMapping("/modificacion")
    public @ResponseBody NivelEducativoDTO modificacion(@RequestBody NivelEducativoDTO dto){
		return service.modificacion(dto);
    }

}
