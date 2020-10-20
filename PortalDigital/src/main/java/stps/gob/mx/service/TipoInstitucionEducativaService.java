package stps.gob.mx.service;

import java.util.List;

import stps.gob.mx.dto.TipoInstitucionEducativaDTO;

public interface TipoInstitucionEducativaService {
	TipoInstitucionEducativaDTO alta(TipoInstitucionEducativaDTO dto);
	TipoInstitucionEducativaDTO baja(TipoInstitucionEducativaDTO dto);
	List<TipoInstitucionEducativaDTO> consulta(TipoInstitucionEducativaDTO dto);
	List<TipoInstitucionEducativaDTO> consultaId(TipoInstitucionEducativaDTO dto);
	TipoInstitucionEducativaDTO modificacion(TipoInstitucionEducativaDTO dto);
}
