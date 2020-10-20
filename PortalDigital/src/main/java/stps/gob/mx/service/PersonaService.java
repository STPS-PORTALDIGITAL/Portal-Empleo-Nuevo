package stps.gob.mx.service;

import java.util.List;

import stps.gob.mx.dto.PersonaDTO;

public interface PersonaService {
	PersonaDTO alta(PersonaDTO dto);
	PersonaDTO baja(PersonaDTO dto);
	List<PersonaDTO> consulta(PersonaDTO dto);
	List<PersonaDTO> consultaId(PersonaDTO dto);
	PersonaDTO modificacion(PersonaDTO dto);
}
