package stps.gob.mx.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.converters.CurriculumConverter;
import stps.gob.mx.domain.Curriculum;
import stps.gob.mx.dto.CurriculumDTO;
import stps.gob.mx.repositories.CurriculumRepository;



@Service
public class CurriculumServiceImpl implements  CurriculumService{
	final static Logger log = Logger.getLogger(CurriculumServiceImpl.class);
	
	
	@Autowired
	LogService logService;
	
	@Autowired
	CurriculumRepository repository;

	/********************************************************************************************************
	 * Nombre del metodo: 	Alta de Curriculum
	 * Descripcion: 		Metodo que implementa el servicio para el alta de Curriculum
	 * Entrada/Salida:		CurriculumDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Alta_Curriculum_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public CurriculumDTO alta(CurriculumDTO dto) {
		Curriculum 			entity 		= new Curriculum();
		Curriculum 			newEntity 	= new Curriculum();
		CurriculumConverter 	converter 	= new CurriculumConverter();
		
		dto=(CurriculumDTO)logService.setValues(dto, "Curriculum", "alta", "CurriculumServiceImpl");
		
		try {
			entity    = converter.toCurriculumAlta(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toCurriculumDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Baja de Curriculum
	 * Descripcion: 		Metodo que implementa el servicio para la baja de Curriculum
	 * Entrada/Salida:		CurriculumDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Baja_Curriculum_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public CurriculumDTO baja(CurriculumDTO dto) {
		Curriculum 			entity 		= new Curriculum();
		Curriculum 			newEntity 	= new Curriculum();
		CurriculumConverter 	converter 	= new CurriculumConverter();
		
		dto=(CurriculumDTO)logService.setValues(dto, "Curriculum", "baja", "CurriculumServiceImpl");
		
		try {
			entity    = converter.toCurriculumBaja(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toCurriculumDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Consulta de Curriculum
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de Curriculum
	 * Entrada:				CurriculumDTO
	 * Salida:				List<CurriculumDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Consulta_Curriculum_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<CurriculumDTO> consulta(CurriculumDTO dto) {
		CurriculumDTO 		out 		= new CurriculumDTO();
		Curriculum 			entity 		= new Curriculum();
		List<Curriculum> 	list 		= new ArrayList<Curriculum>();	
		List<CurriculumDTO> 	finalList 	= new ArrayList<CurriculumDTO>();
		CurriculumConverter 	converter 	= new CurriculumConverter();
		
		dto=(CurriculumDTO)logService.setValues(dto, "Curriculum", "consulta", "CurriculumServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<Curriculum>) repository.findAllRecords(Constantes.ACTIVO);
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTA_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new Curriculum();
						out 		= new CurriculumDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toCurriculumDTO(entity, out);
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
	 * Nombre del metodo: 	Consulta de Curriculum por Id
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de Curriculum por Id
	 * Entrada:				CurriculumDTO
	 * Salida:				List<CurriculumDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_ConsultaId_Curriculum_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<CurriculumDTO> consultaId(CurriculumDTO dto) {
		CurriculumDTO 		out 		= new CurriculumDTO();
		Curriculum 			entity 		= new Curriculum();
		List<Curriculum> 	list 		= new ArrayList<Curriculum>();	
		List<CurriculumDTO> 	finalList 	= new ArrayList<CurriculumDTO>();
		CurriculumConverter 	converter 	= new CurriculumConverter();
		
		dto=(CurriculumDTO)logService.setValues(dto, "Curriculum", "consultaId", "CurriculumServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<Curriculum>) repository.findById(Integer.parseInt(dto.getId()));
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTAID_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new Curriculum();
						out 		= new CurriculumDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toCurriculumDTO(entity, out);
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
	 * Nombre del metodo: 	Modificacion de Curriculum 
	 * Descripcion: 		Metodo que implementa el servicio para la modificacion de Curriculum
	 * Entrada/Salida:		CurriculumDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Modifificacion_Curriculum_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public CurriculumDTO modificacion(CurriculumDTO dto) {
		Curriculum 			entity 		= new Curriculum();
		Curriculum 			newEntity 	= new Curriculum();
		CurriculumConverter 	converter 	= new CurriculumConverter();
		
		dto=(CurriculumDTO)logService.setValues(dto, "Curriculum", "modificacion", "CurriculumServiceImpl");
		
		try {
			entity    = converter.toCurriculum(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toCurriculumDTO(newEntity, dto);
			
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

