package stps.gob.mx.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.converters.CurriculumEscolaridadConverter;
import stps.gob.mx.domain.CurriculumEscolaridad;
import stps.gob.mx.dto.CurriculumEscolaridadDTO;
import stps.gob.mx.repositories.CurriculumEscolaridadRepository;



@Service
public class CurriculumEscolaridadServiceImpl implements  CurriculumEscolaridadService{
	final static Logger log = Logger.getLogger(CurriculumEscolaridadServiceImpl.class);
	
	
	@Autowired
	LogService logService;
	
	@Autowired
	CurriculumEscolaridadRepository repository;

	/********************************************************************************************************
	 * Nombre del metodo: 	Alta de CurriculumEscolaridad
	 * Descripcion: 		Metodo que implementa el servicio para el alta de CurriculumEscolaridad
	 * Entrada/Salida:		CurriculumEscolaridadDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Alta_CurriculumEscolaridad_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public CurriculumEscolaridadDTO alta(CurriculumEscolaridadDTO dto) {
		CurriculumEscolaridad 			entity 		= new CurriculumEscolaridad();
		CurriculumEscolaridad 			newEntity 	= new CurriculumEscolaridad();
		CurriculumEscolaridadConverter 	converter 	= new CurriculumEscolaridadConverter();
		
		dto=(CurriculumEscolaridadDTO)logService.setValues(dto, "CurriculumEscolaridad", "alta", "CurriculumEscolaridadServiceImpl");
		
		try {
			entity    = converter.toCurriculumEscolaridadAlta(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toCurriculumEscolaridadDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Baja de CurriculumEscolaridad
	 * Descripcion: 		Metodo que implementa el servicio para la baja de CurriculumEscolaridad
	 * Entrada/Salida:		CurriculumEscolaridadDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Baja_CurriculumEscolaridad_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public CurriculumEscolaridadDTO baja(CurriculumEscolaridadDTO dto) {
		CurriculumEscolaridad 			entity 		= new CurriculumEscolaridad();
		CurriculumEscolaridad 			newEntity 	= new CurriculumEscolaridad();
		CurriculumEscolaridadConverter 	converter 	= new CurriculumEscolaridadConverter();
		
		dto=(CurriculumEscolaridadDTO)logService.setValues(dto, "CurriculumEscolaridad", "baja", "CurriculumEscolaridadServiceImpl");
		
		try {
			entity    = converter.toCurriculumEscolaridadBaja(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toCurriculumEscolaridadDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Consulta de CurriculumEscolaridad
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de CurriculumEscolaridad
	 * Entrada:				CurriculumEscolaridadDTO
	 * Salida:				List<CurriculumEscolaridadDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Consulta_CurriculumEscolaridad_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<CurriculumEscolaridadDTO> consulta(CurriculumEscolaridadDTO dto) {
		CurriculumEscolaridadDTO 		out 		= new CurriculumEscolaridadDTO();
		CurriculumEscolaridad 			entity 		= new CurriculumEscolaridad();
		List<CurriculumEscolaridad> 	list 		= new ArrayList<CurriculumEscolaridad>();	
		List<CurriculumEscolaridadDTO> 	finalList 	= new ArrayList<CurriculumEscolaridadDTO>();
		CurriculumEscolaridadConverter 	converter 	= new CurriculumEscolaridadConverter();
		
		dto=(CurriculumEscolaridadDTO)logService.setValues(dto, "CurriculumEscolaridad", "consulta", "CurriculumEscolaridadServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<CurriculumEscolaridad>) repository.findAllRecords(Constantes.ACTIVO);
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTA_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new CurriculumEscolaridad();
						out 		= new CurriculumEscolaridadDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toCurriculumEscolaridadDTO(entity, out);
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
	 * Nombre del metodo: 	Consulta de CurriculumEscolaridad por Id
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de CurriculumEscolaridad por Id
	 * Entrada:				CurriculumEscolaridadDTO
	 * Salida:				List<CurriculumEscolaridadDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_ConsultaId_CurriculumEscolaridad_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<CurriculumEscolaridadDTO> consultaId(CurriculumEscolaridadDTO dto) {
		CurriculumEscolaridadDTO 		out 		= new CurriculumEscolaridadDTO();
		CurriculumEscolaridad 			entity 		= new CurriculumEscolaridad();
		List<CurriculumEscolaridad> 	list 		= new ArrayList<CurriculumEscolaridad>();	
		List<CurriculumEscolaridadDTO> 	finalList 	= new ArrayList<CurriculumEscolaridadDTO>();
		CurriculumEscolaridadConverter 	converter 	= new CurriculumEscolaridadConverter();
		
		dto=(CurriculumEscolaridadDTO)logService.setValues(dto, "CurriculumEscolaridad", "consultaId", "CurriculumEscolaridadServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<CurriculumEscolaridad>) repository.findById(Integer.parseInt(dto.getId()));
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTAID_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new CurriculumEscolaridad();
						out 		= new CurriculumEscolaridadDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toCurriculumEscolaridadDTO(entity, out);
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
	 * Nombre del metodo: 	Modificacion de CurriculumEscolaridad 
	 * Descripcion: 		Metodo que implementa el servicio para la modificacion de CurriculumEscolaridad
	 * Entrada/Salida:		CurriculumEscolaridadDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Modifificacion_CurriculumEscolaridad_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public CurriculumEscolaridadDTO modificacion(CurriculumEscolaridadDTO dto) {
		CurriculumEscolaridad 			entity 		= new CurriculumEscolaridad();
		CurriculumEscolaridad 			newEntity 	= new CurriculumEscolaridad();
		CurriculumEscolaridadConverter 	converter 	= new CurriculumEscolaridadConverter();
		
		dto=(CurriculumEscolaridadDTO)logService.setValues(dto, "CurriculumEscolaridad", "modificacion", "CurriculumEscolaridadServiceImpl");
		
		try {
			entity    = converter.toCurriculumEscolaridad(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toCurriculumEscolaridadDTO(newEntity, dto);
			
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

