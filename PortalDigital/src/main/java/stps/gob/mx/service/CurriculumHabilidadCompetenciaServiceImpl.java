package stps.gob.mx.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.converters.CurriculumHabilidadCompetenciaConverter;
import stps.gob.mx.domain.CurriculumHabilidadCompetencia;
import stps.gob.mx.dto.CurriculumHabilidadCompetenciaDTO;
import stps.gob.mx.repositories.CurriculumHabilidadCompetenciaRepository;



@Service
public class CurriculumHabilidadCompetenciaServiceImpl implements  CurriculumHabilidadCompetenciaService{
	final static Logger log = Logger.getLogger(CurriculumHabilidadCompetenciaServiceImpl.class);
	
	
	@Autowired
	LogService logService;
	
	@Autowired
	CurriculumHabilidadCompetenciaRepository repository;

	/********************************************************************************************************
	 * Nombre del metodo: 	Alta de CurriculumHabilidadCompetencia
	 * Descripcion: 		Metodo que implementa el servicio para el alta de CurriculumHabilidadCompetencia
	 * Entrada/Salida:		CurriculumHabilidadCompetenciaDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Alta_CurriculumHabilidadCompetencia_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public CurriculumHabilidadCompetenciaDTO alta(CurriculumHabilidadCompetenciaDTO dto) {
		CurriculumHabilidadCompetencia 			entity 		= new CurriculumHabilidadCompetencia();
		CurriculumHabilidadCompetencia 			newEntity 	= new CurriculumHabilidadCompetencia();
		CurriculumHabilidadCompetenciaConverter 	converter 	= new CurriculumHabilidadCompetenciaConverter();
		
		dto=(CurriculumHabilidadCompetenciaDTO)logService.setValues(dto, "CurriculumHabilidadCompetencia", "alta", "CurriculumHabilidadCompetenciaServiceImpl");
		
		try {
			entity    = converter.toCurriculumHabilidadCompetenciaAlta(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toCurriculumHabilidadCompetenciaDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Baja de CurriculumHabilidadCompetencia
	 * Descripcion: 		Metodo que implementa el servicio para la baja de CurriculumHabilidadCompetencia
	 * Entrada/Salida:		CurriculumHabilidadCompetenciaDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Baja_CurriculumHabilidadCompetencia_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public CurriculumHabilidadCompetenciaDTO baja(CurriculumHabilidadCompetenciaDTO dto) {
		CurriculumHabilidadCompetencia 			entity 		= new CurriculumHabilidadCompetencia();
		CurriculumHabilidadCompetencia 			newEntity 	= new CurriculumHabilidadCompetencia();
		CurriculumHabilidadCompetenciaConverter 	converter 	= new CurriculumHabilidadCompetenciaConverter();
		
		dto=(CurriculumHabilidadCompetenciaDTO)logService.setValues(dto, "CurriculumHabilidadCompetencia", "baja", "CurriculumHabilidadCompetenciaServiceImpl");
		
		try {
			entity    = converter.toCurriculumHabilidadCompetenciaBaja(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toCurriculumHabilidadCompetenciaDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Consulta de CurriculumHabilidadCompetencia
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de CurriculumHabilidadCompetencia
	 * Entrada:				CurriculumHabilidadCompetenciaDTO
	 * Salida:				List<CurriculumHabilidadCompetenciaDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Consulta_CurriculumHabilidadCompetencia_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<CurriculumHabilidadCompetenciaDTO> consulta(CurriculumHabilidadCompetenciaDTO dto) {
		CurriculumHabilidadCompetenciaDTO 		out 		= new CurriculumHabilidadCompetenciaDTO();
		CurriculumHabilidadCompetencia 			entity 		= new CurriculumHabilidadCompetencia();
		List<CurriculumHabilidadCompetencia> 	list 		= new ArrayList<CurriculumHabilidadCompetencia>();	
		List<CurriculumHabilidadCompetenciaDTO> 	finalList 	= new ArrayList<CurriculumHabilidadCompetenciaDTO>();
		CurriculumHabilidadCompetenciaConverter 	converter 	= new CurriculumHabilidadCompetenciaConverter();
		
		dto=(CurriculumHabilidadCompetenciaDTO)logService.setValues(dto, "CurriculumHabilidadCompetencia", "consulta", "CurriculumHabilidadCompetenciaServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<CurriculumHabilidadCompetencia>) repository.findAllRecords(Constantes.ACTIVO);
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTA_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new CurriculumHabilidadCompetencia();
						out 		= new CurriculumHabilidadCompetenciaDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toCurriculumHabilidadCompetenciaDTO(entity, out);
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
	 * Nombre del metodo: 	Consulta de CurriculumHabilidadCompetencia por Id
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de CurriculumHabilidadCompetencia por Id
	 * Entrada:				CurriculumHabilidadCompetenciaDTO
	 * Salida:				List<CurriculumHabilidadCompetenciaDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_ConsultaId_CurriculumHabilidadCompetencia_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<CurriculumHabilidadCompetenciaDTO> consultaId(CurriculumHabilidadCompetenciaDTO dto) {
		CurriculumHabilidadCompetenciaDTO 		out 		= new CurriculumHabilidadCompetenciaDTO();
		CurriculumHabilidadCompetencia 			entity 		= new CurriculumHabilidadCompetencia();
		List<CurriculumHabilidadCompetencia> 	list 		= new ArrayList<CurriculumHabilidadCompetencia>();	
		List<CurriculumHabilidadCompetenciaDTO> 	finalList 	= new ArrayList<CurriculumHabilidadCompetenciaDTO>();
		CurriculumHabilidadCompetenciaConverter 	converter 	= new CurriculumHabilidadCompetenciaConverter();
		
		dto=(CurriculumHabilidadCompetenciaDTO)logService.setValues(dto, "CurriculumHabilidadCompetencia", "consultaId", "CurriculumHabilidadCompetenciaServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<CurriculumHabilidadCompetencia>) repository.findById(Integer.parseInt(dto.getId()));
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTAID_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new CurriculumHabilidadCompetencia();
						out 		= new CurriculumHabilidadCompetenciaDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toCurriculumHabilidadCompetenciaDTO(entity, out);
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
	 * Nombre del metodo: 	Modificacion de CurriculumHabilidadCompetencia 
	 * Descripcion: 		Metodo que implementa el servicio para la modificacion de CurriculumHabilidadCompetencia
	 * Entrada/Salida:		CurriculumHabilidadCompetenciaDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Modifificacion_CurriculumHabilidadCompetencia_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public CurriculumHabilidadCompetenciaDTO modificacion(CurriculumHabilidadCompetenciaDTO dto) {
		CurriculumHabilidadCompetencia 			entity 		= new CurriculumHabilidadCompetencia();
		CurriculumHabilidadCompetencia 			newEntity 	= new CurriculumHabilidadCompetencia();
		CurriculumHabilidadCompetenciaConverter 	converter 	= new CurriculumHabilidadCompetenciaConverter();
		
		dto=(CurriculumHabilidadCompetenciaDTO)logService.setValues(dto, "CurriculumHabilidadCompetencia", "modificacion", "CurriculumHabilidadCompetenciaServiceImpl");
		
		try {
			entity    = converter.toCurriculumHabilidadCompetencia(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toCurriculumHabilidadCompetenciaDTO(newEntity, dto);
			
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

