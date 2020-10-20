package stps.gob.mx.controller;



import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import stps.gob.mx.dto.BusquedaDTO;
import stps.gob.mx.dto.CandidatoDTO;
import stps.gob.mx.dto.InicioDTO;
import stps.gob.mx.dto.MapaDTO;
import stps.gob.mx.dto.OfertaEmpleoDTO;
import stps.gob.mx.dto.UsuarioDTO;

import stps.gob.mx.service.LogService;
import stps.gob.mx.service.LoginService;
import stps.gob.mx.service.OfertaEmpleoService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/Login"})
public class LoginController {
	final static Logger log = Logger.getLogger(LoginController.class);
	
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	LogService logService;
	
	@Autowired
	OfertaEmpleoService service;
	

	@PostMapping("/validaUsuario")
    public @ResponseBody UsuarioDTO validaUsuario(@RequestBody UsuarioDTO vo){
		return loginService.validaUsuario(vo);
    }
	

	@PostMapping("/recuperaContrasena")
    public @ResponseBody UsuarioDTO recuperaContrasena(@RequestBody UsuarioDTO vo){
		return loginService.recuperaContrasena(vo);
    }
	

	@PostMapping("/nuevoUsuario")
    public @ResponseBody UsuarioDTO nuevoUsuario(@RequestBody UsuarioDTO vo){
		return loginService.nuevoUsuario(vo);
    }
	
	@PostMapping("/busquedaSinSesion")
    public @ResponseBody BusquedaDTO busquedaSinSesion(@RequestBody BusquedaDTO vo){
		return loginService.busquedaSinSesion(vo);
    }
	
	@PostMapping("/homeSinSesion")
    public @ResponseBody InicioDTO homeSinSesion(){
		return loginService.homeSinSesion();
    }
	
	@PostMapping("/mostrarMapaSinSesionCandidato")
    public @ResponseBody MapaDTO mostrarMapaSinSesionCandidato(CandidatoDTO id){
		return loginService.mostrarMapaSinSesionCandidato(id);
    }
	
	@PostMapping("/mostrarMapaSinSesionEmpleo")
    public @ResponseBody MapaDTO mostrarMapaSinSesionEmpleo(OfertaEmpleoDTO id){
		return loginService.mostrarMapaSinSesionEmpleo(id);
    }
	

}
