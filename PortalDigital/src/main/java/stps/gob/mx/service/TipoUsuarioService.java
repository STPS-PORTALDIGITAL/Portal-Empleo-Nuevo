package stps.gob.mx.service;

import java.util.List;

import stps.gob.mx.dto.TipoUsuarioDTO;

public interface TipoUsuarioService {
	TipoUsuarioDTO alta(TipoUsuarioDTO dto);
	TipoUsuarioDTO baja(TipoUsuarioDTO dto);
	List<TipoUsuarioDTO> consulta(TipoUsuarioDTO dto);
	List<TipoUsuarioDTO> consultaId(TipoUsuarioDTO dto);
	TipoUsuarioDTO modificacion(TipoUsuarioDTO dto);
}
