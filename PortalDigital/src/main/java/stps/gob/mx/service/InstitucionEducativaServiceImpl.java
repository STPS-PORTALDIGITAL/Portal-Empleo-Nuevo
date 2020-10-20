package stps.gob.mx.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.converters.InstitucionEducativaConverter;
import stps.gob.mx.domain.InstitucionEducativa;
import stps.gob.mx.dto.InstitucionEducativaDTO;
import stps.gob.mx.repositories.InstitucionEducativaRepository;



@Service
public class InstitucionEducativaServiceImpl implements  InstitucionEducativaService{
	final static Logger log = Logger.getLogger(InstitucionEducativaServiceImpl.class);
	
	
	@Autowired
	LogService logService;
	
	@Autowired
	InstitucionEducativaRepository repository;

	/********************************************************************************************************
	 * Nombre del metodo: 	Alta de InstitucionEducativa
	 * Descripcion: 		Metodo que implementa el servicio para el alta de InstitucionEducativa
	 * Entrada/Salida:		InstitucionEducativaDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Alta_InstitucionEducativa_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public InstitucionEducativaDTO alta(InstitucionEducativaDTO dto) {
		InstitucionEducativa 			entity 		= new InstitucionEducativa();
		InstitucionEducativa 			newEntity 	= new InstitucionEducativa();
		InstitucionEducativaConverter 	converter 	= new InstitucionEducativaConverter();
		
		dto=(InstitucionEducativaDTO)logService.setValues(dto, "InstitucionEducativa", "alta", "InstitucionEducativaServiceImpl");
		
		try {
			entity    = converter.toInstitucionEducativaAlta(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toInstitucionEducativaDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Baja de InstitucionEducativa
	 * Descripcion: 		Metodo que implementa el servicio para la baja de InstitucionEducativa
	 * Entrada/Salida:		InstitucionEducativaDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Baja_InstitucionEducativa_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public InstitucionEducativaDTO baja(InstitucionEducativaDTO dto) {
		InstitucionEducativa 			entity 		= new InstitucionEducativa();
		InstitucionEducativa 			newEntity 	= new InstitucionEducativa();
		InstitucionEducativaConverter 	converter 	= new InstitucionEducativaConverter();
		
		dto=(InstitucionEducativaDTO)logService.setValues(dto, "InstitucionEducativa", "baja", "InstitucionEducativaServiceImpl");
		
		try {
			entity    = converter.toInstitucionEducativaBaja(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toInstitucionEducativaDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Consulta de InstitucionEducativa
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de InstitucionEducativa
	 * Entrada:				InstitucionEducativaDTO
	 * Salida:				List<InstitucionEducativaDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Consulta_InstitucionEducativa_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<InstitucionEducativaDTO> consulta(InstitucionEducativaDTO dto) {
		InstitucionEducativaDTO 		out 		= new InstitucionEducativaDTO();
		InstitucionEducativa 			entity 		= new InstitucionEducativa();
		List<InstitucionEducativa> 	list 		= new ArrayList<InstitucionEducativa>();	
		List<InstitucionEducativaDTO> 	finalList 	= new ArrayList<InstitucionEducativaDTO>();
		InstitucionEducativaConverter 	converter 	= new InstitucionEducativaConverter();
		
		dto=(InstitucionEducativaDTO)logService.setValues(dto, "InstitucionEducativa", "consulta", "InstitucionEducativaServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<InstitucionEducativa>) repository.findAllRecords(Constantes.ACTIVO);
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTA_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new InstitucionEducativa();
						out 		= new InstitucionEducativaDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toInstitucionEducativaDTO(entity, out);
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
	 * Nombre del metodo: 	Consulta de InstitucionEducativa por Id
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de InstitucionEducativa por Id
	 * Entrada:				InstitucionEducativaDTO
	 * Salida:				List<InstitucionEducativaDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_ConsultaId_InstitucionEducativa_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<InstitucionEducativaDTO> consultaId(InstitucionEducativaDTO dto) {
		InstitucionEducativaDTO 		out 		= new InstitucionEducativaDTO();
		InstitucionEducativa 			entity 		= new InstitucionEducativa();
		List<InstitucionEducativa> 	list 		= new ArrayList<InstitucionEducativa>();	
		List<InstitucionEducativaDTO> 	finalList 	= new ArrayList<InstitucionEducativaDTO>();
		InstitucionEducativaConverter 	converter 	= new InstitucionEducativaConverter();
		
		dto=(InstitucionEducativaDTO)logService.setValues(dto, "InstitucionEducativa", "consultaId", "InstitucionEducativaServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<InstitucionEducativa>) repository.findById(Integer.parseInt(dto.getId()));
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTAID_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new InstitucionEducativa();
						out 		= new InstitucionEducativaDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toInstitucionEducativaDTO(entity, out);
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
	 * Nombre del metodo: 	Modificacion de InstitucionEducativa 
	 * Descripcion: 		Metodo que implementa el servicio para la modificacion de InstitucionEducativa
	 * Entrada/Salida:		InstitucionEducativaDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Modifificacion_InstitucionEducativa_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public InstitucionEducativaDTO modificacion(InstitucionEducativaDTO dto) {
		InstitucionEducativa 			entity 		= new InstitucionEducativa();
		InstitucionEducativa 			newEntity 	= new InstitucionEducativa();
		InstitucionEducativaConverter 	converter 	= new InstitucionEducativaConverter();
		
		dto=(InstitucionEducativaDTO)logService.setValues(dto, "InstitucionEducativa", "modificacion", "InstitucionEducativaServiceImpl");
		
		try {
			entity    = converter.toInstitucionEducativa(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toInstitucionEducativaDTO(newEntity, dto);
			
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

