package stps.gob.mx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stps.gob.mx.dto.MunicipioDTO;
import stps.gob.mx.service.MunicipioService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/Municipio"})
public class MunicipioController {
	
	@Autowired
	MunicipioService service;
	

	@PostMapping("/alta")
    public @ResponseBody MunicipioDTO alta(@RequestBody MunicipioDTO dto){
		return service.alta(dto);
    }
	

	@PostMapping("/baja")
    public @ResponseBody MunicipioDTO baja(@RequestBody MunicipioDTO dto){
		return  service.baja(dto);
    }
	

	@PostMapping("/consulta")
    public @ResponseBody List<MunicipioDTO> consulta(@RequestBody MunicipioDTO dto){
		return service.consulta(dto);
    }
	

	@PostMapping("/consultaId")
    public @ResponseBody List<MunicipioDTO> consultaId(@RequestBody MunicipioDTO dto){
		return service.consultaId(dto);
    }
	

	@PostMapping("/modificacion")
    public @ResponseBody MunicipioDTO modificacion(@RequestBody MunicipioDTO dto){
		return service.modificacion(dto);
    }

}
