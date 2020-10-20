package stps.gob.mx.service;

import java.util.List;

import stps.gob.mx.dto.TipoContactoDTO;

public interface TipoContactoService {
	TipoContactoDTO alta(TipoContactoDTO dto);
	TipoContactoDTO baja(TipoContactoDTO dto);
	List<TipoContactoDTO> consulta(TipoContactoDTO dto);
	List<TipoContactoDTO> consultaId(TipoContactoDTO dto);
	TipoContactoDTO modificacion(TipoContactoDTO dto);
}
