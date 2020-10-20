package stps.gob.mx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stps.gob.mx.dto.FeriaEmpleoDTO;
import stps.gob.mx.service.FeriaEmpleoService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/FeriaEmpleo"})
public class FeriaEmpleoController {
	
	@Autowired
	FeriaEmpleoService service;
	

	@PostMapping("/alta")
    public @ResponseBody FeriaEmpleoDTO alta(@RequestBody FeriaEmpleoDTO dto){
		return service.alta(dto);
    }
	

	@PostMapping("/baja")
    public @ResponseBody FeriaEmpleoDTO baja(@RequestBody FeriaEmpleoDTO dto){
		return  service.baja(dto);
    }
	

	@PostMapping("/consulta")
    public @ResponseBody List<FeriaEmpleoDTO> consulta(@RequestBody FeriaEmpleoDTO dto){
		return service.consulta(dto);
    }
	

	@PostMapping("/consultaId")
    public @ResponseBody List<FeriaEmpleoDTO> consultaId(@RequestBody FeriaEmpleoDTO dto){
		return service.consultaId(dto);
    }
	

	@PostMapping("/modificacion")
    public @ResponseBody FeriaEmpleoDTO modificacion(@RequestBody FeriaEmpleoDTO dto){
		return service.modificacion(dto);
    }

}
