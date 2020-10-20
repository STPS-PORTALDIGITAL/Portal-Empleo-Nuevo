package stps.gob.mx.service;

import java.util.List;

import stps.gob.mx.dto.PabellonesDTO;

public interface PabellonesService {
	PabellonesDTO alta(PabellonesDTO dto);
	PabellonesDTO baja(PabellonesDTO dto);
	List<PabellonesDTO> consulta(PabellonesDTO dto);
	List<PabellonesDTO> consultaId(PabellonesDTO dto);
	PabellonesDTO modificacion(PabellonesDTO dto);
}
