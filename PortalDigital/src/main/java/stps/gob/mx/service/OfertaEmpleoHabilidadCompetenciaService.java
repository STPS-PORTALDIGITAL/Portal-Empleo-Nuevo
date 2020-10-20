package stps.gob.mx.service;

import java.util.List;

import stps.gob.mx.dto.OfertaEmpleoHabilidadCompetenciaDTO;

public interface OfertaEmpleoHabilidadCompetenciaService {
	OfertaEmpleoHabilidadCompetenciaDTO alta(OfertaEmpleoHabilidadCompetenciaDTO dto);
	OfertaEmpleoHabilidadCompetenciaDTO baja(OfertaEmpleoHabilidadCompetenciaDTO dto);
	List<OfertaEmpleoHabilidadCompetenciaDTO> consulta(OfertaEmpleoHabilidadCompetenciaDTO dto);
	List<OfertaEmpleoHabilidadCompetenciaDTO> consultaId(OfertaEmpleoHabilidadCompetenciaDTO dto);
	OfertaEmpleoHabilidadCompetenciaDTO modificacion(OfertaEmpleoHabilidadCompetenciaDTO dto);
}
