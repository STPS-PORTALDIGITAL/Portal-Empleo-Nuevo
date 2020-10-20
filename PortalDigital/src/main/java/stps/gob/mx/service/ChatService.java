package stps.gob.mx.service;

import java.util.List;

import stps.gob.mx.dto.ChatDTO;

public interface ChatService {
	ChatDTO alta(ChatDTO dto);
	ChatDTO baja(ChatDTO dto);
	List<ChatDTO> consulta(ChatDTO dto);
	List<ChatDTO> consultaId(ChatDTO dto);
	ChatDTO modificacion(ChatDTO dto);
}
