package stps.gob.mx.service;

import java.util.List;

import stps.gob.mx.dto.OfertaTipoDiscapacidadDTO;

public interface OfertaTipoDiscapacidadService {
	OfertaTipoDiscapacidadDTO alta(OfertaTipoDiscapacidadDTO dto);
	OfertaTipoDiscapacidadDTO baja(OfertaTipoDiscapacidadDTO dto);
	List<OfertaTipoDiscapacidadDTO> consulta(OfertaTipoDiscapacidadDTO dto);
	List<OfertaTipoDiscapacidadDTO> consultaId(OfertaTipoDiscapacidadDTO dto);
	OfertaTipoDiscapacidadDTO modificacion(OfertaTipoDiscapacidadDTO dto);
}
