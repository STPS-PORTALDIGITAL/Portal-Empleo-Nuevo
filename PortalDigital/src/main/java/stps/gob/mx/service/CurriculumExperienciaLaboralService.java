package stps.gob.mx.service;

import java.util.List;

import stps.gob.mx.dto.CurriculumExperienciaLaboralDTO;

public interface CurriculumExperienciaLaboralService {
	CurriculumExperienciaLaboralDTO alta(CurriculumExperienciaLaboralDTO dto);
	CurriculumExperienciaLaboralDTO baja(CurriculumExperienciaLaboralDTO dto);
	List<CurriculumExperienciaLaboralDTO> consulta(CurriculumExperienciaLaboralDTO dto);
	List<CurriculumExperienciaLaboralDTO> consultaId(CurriculumExperienciaLaboralDTO dto);
	CurriculumExperienciaLaboralDTO modificacion(CurriculumExperienciaLaboralDTO dto);
}
