package stps.gob.mx.service;

import java.util.List;

import stps.gob.mx.dto.OfertaFeriaEmpleoDTO;

public interface OfertaFeriaEmpleoService {
	OfertaFeriaEmpleoDTO alta(OfertaFeriaEmpleoDTO dto);
	OfertaFeriaEmpleoDTO baja(OfertaFeriaEmpleoDTO dto);
	List<OfertaFeriaEmpleoDTO> consulta(OfertaFeriaEmpleoDTO dto);
	List<OfertaFeriaEmpleoDTO> consultaId(OfertaFeriaEmpleoDTO dto);
	OfertaFeriaEmpleoDTO modificacion(OfertaFeriaEmpleoDTO dto);
}
