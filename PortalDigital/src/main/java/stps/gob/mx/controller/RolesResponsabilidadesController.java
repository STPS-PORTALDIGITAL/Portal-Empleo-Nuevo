package stps.gob.mx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stps.gob.mx.dto.RolesResponsabilidadesDTO;
import stps.gob.mx.service.RolesResponsabilidadesService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/RolesResponsabilidades"})
public class RolesResponsabilidadesController {
	
	@Autowired
	RolesResponsabilidadesService service;
	

	@PostMapping("/alta")
    public @ResponseBody RolesResponsabilidadesDTO alta(@RequestBody RolesResponsabilidadesDTO dto){
		return service.alta(dto);
    }
	

	@PostMapping("/baja")
    public @ResponseBody RolesResponsabilidadesDTO baja(@RequestBody RolesResponsabilidadesDTO dto){
		return  service.baja(dto);
    }
	

	@PostMapping("/consulta")
    public @ResponseBody List<RolesResponsabilidadesDTO> consulta(@RequestBody RolesResponsabilidadesDTO dto){
		return service.consulta(dto);
    }
	

	@PostMapping("/consultaId")
    public @ResponseBody List<RolesResponsabilidadesDTO> consultaId(@RequestBody RolesResponsabilidadesDTO dto){
		return service.consultaId(dto);
    }
	

	@PostMapping("/modificacion")
    public @ResponseBody RolesResponsabilidadesDTO modificacion(@RequestBody RolesResponsabilidadesDTO dto){
		return service.modificacion(dto);
    }

}
