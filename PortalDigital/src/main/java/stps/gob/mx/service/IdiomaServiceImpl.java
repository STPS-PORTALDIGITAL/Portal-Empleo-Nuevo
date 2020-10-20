package stps.gob.mx.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.converters.IdiomaConverter;
import stps.gob.mx.domain.Idioma;
import stps.gob.mx.dto.IdiomaDTO;
import stps.gob.mx.repositories.IdiomaRepository;



@Service
public class IdiomaServiceImpl implements  IdiomaService{
	final static Logger log = Logger.getLogger(IdiomaServiceImpl.class);
	
	
	@Autowired
	LogService logService;
	
	@Autowired
	IdiomaRepository repository;

	/********************************************************************************************************
	 * Nombre del metodo: 	Alta de Idioma
	 * Descripcion: 		Metodo que implementa el servicio para el alta de Idioma
	 * Entrada/Salida:		IdiomaDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Alta_Idioma_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public IdiomaDTO alta(IdiomaDTO dto) {
		Idioma 			entity 		= new Idioma();
		Idioma 			newEntity 	= new Idioma();
		IdiomaConverter 	converter 	= new IdiomaConverter();
		
		dto=(IdiomaDTO)logService.setValues(dto, "Idioma", "alta", "IdiomaServiceImpl");
		
		try {
			entity    = converter.toIdiomaAlta(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toIdiomaDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Baja de Idioma
	 * Descripcion: 		Metodo que implementa el servicio para la baja de Idioma
	 * Entrada/Salida:		IdiomaDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Baja_Idioma_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public IdiomaDTO baja(IdiomaDTO dto) {
		Idioma 			entity 		= new Idioma();
		Idioma 			newEntity 	= new Idioma();
		IdiomaConverter 	converter 	= new IdiomaConverter();
		
		dto=(IdiomaDTO)logService.setValues(dto, "Idioma", "baja", "IdiomaServiceImpl");
		
		try {
			entity    = converter.toIdiomaBaja(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toIdiomaDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Consulta de Idioma
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de Idioma
	 * Entrada:				IdiomaDTO
	 * Salida:				List<IdiomaDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Consulta_Idioma_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<IdiomaDTO> consulta(IdiomaDTO dto) {
		IdiomaDTO 		out 		= new IdiomaDTO();
		Idioma 			entity 		= new Idioma();
		List<Idioma> 	list 		= new ArrayList<Idioma>();	
		List<IdiomaDTO> 	finalList 	= new ArrayList<IdiomaDTO>();
		IdiomaConverter 	converter 	= new IdiomaConverter();
		
		dto=(IdiomaDTO)logService.setValues(dto, "Idioma", "consulta", "IdiomaServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<Idioma>) repository.findAllRecords(Constantes.ACTIVO);
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTA_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new Idioma();
						out 		= new IdiomaDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toIdiomaDTO(entity, out);
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
	 * Nombre del metodo: 	Consulta de Idioma por Id
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de Idioma por Id
	 * Entrada:				IdiomaDTO
	 * Salida:				List<IdiomaDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_ConsultaId_Idioma_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<IdiomaDTO> consultaId(IdiomaDTO dto) {
		IdiomaDTO 		out 		= new IdiomaDTO();
		Idioma 			entity 		= new Idioma();
		List<Idioma> 	list 		= new ArrayList<Idioma>();	
		List<IdiomaDTO> 	finalList 	= new ArrayList<IdiomaDTO>();
		IdiomaConverter 	converter 	= new IdiomaConverter();
		
		dto=(IdiomaDTO)logService.setValues(dto, "Idioma", "consultaId", "IdiomaServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<Idioma>) repository.findById(Integer.parseInt(dto.getId()));
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTAID_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new Idioma();
						out 		= new IdiomaDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toIdiomaDTO(entity, out);
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
	 * Nombre del metodo: 	Modificacion de Idioma 
	 * Descripcion: 		Metodo que implementa el servicio para la modificacion de Idioma
	 * Entrada/Salida:		IdiomaDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Modifificacion_Idioma_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public IdiomaDTO modificacion(IdiomaDTO dto) {
		Idioma 			entity 		= new Idioma();
		Idioma 			newEntity 	= new Idioma();
		IdiomaConverter 	converter 	= new IdiomaConverter();
		
		dto=(IdiomaDTO)logService.setValues(dto, "Idioma", "modificacion", "IdiomaServiceImpl");
		
		try {
			entity    = converter.toIdioma(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toIdiomaDTO(newEntity, dto);
			
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

