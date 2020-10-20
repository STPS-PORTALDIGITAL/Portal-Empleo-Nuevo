package stps.gob.mx.service;

import java.util.List;

import stps.gob.mx.dto.NivelEducativoDTO;

public interface NivelEducativoService {
	NivelEducativoDTO alta(NivelEducativoDTO dto);
	NivelEducativoDTO baja(NivelEducativoDTO dto);
	List<NivelEducativoDTO> consulta(NivelEducativoDTO dto);
	List<NivelEducativoDTO> consultaId(NivelEducativoDTO dto);
	NivelEducativoDTO modificacion(NivelEducativoDTO dto);
}
