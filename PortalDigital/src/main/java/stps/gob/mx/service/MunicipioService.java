package stps.gob.mx.service;

import java.util.List;

import stps.gob.mx.dto.MunicipioDTO;

public interface MunicipioService {
	MunicipioDTO alta(MunicipioDTO dto);
	MunicipioDTO baja(MunicipioDTO dto);
	List<MunicipioDTO> consulta(MunicipioDTO dto);
	List<MunicipioDTO> consultaId(MunicipioDTO dto);
	MunicipioDTO modificacion(MunicipioDTO dto);
}
