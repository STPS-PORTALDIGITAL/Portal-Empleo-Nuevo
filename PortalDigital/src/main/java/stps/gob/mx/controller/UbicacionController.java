package stps.gob.mx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stps.gob.mx.dto.UbicacionDTO;
import stps.gob.mx.service.UbicacionService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/Ubicacion"})
public class UbicacionController {
	
	@Autowired
	UbicacionService service;
	

	@PostMapping("/alta")
    public @ResponseBody UbicacionDTO alta(@RequestBody UbicacionDTO dto){
		return service.alta(dto);
    }
	

	@PostMapping("/baja")
    public @ResponseBody UbicacionDTO baja(@RequestBody UbicacionDTO dto){
		return  service.baja(dto);
    }
	

	@PostMapping("/consulta")
    public @ResponseBody List<UbicacionDTO> consulta(@RequestBody UbicacionDTO dto){
		return service.consulta(dto);
    }
	

	@PostMapping("/consultaId")
    public @ResponseBody List<UbicacionDTO> consultaId(@RequestBody UbicacionDTO dto){
		return service.consultaId(dto);
    }
	

	@PostMapping("/modificacion")
    public @ResponseBody UbicacionDTO modificacion(@RequestBody UbicacionDTO dto){
		return service.modificacion(dto);
    }

}
