package stps.gob.mx.service;

import java.util.List;

import stps.gob.mx.dto.NotificacionDTO;

public interface NotificacionService {
	NotificacionDTO alta(NotificacionDTO dto);
	NotificacionDTO baja(NotificacionDTO dto);
	List<NotificacionDTO> consulta(NotificacionDTO dto);
	List<NotificacionDTO> consultaId(NotificacionDTO dto);
	NotificacionDTO modificacion(NotificacionDTO dto);
}
