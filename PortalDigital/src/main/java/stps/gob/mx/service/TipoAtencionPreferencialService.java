package stps.gob.mx.service;

import java.util.List;

import stps.gob.mx.dto.TipoAtencionPreferencialDTO;

public interface TipoAtencionPreferencialService {
	TipoAtencionPreferencialDTO alta(TipoAtencionPreferencialDTO dto);
	TipoAtencionPreferencialDTO baja(TipoAtencionPreferencialDTO dto);
	List<TipoAtencionPreferencialDTO> consulta(TipoAtencionPreferencialDTO dto);
	List<TipoAtencionPreferencialDTO> consultaId(TipoAtencionPreferencialDTO dto);
	TipoAtencionPreferencialDTO modificacion(TipoAtencionPreferencialDTO dto);
}
