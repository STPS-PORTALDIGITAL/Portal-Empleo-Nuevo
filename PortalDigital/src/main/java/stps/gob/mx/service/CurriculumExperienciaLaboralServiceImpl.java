package stps.gob.mx.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.converters.CurriculumExperienciaLaboralConverter;
import stps.gob.mx.domain.CurriculumExperienciaLaboral;
import stps.gob.mx.dto.CurriculumExperienciaLaboralDTO;
import stps.gob.mx.repositories.CurriculumExperienciaLaboralRepository;



@Service
public class CurriculumExperienciaLaboralServiceImpl implements  CurriculumExperienciaLaboralService{
	final static Logger log = Logger.getLogger(CurriculumExperienciaLaboralServiceImpl.class);
	
	
	@Autowired
	LogService logService;
	
	@Autowired
	CurriculumExperienciaLaboralRepository repository;

	/********************************************************************************************************
	 * Nombre del metodo: 	Alta de CurriculumExperienciaLaboral
	 * Descripcion: 		Metodo que implementa el servicio para el alta de CurriculumExperienciaLaboral
	 * Entrada/Salida:		CurriculumExperienciaLaboralDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Alta_CurriculumExperienciaLaboral_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public CurriculumExperienciaLaboralDTO alta(CurriculumExperienciaLaboralDTO dto) {
		CurriculumExperienciaLaboral 			entity 		= new CurriculumExperienciaLaboral();
		CurriculumExperienciaLaboral 			newEntity 	= new CurriculumExperienciaLaboral();
		CurriculumExperienciaLaboralConverter 	converter 	= new CurriculumExperienciaLaboralConverter();
		
		dto=(CurriculumExperienciaLaboralDTO)logService.setValues(dto, "CurriculumExperienciaLaboral", "alta", "CurriculumExperienciaLaboralServiceImpl");
		
		try {
			entity    = converter.toCurriculumExperienciaLaboralAlta(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toCurriculumExperienciaLaboralDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Baja de CurriculumExperienciaLaboral
	 * Descripcion: 		Metodo que implementa el servicio para la baja de CurriculumExperienciaLaboral
	 * Entrada/Salida:		CurriculumExperienciaLaboralDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Baja_CurriculumExperienciaLaboral_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public CurriculumExperienciaLaboralDTO baja(CurriculumExperienciaLaboralDTO dto) {
		CurriculumExperienciaLaboral 			entity 		= new CurriculumExperienciaLaboral();
		CurriculumExperienciaLaboral 			newEntity 	= new CurriculumExperienciaLaboral();
		CurriculumExperienciaLaboralConverter 	converter 	= new CurriculumExperienciaLaboralConverter();
		
		dto=(CurriculumExperienciaLaboralDTO)logService.setValues(dto, "CurriculumExperienciaLaboral", "baja", "CurriculumExperienciaLaboralServiceImpl");
		
		try {
			entity    = converter.toCurriculumExperienciaLaboralBaja(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toCurriculumExperienciaLaboralDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Consulta de CurriculumExperienciaLaboral
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de CurriculumExperienciaLaboral
	 * Entrada:				CurriculumExperienciaLaboralDTO
	 * Salida:				List<CurriculumExperienciaLaboralDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Consulta_CurriculumExperienciaLaboral_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<CurriculumExperienciaLaboralDTO> consulta(CurriculumExperienciaLaboralDTO dto) {
		CurriculumExperienciaLaboralDTO 		out 		= new CurriculumExperienciaLaboralDTO();
		CurriculumExperienciaLaboral 			entity 		= new CurriculumExperienciaLaboral();
		List<CurriculumExperienciaLaboral> 	list 		= new ArrayList<CurriculumExperienciaLaboral>();	
		List<CurriculumExperienciaLaboralDTO> 	finalList 	= new ArrayList<CurriculumExperienciaLaboralDTO>();
		CurriculumExperienciaLaboralConverter 	converter 	= new CurriculumExperienciaLaboralConverter();
		
		dto=(CurriculumExperienciaLaboralDTO)logService.setValues(dto, "CurriculumExperienciaLaboral", "consulta", "CurriculumExperienciaLaboralServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<CurriculumExperienciaLaboral>) repository.findAllRecords(Constantes.ACTIVO);
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTA_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new CurriculumExperienciaLaboral();
						out 		= new CurriculumExperienciaLaboralDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toCurriculumExperienciaLaboralDTO(entity, out);
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
	 * Nombre del metodo: 	Consulta de CurriculumExperienciaLaboral por Id
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de CurriculumExperienciaLaboral por Id
	 * Entrada:				CurriculumExperienciaLaboralDTO
	 * Salida:				List<CurriculumExperienciaLaboralDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_ConsultaId_CurriculumExperienciaLaboral_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<CurriculumExperienciaLaboralDTO> consultaId(CurriculumExperienciaLaboralDTO dto) {
		CurriculumExperienciaLaboralDTO 		out 		= new CurriculumExperienciaLaboralDTO();
		CurriculumExperienciaLaboral 			entity 		= new CurriculumExperienciaLaboral();
		List<CurriculumExperienciaLaboral> 	list 		= new ArrayList<CurriculumExperienciaLaboral>();	
		List<CurriculumExperienciaLaboralDTO> 	finalList 	= new ArrayList<CurriculumExperienciaLaboralDTO>();
		CurriculumExperienciaLaboralConverter 	converter 	= new CurriculumExperienciaLaboralConverter();
		
		dto=(CurriculumExperienciaLaboralDTO)logService.setValues(dto, "CurriculumExperienciaLaboral", "consultaId", "CurriculumExperienciaLaboralServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<CurriculumExperienciaLaboral>) repository.findById(Integer.parseInt(dto.getId()));
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTAID_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new CurriculumExperienciaLaboral();
						out 		= new CurriculumExperienciaLaboralDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toCurriculumExperienciaLaboralDTO(entity, out);
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
	 * Nombre del metodo: 	Modificacion de CurriculumExperienciaLaboral 
	 * Descripcion: 		Metodo que implementa el servicio para la modificacion de CurriculumExperienciaLaboral
	 * Entrada/Salida:		CurriculumExperienciaLaboralDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Modifificacion_CurriculumExperienciaLaboral_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public CurriculumExperienciaLaboralDTO modificacion(CurriculumExperienciaLaboralDTO dto) {
		CurriculumExperienciaLaboral 			entity 		= new CurriculumExperienciaLaboral();
		CurriculumExperienciaLaboral 			newEntity 	= new CurriculumExperienciaLaboral();
		CurriculumExperienciaLaboralConverter 	converter 	= new CurriculumExperienciaLaboralConverter();
		
		dto=(CurriculumExperienciaLaboralDTO)logService.setValues(dto, "CurriculumExperienciaLaboral", "modificacion", "CurriculumExperienciaLaboralServiceImpl");
		
		try {
			entity    = converter.toCurriculumExperienciaLaboral(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toCurriculumExperienciaLaboralDTO(newEntity, dto);
			
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

