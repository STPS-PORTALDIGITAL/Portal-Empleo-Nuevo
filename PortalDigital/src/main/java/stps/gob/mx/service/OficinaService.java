package stps.gob.mx.service;

import java.util.List;

import stps.gob.mx.dto.OficinaDTO;

public interface OficinaService {
	OficinaDTO alta(OficinaDTO dto);
	OficinaDTO baja(OficinaDTO dto);
	List<OficinaDTO> consulta(OficinaDTO dto);
	List<OficinaDTO> consultaId(OficinaDTO dto);
	OficinaDTO modificacion(OficinaDTO dto);
}
