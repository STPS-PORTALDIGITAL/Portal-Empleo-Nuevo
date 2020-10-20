package stps.gob.mx.service;

import java.util.List;

import stps.gob.mx.dto.InstitucionEducativaDTO;

public interface InstitucionEducativaService {
	InstitucionEducativaDTO alta(InstitucionEducativaDTO dto);
	InstitucionEducativaDTO baja(InstitucionEducativaDTO dto);
	List<InstitucionEducativaDTO> consulta(InstitucionEducativaDTO dto);
	List<InstitucionEducativaDTO> consultaId(InstitucionEducativaDTO dto);
	InstitucionEducativaDTO modificacion(InstitucionEducativaDTO dto);
}
