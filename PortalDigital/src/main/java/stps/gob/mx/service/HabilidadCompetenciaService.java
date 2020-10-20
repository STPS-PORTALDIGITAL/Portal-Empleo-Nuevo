package stps.gob.mx.service;

import java.util.List;

import stps.gob.mx.dto.HabilidadCompetenciaDTO;

public interface HabilidadCompetenciaService {
	HabilidadCompetenciaDTO alta(HabilidadCompetenciaDTO dto);
	HabilidadCompetenciaDTO baja(HabilidadCompetenciaDTO dto);
	List<HabilidadCompetenciaDTO> consulta(HabilidadCompetenciaDTO dto);
	List<HabilidadCompetenciaDTO> consultaId(HabilidadCompetenciaDTO dto);
	HabilidadCompetenciaDTO modificacion(HabilidadCompetenciaDTO dto);
}
