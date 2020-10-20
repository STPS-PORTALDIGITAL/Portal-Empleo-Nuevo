package stps.gob.mx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stps.gob.mx.dto.OfertaEmpleoConocimientoHerramientaDTO;
import stps.gob.mx.service.OfertaEmpleoConocimientoHerramientaService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/OfertaEmpleoConocimientoHerramienta"})
public class OfertaEmpleoConocimientoHerramientaController {
	
	@Autowired
	OfertaEmpleoConocimientoHerramientaService service;
	

	@PostMapping("/alta")
    public @ResponseBody OfertaEmpleoConocimientoHerramientaDTO alta(@RequestBody OfertaEmpleoConocimientoHerramientaDTO dto){
		return service.alta(dto);
    }
	

	@PostMapping("/baja")
    public @ResponseBody OfertaEmpleoConocimientoHerramientaDTO baja(@RequestBody OfertaEmpleoConocimientoHerramientaDTO dto){
		return  service.baja(dto);
    }
	

	@PostMapping("/consulta")
    public @ResponseBody List<OfertaEmpleoConocimientoHerramientaDTO> consulta(@RequestBody OfertaEmpleoConocimientoHerramientaDTO dto){
		return service.consulta(dto);
    }
	

	@PostMapping("/consultaId")
    public @ResponseBody List<OfertaEmpleoConocimientoHerramientaDTO> consultaId(@RequestBody OfertaEmpleoConocimientoHerramientaDTO dto){
		return service.consultaId(dto);
    }
	

	@PostMapping("/modificacion")
    public @ResponseBody OfertaEmpleoConocimientoHerramientaDTO modificacion(@RequestBody OfertaEmpleoConocimientoHerramientaDTO dto){
		return service.modificacion(dto);
    }

}
