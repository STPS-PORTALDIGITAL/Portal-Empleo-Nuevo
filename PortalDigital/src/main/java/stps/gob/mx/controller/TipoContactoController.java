package stps.gob.mx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stps.gob.mx.dto.TipoContactoDTO;
import stps.gob.mx.service.TipoContactoService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/TipoContacto"})
public class TipoContactoController {
	
	@Autowired
	TipoContactoService service;
	

	@PostMapping("/alta")
    public @ResponseBody TipoContactoDTO alta(@RequestBody TipoContactoDTO dto){
		return service.alta(dto);
    }
	

	@PostMapping("/baja")
    public @ResponseBody TipoContactoDTO baja(@RequestBody TipoContactoDTO dto){
		return  service.baja(dto);
    }
	

	@PostMapping("/consulta")
    public @ResponseBody List<TipoContactoDTO> consulta(@RequestBody TipoContactoDTO dto){
		return service.consulta(dto);
    }
	

	@PostMapping("/consultaId")
    public @ResponseBody List<TipoContactoDTO> consultaId(@RequestBody TipoContactoDTO dto){
		return service.consultaId(dto);
    }
	

	@PostMapping("/modificacion")
    public @ResponseBody TipoContactoDTO modificacion(@RequestBody TipoContactoDTO dto){
		return service.modificacion(dto);
    }

}
