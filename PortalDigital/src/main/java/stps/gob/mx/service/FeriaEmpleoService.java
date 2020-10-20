package stps.gob.mx.service;

import java.util.List;

import stps.gob.mx.dto.FeriaEmpleoDTO;

public interface FeriaEmpleoService {
	FeriaEmpleoDTO alta(FeriaEmpleoDTO dto);
	FeriaEmpleoDTO baja(FeriaEmpleoDTO dto);
	List<FeriaEmpleoDTO> consulta(FeriaEmpleoDTO dto);
	List<FeriaEmpleoDTO> consultaId(FeriaEmpleoDTO dto);
	FeriaEmpleoDTO modificacion(FeriaEmpleoDTO dto);
}
