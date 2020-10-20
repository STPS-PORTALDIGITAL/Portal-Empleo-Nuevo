package stps.gob.mx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stps.gob.mx.dto.TipoEmpresaDTO;
import stps.gob.mx.service.TipoEmpresaService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/TipoEmpresa"})
public class TipoEmpresaController {
	
	@Autowired
	TipoEmpresaService service;
	

	@PostMapping("/alta")
    public @ResponseBody TipoEmpresaDTO alta(@RequestBody TipoEmpresaDTO dto){
		return service.alta(dto);
    }
	

	@PostMapping("/baja")
    public @ResponseBody TipoEmpresaDTO baja(@RequestBody TipoEmpresaDTO dto){
		return  service.baja(dto);
    }
	

	@PostMapping("/consulta")
    public @ResponseBody List<TipoEmpresaDTO> consulta(@RequestBody TipoEmpresaDTO dto){
		return service.consulta(dto);
    }
	

	@PostMapping("/consultaId")
    public @ResponseBody List<TipoEmpresaDTO> consultaId(@RequestBody TipoEmpresaDTO dto){
		return service.consultaId(dto);
    }
	

	@PostMapping("/modificacion")
    public @ResponseBody TipoEmpresaDTO modificacion(@RequestBody TipoEmpresaDTO dto){
		return service.modificacion(dto);
    }

}
