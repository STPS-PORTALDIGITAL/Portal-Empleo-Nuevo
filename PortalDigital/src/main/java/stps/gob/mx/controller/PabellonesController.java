package stps.gob.mx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stps.gob.mx.dto.PabellonesDTO;
import stps.gob.mx.service.PabellonesService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/Pabellones"})
public class PabellonesController {
	
	@Autowired
	PabellonesService service;
	

	@PostMapping("/alta")
    public @ResponseBody PabellonesDTO alta(@RequestBody PabellonesDTO dto){
		return service.alta(dto);
    }
	

	@PostMapping("/baja")
    public @ResponseBody PabellonesDTO baja(@RequestBody PabellonesDTO dto){
		return  service.baja(dto);
    }
	

	@PostMapping("/consulta")
    public @ResponseBody List<PabellonesDTO> consulta(@RequestBody PabellonesDTO dto){
		return service.consulta(dto);
    }
	

	@PostMapping("/consultaId")
    public @ResponseBody List<PabellonesDTO> consultaId(@RequestBody PabellonesDTO dto){
		return service.consultaId(dto);
    }
	

	@PostMapping("/modificacion")
    public @ResponseBody PabellonesDTO modificacion(@RequestBody PabellonesDTO dto){
		return service.modificacion(dto);
    }

}
