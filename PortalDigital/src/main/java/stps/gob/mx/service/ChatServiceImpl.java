package stps.gob.mx.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.dto.ChatDTO;


@Service
public class ChatServiceImpl implements  ChatService{

	@Autowired
	LogService logService;

	/********************************************************************************************************
	 * Nombre del metodo: 	Alta de Chat
	 * Descripcion: 		Metodo que implementa el servicio para el alta de Chat
	 * Entrada/Salida:		ChatDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Alta_Chat_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public ChatDTO alta(ChatDTO dto) {

		dto=(ChatDTO)logService.setValues(dto, "Chat", "alta", "ChatServiceImpl");
		
		try {
			dto.setComments(Constantes.ALTA_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
			dto.setMessage(dto.getComments());
			dto.setResult(Constantes.TRUE);
		}catch(Exception e) {
			dto.setComments(Constantes.ERROR_EXCEPCION+"/"+dto.getServicio()+"/"+dto.getMetodo());
			dto.setMessage(dto.getComments());
			logService.recordException(e, dto);	
		}
		logService.recordLog(dto);
		
		return dto;
	}

	
	/********************************************************************************************************
	 * Nombre del metodo: 	Baja de Chat
	 * Descripcion: 		Metodo que implementa el servicio para la baja de Chat
	 * Entrada/Salida:		ChatDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Baja_Chat_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public ChatDTO baja(ChatDTO dto) {
		ChatDTO out = new ChatDTO();
		dto=(ChatDTO)logService.setValues(dto, "Chat", "baja", "ChatServiceImpl");
		
		try {
			dto.setComments(Constantes.BAJA_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
			out.setMessage(dto.getComments());
			out.setResult(Constantes.TRUE);
		}catch(Exception e) {
			dto.setComments(Constantes.ERROR_EXCEPCION+"/"+dto.getServicio()+"/"+dto.getMetodo());
			out.setMessage(dto.getComments());
			logService.recordException(e, dto);	
		}
		logService.recordLog(dto);
		
		return out;
	}

	/********************************************************************************************************
	 * Nombre del metodo: 	Consulta de Chat
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de Chat
	 * Entrada:				ChatDTO
	 * Salida:				List<ChatDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Consulta_Chat_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<ChatDTO> consulta(ChatDTO dto) {
		ChatDTO out = new ChatDTO();
		List<ChatDTO> list = new ArrayList<ChatDTO>();
		
		dto=(ChatDTO)logService.setValues(dto, "Chat", "consulta", "ChatServiceImpl");
		
		try {
			dto.setComments(Constantes.CONSULTA_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
			out.setMessage(dto.getComments());
			out.setResult(Constantes.TRUE);
			list.add(out);
		}catch(Exception e) {
			dto.setComments(Constantes.ERROR_EXCEPCION+"/"+dto.getServicio()+"/"+dto.getMetodo());
			out.setMessage(dto.getComments());
			logService.recordException(e, dto);	
		}
		logService.recordLog(dto);
		
		return list;
	}

	/********************************************************************************************************
	 * Nombre del metodo: 	Consulta de Chat por Id
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de Chat por Id
	 * Entrada:				ChatDTO
	 * Salida:				List<ChatDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_ConsultaId_Chat_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<ChatDTO> consultaId(ChatDTO dto) {
		ChatDTO out = new ChatDTO();
		List<ChatDTO> list = new ArrayList<ChatDTO>();
		
		dto=(ChatDTO)logService.setValues(dto, "Chat", "consultaId", "ChatServiceImpl");
		
		try {
			dto.setComments(Constantes.CONSULTAID_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
			out.setMessage(dto.getComments());
			out.setResult(Constantes.TRUE);
			list.add(out);
		}catch(Exception e) {
			dto.setComments(Constantes.ERROR_EXCEPCION+"/"+dto.getServicio()+"/"+dto.getMetodo());
			out.setMessage(dto.getComments());
			logService.recordException(e, dto);	
		}
		logService.recordLog(dto);
		
		return list;
	}

	/********************************************************************************************************
	 * Nombre del metodo: 	Modificacion de Chat 
	 * Descripcion: 		Metodo que implementa el servicio para la modificacion de Chat
	 * Entrada/Salida:		ChatDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Modifificacion_Chat_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public ChatDTO modificacion(ChatDTO dto) {
		ChatDTO out = new ChatDTO();
		dto=(ChatDTO)logService.setValues(dto, "Chat", "modificacion", "ChatServiceImpl");
		
		try {
			dto.setComments(Constantes.MODIFICACION_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
			out.setMessage(dto.getComments());
			out.setResult(Constantes.TRUE);
		}catch(Exception e) {
			dto.setComments(Constantes.ERROR_EXCEPCION+"/"+dto.getServicio()+"/"+dto.getMetodo());
			out.setMessage(dto.getComments());
			logService.recordException(e, dto);	
		}
		logService.recordLog(dto);
		
		return out;
	}


}

