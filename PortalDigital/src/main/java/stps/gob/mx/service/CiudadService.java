package stps.gob.mx.service;

import java.util.List;

import stps.gob.mx.dto.CiudadDTO;

public interface CiudadService {
	CiudadDTO alta(CiudadDTO dto);
	CiudadDTO baja(CiudadDTO dto);
	List<CiudadDTO> consulta(CiudadDTO dto);
	List<CiudadDTO> consultaId(CiudadDTO dto);
	CiudadDTO modificacion(CiudadDTO dto);
}
