package stps.gob.mx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stps.gob.mx.dto.RolesDTO;
import stps.gob.mx.service.RolesService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/Roles"})
public class RolesController {
	
	@Autowired
	RolesService service;
	

	@PostMapping("/alta")
    public @ResponseBody RolesDTO alta(@RequestBody RolesDTO dto){
		return service.alta(dto);
    }
	

	@PostMapping("/baja")
    public @ResponseBody RolesDTO baja(@RequestBody RolesDTO dto){
		return  service.baja(dto);
    }
	

	@PostMapping("/consulta")
    public @ResponseBody List<RolesDTO> consulta(@RequestBody RolesDTO dto){
		return service.consulta(dto);
    }
	

	@PostMapping("/consultaId")
    public @ResponseBody List<RolesDTO> consultaId(@RequestBody RolesDTO dto){
		return service.consultaId(dto);
    }
	

	@PostMapping("/modificacion")
    public @ResponseBody RolesDTO modificacion(@RequestBody RolesDTO dto){
		return service.modificacion(dto);
    }

}
