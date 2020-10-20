package stps.gob.mx.service;

import java.util.List;

import stps.gob.mx.dto.EncuestaDTO;

public interface EncuestaService {
	EncuestaDTO alta(EncuestaDTO dto);
	EncuestaDTO baja(EncuestaDTO dto);
	List<EncuestaDTO> consulta(EncuestaDTO dto);
	List<EncuestaDTO> consultaId(EncuestaDTO dto);
	EncuestaDTO modificacion(EncuestaDTO dto);
}
