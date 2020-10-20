package stps.gob.mx.service;

import java.util.List;

import stps.gob.mx.dto.RolesResponsabilidadesDTO;

public interface RolesResponsabilidadesService {
	RolesResponsabilidadesDTO alta(RolesResponsabilidadesDTO dto);
	RolesResponsabilidadesDTO baja(RolesResponsabilidadesDTO dto);
	List<RolesResponsabilidadesDTO> consulta(RolesResponsabilidadesDTO dto);
	List<RolesResponsabilidadesDTO> consultaId(RolesResponsabilidadesDTO dto);
	RolesResponsabilidadesDTO modificacion(RolesResponsabilidadesDTO dto);
}
