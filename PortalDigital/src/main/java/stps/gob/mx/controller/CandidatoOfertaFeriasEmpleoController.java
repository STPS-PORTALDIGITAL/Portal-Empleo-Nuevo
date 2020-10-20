package stps.gob.mx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import stps.gob.mx.dto.CandidatoOfertaFeriasEmpleoDTO;
import stps.gob.mx.service.CandidatoOfertaFeriasEmpleoService;




@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/CandidatoOfertaFeriasEmpleo"})
public class CandidatoOfertaFeriasEmpleoController {
	
	@Autowired
	CandidatoOfertaFeriasEmpleoService service;
	

	@PostMapping("/alta")
    public @ResponseBody CandidatoOfertaFeriasEmpleoDTO alta(@RequestBody CandidatoOfertaFeriasEmpleoDTO dto){
		return service.alta(dto);
    }
	

	@PostMapping("/baja")
    public @ResponseBody CandidatoOfertaFeriasEmpleoDTO baja(@RequestBody CandidatoOfertaFeriasEmpleoDTO dto){
		return  service.baja(dto);
    }
	

	@PostMapping("/consulta")
    public @ResponseBody List<CandidatoOfertaFeriasEmpleoDTO> consulta(@RequestBody CandidatoOfertaFeriasEmpleoDTO dto){
		return service.consulta(dto);
    }
	

	@PostMapping("/consultaId")
    public @ResponseBody List<CandidatoOfertaFeriasEmpleoDTO> consultaId(@RequestBody CandidatoOfertaFeriasEmpleoDTO dto){
		return service.consultaId(dto);
    }
	

	@PostMapping("/modificacion")
    public @ResponseBody CandidatoOfertaFeriasEmpleoDTO modificacion(@RequestBody CandidatoOfertaFeriasEmpleoDTO dto){
		return service.modificacion(dto);
    }

}
