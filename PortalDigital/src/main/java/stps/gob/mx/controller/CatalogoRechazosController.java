package stps.gob.mx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stps.gob.mx.dto.CatalogoRechazosDTO;
import stps.gob.mx.service.CatalogoRechazosService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/CatalogoRechazos"})
public class CatalogoRechazosController {
	
	@Autowired
	CatalogoRechazosService service;
	

	@PostMapping("/alta")
    public @ResponseBody CatalogoRechazosDTO alta(@RequestBody CatalogoRechazosDTO dto){
		return service.alta(dto);
    }
	

	@PostMapping("/baja")
    public @ResponseBody CatalogoRechazosDTO baja(@RequestBody CatalogoRechazosDTO dto){
		return  service.baja(dto);
    }
	

	@PostMapping("/consulta")
    public @ResponseBody List<CatalogoRechazosDTO> consulta(@RequestBody CatalogoRechazosDTO dto){
		return service.consulta(dto);
    }
	

	@PostMapping("/consultaId")
    public @ResponseBody List<CatalogoRechazosDTO> consultaId(@RequestBody CatalogoRechazosDTO dto){
		return service.consultaId(dto);
    }
	

	@PostMapping("/modificacion")
    public @ResponseBody CatalogoRechazosDTO modificacion(@RequestBody CatalogoRechazosDTO dto){
		return service.modificacion(dto);
    }

}
