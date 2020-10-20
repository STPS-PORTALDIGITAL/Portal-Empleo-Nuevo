package stps.gob.mx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stps.gob.mx.dto.ContactoEmpleadorDTO;
import stps.gob.mx.service.ContactoEmpleadorService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/ContactoEmpleador"})
public class ContactoEmpleadorController {
	
	@Autowired
	ContactoEmpleadorService service;
	

	@PostMapping("/alta")
    public @ResponseBody ContactoEmpleadorDTO alta(@RequestBody ContactoEmpleadorDTO dto){
		return service.alta(dto);
    }
	

	@PostMapping("/baja")
    public @ResponseBody ContactoEmpleadorDTO baja(@RequestBody ContactoEmpleadorDTO dto){
		return  service.baja(dto);
    }
	

	@PostMapping("/consulta")
    public @ResponseBody List<ContactoEmpleadorDTO> consulta(@RequestBody ContactoEmpleadorDTO dto){
		return service.consulta(dto);
    }
	

	@PostMapping("/consultaId")
    public @ResponseBody List<ContactoEmpleadorDTO> consultaId(@RequestBody ContactoEmpleadorDTO dto){
		return service.consultaId(dto);
    }
	

	@PostMapping("/modificacion")
    public @ResponseBody ContactoEmpleadorDTO modificacion(@RequestBody ContactoEmpleadorDTO dto){
		return service.modificacion(dto);
    }

}
