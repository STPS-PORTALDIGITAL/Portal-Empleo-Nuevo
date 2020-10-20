package stps.gob.mx.service;

import java.util.List;

import stps.gob.mx.dto.CurriculumDTO;

public interface CurriculumService {
	CurriculumDTO alta(CurriculumDTO dto);
	CurriculumDTO baja(CurriculumDTO dto);
	List<CurriculumDTO> consulta(CurriculumDTO dto);
	List<CurriculumDTO> consultaId(CurriculumDTO dto);
	CurriculumDTO modificacion(CurriculumDTO dto);
}
