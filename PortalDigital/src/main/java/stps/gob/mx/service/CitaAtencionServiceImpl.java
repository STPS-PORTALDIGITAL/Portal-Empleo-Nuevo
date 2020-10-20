package stps.gob.mx.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.converters.CitaAtencionConverter;
import stps.gob.mx.domain.CitaAtencion;
import stps.gob.mx.dto.CitaAtencionDTO;
import stps.gob.mx.repositories.CitaAtencionRepository;



@Service
public class CitaAtencionServiceImpl implements  CitaAtencionService{
	final static Logger log = Logger.getLogger(CitaAtencionServiceImpl.class);
	
	
	@Autowired
	LogService logService;
	
	@Autowired
	CitaAtencionRepository repository;

	/********************************************************************************************************
	 * Nombre del metodo: 	Alta de CitaAtencion
	 * Descripcion: 		Metodo que implementa el servicio para el alta de CitaAtencion
	 * Entrada/Salida:		CitaAtencionDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Alta_CitaAtencion_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public CitaAtencionDTO alta(CitaAtencionDTO dto) {
		CitaAtencion 			entity 		= new CitaAtencion();
		CitaAtencion 			newEntity 	= new CitaAtencion();
		CitaAtencionConverter 	converter 	= new CitaAtencionConverter();
		
		dto=(CitaAtencionDTO)logService.setValues(dto, "CitaAtencion", "alta", "CitaAtencionServiceImpl");
		
		try {
			entity    = converter.toCitaAtencionAlta(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toCitaAtencionDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Baja de CitaAtencion
	 * Descripcion: 		Metodo que implementa el servicio para la baja de CitaAtencion
	 * Entrada/Salida:		CitaAtencionDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Baja_CitaAtencion_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public CitaAtencionDTO baja(CitaAtencionDTO dto) {
		CitaAtencion 			entity 		= new CitaAtencion();
		CitaAtencion 			newEntity 	= new CitaAtencion();
		CitaAtencionConverter 	converter 	= new CitaAtencionConverter();
		
		dto=(CitaAtencionDTO)logService.setValues(dto, "CitaAtencion", "baja", "CitaAtencionServiceImpl");
		
		try {
			entity    = converter.toCitaAtencionBaja(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toCitaAtencionDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Consulta de CitaAtencion
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de CitaAtencion
	 * Entrada:				CitaAtencionDTO
	 * Salida:				List<CitaAtencionDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Consulta_CitaAtencion_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<CitaAtencionDTO> consulta(CitaAtencionDTO dto) {
		CitaAtencionDTO 		out 		= new CitaAtencionDTO();
		CitaAtencion 			entity 		= new CitaAtencion();
		List<CitaAtencion> 	list 		= new ArrayList<CitaAtencion>();	
		List<CitaAtencionDTO> 	finalList 	= new ArrayList<CitaAtencionDTO>();
		CitaAtencionConverter 	converter 	= new CitaAtencionConverter();
		
		dto=(CitaAtencionDTO)logService.setValues(dto, "CitaAtencion", "consulta", "CitaAtencionServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<CitaAtencion>) repository.findAllRecords(Constantes.ACTIVO);
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTA_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new CitaAtencion();
						out 		= new CitaAtencionDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toCitaAtencionDTO(entity, out);
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
	 * Nombre del metodo: 	Consulta de CitaAtencion por Id
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de CitaAtencion por Id
	 * Entrada:				CitaAtencionDTO
	 * Salida:				List<CitaAtencionDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_ConsultaId_CitaAtencion_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<CitaAtencionDTO> consultaId(CitaAtencionDTO dto) {
		CitaAtencionDTO 		out 		= new CitaAtencionDTO();
		CitaAtencion 			entity 		= new CitaAtencion();
		List<CitaAtencion> 	list 		= new ArrayList<CitaAtencion>();	
		List<CitaAtencionDTO> 	finalList 	= new ArrayList<CitaAtencionDTO>();
		CitaAtencionConverter 	converter 	= new CitaAtencionConverter();
		
		dto=(CitaAtencionDTO)logService.setValues(dto, "CitaAtencion", "consultaId", "CitaAtencionServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<CitaAtencion>) repository.findById(Integer.parseInt(dto.getId()));
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTAID_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new CitaAtencion();
						out 		= new CitaAtencionDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toCitaAtencionDTO(entity, out);
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
	 * Nombre del metodo: 	Modificacion de CitaAtencion 
	 * Descripcion: 		Metodo que implementa el servicio para la modificacion de CitaAtencion
	 * Entrada/Salida:		CitaAtencionDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Modifificacion_CitaAtencion_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public CitaAtencionDTO modificacion(CitaAtencionDTO dto) {
		CitaAtencion 			entity 		= new CitaAtencion();
		CitaAtencion 			newEntity 	= new CitaAtencion();
		CitaAtencionConverter 	converter 	= new CitaAtencionConverter();
		
		dto=(CitaAtencionDTO)logService.setValues(dto, "CitaAtencion", "modificacion", "CitaAtencionServiceImpl");
		
		try {
			entity    = converter.toCitaAtencion(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toCitaAtencionDTO(newEntity, dto);
			
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

