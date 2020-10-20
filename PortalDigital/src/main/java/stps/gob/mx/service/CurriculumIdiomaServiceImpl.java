package stps.gob.mx.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.converters.CurriculumIdiomaConverter;
import stps.gob.mx.domain.CurriculumIdioma;
import stps.gob.mx.dto.CurriculumIdiomaDTO;
import stps.gob.mx.repositories.CurriculumIdiomaRepository;



@Service
public class CurriculumIdiomaServiceImpl implements  CurriculumIdiomaService{
	final static Logger log = Logger.getLogger(CurriculumIdiomaServiceImpl.class);
	
	
	@Autowired
	LogService logService;
	
	@Autowired
	CurriculumIdiomaRepository repository;

	/********************************************************************************************************
	 * Nombre del metodo: 	Alta de CurriculumIdioma
	 * Descripcion: 		Metodo que implementa el servicio para el alta de CurriculumIdioma
	 * Entrada/Salida:		CurriculumIdiomaDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Alta_CurriculumIdioma_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public CurriculumIdiomaDTO alta(CurriculumIdiomaDTO dto) {
		CurriculumIdioma 			entity 		= new CurriculumIdioma();
		CurriculumIdioma 			newEntity 	= new CurriculumIdioma();
		CurriculumIdiomaConverter 	converter 	= new CurriculumIdiomaConverter();
		
		dto=(CurriculumIdiomaDTO)logService.setValues(dto, "CurriculumIdioma", "alta", "CurriculumIdiomaServiceImpl");
		
		try {
			entity    = converter.toCurriculumIdiomaAlta(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toCurriculumIdiomaDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Baja de CurriculumIdioma
	 * Descripcion: 		Metodo que implementa el servicio para la baja de CurriculumIdioma
	 * Entrada/Salida:		CurriculumIdiomaDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Baja_CurriculumIdioma_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public CurriculumIdiomaDTO baja(CurriculumIdiomaDTO dto) {
		CurriculumIdioma 			entity 		= new CurriculumIdioma();
		CurriculumIdioma 			newEntity 	= new CurriculumIdioma();
		CurriculumIdiomaConverter 	converter 	= new CurriculumIdiomaConverter();
		
		dto=(CurriculumIdiomaDTO)logService.setValues(dto, "CurriculumIdioma", "baja", "CurriculumIdiomaServiceImpl");
		
		try {
			entity    = converter.toCurriculumIdiomaBaja(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toCurriculumIdiomaDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Consulta de CurriculumIdioma
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de CurriculumIdioma
	 * Entrada:				CurriculumIdiomaDTO
	 * Salida:				List<CurriculumIdiomaDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Consulta_CurriculumIdioma_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<CurriculumIdiomaDTO> consulta(CurriculumIdiomaDTO dto) {
		CurriculumIdiomaDTO 		out 		= new CurriculumIdiomaDTO();
		CurriculumIdioma 			entity 		= new CurriculumIdioma();
		List<CurriculumIdioma> 	list 		= new ArrayList<CurriculumIdioma>();	
		List<CurriculumIdiomaDTO> 	finalList 	= new ArrayList<CurriculumIdiomaDTO>();
		CurriculumIdiomaConverter 	converter 	= new CurriculumIdiomaConverter();
		
		dto=(CurriculumIdiomaDTO)logService.setValues(dto, "CurriculumIdioma", "consulta", "CurriculumIdiomaServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<CurriculumIdioma>) repository.findAllRecords(Constantes.ACTIVO);
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTA_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new CurriculumIdioma();
						out 		= new CurriculumIdiomaDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toCurriculumIdiomaDTO(entity, out);
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
	 * Nombre del metodo: 	Consulta de CurriculumIdioma por Id
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de CurriculumIdioma por Id
	 * Entrada:				CurriculumIdiomaDTO
	 * Salida:				List<CurriculumIdiomaDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_ConsultaId_CurriculumIdioma_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<CurriculumIdiomaDTO> consultaId(CurriculumIdiomaDTO dto) {
		CurriculumIdiomaDTO 		out 		= new CurriculumIdiomaDTO();
		CurriculumIdioma 			entity 		= new CurriculumIdioma();
		List<CurriculumIdioma> 	list 		= new ArrayList<CurriculumIdioma>();	
		List<CurriculumIdiomaDTO> 	finalList 	= new ArrayList<CurriculumIdiomaDTO>();
		CurriculumIdiomaConverter 	converter 	= new CurriculumIdiomaConverter();
		
		dto=(CurriculumIdiomaDTO)logService.setValues(dto, "CurriculumIdioma", "consultaId", "CurriculumIdiomaServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<CurriculumIdioma>) repository.findById(Integer.parseInt(dto.getId()));
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTAID_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new CurriculumIdioma();
						out 		= new CurriculumIdiomaDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toCurriculumIdiomaDTO(entity, out);
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
	 * Nombre del metodo: 	Modificacion de CurriculumIdioma 
	 * Descripcion: 		Metodo que implementa el servicio para la modificacion de CurriculumIdioma
	 * Entrada/Salida:		CurriculumIdiomaDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Modifificacion_CurriculumIdioma_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public CurriculumIdiomaDTO modificacion(CurriculumIdiomaDTO dto) {
		CurriculumIdioma 			entity 		= new CurriculumIdioma();
		CurriculumIdioma 			newEntity 	= new CurriculumIdioma();
		CurriculumIdiomaConverter 	converter 	= new CurriculumIdiomaConverter();
		
		dto=(CurriculumIdiomaDTO)logService.setValues(dto, "CurriculumIdioma", "modificacion", "CurriculumIdiomaServiceImpl");
		
		try {
			entity    = converter.toCurriculumIdioma(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toCurriculumIdiomaDTO(newEntity, dto);
			
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

