package stps.gob.mx.service;

import java.util.List;

import stps.gob.mx.dto.EmpleadorDTO;

public interface EmpleadorService {
	EmpleadorDTO alta(EmpleadorDTO dto);
	EmpleadorDTO baja(EmpleadorDTO dto);
	List<EmpleadorDTO> consulta(EmpleadorDTO dto);
	List<EmpleadorDTO> consultaId(EmpleadorDTO dto);
	EmpleadorDTO modificacion(EmpleadorDTO dto);
}
