package stps.gob.mx.service;

import java.util.List;

import stps.gob.mx.dto.PaisDTO;

public interface PaisService {
	PaisDTO alta(PaisDTO dto);
	PaisDTO baja(PaisDTO dto);
	List<PaisDTO> consulta(PaisDTO dto);
	List<PaisDTO> consultaId(PaisDTO dto);
	PaisDTO modificacion(PaisDTO dto);
}
