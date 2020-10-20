package stps.gob.mx.service;

import java.util.List;

import stps.gob.mx.dto.CitaAtencionDTO;

public interface CitaAtencionService {
	CitaAtencionDTO alta(CitaAtencionDTO dto);
	CitaAtencionDTO baja(CitaAtencionDTO dto);
	List<CitaAtencionDTO> consulta(CitaAtencionDTO dto);
	List<CitaAtencionDTO> consultaId(CitaAtencionDTO dto);
	CitaAtencionDTO modificacion(CitaAtencionDTO dto);
}
