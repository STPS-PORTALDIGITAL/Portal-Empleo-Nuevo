package stps.gob.mx.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.converters.CiudadConverter;
import stps.gob.mx.domain.Ciudad;
import stps.gob.mx.dto.CiudadDTO;
import stps.gob.mx.repositories.CiudadRepository;



@Service
public class CiudadServiceImpl implements  CiudadService{
	final static Logger log = Logger.getLogger(CiudadServiceImpl.class);
	
	
	@Autowired
	LogService logService;
	
	@Autowired
	CiudadRepository repository;

	/********************************************************************************************************
	 * Nombre del metodo: 	Alta de Ciudad
	 * Descripcion: 		Metodo que implementa el servicio para el alta de Ciudad
	 * Entrada/Salida:		CiudadDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Alta_Ciudad_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public CiudadDTO alta(CiudadDTO dto) {
		Ciudad 			entity 		= new Ciudad();
		Ciudad 			newEntity 	= new Ciudad();
		CiudadConverter 	converter 	= new CiudadConverter();
		
		dto=(CiudadDTO)logService.setValues(dto, "Ciudad", "alta", "CiudadServiceImpl");
		
		try {
			entity    = converter.toCiudadAlta(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toCiudadDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Baja de Ciudad
	 * Descripcion: 		Metodo que implementa el servicio para la baja de Ciudad
	 * Entrada/Salida:		CiudadDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Baja_Ciudad_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public CiudadDTO baja(CiudadDTO dto) {
		Ciudad 			entity 		= new Ciudad();
		Ciudad 			newEntity 	= new Ciudad();
		CiudadConverter 	converter 	= new CiudadConverter();
		
		dto=(CiudadDTO)logService.setValues(dto, "Ciudad", "baja", "CiudadServiceImpl");
		
		try {
			entity    = converter.toCiudadBaja(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toCiudadDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Consulta de Ciudad
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de Ciudad
	 * Entrada:				CiudadDTO
	 * Salida:				List<CiudadDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Consulta_Ciudad_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<CiudadDTO> consulta(CiudadDTO dto) {
		CiudadDTO 		out 		= new CiudadDTO();
		Ciudad 			entity 		= new Ciudad();
		List<Ciudad> 	list 		= new ArrayList<Ciudad>();	
		List<CiudadDTO> 	finalList 	= new ArrayList<CiudadDTO>();
		CiudadConverter 	converter 	= new CiudadConverter();
		
		dto=(CiudadDTO)logService.setValues(dto, "Ciudad", "consulta", "CiudadServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<Ciudad>) repository.findAllRecords(Constantes.ACTIVO);
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTA_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new Ciudad();
						out 		= new CiudadDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toCiudadDTO(entity, out);
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
	 * Nombre del metodo: 	Consulta de Ciudad por Id
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de Ciudad por Id
	 * Entrada:				CiudadDTO
	 * Salida:				List<CiudadDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_ConsultaId_Ciudad_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<CiudadDTO> consultaId(CiudadDTO dto) {
		CiudadDTO 		out 		= new CiudadDTO();
		Ciudad 			entity 		= new Ciudad();
		List<Ciudad> 	list 		= new ArrayList<Ciudad>();	
		List<CiudadDTO> 	finalList 	= new ArrayList<CiudadDTO>();
		CiudadConverter 	converter 	= new CiudadConverter();
		
		dto=(CiudadDTO)logService.setValues(dto, "Ciudad", "consultaId", "CiudadServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<Ciudad>) repository.findById(Integer.parseInt(dto.getId()));
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTAID_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new Ciudad();
						out 		= new CiudadDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toCiudadDTO(entity, out);
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
	 * Nombre del metodo: 	Modificacion de Ciudad 
	 * Descripcion: 		Metodo que implementa el servicio para la modificacion de Ciudad
	 * Entrada/Salida:		CiudadDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Modifificacion_Ciudad_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public CiudadDTO modificacion(CiudadDTO dto) {
		Ciudad 			entity 		= new Ciudad();
		Ciudad 			newEntity 	= new Ciudad();
		CiudadConverter 	converter 	= new CiudadConverter();
		
		dto=(CiudadDTO)logService.setValues(dto, "Ciudad", "modificacion", "CiudadServiceImpl");
		
		try {
			entity    = converter.toCiudad(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toCiudadDTO(newEntity, dto);
			
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

