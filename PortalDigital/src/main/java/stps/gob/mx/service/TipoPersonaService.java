package stps.gob.mx.service;

import java.util.List;

import stps.gob.mx.dto.TipoPersonaDTO;

public interface TipoPersonaService {
	TipoPersonaDTO alta(TipoPersonaDTO dto);
	TipoPersonaDTO baja(TipoPersonaDTO dto);
	List<TipoPersonaDTO> consulta(TipoPersonaDTO dto);
	List<TipoPersonaDTO> consultaId(TipoPersonaDTO dto);
	TipoPersonaDTO modificacion(TipoPersonaDTO dto);
}
