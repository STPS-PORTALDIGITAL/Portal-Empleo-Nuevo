package stps.gob.mx.service;

import java.util.List;

import stps.gob.mx.dto.ColoniaDTO;

public interface ColoniaService {
	ColoniaDTO alta(ColoniaDTO dto);
	ColoniaDTO baja(ColoniaDTO dto);
	List<ColoniaDTO> consulta(ColoniaDTO dto);
	List<ColoniaDTO> consultaId(ColoniaDTO dto);
	ColoniaDTO modificacion(ColoniaDTO dto);
}
