package stps.gob.mx.service;

import java.util.List;

import stps.gob.mx.dto.CatalogoRechazosDTO;

public interface CatalogoRechazosService {
	CatalogoRechazosDTO alta(CatalogoRechazosDTO dto);
	CatalogoRechazosDTO baja(CatalogoRechazosDTO dto);
	List<CatalogoRechazosDTO> consulta(CatalogoRechazosDTO dto);
	List<CatalogoRechazosDTO> consultaId(CatalogoRechazosDTO dto);
	CatalogoRechazosDTO modificacion(CatalogoRechazosDTO dto);
}
