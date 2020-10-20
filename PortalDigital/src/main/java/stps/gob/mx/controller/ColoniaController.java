package stps.gob.mx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stps.gob.mx.dto.ColoniaDTO;
import stps.gob.mx.service.ColoniaService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/Colonia"})
public class ColoniaController {
	
	@Autowired
	ColoniaService service;
	

	@PostMapping("/alta")
    public @ResponseBody ColoniaDTO alta(@RequestBody ColoniaDTO dto){
		return service.alta(dto);
    }
	

	@PostMapping("/baja")
    public @ResponseBody ColoniaDTO baja(@RequestBody ColoniaDTO dto){
		return  service.baja(dto);
    }
	

	@PostMapping("/consulta")
    public @ResponseBody List<ColoniaDTO> consulta(@RequestBody ColoniaDTO dto){
		return service.consulta(dto);
    }
	

	@PostMapping("/consultaId")
    public @ResponseBody List<ColoniaDTO> consultaId(@RequestBody ColoniaDTO dto){
		return service.consultaId(dto);
    }
	

	@PostMapping("/modificacion")
    public @ResponseBody ColoniaDTO modificacion(@RequestBody ColoniaDTO dto){
		return service.modificacion(dto);
    }

}
