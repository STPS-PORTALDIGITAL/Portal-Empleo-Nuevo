package stps.gob.mx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stps.gob.mx.dto.IdiomaDTO;
import stps.gob.mx.service.IdiomaService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/Idioma"})
public class IdiomaController {
	
	@Autowired
	IdiomaService service;
	

	@PostMapping("/alta")
    public @ResponseBody IdiomaDTO alta(@RequestBody IdiomaDTO dto){
		return service.alta(dto);
    }
	

	@PostMapping("/baja")
    public @ResponseBody IdiomaDTO baja(@RequestBody IdiomaDTO dto){
		return  service.baja(dto);
    }
	

	@PostMapping("/consulta")
    public @ResponseBody List<IdiomaDTO> consulta(@RequestBody IdiomaDTO dto){
		return service.consulta(dto);
    }
	

	@PostMapping("/consultaId")
    public @ResponseBody List<IdiomaDTO> consultaId(@RequestBody IdiomaDTO dto){
		return service.consultaId(dto);
    }
	

	@PostMapping("/modificacion")
    public @ResponseBody IdiomaDTO modificacion(@RequestBody IdiomaDTO dto){
		return service.modificacion(dto);
    }

}
