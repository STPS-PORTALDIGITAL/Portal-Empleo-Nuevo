package stps.gob.mx.service;

import java.util.List;

import stps.gob.mx.dto.ResponsabilidadesDTO;

public interface ResponsabilidadesService {
	ResponsabilidadesDTO alta(ResponsabilidadesDTO dto);
	ResponsabilidadesDTO baja(ResponsabilidadesDTO dto);
	List<ResponsabilidadesDTO> consulta(ResponsabilidadesDTO dto);
	List<ResponsabilidadesDTO> consultaId(ResponsabilidadesDTO dto);
	ResponsabilidadesDTO modificacion(ResponsabilidadesDTO dto);
}
