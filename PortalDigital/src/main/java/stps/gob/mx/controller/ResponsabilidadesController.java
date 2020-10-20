package stps.gob.mx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stps.gob.mx.dto.ResponsabilidadesDTO;
import stps.gob.mx.service.ResponsabilidadesService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/Responsabilidades"})
public class ResponsabilidadesController {
	
	@Autowired
	ResponsabilidadesService service;
	

	@PostMapping("/alta")
    public @ResponseBody ResponsabilidadesDTO alta(@RequestBody ResponsabilidadesDTO dto){
		return service.alta(dto);
    }
	

	@PostMapping("/baja")
    public @ResponseBody ResponsabilidadesDTO baja(@RequestBody ResponsabilidadesDTO dto){
		return  service.baja(dto);
    }
	

	@PostMapping("/consulta")
    public @ResponseBody List<ResponsabilidadesDTO> consulta(@RequestBody ResponsabilidadesDTO dto){
		return service.consulta(dto);
    }
	

	@PostMapping("/consultaId")
    public @ResponseBody List<ResponsabilidadesDTO> consultaId(@RequestBody ResponsabilidadesDTO dto){
		return service.consultaId(dto);
    }
	

	@PostMapping("/modificacion")
    public @ResponseBody ResponsabilidadesDTO modificacion(@RequestBody ResponsabilidadesDTO dto){
		return service.modificacion(dto);
    }

}
