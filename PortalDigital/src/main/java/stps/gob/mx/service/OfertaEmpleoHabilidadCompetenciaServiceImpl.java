package stps.gob.mx.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.converters.OfertaEmpleoHabilidadCompetenciaConverter;
import stps.gob.mx.domain.OfertaEmpleoHabilidadCompetencia;
import stps.gob.mx.dto.OfertaEmpleoHabilidadCompetenciaDTO;
import stps.gob.mx.repositories.OfertaEmpleoHabilidadCompetenciaRepository;



@Service
public class OfertaEmpleoHabilidadCompetenciaServiceImpl implements  OfertaEmpleoHabilidadCompetenciaService{
	final static Logger log = Logger.getLogger(OfertaEmpleoHabilidadCompetenciaServiceImpl.class);
	
	
	@Autowired
	LogService logService;
	
	@Autowired
	OfertaEmpleoHabilidadCompetenciaRepository repository;

	/********************************************************************************************************
	 * Nombre del metodo: 	Alta de OfertaEmpleoHabilidadCompetencia
	 * Descripcion: 		Metodo que implementa el servicio para el alta de OfertaEmpleoHabilidadCompetencia
	 * Entrada/Salida:		OfertaEmpleoHabilidadCompetenciaDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Alta_OfertaEmpleoHabilidadCompetencia_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public OfertaEmpleoHabilidadCompetenciaDTO alta(OfertaEmpleoHabilidadCompetenciaDTO dto) {
		OfertaEmpleoHabilidadCompetencia 			entity 		= new OfertaEmpleoHabilidadCompetencia();
		OfertaEmpleoHabilidadCompetencia 			newEntity 	= new OfertaEmpleoHabilidadCompetencia();
		OfertaEmpleoHabilidadCompetenciaConverter 	converter 	= new OfertaEmpleoHabilidadCompetenciaConverter();
		
		dto=(OfertaEmpleoHabilidadCompetenciaDTO)logService.setValues(dto, "OfertaEmpleoHabilidadCompetencia", "alta", "OfertaEmpleoHabilidadCompetenciaServiceImpl");
		
		try {
			entity    = converter.toOfertaEmpleoHabilidadCompetenciaAlta(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toOfertaEmpleoHabilidadCompetenciaDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Baja de OfertaEmpleoHabilidadCompetencia
	 * Descripcion: 		Metodo que implementa el servicio para la baja de OfertaEmpleoHabilidadCompetencia
	 * Entrada/Salida:		OfertaEmpleoHabilidadCompetenciaDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Baja_OfertaEmpleoHabilidadCompetencia_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public OfertaEmpleoHabilidadCompetenciaDTO baja(OfertaEmpleoHabilidadCompetenciaDTO dto) {
		OfertaEmpleoHabilidadCompetencia 			entity 		= new OfertaEmpleoHabilidadCompetencia();
		OfertaEmpleoHabilidadCompetencia 			newEntity 	= new OfertaEmpleoHabilidadCompetencia();
		OfertaEmpleoHabilidadCompetenciaConverter 	converter 	= new OfertaEmpleoHabilidadCompetenciaConverter();
		
		dto=(OfertaEmpleoHabilidadCompetenciaDTO)logService.setValues(dto, "OfertaEmpleoHabilidadCompetencia", "baja", "OfertaEmpleoHabilidadCompetenciaServiceImpl");
		
		try {
			entity    = converter.toOfertaEmpleoHabilidadCompetenciaBaja(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toOfertaEmpleoHabilidadCompetenciaDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Consulta de OfertaEmpleoHabilidadCompetencia
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de OfertaEmpleoHabilidadCompetencia
	 * Entrada:				OfertaEmpleoHabilidadCompetenciaDTO
	 * Salida:				List<OfertaEmpleoHabilidadCompetenciaDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Consulta_OfertaEmpleoHabilidadCompetencia_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<OfertaEmpleoHabilidadCompetenciaDTO> consulta(OfertaEmpleoHabilidadCompetenciaDTO dto) {
		OfertaEmpleoHabilidadCompetenciaDTO 		out 		= new OfertaEmpleoHabilidadCompetenciaDTO();
		OfertaEmpleoHabilidadCompetencia 			entity 		= new OfertaEmpleoHabilidadCompetencia();
		List<OfertaEmpleoHabilidadCompetencia> 	list 		= new ArrayList<OfertaEmpleoHabilidadCompetencia>();	
		List<OfertaEmpleoHabilidadCompetenciaDTO> 	finalList 	= new ArrayList<OfertaEmpleoHabilidadCompetenciaDTO>();
		OfertaEmpleoHabilidadCompetenciaConverter 	converter 	= new OfertaEmpleoHabilidadCompetenciaConverter();
		
		dto=(OfertaEmpleoHabilidadCompetenciaDTO)logService.setValues(dto, "OfertaEmpleoHabilidadCompetencia", "consulta", "OfertaEmpleoHabilidadCompetenciaServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<OfertaEmpleoHabilidadCompetencia>) repository.findAllRecords(Constantes.ACTIVO);
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTA_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new OfertaEmpleoHabilidadCompetencia();
						out 		= new OfertaEmpleoHabilidadCompetenciaDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toOfertaEmpleoHabilidadCompetenciaDTO(entity, out);
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
	 * Nombre del metodo: 	Consulta de OfertaEmpleoHabilidadCompetencia por Id
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de OfertaEmpleoHabilidadCompetencia por Id
	 * Entrada:				OfertaEmpleoHabilidadCompetenciaDTO
	 * Salida:				List<OfertaEmpleoHabilidadCompetenciaDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_ConsultaId_OfertaEmpleoHabilidadCompetencia_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<OfertaEmpleoHabilidadCompetenciaDTO> consultaId(OfertaEmpleoHabilidadCompetenciaDTO dto) {
		OfertaEmpleoHabilidadCompetenciaDTO 		out 		= new OfertaEmpleoHabilidadCompetenciaDTO();
		OfertaEmpleoHabilidadCompetencia 			entity 		= new OfertaEmpleoHabilidadCompetencia();
		List<OfertaEmpleoHabilidadCompetencia> 	list 		= new ArrayList<OfertaEmpleoHabilidadCompetencia>();	
		List<OfertaEmpleoHabilidadCompetenciaDTO> 	finalList 	= new ArrayList<OfertaEmpleoHabilidadCompetenciaDTO>();
		OfertaEmpleoHabilidadCompetenciaConverter 	converter 	= new OfertaEmpleoHabilidadCompetenciaConverter();
		
		dto=(OfertaEmpleoHabilidadCompetenciaDTO)logService.setValues(dto, "OfertaEmpleoHabilidadCompetencia", "consultaId", "OfertaEmpleoHabilidadCompetenciaServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<OfertaEmpleoHabilidadCompetencia>) repository.findById(Integer.parseInt(dto.getId()));
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTAID_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new OfertaEmpleoHabilidadCompetencia();
						out 		= new OfertaEmpleoHabilidadCompetenciaDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toOfertaEmpleoHabilidadCompetenciaDTO(entity, out);
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
	 * Nombre del metodo: 	Modificacion de OfertaEmpleoHabilidadCompetencia 
	 * Descripcion: 		Metodo que implementa el servicio para la modificacion de OfertaEmpleoHabilidadCompetencia
	 * Entrada/Salida:		OfertaEmpleoHabilidadCompetenciaDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Modifificacion_OfertaEmpleoHabilidadCompetencia_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public OfertaEmpleoHabilidadCompetenciaDTO modificacion(OfertaEmpleoHabilidadCompetenciaDTO dto) {
		OfertaEmpleoHabilidadCompetencia 			entity 		= new OfertaEmpleoHabilidadCompetencia();
		OfertaEmpleoHabilidadCompetencia 			newEntity 	= new OfertaEmpleoHabilidadCompetencia();
		OfertaEmpleoHabilidadCompetenciaConverter 	converter 	= new OfertaEmpleoHabilidadCompetenciaConverter();
		
		dto=(OfertaEmpleoHabilidadCompetenciaDTO)logService.setValues(dto, "OfertaEmpleoHabilidadCompetencia", "modificacion", "OfertaEmpleoHabilidadCompetenciaServiceImpl");
		
		try {
			entity    = converter.toOfertaEmpleoHabilidadCompetencia(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toOfertaEmpleoHabilidadCompetenciaDTO(newEntity, dto);
			
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

