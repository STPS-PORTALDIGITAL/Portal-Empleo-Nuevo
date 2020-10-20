package stps.gob.mx.service;

import java.util.List;

import stps.gob.mx.dto.UbicacionDTO;

public interface UbicacionService {
	UbicacionDTO alta(UbicacionDTO dto);
	UbicacionDTO baja(UbicacionDTO dto);
	List<UbicacionDTO> consulta(UbicacionDTO dto);
	List<UbicacionDTO> consultaId(UbicacionDTO dto);
	UbicacionDTO modificacion(UbicacionDTO dto);
}
