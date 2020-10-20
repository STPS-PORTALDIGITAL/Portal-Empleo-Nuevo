package stps.gob.mx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stps.gob.mx.dto.CodigoPostalDTO;
import stps.gob.mx.service.CodigoPostalService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/CodigoPostal"})
public class CodigoPostalController {
	
	@Autowired
	CodigoPostalService service;
	

	@PostMapping("/alta")
    public @ResponseBody CodigoPostalDTO alta(@RequestBody CodigoPostalDTO dto){
		return service.alta(dto);
    }
	

	@PostMapping("/baja")
    public @ResponseBody CodigoPostalDTO baja(@RequestBody CodigoPostalDTO dto){
		return  service.baja(dto);
    }
	

	@PostMapping("/consulta")
    public @ResponseBody List<CodigoPostalDTO> consulta(@RequestBody CodigoPostalDTO dto){
		return service.consulta(dto);
    }
	

	@PostMapping("/consultaId")
    public @ResponseBody List<CodigoPostalDTO> consultaId(@RequestBody CodigoPostalDTO dto){
		return service.consultaId(dto);
    }
	

	@PostMapping("/modificacion")
    public @ResponseBody CodigoPostalDTO modificacion(@RequestBody CodigoPostalDTO dto){
		return service.modificacion(dto);
    }

}
