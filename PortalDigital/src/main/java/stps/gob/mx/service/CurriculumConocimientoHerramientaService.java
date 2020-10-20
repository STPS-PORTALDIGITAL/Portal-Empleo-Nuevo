package stps.gob.mx.service;

import java.util.List;

import stps.gob.mx.dto.CurriculumConocimientoHerramientaDTO;

public interface CurriculumConocimientoHerramientaService {
	CurriculumConocimientoHerramientaDTO alta(CurriculumConocimientoHerramientaDTO dto);
	CurriculumConocimientoHerramientaDTO baja(CurriculumConocimientoHerramientaDTO dto);
	List<CurriculumConocimientoHerramientaDTO> consulta(CurriculumConocimientoHerramientaDTO dto);
	List<CurriculumConocimientoHerramientaDTO> consultaId(CurriculumConocimientoHerramientaDTO dto);
	CurriculumConocimientoHerramientaDTO modificacion(CurriculumConocimientoHerramientaDTO dto);
}
