package stps.gob.mx.service;

import java.util.List;

import stps.gob.mx.dto.SectorGiroDTO;

public interface SectorGiroService {
	SectorGiroDTO alta(SectorGiroDTO dto);
	SectorGiroDTO baja(SectorGiroDTO dto);
	List<SectorGiroDTO> consulta(SectorGiroDTO dto);
	List<SectorGiroDTO> consultaId(SectorGiroDTO dto);
	SectorGiroDTO modificacion(SectorGiroDTO dto);
}
