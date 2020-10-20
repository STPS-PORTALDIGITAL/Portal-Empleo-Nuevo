package stps.gob.mx.service;


import java.util.List;

import stps.gob.mx.dto.BusquedaDTO;
import stps.gob.mx.dto.CandidatoDTO;
import stps.gob.mx.dto.InicioDTO;
import stps.gob.mx.dto.MapaDTO;
import stps.gob.mx.dto.OfertaEmpleoDTO;
import stps.gob.mx.dto.UsuarioDTO;


public interface LoginService {
	UsuarioDTO validaUsuario(UsuarioDTO vo);
	UsuarioDTO recuperaContrasena(UsuarioDTO vo);
	UsuarioDTO nuevoUsuario(UsuarioDTO vo);
	InicioDTO homeSinSesion();
	BusquedaDTO busquedaSinSesion( BusquedaDTO in);
	MapaDTO mostrarMapaSinSesionCandidato (CandidatoDTO in);
	MapaDTO mostrarMapaSinSesionEmpleo (OfertaEmpleoDTO in);
}
