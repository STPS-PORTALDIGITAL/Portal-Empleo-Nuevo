package stps.gob.mx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stps.gob.mx.dto.PaisDTO;
import stps.gob.mx.service.PaisService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/Pais"})
public class PaisController {
	
	@Autowired
	PaisService service;
	

	@PostMapping("/alta")
    public @ResponseBody PaisDTO alta(@RequestBody PaisDTO dto){
		return service.alta(dto);
    }
	

	@PostMapping("/baja")
    public @ResponseBody PaisDTO baja(@RequestBody PaisDTO dto){
		return  service.baja(dto);
    }
	

	@PostMapping("/consulta")
    public @ResponseBody List<PaisDTO> consulta(@RequestBody PaisDTO dto){
		return service.consulta(dto);
    }
	

	@PostMapping("/consultaId")
    public @ResponseBody List<PaisDTO> consultaId(@RequestBody PaisDTO dto){
		return service.consultaId(dto);
    }
	

	@PostMapping("/modificacion")
    public @ResponseBody PaisDTO modificacion(@RequestBody PaisDTO dto){
		return service.modificacion(dto);
    }

}
