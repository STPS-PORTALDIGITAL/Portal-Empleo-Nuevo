package stps.gob.mx.service;

import java.util.List;

import stps.gob.mx.dto.EntidadDTO;

public interface EntidadService {
	EntidadDTO alta(EntidadDTO dto);
	EntidadDTO baja(EntidadDTO dto);
	List<EntidadDTO> consulta(EntidadDTO dto);
	List<EntidadDTO> consultaId(EntidadDTO dto);
	EntidadDTO modificacion(EntidadDTO dto);
}
