package stps.gob.mx.service;

import java.util.List;

import stps.gob.mx.dto.StandDTO;

public interface StandService {
	StandDTO alta(StandDTO dto);
	StandDTO baja(StandDTO dto);
	List<StandDTO> consulta(StandDTO dto);
	List<StandDTO> consultaId(StandDTO dto);
	StandDTO modificacion(StandDTO dto);
}
