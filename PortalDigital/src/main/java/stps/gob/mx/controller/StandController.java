package stps.gob.mx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stps.gob.mx.dto.StandDTO;
import stps.gob.mx.service.StandService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/Stand"})
public class StandController {
	
	@Autowired
	StandService service;
	

	@PostMapping("/alta")
    public @ResponseBody StandDTO alta(@RequestBody StandDTO dto){
		return service.alta(dto);
    }
	

	@PostMapping("/baja")
    public @ResponseBody StandDTO baja(@RequestBody StandDTO dto){
		return  service.baja(dto);
    }
	

	@PostMapping("/consulta")
    public @ResponseBody List<StandDTO> consulta(@RequestBody StandDTO dto){
		return service.consulta(dto);
    }
	

	@PostMapping("/consultaId")
    public @ResponseBody List<StandDTO> consultaId(@RequestBody StandDTO dto){
		return service.consultaId(dto);
    }
	

	@PostMapping("/modificacion")
    public @ResponseBody StandDTO modificacion(@RequestBody StandDTO dto){
		return service.modificacion(dto);
    }

}
