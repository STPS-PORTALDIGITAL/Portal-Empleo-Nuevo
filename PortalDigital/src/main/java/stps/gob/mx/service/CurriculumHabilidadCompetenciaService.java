package stps.gob.mx.service;

import java.util.List;

import stps.gob.mx.dto.CurriculumHabilidadCompetenciaDTO;

public interface CurriculumHabilidadCompetenciaService {
	CurriculumHabilidadCompetenciaDTO alta(CurriculumHabilidadCompetenciaDTO dto);
	CurriculumHabilidadCompetenciaDTO baja(CurriculumHabilidadCompetenciaDTO dto);
	List<CurriculumHabilidadCompetenciaDTO> consulta(CurriculumHabilidadCompetenciaDTO dto);
	List<CurriculumHabilidadCompetenciaDTO> consultaId(CurriculumHabilidadCompetenciaDTO dto);
	CurriculumHabilidadCompetenciaDTO modificacion(CurriculumHabilidadCompetenciaDTO dto);
}
