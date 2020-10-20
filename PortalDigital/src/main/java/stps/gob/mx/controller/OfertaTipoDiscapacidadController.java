package stps.gob.mx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stps.gob.mx.dto.OfertaTipoDiscapacidadDTO;
import stps.gob.mx.service.OfertaTipoDiscapacidadService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/OfertaTipoDiscapacidad"})
public class OfertaTipoDiscapacidadController {
	
	@Autowired
	OfertaTipoDiscapacidadService service;
	

	@PostMapping("/alta")
    public @ResponseBody OfertaTipoDiscapacidadDTO alta(@RequestBody OfertaTipoDiscapacidadDTO dto){
		return service.alta(dto);
    }
	

	@PostMapping("/baja")
    public @ResponseBody OfertaTipoDiscapacidadDTO baja(@RequestBody OfertaTipoDiscapacidadDTO dto){
		return  service.baja(dto);
    }
	

	@PostMapping("/consulta")
    public @ResponseBody List<OfertaTipoDiscapacidadDTO> consulta(@RequestBody OfertaTipoDiscapacidadDTO dto){
		return service.consulta(dto);
    }
	

	@PostMapping("/consultaId")
    public @ResponseBody List<OfertaTipoDiscapacidadDTO> consultaId(@RequestBody OfertaTipoDiscapacidadDTO dto){
		return service.consultaId(dto);
    }
	

	@PostMapping("/modificacion")
    public @ResponseBody OfertaTipoDiscapacidadDTO modificacion(@RequestBody OfertaTipoDiscapacidadDTO dto){
		return service.modificacion(dto);
    }

}
