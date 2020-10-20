package stps.gob.mx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stps.gob.mx.dto.ChatDTO;
import stps.gob.mx.service.ChatService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/Chat"})
public class ChatController {
	
	@Autowired
	ChatService service;
	

	@PostMapping("/alta")
    public @ResponseBody ChatDTO alta(@RequestBody ChatDTO dto){
		return service.alta(dto);
    }
	

	@PostMapping("/baja")
    public @ResponseBody ChatDTO baja(@RequestBody ChatDTO dto){
		return  service.baja(dto);
    }
	

	@PostMapping("/consulta")
    public @ResponseBody List<ChatDTO> consulta(@RequestBody ChatDTO dto){
		return service.consulta(dto);
    }
	

	@PostMapping("/consultaId")
    public @ResponseBody List<ChatDTO> consultaId(@RequestBody ChatDTO dto){
		return service.consultaId(dto);
    }
	

	@PostMapping("/modificacion")
    public @ResponseBody ChatDTO modificacion(@RequestBody ChatDTO dto){
		return service.modificacion(dto);
    }

}
