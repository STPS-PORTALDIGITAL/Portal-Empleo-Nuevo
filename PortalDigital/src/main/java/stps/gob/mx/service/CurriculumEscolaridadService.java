package stps.gob.mx.service;

import java.util.List;

import stps.gob.mx.dto.CurriculumEscolaridadDTO;

public interface CurriculumEscolaridadService {
	CurriculumEscolaridadDTO alta(CurriculumEscolaridadDTO dto);
	CurriculumEscolaridadDTO baja(CurriculumEscolaridadDTO dto);
	List<CurriculumEscolaridadDTO> consulta(CurriculumEscolaridadDTO dto);
	List<CurriculumEscolaridadDTO> consultaId(CurriculumEscolaridadDTO dto);
	CurriculumEscolaridadDTO modificacion(CurriculumEscolaridadDTO dto);
}
