package stps.gob.mx.service;

import java.util.List;

import stps.gob.mx.dto.RolesDTO;

public interface RolesService {
	RolesDTO alta(RolesDTO dto);
	RolesDTO baja(RolesDTO dto);
	List<RolesDTO> consulta(RolesDTO dto);
	List<RolesDTO> consultaId(RolesDTO dto);
	RolesDTO modificacion(RolesDTO dto);
}
