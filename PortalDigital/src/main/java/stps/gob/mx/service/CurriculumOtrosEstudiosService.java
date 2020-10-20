package stps.gob.mx.service;

import java.util.List;

import stps.gob.mx.dto.CurriculumOtrosEstudiosDTO;

public interface CurriculumOtrosEstudiosService {
	CurriculumOtrosEstudiosDTO alta(CurriculumOtrosEstudiosDTO dto);
	CurriculumOtrosEstudiosDTO baja(CurriculumOtrosEstudiosDTO dto);
	List<CurriculumOtrosEstudiosDTO> consulta(CurriculumOtrosEstudiosDTO dto);
	List<CurriculumOtrosEstudiosDTO> consultaId(CurriculumOtrosEstudiosDTO dto);
	CurriculumOtrosEstudiosDTO modificacion(CurriculumOtrosEstudiosDTO dto);
}
