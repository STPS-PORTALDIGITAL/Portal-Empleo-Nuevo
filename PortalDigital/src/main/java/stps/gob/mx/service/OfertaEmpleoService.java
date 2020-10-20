package stps.gob.mx.service;

import java.util.List;


import stps.gob.mx.dto.OfertaEmpleoDTO;

public interface OfertaEmpleoService {
	OfertaEmpleoDTO alta(OfertaEmpleoDTO dto);
	OfertaEmpleoDTO baja(OfertaEmpleoDTO dto);
	List<OfertaEmpleoDTO> consulta(OfertaEmpleoDTO dto);
	List<OfertaEmpleoDTO> consultaId(OfertaEmpleoDTO dto);
	OfertaEmpleoDTO modificacion(OfertaEmpleoDTO dto);
	
}
