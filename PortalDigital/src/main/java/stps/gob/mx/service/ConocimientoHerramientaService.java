package stps.gob.mx.service;

import java.util.List;

import stps.gob.mx.dto.ConocimientoHerramientaDTO;

public interface ConocimientoHerramientaService {
	ConocimientoHerramientaDTO alta(ConocimientoHerramientaDTO dto);
	ConocimientoHerramientaDTO baja(ConocimientoHerramientaDTO dto);
	List<ConocimientoHerramientaDTO> consulta(ConocimientoHerramientaDTO dto);
	List<ConocimientoHerramientaDTO> consultaId(ConocimientoHerramientaDTO dto);
	ConocimientoHerramientaDTO modificacion(ConocimientoHerramientaDTO dto);
}
