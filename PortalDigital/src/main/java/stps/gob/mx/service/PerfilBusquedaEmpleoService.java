package stps.gob.mx.service;

import java.util.List;

import stps.gob.mx.dto.PerfilBusquedaEmpleoDTO;

public interface PerfilBusquedaEmpleoService {
	PerfilBusquedaEmpleoDTO alta(PerfilBusquedaEmpleoDTO dto);
	PerfilBusquedaEmpleoDTO baja(PerfilBusquedaEmpleoDTO dto);
	List<PerfilBusquedaEmpleoDTO> consulta(PerfilBusquedaEmpleoDTO dto);
	List<PerfilBusquedaEmpleoDTO> consultaId(PerfilBusquedaEmpleoDTO dto);
	PerfilBusquedaEmpleoDTO modificacion(PerfilBusquedaEmpleoDTO dto);
}
