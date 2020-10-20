package stps.gob.mx.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.converters.DisponibilidadConverter;
import stps.gob.mx.domain.Disponibilidad;
import stps.gob.mx.dto.DisponibilidadDTO;
import stps.gob.mx.repositories.DisponibilidadRepository;



@Service
public class DisponibilidadServiceImpl implements  DisponibilidadService{
	final static Logger log = Logger.getLogger(DisponibilidadServiceImpl.class);
	
	
	@Autowired
	LogService logService;
	
	@Autowired
	DisponibilidadRepository repository;

	/********************************************************************************************************
	 * Nombre del metodo: 	Alta de Disponibilidad
	 * Descripcion: 		Metodo que implementa el servicio para el alta de Disponibilidad
	 * Entrada/Salida:		DisponibilidadDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Alta_Disponibilidad_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public DisponibilidadDTO alta(DisponibilidadDTO dto) {
		Disponibilidad 			entity 		= new Disponibilidad();
		Disponibilidad 			newEntity 	= new Disponibilidad();
		DisponibilidadConverter 	converter 	= new DisponibilidadConverter();
		
		dto=(DisponibilidadDTO)logService.setValues(dto, "Disponibilidad", "alta", "DisponibilidadServiceImpl");
		
		try {
			entity    = converter.toDisponibilidadAlta(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toDisponibilidadDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Baja de Disponibilidad
	 * Descripcion: 		Metodo que implementa el servicio para la baja de Disponibilidad
	 * Entrada/Salida:		DisponibilidadDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Baja_Disponibilidad_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public DisponibilidadDTO baja(DisponibilidadDTO dto) {
		Disponibilidad 			entity 		= new Disponibilidad();
		Disponibilidad 			newEntity 	= new Disponibilidad();
		DisponibilidadConverter 	converter 	= new DisponibilidadConverter();
		
		dto=(DisponibilidadDTO)logService.setValues(dto, "Disponibilidad", "baja", "DisponibilidadServiceImpl");
		
		try {
			entity    = converter.toDisponibilidadBaja(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toDisponibilidadDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Consulta de Disponibilidad
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de Disponibilidad
	 * Entrada:				DisponibilidadDTO
	 * Salida:				List<DisponibilidadDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Consulta_Disponibilidad_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<DisponibilidadDTO> consulta(DisponibilidadDTO dto) {
		DisponibilidadDTO 		out 		= new DisponibilidadDTO();
		Disponibilidad 			entity 		= new Disponibilidad();
		List<Disponibilidad> 	list 		= new ArrayList<Disponibilidad>();	
		List<DisponibilidadDTO> 	finalList 	= new ArrayList<DisponibilidadDTO>();
		DisponibilidadConverter 	converter 	= new DisponibilidadConverter();
		
		dto=(DisponibilidadDTO)logService.setValues(dto, "Disponibilidad", "consulta", "DisponibilidadServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<Disponibilidad>) repository.findAllRecords(Constantes.ACTIVO);
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTA_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new Disponibilidad();
						out 		= new DisponibilidadDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toDisponibilidadDTO(entity, out);
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
	 * Nombre del metodo: 	Consulta de Disponibilidad por Id
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de Disponibilidad por Id
	 * Entrada:				DisponibilidadDTO
	 * Salida:				List<DisponibilidadDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_ConsultaId_Disponibilidad_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<DisponibilidadDTO> consultaId(DisponibilidadDTO dto) {
		DisponibilidadDTO 		out 		= new DisponibilidadDTO();
		Disponibilidad 			entity 		= new Disponibilidad();
		List<Disponibilidad> 	list 		= new ArrayList<Disponibilidad>();	
		List<DisponibilidadDTO> 	finalList 	= new ArrayList<DisponibilidadDTO>();
		DisponibilidadConverter 	converter 	= new DisponibilidadConverter();
		
		dto=(DisponibilidadDTO)logService.setValues(dto, "Disponibilidad", "consultaId", "DisponibilidadServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<Disponibilidad>) repository.findById(Integer.parseInt(dto.getId()));
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTAID_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new Disponibilidad();
						out 		= new DisponibilidadDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toDisponibilidadDTO(entity, out);
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
	 * Nombre del metodo: 	Modificacion de Disponibilidad 
	 * Descripcion: 		Metodo que implementa el servicio para la modificacion de Disponibilidad
	 * Entrada/Salida:		DisponibilidadDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Modifificacion_Disponibilidad_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public DisponibilidadDTO modificacion(DisponibilidadDTO dto) {
		Disponibilidad 			entity 		= new Disponibilidad();
		Disponibilidad 			newEntity 	= new Disponibilidad();
		DisponibilidadConverter 	converter 	= new DisponibilidadConverter();
		
		dto=(DisponibilidadDTO)logService.setValues(dto, "Disponibilidad", "modificacion", "DisponibilidadServiceImpl");
		
		try {
			entity    = converter.toDisponibilidad(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toDisponibilidadDTO(newEntity, dto);
			
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

