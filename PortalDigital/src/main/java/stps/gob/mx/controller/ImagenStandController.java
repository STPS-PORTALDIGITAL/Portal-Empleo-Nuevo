package stps.gob.mx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stps.gob.mx.dto.ImagenStandDTO;
import stps.gob.mx.service.ImagenStandService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/ImagenStand"})
public class ImagenStandController {
	
	@Autowired
	ImagenStandService service;
	

	@PostMapping("/alta")
    public @ResponseBody ImagenStandDTO alta(@RequestBody ImagenStandDTO dto){
		return service.alta(dto);
    }
	

	@PostMapping("/baja")
    public @ResponseBody ImagenStandDTO baja(@RequestBody ImagenStandDTO dto){
		return  service.baja(dto);
    }
	

	@PostMapping("/consulta")
    public @ResponseBody List<ImagenStandDTO> consulta(@RequestBody ImagenStandDTO dto){
		return service.consulta(dto);
    }
	

	@PostMapping("/consultaId")
    public @ResponseBody List<ImagenStandDTO> consultaId(@RequestBody ImagenStandDTO dto){
		return service.consultaId(dto);
    }
	

	@PostMapping("/modificacion")
    public @ResponseBody ImagenStandDTO modificacion(@RequestBody ImagenStandDTO dto){
		return service.modificacion(dto);
    }

}
