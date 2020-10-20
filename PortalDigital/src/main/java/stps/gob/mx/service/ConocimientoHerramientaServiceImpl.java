package stps.gob.mx.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.converters.ConocimientoHerramientaConverter;
import stps.gob.mx.domain.ConocimientoHerramienta;
import stps.gob.mx.dto.ConocimientoHerramientaDTO;
import stps.gob.mx.repositories.ConocimientoHerramientaRepository;



@Service
public class ConocimientoHerramientaServiceImpl implements  ConocimientoHerramientaService{
	final static Logger log = Logger.getLogger(ConocimientoHerramientaServiceImpl.class);
	
	
	@Autowired
	LogService logService;
	
	@Autowired
	ConocimientoHerramientaRepository repository;

	/********************************************************************************************************
	 * Nombre del metodo: 	Alta de ConocimientoHerramienta
	 * Descripcion: 		Metodo que implementa el servicio para el alta de ConocimientoHerramienta
	 * Entrada/Salida:		ConocimientoHerramientaDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Alta_ConocimientoHerramienta_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public ConocimientoHerramientaDTO alta(ConocimientoHerramientaDTO dto) {
		ConocimientoHerramienta 			entity 		= new ConocimientoHerramienta();
		ConocimientoHerramienta 			newEntity 	= new ConocimientoHerramienta();
		ConocimientoHerramientaConverter 	converter 	= new ConocimientoHerramientaConverter();
		
		dto=(ConocimientoHerramientaDTO)logService.setValues(dto, "ConocimientoHerramienta", "alta", "ConocimientoHerramientaServiceImpl");
		
		try {
			entity    = converter.toConocimientoHerramientaAlta(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toConocimientoHerramientaDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Baja de ConocimientoHerramienta
	 * Descripcion: 		Metodo que implementa el servicio para la baja de ConocimientoHerramienta
	 * Entrada/Salida:		ConocimientoHerramientaDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Baja_ConocimientoHerramienta_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public ConocimientoHerramientaDTO baja(ConocimientoHerramientaDTO dto) {
		ConocimientoHerramienta 			entity 		= new ConocimientoHerramienta();
		ConocimientoHerramienta 			newEntity 	= new ConocimientoHerramienta();
		ConocimientoHerramientaConverter 	converter 	= new ConocimientoHerramientaConverter();
		
		dto=(ConocimientoHerramientaDTO)logService.setValues(dto, "ConocimientoHerramienta", "baja", "ConocimientoHerramientaServiceImpl");
		
		try {
			entity    = converter.toConocimientoHerramientaBaja(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toConocimientoHerramientaDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Consulta de ConocimientoHerramienta
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de ConocimientoHerramienta
	 * Entrada:				ConocimientoHerramientaDTO
	 * Salida:				List<ConocimientoHerramientaDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Consulta_ConocimientoHerramienta_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<ConocimientoHerramientaDTO> consulta(ConocimientoHerramientaDTO dto) {
		ConocimientoHerramientaDTO 		out 		= new ConocimientoHerramientaDTO();
		ConocimientoHerramienta 			entity 		= new ConocimientoHerramienta();
		List<ConocimientoHerramienta> 	list 		= new ArrayList<ConocimientoHerramienta>();	
		List<ConocimientoHerramientaDTO> 	finalList 	= new ArrayList<ConocimientoHerramientaDTO>();
		ConocimientoHerramientaConverter 	converter 	= new ConocimientoHerramientaConverter();
		
		dto=(ConocimientoHerramientaDTO)logService.setValues(dto, "ConocimientoHerramienta", "consulta", "ConocimientoHerramientaServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<ConocimientoHerramienta>) repository.findAllRecords(Constantes.ACTIVO);
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTA_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new ConocimientoHerramienta();
						out 		= new ConocimientoHerramientaDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toConocimientoHerramientaDTO(entity, out);
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
	 * Nombre del metodo: 	Consulta de ConocimientoHerramienta por Id
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de ConocimientoHerramienta por Id
	 * Entrada:				ConocimientoHerramientaDTO
	 * Salida:				List<ConocimientoHerramientaDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_ConsultaId_ConocimientoHerramienta_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<ConocimientoHerramientaDTO> consultaId(ConocimientoHerramientaDTO dto) {
		ConocimientoHerramientaDTO 		out 		= new ConocimientoHerramientaDTO();
		ConocimientoHerramienta 			entity 		= new ConocimientoHerramienta();
		List<ConocimientoHerramienta> 	list 		= new ArrayList<ConocimientoHerramienta>();	
		List<ConocimientoHerramientaDTO> 	finalList 	= new ArrayList<ConocimientoHerramientaDTO>();
		ConocimientoHerramientaConverter 	converter 	= new ConocimientoHerramientaConverter();
		
		dto=(ConocimientoHerramientaDTO)logService.setValues(dto, "ConocimientoHerramienta", "consultaId", "ConocimientoHerramientaServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<ConocimientoHerramienta>) repository.findById(Integer.parseInt(dto.getId()));
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTAID_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new ConocimientoHerramienta();
						out 		= new ConocimientoHerramientaDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toConocimientoHerramientaDTO(entity, out);
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
	 * Nombre del metodo: 	Modificacion de ConocimientoHerramienta 
	 * Descripcion: 		Metodo que implementa el servicio para la modificacion de ConocimientoHerramienta
	 * Entrada/Salida:		ConocimientoHerramientaDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Modifificacion_ConocimientoHerramienta_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public ConocimientoHerramientaDTO modificacion(ConocimientoHerramientaDTO dto) {
		ConocimientoHerramienta 			entity 		= new ConocimientoHerramienta();
		ConocimientoHerramienta 			newEntity 	= new ConocimientoHerramienta();
		ConocimientoHerramientaConverter 	converter 	= new ConocimientoHerramientaConverter();
		
		dto=(ConocimientoHerramientaDTO)logService.setValues(dto, "ConocimientoHerramienta", "modificacion", "ConocimientoHerramientaServiceImpl");
		
		try {
			entity    = converter.toConocimientoHerramienta(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toConocimientoHerramientaDTO(newEntity, dto);
			
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

