package stps.gob.mx.service;

import java.util.List;

import stps.gob.mx.dto.TipoEmpresaDTO;

public interface TipoEmpresaService {
	TipoEmpresaDTO alta(TipoEmpresaDTO dto);
	TipoEmpresaDTO baja(TipoEmpresaDTO dto);
	List<TipoEmpresaDTO> consulta(TipoEmpresaDTO dto);
	List<TipoEmpresaDTO> consultaId(TipoEmpresaDTO dto);
	TipoEmpresaDTO modificacion(TipoEmpresaDTO dto);
}
