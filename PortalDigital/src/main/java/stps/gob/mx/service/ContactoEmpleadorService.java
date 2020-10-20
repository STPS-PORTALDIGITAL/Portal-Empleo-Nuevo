package stps.gob.mx.service;

import java.util.List;

import stps.gob.mx.dto.ContactoEmpleadorDTO;

public interface ContactoEmpleadorService {
	ContactoEmpleadorDTO alta(ContactoEmpleadorDTO dto);
	ContactoEmpleadorDTO baja(ContactoEmpleadorDTO dto);
	List<ContactoEmpleadorDTO> consulta(ContactoEmpleadorDTO dto);
	List<ContactoEmpleadorDTO> consultaId(ContactoEmpleadorDTO dto);
	ContactoEmpleadorDTO modificacion(ContactoEmpleadorDTO dto);
}
