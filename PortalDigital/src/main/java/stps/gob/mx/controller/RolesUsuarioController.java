package stps.gob.mx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stps.gob.mx.dto.RolesUsuarioDTO;
import stps.gob.mx.service.RolesUsuarioService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/RolesUsuario"})
public class RolesUsuarioController {
	
	@Autowired
	RolesUsuarioService service;
	

	@PostMapping("/alta")
    public @ResponseBody RolesUsuarioDTO alta(@RequestBody RolesUsuarioDTO dto){
		return service.alta(dto);
    }
	

	@PostMapping("/baja")
    public @ResponseBody RolesUsuarioDTO baja(@RequestBody RolesUsuarioDTO dto){
		return  service.baja(dto);
    }
	

	@PostMapping("/consulta")
    public @ResponseBody List<RolesUsuarioDTO> consulta(@RequestBody RolesUsuarioDTO dto){
		return service.consulta(dto);
    }
	

	@PostMapping("/consultaId")
    public @ResponseBody List<RolesUsuarioDTO> consultaId(@RequestBody RolesUsuarioDTO dto){
		return service.consultaId(dto);
    }
	

	@PostMapping("/modificacion")
    public @ResponseBody RolesUsuarioDTO modificacion(@RequestBody RolesUsuarioDTO dto){
		return service.modificacion(dto);
    }

}
