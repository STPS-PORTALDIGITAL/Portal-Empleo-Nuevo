package stps.gob.mx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stps.gob.mx.dto.OfertaEmpleoDTO;
import stps.gob.mx.service.OfertaEmpleoService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/OfertaEmpleo"})
public class OfertaEmpleoController {
	
	@Autowired
	OfertaEmpleoService service;
	

	@PostMapping("/alta")
    public @ResponseBody OfertaEmpleoDTO alta(@RequestBody OfertaEmpleoDTO dto){
		return service.alta(dto);
    }
	

	@PostMapping("/baja")
    public @ResponseBody OfertaEmpleoDTO baja(@RequestBody OfertaEmpleoDTO dto){
		return  service.baja(dto);
    }
	

	@PostMapping("/consulta")
    public @ResponseBody List<OfertaEmpleoDTO> consulta(@RequestBody OfertaEmpleoDTO dto){
		return service.consulta(dto);
    }
	

	@PostMapping("/consultaId")
    public @ResponseBody List<OfertaEmpleoDTO> consultaId(@RequestBody OfertaEmpleoDTO dto){
		return service.consultaId(dto);
    }
	

	@PostMapping("/modificacion")
    public @ResponseBody OfertaEmpleoDTO modificacion(@RequestBody OfertaEmpleoDTO dto){
		return service.modificacion(dto);
    }
	


}
