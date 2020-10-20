package stps.gob.mx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stps.gob.mx.dto.PerfilBusquedaEmpleoDTO;
import stps.gob.mx.service.PerfilBusquedaEmpleoService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/PerfilBusquedaEmpleo"})
public class PerfilBusquedaEmpleoController {
	
	@Autowired
	PerfilBusquedaEmpleoService service;
	

	@PostMapping("/alta")
    public @ResponseBody PerfilBusquedaEmpleoDTO alta(@RequestBody PerfilBusquedaEmpleoDTO dto){
		return service.alta(dto);
    }
	

	@PostMapping("/baja")
    public @ResponseBody PerfilBusquedaEmpleoDTO baja(@RequestBody PerfilBusquedaEmpleoDTO dto){
		return  service.baja(dto);
    }
	

	@PostMapping("/consulta")
    public @ResponseBody List<PerfilBusquedaEmpleoDTO> consulta(@RequestBody PerfilBusquedaEmpleoDTO dto){
		return service.consulta(dto);
    }
	

	@PostMapping("/consultaId")
    public @ResponseBody List<PerfilBusquedaEmpleoDTO> consultaId(@RequestBody PerfilBusquedaEmpleoDTO dto){
		return service.consultaId(dto);
    }
	

	@PostMapping("/modificacion")
    public @ResponseBody PerfilBusquedaEmpleoDTO modificacion(@RequestBody PerfilBusquedaEmpleoDTO dto){
		return service.modificacion(dto);
    }

}
