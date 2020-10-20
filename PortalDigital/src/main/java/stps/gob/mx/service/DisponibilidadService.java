package stps.gob.mx.service;

import java.util.List;

import stps.gob.mx.dto.DisponibilidadDTO;

public interface DisponibilidadService {
	DisponibilidadDTO alta(DisponibilidadDTO dto);
	DisponibilidadDTO baja(DisponibilidadDTO dto);
	List<DisponibilidadDTO> consulta(DisponibilidadDTO dto);
	List<DisponibilidadDTO> consultaId(DisponibilidadDTO dto);
	DisponibilidadDTO modificacion(DisponibilidadDTO dto);
}
