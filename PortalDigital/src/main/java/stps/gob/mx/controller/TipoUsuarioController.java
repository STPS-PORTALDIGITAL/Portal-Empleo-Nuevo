package stps.gob.mx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stps.gob.mx.dto.TipoUsuarioDTO;
import stps.gob.mx.service.TipoUsuarioService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/TipoUsuario"})
public class TipoUsuarioController {
	
	@Autowired
	TipoUsuarioService service;
	

	@PostMapping("/alta")
    public @ResponseBody TipoUsuarioDTO alta(@RequestBody TipoUsuarioDTO dto){
		return service.alta(dto);
    }
	

	@PostMapping("/baja")
    public @ResponseBody TipoUsuarioDTO baja(@RequestBody TipoUsuarioDTO dto){
		return  service.baja(dto);
    }
	

	@PostMapping("/consulta")
    public @ResponseBody List<TipoUsuarioDTO> consulta(@RequestBody TipoUsuarioDTO dto){
		return service.consulta(dto);
    }
	

	@PostMapping("/consultaId")
    public @ResponseBody List<TipoUsuarioDTO> consultaId(@RequestBody TipoUsuarioDTO dto){
		return service.consultaId(dto);
    }
	

	@PostMapping("/modificacion")
    public @ResponseBody TipoUsuarioDTO modificacion(@RequestBody TipoUsuarioDTO dto){
		return service.modificacion(dto);
    }

}
