package stps.gob.mx.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.converters.EntidadConverter;
import stps.gob.mx.domain.Entidad;
import stps.gob.mx.dto.EntidadDTO;
import stps.gob.mx.repositories.EntidadRepository;



@Service
public class EntidadServiceImpl implements  EntidadService{
	final static Logger log = Logger.getLogger(EntidadServiceImpl.class);
	
	
	@Autowired
	LogService logService;
	
	@Autowired
	EntidadRepository repository;

	/********************************************************************************************************
	 * Nombre del metodo: 	Alta de Entidad
	 * Descripcion: 		Metodo que implementa el servicio para el alta de Entidad
	 * Entrada/Salida:		EntidadDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Alta_Entidad_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public EntidadDTO alta(EntidadDTO dto) {
		Entidad 			entity 		= new Entidad();
		Entidad 			newEntity 	= new Entidad();
		EntidadConverter 	converter 	= new EntidadConverter();
		
		dto=(EntidadDTO)logService.setValues(dto, "Entidad", "alta", "EntidadServiceImpl");
		
		try {
			entity    = converter.toEntidadAlta(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toEntidadDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Baja de Entidad
	 * Descripcion: 		Metodo que implementa el servicio para la baja de Entidad
	 * Entrada/Salida:		EntidadDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Baja_Entidad_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public EntidadDTO baja(EntidadDTO dto) {
		Entidad 			entity 		= new Entidad();
		Entidad 			newEntity 	= new Entidad();
		EntidadConverter 	converter 	= new EntidadConverter();
		
		dto=(EntidadDTO)logService.setValues(dto, "Entidad", "baja", "EntidadServiceImpl");
		
		try {
			entity    = converter.toEntidadBaja(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toEntidadDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Consulta de Entidad
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de Entidad
	 * Entrada:				EntidadDTO
	 * Salida:				List<EntidadDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Consulta_Entidad_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<EntidadDTO> consulta(EntidadDTO dto) {
		EntidadDTO 		out 		= new EntidadDTO();
		Entidad 			entity 		= new Entidad();
		List<Entidad> 	list 		= new ArrayList<Entidad>();	
		List<EntidadDTO> 	finalList 	= new ArrayList<EntidadDTO>();
		EntidadConverter 	converter 	= new EntidadConverter();
		
		dto=(EntidadDTO)logService.setValues(dto, "Entidad", "consulta", "EntidadServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<Entidad>) repository.findAllRecords(Constantes.ACTIVO);
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTA_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new Entidad();
						out 		= new EntidadDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toEntidadDTO(entity, out);
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
	 * Nombre del metodo: 	Consulta de Entidad por Id
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de Entidad por Id
	 * Entrada:				EntidadDTO
	 * Salida:				List<EntidadDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_ConsultaId_Entidad_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<EntidadDTO> consultaId(EntidadDTO dto) {
		EntidadDTO 		out 		= new EntidadDTO();
		Entidad 			entity 		= new Entidad();
		List<Entidad> 	list 		= new ArrayList<Entidad>();	
		List<EntidadDTO> 	finalList 	= new ArrayList<EntidadDTO>();
		EntidadConverter 	converter 	= new EntidadConverter();
		
		dto=(EntidadDTO)logService.setValues(dto, "Entidad", "consultaId", "EntidadServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<Entidad>) repository.findById(Integer.parseInt(dto.getId()));
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTAID_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new Entidad();
						out 		= new EntidadDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toEntidadDTO(entity, out);
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
	 * Nombre del metodo: 	Modificacion de Entidad 
	 * Descripcion: 		Metodo que implementa el servicio para la modificacion de Entidad
	 * Entrada/Salida:		EntidadDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Modifificacion_Entidad_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public EntidadDTO modificacion(EntidadDTO dto) {
		Entidad 			entity 		= new Entidad();
		Entidad 			newEntity 	= new Entidad();
		EntidadConverter 	converter 	= new EntidadConverter();
		
		dto=(EntidadDTO)logService.setValues(dto, "Entidad", "modificacion", "EntidadServiceImpl");
		
		try {
			entity    = converter.toEntidad(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toEntidadDTO(newEntity, dto);
			
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

