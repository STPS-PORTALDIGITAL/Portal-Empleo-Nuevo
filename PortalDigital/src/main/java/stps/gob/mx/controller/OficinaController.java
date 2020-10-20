package stps.gob.mx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stps.gob.mx.dto.OficinaDTO;
import stps.gob.mx.service.OficinaService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/Oficina"})
public class OficinaController {
	
	@Autowired
	OficinaService service;
	

	@PostMapping("/alta")
    public @ResponseBody OficinaDTO alta(@RequestBody OficinaDTO dto){
		return service.alta(dto);
    }
	

	@PostMapping("/baja")
    public @ResponseBody OficinaDTO baja(@RequestBody OficinaDTO dto){
		return  service.baja(dto);
    }
	

	@PostMapping("/consulta")
    public @ResponseBody List<OficinaDTO> consulta(@RequestBody OficinaDTO dto){
		return service.consulta(dto);
    }
	

	@PostMapping("/consultaId")
    public @ResponseBody List<OficinaDTO> consultaId(@RequestBody OficinaDTO dto){
		return service.consultaId(dto);
    }
	

	@PostMapping("/modificacion")
    public @ResponseBody OficinaDTO modificacion(@RequestBody OficinaDTO dto){
		return service.modificacion(dto);
    }

}
