package stps.gob.mx.service;

import java.util.List;

import stps.gob.mx.dto.CodigoPostalDTO;

public interface CodigoPostalService {
	CodigoPostalDTO alta(CodigoPostalDTO dto);
	CodigoPostalDTO baja(CodigoPostalDTO dto);
	List<CodigoPostalDTO> consulta(CodigoPostalDTO dto);
	List<CodigoPostalDTO> consultaId(CodigoPostalDTO dto);
	CodigoPostalDTO modificacion(CodigoPostalDTO dto);
}
