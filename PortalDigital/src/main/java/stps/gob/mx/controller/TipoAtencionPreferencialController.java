package stps.gob.mx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stps.gob.mx.dto.TipoAtencionPreferencialDTO;
import stps.gob.mx.service.TipoAtencionPreferencialService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/TipoAtencionPreferencial"})
public class TipoAtencionPreferencialController {
	
	@Autowired
	TipoAtencionPreferencialService service;
	

	@PostMapping("/alta")
    public @ResponseBody TipoAtencionPreferencialDTO alta(@RequestBody TipoAtencionPreferencialDTO dto){
		return service.alta(dto);
    }
	

	@PostMapping("/baja")
    public @ResponseBody TipoAtencionPreferencialDTO baja(@RequestBody TipoAtencionPreferencialDTO dto){
		return  service.baja(dto);
    }
	

	@PostMapping("/consulta")
    public @ResponseBody List<TipoAtencionPreferencialDTO> consulta(@RequestBody TipoAtencionPreferencialDTO dto){
		return service.consulta(dto);
    }
	

	@PostMapping("/consultaId")
    public @ResponseBody List<TipoAtencionPreferencialDTO> consultaId(@RequestBody TipoAtencionPreferencialDTO dto){
		return service.consultaId(dto);
    }
	

	@PostMapping("/modificacion")
    public @ResponseBody TipoAtencionPreferencialDTO modificacion(@RequestBody TipoAtencionPreferencialDTO dto){
		return service.modificacion(dto);
    }

}
