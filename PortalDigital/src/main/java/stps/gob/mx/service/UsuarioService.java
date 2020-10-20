package stps.gob.mx.service;

import java.util.List;

import stps.gob.mx.dto.UsuarioDTO;

public interface UsuarioService {
	UsuarioDTO alta(UsuarioDTO dto);
	UsuarioDTO baja(UsuarioDTO dto);
	List<UsuarioDTO> consulta(UsuarioDTO dto);
	List<UsuarioDTO> consultaId(UsuarioDTO dto);
	UsuarioDTO modificacion(UsuarioDTO dto);
}
