package stps.gob.mx.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.converters.UbicacionConverter;
import stps.gob.mx.domain.Ubicacion;
import stps.gob.mx.dto.UbicacionDTO;
import stps.gob.mx.repositories.UbicacionRepository;



@Service
public class UbicacionServiceImpl implements  UbicacionService{
	final static Logger log = Logger.getLogger(UbicacionServiceImpl.class);
	
	
	@Autowired
	LogService logService;
	
	@Autowired
	UbicacionRepository repository;

	/********************************************************************************************************
	 * Nombre del metodo: 	Alta de Ubicacion
	 * Descripcion: 		Metodo que implementa el servicio para el alta de Ubicacion
	 * Entrada/Salida:		UbicacionDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Alta_Ubicacion_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public UbicacionDTO alta(UbicacionDTO dto) {
		Ubicacion 			entity 		= new Ubicacion();
		Ubicacion 			newEntity 	= new Ubicacion();
		UbicacionConverter 	converter 	= new UbicacionConverter();
		
		dto=(UbicacionDTO)logService.setValues(dto, "Ubicacion", "alta", "UbicacionServiceImpl");
		
		try {
			entity    = converter.toUbicacionAlta(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toUbicacionDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Baja de Ubicacion
	 * Descripcion: 		Metodo que implementa el servicio para la baja de Ubicacion
	 * Entrada/Salida:		UbicacionDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Baja_Ubicacion_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public UbicacionDTO baja(UbicacionDTO dto) {
		Ubicacion 			entity 		= new Ubicacion();
		Ubicacion 			newEntity 	= new Ubicacion();
		UbicacionConverter 	converter 	= new UbicacionConverter();
		
		dto=(UbicacionDTO)logService.setValues(dto, "Ubicacion", "baja", "UbicacionServiceImpl");
		
		try {
			entity    = converter.toUbicacionBaja(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toUbicacionDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Consulta de Ubicacion
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de Ubicacion
	 * Entrada:				UbicacionDTO
	 * Salida:				List<UbicacionDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Consulta_Ubicacion_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<UbicacionDTO> consulta(UbicacionDTO dto) {
		UbicacionDTO 		out 		= new UbicacionDTO();
		Ubicacion 			entity 		= new Ubicacion();
		List<Ubicacion> 	list 		= new ArrayList<Ubicacion>();	
		List<UbicacionDTO> 	finalList 	= new ArrayList<UbicacionDTO>();
		UbicacionConverter 	converter 	= new UbicacionConverter();
		
		dto=(UbicacionDTO)logService.setValues(dto, "Ubicacion", "consulta", "UbicacionServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<Ubicacion>) repository.findAllRecords(Constantes.ACTIVO);
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTA_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new Ubicacion();
						out 		= new UbicacionDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toUbicacionDTO(entity, out);
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
	 * Nombre del metodo: 	Consulta de Ubicacion por Id
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de Ubicacion por Id
	 * Entrada:				UbicacionDTO
	 * Salida:				List<UbicacionDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_ConsultaId_Ubicacion_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<UbicacionDTO> consultaId(UbicacionDTO dto) {
		UbicacionDTO 		out 		= new UbicacionDTO();
		Ubicacion 			entity 		= new Ubicacion();
		List<Ubicacion> 	list 		= new ArrayList<Ubicacion>();	
		List<UbicacionDTO> 	finalList 	= new ArrayList<UbicacionDTO>();
		UbicacionConverter 	converter 	= new UbicacionConverter();
		
		dto=(UbicacionDTO)logService.setValues(dto, "Ubicacion", "consultaId", "UbicacionServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<Ubicacion>) repository.findById(Integer.parseInt(dto.getId()));
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTAID_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new Ubicacion();
						out 		= new UbicacionDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toUbicacionDTO(entity, out);
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
	 * Nombre del metodo: 	Modificacion de Ubicacion 
	 * Descripcion: 		Metodo que implementa el servicio para la modificacion de Ubicacion
	 * Entrada/Salida:		UbicacionDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Modifificacion_Ubicacion_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public UbicacionDTO modificacion(UbicacionDTO dto) {
		Ubicacion 			entity 		= new Ubicacion();
		Ubicacion 			newEntity 	= new Ubicacion();
		UbicacionConverter 	converter 	= new UbicacionConverter();
		
		dto=(UbicacionDTO)logService.setValues(dto, "Ubicacion", "modificacion", "UbicacionServiceImpl");
		
		try {
			entity    = converter.toUbicacion(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toUbicacionDTO(newEntity, dto);
			
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

