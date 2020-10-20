package stps.gob.mx.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.converters.HabilidadCompetenciaConverter;
import stps.gob.mx.domain.HabilidadCompetencia;
import stps.gob.mx.dto.HabilidadCompetenciaDTO;
import stps.gob.mx.repositories.HabilidadCompetenciaRepository;



@Service
public class HabilidadCompetenciaServiceImpl implements  HabilidadCompetenciaService{
	final static Logger log = Logger.getLogger(HabilidadCompetenciaServiceImpl.class);
	
	
	@Autowired
	LogService logService;
	
	@Autowired
	HabilidadCompetenciaRepository repository;

	/********************************************************************************************************
	 * Nombre del metodo: 	Alta de HabilidadCompetencia
	 * Descripcion: 		Metodo que implementa el servicio para el alta de HabilidadCompetencia
	 * Entrada/Salida:		HabilidadCompetenciaDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Alta_HabilidadCompetencia_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public HabilidadCompetenciaDTO alta(HabilidadCompetenciaDTO dto) {
		HabilidadCompetencia 			entity 		= new HabilidadCompetencia();
		HabilidadCompetencia 			newEntity 	= new HabilidadCompetencia();
		HabilidadCompetenciaConverter 	converter 	= new HabilidadCompetenciaConverter();
		
		dto=(HabilidadCompetenciaDTO)logService.setValues(dto, "HabilidadCompetencia", "alta", "HabilidadCompetenciaServiceImpl");
		
		try {
			entity    = converter.toHabilidadCompetenciaAlta(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toHabilidadCompetenciaDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Baja de HabilidadCompetencia
	 * Descripcion: 		Metodo que implementa el servicio para la baja de HabilidadCompetencia
	 * Entrada/Salida:		HabilidadCompetenciaDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Baja_HabilidadCompetencia_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public HabilidadCompetenciaDTO baja(HabilidadCompetenciaDTO dto) {
		HabilidadCompetencia 			entity 		= new HabilidadCompetencia();
		HabilidadCompetencia 			newEntity 	= new HabilidadCompetencia();
		HabilidadCompetenciaConverter 	converter 	= new HabilidadCompetenciaConverter();
		
		dto=(HabilidadCompetenciaDTO)logService.setValues(dto, "HabilidadCompetencia", "baja", "HabilidadCompetenciaServiceImpl");
		
		try {
			entity    = converter.toHabilidadCompetenciaBaja(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toHabilidadCompetenciaDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Consulta de HabilidadCompetencia
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de HabilidadCompetencia
	 * Entrada:				HabilidadCompetenciaDTO
	 * Salida:				List<HabilidadCompetenciaDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Consulta_HabilidadCompetencia_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<HabilidadCompetenciaDTO> consulta(HabilidadCompetenciaDTO dto) {
		HabilidadCompetenciaDTO 		out 		= new HabilidadCompetenciaDTO();
		HabilidadCompetencia 			entity 		= new HabilidadCompetencia();
		List<HabilidadCompetencia> 	list 		= new ArrayList<HabilidadCompetencia>();	
		List<HabilidadCompetenciaDTO> 	finalList 	= new ArrayList<HabilidadCompetenciaDTO>();
		HabilidadCompetenciaConverter 	converter 	= new HabilidadCompetenciaConverter();
		
		dto=(HabilidadCompetenciaDTO)logService.setValues(dto, "HabilidadCompetencia", "consulta", "HabilidadCompetenciaServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<HabilidadCompetencia>) repository.findAllRecords(Constantes.ACTIVO);
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTA_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new HabilidadCompetencia();
						out 		= new HabilidadCompetenciaDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toHabilidadCompetenciaDTO(entity, out);
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
	 * Nombre del metodo: 	Consulta de HabilidadCompetencia por Id
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de HabilidadCompetencia por Id
	 * Entrada:				HabilidadCompetenciaDTO
	 * Salida:				List<HabilidadCompetenciaDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_ConsultaId_HabilidadCompetencia_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<HabilidadCompetenciaDTO> consultaId(HabilidadCompetenciaDTO dto) {
		HabilidadCompetenciaDTO 		out 		= new HabilidadCompetenciaDTO();
		HabilidadCompetencia 			entity 		= new HabilidadCompetencia();
		List<HabilidadCompetencia> 	list 		= new ArrayList<HabilidadCompetencia>();	
		List<HabilidadCompetenciaDTO> 	finalList 	= new ArrayList<HabilidadCompetenciaDTO>();
		HabilidadCompetenciaConverter 	converter 	= new HabilidadCompetenciaConverter();
		
		dto=(HabilidadCompetenciaDTO)logService.setValues(dto, "HabilidadCompetencia", "consultaId", "HabilidadCompetenciaServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<HabilidadCompetencia>) repository.findById(Integer.parseInt(dto.getId()));
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTAID_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new HabilidadCompetencia();
						out 		= new HabilidadCompetenciaDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toHabilidadCompetenciaDTO(entity, out);
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
	 * Nombre del metodo: 	Modificacion de HabilidadCompetencia 
	 * Descripcion: 		Metodo que implementa el servicio para la modificacion de HabilidadCompetencia
	 * Entrada/Salida:		HabilidadCompetenciaDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Modifificacion_HabilidadCompetencia_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public HabilidadCompetenciaDTO modificacion(HabilidadCompetenciaDTO dto) {
		HabilidadCompetencia 			entity 		= new HabilidadCompetencia();
		HabilidadCompetencia 			newEntity 	= new HabilidadCompetencia();
		HabilidadCompetenciaConverter 	converter 	= new HabilidadCompetenciaConverter();
		
		dto=(HabilidadCompetenciaDTO)logService.setValues(dto, "HabilidadCompetencia", "modificacion", "HabilidadCompetenciaServiceImpl");
		
		try {
			entity    = converter.toHabilidadCompetencia(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toHabilidadCompetenciaDTO(newEntity, dto);
			
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

