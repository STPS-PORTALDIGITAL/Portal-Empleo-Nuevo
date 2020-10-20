package stps.gob.mx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stps.gob.mx.dto.UsuarioDTO;
import stps.gob.mx.service.UsuarioService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/Usuario"})
public class UsuarioController {
	
	@Autowired
	UsuarioService service;
	

	@PostMapping("/alta")
    public @ResponseBody UsuarioDTO alta(@RequestBody UsuarioDTO dto){
		return service.alta(dto);
    }
	

	@PostMapping("/baja")
    public @ResponseBody UsuarioDTO baja(@RequestBody UsuarioDTO dto){
		return  service.baja(dto);
    }
	

	@PostMapping("/consulta")
    public @ResponseBody List<UsuarioDTO> consulta(@RequestBody UsuarioDTO dto){
		return service.consulta(dto);
    }
	

	@PostMapping("/consultaId")
    public @ResponseBody List<UsuarioDTO> consultaId(@RequestBody UsuarioDTO dto){
		return service.consultaId(dto);
    }
	

	@PostMapping("/modificacion")
    public @ResponseBody UsuarioDTO modificacion(@RequestBody UsuarioDTO dto){
		return service.modificacion(dto);
    }

}
