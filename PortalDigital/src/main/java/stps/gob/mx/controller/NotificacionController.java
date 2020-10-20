package stps.gob.mx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stps.gob.mx.dto.NotificacionDTO;
import stps.gob.mx.service.NotificacionService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/Notificacion"})
public class NotificacionController {
	
	@Autowired
	NotificacionService service;
	

	@PostMapping("/alta")
    public @ResponseBody NotificacionDTO alta(@RequestBody NotificacionDTO dto){
		return service.alta(dto);
    }
	

	@PostMapping("/baja")
    public @ResponseBody NotificacionDTO baja(@RequestBody NotificacionDTO dto){
		return  service.baja(dto);
    }
	

	@PostMapping("/consulta")
    public @ResponseBody List<NotificacionDTO> consulta(@RequestBody NotificacionDTO dto){
		return service.consulta(dto);
    }
	

	@PostMapping("/consultaId")
    public @ResponseBody List<NotificacionDTO> consultaId(@RequestBody NotificacionDTO dto){
		return service.consultaId(dto);
    }
	

	@PostMapping("/modificacion")
    public @ResponseBody NotificacionDTO modificacion(@RequestBody NotificacionDTO dto){
		return service.modificacion(dto);
    }

}
