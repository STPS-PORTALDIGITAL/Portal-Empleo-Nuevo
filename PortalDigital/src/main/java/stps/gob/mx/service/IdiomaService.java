package stps.gob.mx.service;

import java.util.List;

import stps.gob.mx.dto.IdiomaDTO;

public interface IdiomaService {
	IdiomaDTO alta(IdiomaDTO dto);
	IdiomaDTO baja(IdiomaDTO dto);
	List<IdiomaDTO> consulta(IdiomaDTO dto);
	List<IdiomaDTO> consultaId(IdiomaDTO dto);
	IdiomaDTO modificacion(IdiomaDTO dto);
}
