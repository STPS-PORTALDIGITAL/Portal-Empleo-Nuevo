package stps.gob.mx.service;

import java.util.List;

import stps.gob.mx.dto.CurriculumIdiomaDTO;

public interface CurriculumIdiomaService {
	CurriculumIdiomaDTO alta(CurriculumIdiomaDTO dto);
	CurriculumIdiomaDTO baja(CurriculumIdiomaDTO dto);
	List<CurriculumIdiomaDTO> consulta(CurriculumIdiomaDTO dto);
	List<CurriculumIdiomaDTO> consultaId(CurriculumIdiomaDTO dto);
	CurriculumIdiomaDTO modificacion(CurriculumIdiomaDTO dto);
}
