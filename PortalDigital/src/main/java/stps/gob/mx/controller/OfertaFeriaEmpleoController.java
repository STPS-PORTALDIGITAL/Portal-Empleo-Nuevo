package stps.gob.mx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stps.gob.mx.dto.OfertaFeriaEmpleoDTO;
import stps.gob.mx.service.OfertaFeriaEmpleoService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/OfertaFeriaEmpleo"})
public class OfertaFeriaEmpleoController {
	
	@Autowired
	OfertaFeriaEmpleoService service;
	

	@PostMapping("/alta")
    public @ResponseBody OfertaFeriaEmpleoDTO alta(@RequestBody OfertaFeriaEmpleoDTO dto){
		return service.alta(dto);
    }
	

	@PostMapping("/baja")
    public @ResponseBody OfertaFeriaEmpleoDTO baja(@RequestBody OfertaFeriaEmpleoDTO dto){
		return  service.baja(dto);
    }
	

	@PostMapping("/consulta")
    public @ResponseBody List<OfertaFeriaEmpleoDTO> consulta(@RequestBody OfertaFeriaEmpleoDTO dto){
		return service.consulta(dto);
    }
	

	@PostMapping("/consultaId")
    public @ResponseBody List<OfertaFeriaEmpleoDTO> consultaId(@RequestBody OfertaFeriaEmpleoDTO dto){
		return service.consultaId(dto);
    }
	

	@PostMapping("/modificacion")
    public @ResponseBody OfertaFeriaEmpleoDTO modificacion(@RequestBody OfertaFeriaEmpleoDTO dto){
		return service.modificacion(dto);
    }

}
