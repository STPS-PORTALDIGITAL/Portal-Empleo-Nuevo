package stps.gob.mx.service;

import java.util.List;

import stps.gob.mx.dto.OfertaEmpleoConocimientoHerramientaDTO;

public interface OfertaEmpleoConocimientoHerramientaService {
	OfertaEmpleoConocimientoHerramientaDTO alta(OfertaEmpleoConocimientoHerramientaDTO dto);
	OfertaEmpleoConocimientoHerramientaDTO baja(OfertaEmpleoConocimientoHerramientaDTO dto);
	List<OfertaEmpleoConocimientoHerramientaDTO> consulta(OfertaEmpleoConocimientoHerramientaDTO dto);
	List<OfertaEmpleoConocimientoHerramientaDTO> consultaId(OfertaEmpleoConocimientoHerramientaDTO dto);
	OfertaEmpleoConocimientoHerramientaDTO modificacion(OfertaEmpleoConocimientoHerramientaDTO dto);
}
