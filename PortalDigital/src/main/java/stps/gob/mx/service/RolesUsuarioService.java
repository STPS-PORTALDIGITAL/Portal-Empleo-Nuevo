package stps.gob.mx.service;

import java.util.List;

import stps.gob.mx.dto.RolesUsuarioDTO;

public interface RolesUsuarioService {
	RolesUsuarioDTO alta(RolesUsuarioDTO dto);
	RolesUsuarioDTO baja(RolesUsuarioDTO dto);
	List<RolesUsuarioDTO> consulta(RolesUsuarioDTO dto);
	List<RolesUsuarioDTO> consultaId(RolesUsuarioDTO dto);
	RolesUsuarioDTO modificacion(RolesUsuarioDTO dto);
}
