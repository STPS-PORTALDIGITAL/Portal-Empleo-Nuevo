package stps.gob.mx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stps.gob.mx.dto.ConocimientoHerramientaDTO;
import stps.gob.mx.service.ConocimientoHerramientaService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/ConocimientoHerramienta"})
public class ConocimientoHerramientaController {
	
	@Autowired
	ConocimientoHerramientaService service;
	

	@PostMapping("/alta")
    public @ResponseBody ConocimientoHerramientaDTO alta(@RequestBody ConocimientoHerramientaDTO dto){
		return service.alta(dto);
    }
	

	@PostMapping("/baja")
    public @ResponseBody ConocimientoHerramientaDTO baja(@RequestBody ConocimientoHerramientaDTO dto){
		return  service.baja(dto);
    }
	

	@PostMapping("/consulta")
    public @ResponseBody List<ConocimientoHerramientaDTO> consulta(@RequestBody ConocimientoHerramientaDTO dto){
		return service.consulta(dto);
    }
	

	@PostMapping("/consultaId")
    public @ResponseBody List<ConocimientoHerramientaDTO> consultaId(@RequestBody ConocimientoHerramientaDTO dto){
		return service.consultaId(dto);
    }
	

	@PostMapping("/modificacion")
    public @ResponseBody ConocimientoHerramientaDTO modificacion(@RequestBody ConocimientoHerramientaDTO dto){
		return service.modificacion(dto);
    }

}
