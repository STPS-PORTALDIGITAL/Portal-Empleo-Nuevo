package stps.gob.mx.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.converters.NotificacionConverter;
import stps.gob.mx.domain.Notificacion;
import stps.gob.mx.dto.NotificacionDTO;
import stps.gob.mx.repositories.NotificacionRepository;



@Service
public class NotificacionServiceImpl implements  NotificacionService{
	final static Logger log = Logger.getLogger(NotificacionServiceImpl.class);
	
	
	@Autowired
	LogService logService;
	
	@Autowired
	NotificacionRepository repository;

	/********************************************************************************************************
	 * Nombre del metodo: 	Alta de Notificacion
	 * Descripcion: 		Metodo que implementa el servicio para el alta de Notificacion
	 * Entrada/Salida:		NotificacionDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Alta_Notificacion_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public NotificacionDTO alta(NotificacionDTO dto) {
		Notificacion 			entity 		= new Notificacion();
		Notificacion 			newEntity 	= new Notificacion();
		NotificacionConverter 	converter 	= new NotificacionConverter();
		
		dto=(NotificacionDTO)logService.setValues(dto, "Notificacion", "alta", "NotificacionServiceImpl");
		
		try {
			entity    = converter.toNotificacionAlta(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toNotificacionDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Baja de Notificacion
	 * Descripcion: 		Metodo que implementa el servicio para la baja de Notificacion
	 * Entrada/Salida:		NotificacionDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Baja_Notificacion_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public NotificacionDTO baja(NotificacionDTO dto) {
		Notificacion 			entity 		= new Notificacion();
		Notificacion 			newEntity 	= new Notificacion();
		NotificacionConverter 	converter 	= new NotificacionConverter();
		
		dto=(NotificacionDTO)logService.setValues(dto, "Notificacion", "baja", "NotificacionServiceImpl");
		
		try {
			entity    = converter.toNotificacionBaja(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toNotificacionDTO(newEntity, dto);
			
			dto.setComments(Constantes.BAJA_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
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
	 * Nombre del metodo: 	Consulta de Notificacion
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de Notificacion
	 * Entrada:				NotificacionDTO
	 * Salida:				List<NotificacionDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Consulta_Notificacion_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<NotificacionDTO> consulta(NotificacionDTO dto) {
		NotificacionDTO 		out 		= new NotificacionDTO();
		Notificacion 			entity 		= new Notificacion();
		List<Notificacion> 	list 		= new ArrayList<Notificacion>();	
		List<NotificacionDTO> 	finalList 	= new ArrayList<NotificacionDTO>();
		NotificacionConverter 	converter 	= new NotificacionConverter();
		
		dto=(NotificacionDTO)logService.setValues(dto, "Notificacion", "consulta", "NotificacionServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<Notificacion>) repository.findAllRecords(Constantes.ACTIVO);
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTA_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new Notificacion();
						out 		= new NotificacionDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toNotificacionDTO(entity, out);
						finalList.add(out);
					}
				}else {
					dto.setComments(Constantes.CONSULTA_SIN_REGISTROS +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.FALSE);	
				}
			}else {
				dto.setComments(Constantes.CONSULTA_NO_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
				dto.setMessage(out.getComments());
				dto.setResult(Constantes.FALSE);
			}
			
			
		}catch(Exception e) {
			dto.setComments(Constantes.ERROR_EXCEPCION+"/"+dto.getServicio()+"/"+dto.getMetodo());
			out.setMessage(dto.getComments());
			logService.recordException(e, out);	
		}
		logService.recordLog(dto);
		
		return finalList;
	}

	/********************************************************************************************************
	 * Nombre del metodo: 	Consulta de Notificacion por Id
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de Notificacion por Id
	 * Entrada:				NotificacionDTO
	 * Salida:				List<NotificacionDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_ConsultaId_Notificacion_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<NotificacionDTO> consultaId(NotificacionDTO dto) {
		NotificacionDTO 		out 		= new NotificacionDTO();
		Notificacion 			entity 		= new Notificacion();
		List<Notificacion> 	list 		= new ArrayList<Notificacion>();	
		List<NotificacionDTO> 	finalList 	= new ArrayList<NotificacionDTO>();
		NotificacionConverter 	converter 	= new NotificacionConverter();
		
		dto=(NotificacionDTO)logService.setValues(dto, "Notificacion", "consultaId", "NotificacionServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<Notificacion>) repository.findById(Integer.parseInt(dto.getId()));
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTAID_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new Notificacion();
						out 		= new NotificacionDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toNotificacionDTO(entity, out);
						finalList.add(out);
					}
				}else {
					dto.setComments(Constantes.CONSULTA_SIN_REGISTROS +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.FALSE);	
				}
			}else {
				dto.setComments(Constantes.CONSULTA_NO_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
				dto.setMessage(out.getComments());
				dto.setResult(Constantes.FALSE);
			}
			
			
		}catch(Exception e) {
			dto.setComments(Constantes.ERROR_EXCEPCION+"/"+dto.getServicio()+"/"+dto.getMetodo());
			out.setMessage(dto.getComments());
			logService.recordException(e, out);	
		}
		logService.recordLog(dto);
		
		return finalList;
	}

	/********************************************************************************************************
	 * Nombre del metodo: 	Modificacion de Notificacion 
	 * Descripcion: 		Metodo que implementa el servicio para la modificacion de Notificacion
	 * Entrada/Salida:		NotificacionDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Modifificacion_Notificacion_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public NotificacionDTO modificacion(NotificacionDTO dto) {
		Notificacion 			entity 		= new Notificacion();
		Notificacion 			newEntity 	= new Notificacion();
		NotificacionConverter 	converter 	= new NotificacionConverter();
		
		dto=(NotificacionDTO)logService.setValues(dto, "Notificacion", "modificacion", "NotificacionServiceImpl");
		
		try {
			entity    = converter.toNotificacion(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toNotificacionDTO(newEntity, dto);
			
			dto.setComments(Constantes.MODIFICACION_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
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


}

