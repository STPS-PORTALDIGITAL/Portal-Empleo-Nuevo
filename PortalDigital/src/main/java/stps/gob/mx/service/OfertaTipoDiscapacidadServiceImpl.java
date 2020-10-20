package stps.gob.mx.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.converters.OfertaTipoDiscapacidadConverter;
import stps.gob.mx.domain.OfertaTipoDiscapacidad;
import stps.gob.mx.dto.OfertaTipoDiscapacidadDTO;
import stps.gob.mx.repositories.OfertaTipoDiscapacidadRepository;



@Service
public class OfertaTipoDiscapacidadServiceImpl implements  OfertaTipoDiscapacidadService{
	final static Logger log = Logger.getLogger(OfertaTipoDiscapacidadServiceImpl.class);
	
	
	@Autowired
	LogService logService;
	
	@Autowired
	OfertaTipoDiscapacidadRepository repository;

	/********************************************************************************************************
	 * Nombre del metodo: 	Alta de OfertaTipoDiscapacidad
	 * Descripcion: 		Metodo que implementa el servicio para el alta de OfertaTipoDiscapacidad
	 * Entrada/Salida:		OfertaTipoDiscapacidadDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Alta_OfertaTipoDiscapacidad_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public OfertaTipoDiscapacidadDTO alta(OfertaTipoDiscapacidadDTO dto) {
		OfertaTipoDiscapacidad 			entity 		= new OfertaTipoDiscapacidad();
		OfertaTipoDiscapacidad 			newEntity 	= new OfertaTipoDiscapacidad();
		OfertaTipoDiscapacidadConverter 	converter 	= new OfertaTipoDiscapacidadConverter();
		
		dto=(OfertaTipoDiscapacidadDTO)logService.setValues(dto, "OfertaTipoDiscapacidad", "alta", "OfertaTipoDiscapacidadServiceImpl");
		
		try {
			entity    = converter.toOfertaTipoDiscapacidadAlta(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toOfertaTipoDiscapacidadDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Baja de OfertaTipoDiscapacidad
	 * Descripcion: 		Metodo que implementa el servicio para la baja de OfertaTipoDiscapacidad
	 * Entrada/Salida:		OfertaTipoDiscapacidadDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Baja_OfertaTipoDiscapacidad_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public OfertaTipoDiscapacidadDTO baja(OfertaTipoDiscapacidadDTO dto) {
		OfertaTipoDiscapacidad 			entity 		= new OfertaTipoDiscapacidad();
		OfertaTipoDiscapacidad 			newEntity 	= new OfertaTipoDiscapacidad();
		OfertaTipoDiscapacidadConverter 	converter 	= new OfertaTipoDiscapacidadConverter();
		
		dto=(OfertaTipoDiscapacidadDTO)logService.setValues(dto, "OfertaTipoDiscapacidad", "baja", "OfertaTipoDiscapacidadServiceImpl");
		
		try {
			entity    = converter.toOfertaTipoDiscapacidadBaja(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toOfertaTipoDiscapacidadDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Consulta de OfertaTipoDiscapacidad
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de OfertaTipoDiscapacidad
	 * Entrada:				OfertaTipoDiscapacidadDTO
	 * Salida:				List<OfertaTipoDiscapacidadDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Consulta_OfertaTipoDiscapacidad_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<OfertaTipoDiscapacidadDTO> consulta(OfertaTipoDiscapacidadDTO dto) {
		OfertaTipoDiscapacidadDTO 		out 		= new OfertaTipoDiscapacidadDTO();
		OfertaTipoDiscapacidad 			entity 		= new OfertaTipoDiscapacidad();
		List<OfertaTipoDiscapacidad> 	list 		= new ArrayList<OfertaTipoDiscapacidad>();	
		List<OfertaTipoDiscapacidadDTO> 	finalList 	= new ArrayList<OfertaTipoDiscapacidadDTO>();
		OfertaTipoDiscapacidadConverter 	converter 	= new OfertaTipoDiscapacidadConverter();
		
		dto=(OfertaTipoDiscapacidadDTO)logService.setValues(dto, "OfertaTipoDiscapacidad", "consulta", "OfertaTipoDiscapacidadServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<OfertaTipoDiscapacidad>) repository.findAllRecords(Constantes.ACTIVO);
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTA_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new OfertaTipoDiscapacidad();
						out 		= new OfertaTipoDiscapacidadDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toOfertaTipoDiscapacidadDTO(entity, out);
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
	 * Nombre del metodo: 	Consulta de OfertaTipoDiscapacidad por Id
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de OfertaTipoDiscapacidad por Id
	 * Entrada:				OfertaTipoDiscapacidadDTO
	 * Salida:				List<OfertaTipoDiscapacidadDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_ConsultaId_OfertaTipoDiscapacidad_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<OfertaTipoDiscapacidadDTO> consultaId(OfertaTipoDiscapacidadDTO dto) {
		OfertaTipoDiscapacidadDTO 		out 		= new OfertaTipoDiscapacidadDTO();
		OfertaTipoDiscapacidad 			entity 		= new OfertaTipoDiscapacidad();
		List<OfertaTipoDiscapacidad> 	list 		= new ArrayList<OfertaTipoDiscapacidad>();	
		List<OfertaTipoDiscapacidadDTO> 	finalList 	= new ArrayList<OfertaTipoDiscapacidadDTO>();
		OfertaTipoDiscapacidadConverter 	converter 	= new OfertaTipoDiscapacidadConverter();
		
		dto=(OfertaTipoDiscapacidadDTO)logService.setValues(dto, "OfertaTipoDiscapacidad", "consultaId", "OfertaTipoDiscapacidadServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<OfertaTipoDiscapacidad>) repository.findById(Integer.parseInt(dto.getId()));
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTAID_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new OfertaTipoDiscapacidad();
						out 		= new OfertaTipoDiscapacidadDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toOfertaTipoDiscapacidadDTO(entity, out);
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
	 * Nombre del metodo: 	Modificacion de OfertaTipoDiscapacidad 
	 * Descripcion: 		Metodo que implementa el servicio para la modificacion de OfertaTipoDiscapacidad
	 * Entrada/Salida:		OfertaTipoDiscapacidadDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Modifificacion_OfertaTipoDiscapacidad_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public OfertaTipoDiscapacidadDTO modificacion(OfertaTipoDiscapacidadDTO dto) {
		OfertaTipoDiscapacidad 			entity 		= new OfertaTipoDiscapacidad();
		OfertaTipoDiscapacidad 			newEntity 	= new OfertaTipoDiscapacidad();
		OfertaTipoDiscapacidadConverter 	converter 	= new OfertaTipoDiscapacidadConverter();
		
		dto=(OfertaTipoDiscapacidadDTO)logService.setValues(dto, "OfertaTipoDiscapacidad", "modificacion", "OfertaTipoDiscapacidadServiceImpl");
		
		try {
			entity    = converter.toOfertaTipoDiscapacidad(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toOfertaTipoDiscapacidadDTO(newEntity, dto);
			
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

