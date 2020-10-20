package stps.gob.mx.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.converters.OfertaEmpleoConocimientoHerramientaConverter;
import stps.gob.mx.domain.OfertaEmpleoConocimientoHerramienta;
import stps.gob.mx.dto.OfertaEmpleoConocimientoHerramientaDTO;
import stps.gob.mx.repositories.OfertaEmpleoConocimientoHerramientaRepository;



@Service
public class OfertaEmpleoConocimientoHerramientaServiceImpl implements  OfertaEmpleoConocimientoHerramientaService{
	final static Logger log = Logger.getLogger(OfertaEmpleoConocimientoHerramientaServiceImpl.class);
	
	
	@Autowired
	LogService logService;
	
	@Autowired
	OfertaEmpleoConocimientoHerramientaRepository repository;

	/********************************************************************************************************
	 * Nombre del metodo: 	Alta de OfertaEmpleoConocimientoHerramienta
	 * Descripcion: 		Metodo que implementa el servicio para el alta de OfertaEmpleoConocimientoHerramienta
	 * Entrada/Salida:		OfertaEmpleoConocimientoHerramientaDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Alta_OfertaEmpleoConocimientoHerramienta_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public OfertaEmpleoConocimientoHerramientaDTO alta(OfertaEmpleoConocimientoHerramientaDTO dto) {
		OfertaEmpleoConocimientoHerramienta 			entity 		= new OfertaEmpleoConocimientoHerramienta();
		OfertaEmpleoConocimientoHerramienta 			newEntity 	= new OfertaEmpleoConocimientoHerramienta();
		OfertaEmpleoConocimientoHerramientaConverter 	converter 	= new OfertaEmpleoConocimientoHerramientaConverter();
		
		dto=(OfertaEmpleoConocimientoHerramientaDTO)logService.setValues(dto, "OfertaEmpleoConocimientoHerramienta", "alta", "OfertaEmpleoConocimientoHerramientaServiceImpl");
		
		try {
			entity    = converter.toOfertaEmpleoConocimientoHerramientaAlta(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toOfertaEmpleoConocimientoHerramientaDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Baja de OfertaEmpleoConocimientoHerramienta
	 * Descripcion: 		Metodo que implementa el servicio para la baja de OfertaEmpleoConocimientoHerramienta
	 * Entrada/Salida:		OfertaEmpleoConocimientoHerramientaDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Baja_OfertaEmpleoConocimientoHerramienta_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public OfertaEmpleoConocimientoHerramientaDTO baja(OfertaEmpleoConocimientoHerramientaDTO dto) {
		OfertaEmpleoConocimientoHerramienta 			entity 		= new OfertaEmpleoConocimientoHerramienta();
		OfertaEmpleoConocimientoHerramienta 			newEntity 	= new OfertaEmpleoConocimientoHerramienta();
		OfertaEmpleoConocimientoHerramientaConverter 	converter 	= new OfertaEmpleoConocimientoHerramientaConverter();
		
		dto=(OfertaEmpleoConocimientoHerramientaDTO)logService.setValues(dto, "OfertaEmpleoConocimientoHerramienta", "baja", "OfertaEmpleoConocimientoHerramientaServiceImpl");
		
		try {
			entity    = converter.toOfertaEmpleoConocimientoHerramientaBaja(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toOfertaEmpleoConocimientoHerramientaDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Consulta de OfertaEmpleoConocimientoHerramienta
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de OfertaEmpleoConocimientoHerramienta
	 * Entrada:				OfertaEmpleoConocimientoHerramientaDTO
	 * Salida:				List<OfertaEmpleoConocimientoHerramientaDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Consulta_OfertaEmpleoConocimientoHerramienta_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<OfertaEmpleoConocimientoHerramientaDTO> consulta(OfertaEmpleoConocimientoHerramientaDTO dto) {
		OfertaEmpleoConocimientoHerramientaDTO 		out 		= new OfertaEmpleoConocimientoHerramientaDTO();
		OfertaEmpleoConocimientoHerramienta 			entity 		= new OfertaEmpleoConocimientoHerramienta();
		List<OfertaEmpleoConocimientoHerramienta> 	list 		= new ArrayList<OfertaEmpleoConocimientoHerramienta>();	
		List<OfertaEmpleoConocimientoHerramientaDTO> 	finalList 	= new ArrayList<OfertaEmpleoConocimientoHerramientaDTO>();
		OfertaEmpleoConocimientoHerramientaConverter 	converter 	= new OfertaEmpleoConocimientoHerramientaConverter();
		
		dto=(OfertaEmpleoConocimientoHerramientaDTO)logService.setValues(dto, "OfertaEmpleoConocimientoHerramienta", "consulta", "OfertaEmpleoConocimientoHerramientaServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<OfertaEmpleoConocimientoHerramienta>) repository.findAllRecords(Constantes.ACTIVO);
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTA_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new OfertaEmpleoConocimientoHerramienta();
						out 		= new OfertaEmpleoConocimientoHerramientaDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toOfertaEmpleoConocimientoHerramientaDTO(entity, out);
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
	 * Nombre del metodo: 	Consulta de OfertaEmpleoConocimientoHerramienta por Id
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de OfertaEmpleoConocimientoHerramienta por Id
	 * Entrada:				OfertaEmpleoConocimientoHerramientaDTO
	 * Salida:				List<OfertaEmpleoConocimientoHerramientaDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_ConsultaId_OfertaEmpleoConocimientoHerramienta_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<OfertaEmpleoConocimientoHerramientaDTO> consultaId(OfertaEmpleoConocimientoHerramientaDTO dto) {
		OfertaEmpleoConocimientoHerramientaDTO 		out 		= new OfertaEmpleoConocimientoHerramientaDTO();
		OfertaEmpleoConocimientoHerramienta 			entity 		= new OfertaEmpleoConocimientoHerramienta();
		List<OfertaEmpleoConocimientoHerramienta> 	list 		= new ArrayList<OfertaEmpleoConocimientoHerramienta>();	
		List<OfertaEmpleoConocimientoHerramientaDTO> 	finalList 	= new ArrayList<OfertaEmpleoConocimientoHerramientaDTO>();
		OfertaEmpleoConocimientoHerramientaConverter 	converter 	= new OfertaEmpleoConocimientoHerramientaConverter();
		
		dto=(OfertaEmpleoConocimientoHerramientaDTO)logService.setValues(dto, "OfertaEmpleoConocimientoHerramienta", "consultaId", "OfertaEmpleoConocimientoHerramientaServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<OfertaEmpleoConocimientoHerramienta>) repository.findById(Integer.parseInt(dto.getId()));
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTAID_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new OfertaEmpleoConocimientoHerramienta();
						out 		= new OfertaEmpleoConocimientoHerramientaDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toOfertaEmpleoConocimientoHerramientaDTO(entity, out);
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
	 * Nombre del metodo: 	Modificacion de OfertaEmpleoConocimientoHerramienta 
	 * Descripcion: 		Metodo que implementa el servicio para la modificacion de OfertaEmpleoConocimientoHerramienta
	 * Entrada/Salida:		OfertaEmpleoConocimientoHerramientaDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Modifificacion_OfertaEmpleoConocimientoHerramienta_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public OfertaEmpleoConocimientoHerramientaDTO modificacion(OfertaEmpleoConocimientoHerramientaDTO dto) {
		OfertaEmpleoConocimientoHerramienta 			entity 		= new OfertaEmpleoConocimientoHerramienta();
		OfertaEmpleoConocimientoHerramienta 			newEntity 	= new OfertaEmpleoConocimientoHerramienta();
		OfertaEmpleoConocimientoHerramientaConverter 	converter 	= new OfertaEmpleoConocimientoHerramientaConverter();
		
		dto=(OfertaEmpleoConocimientoHerramientaDTO)logService.setValues(dto, "OfertaEmpleoConocimientoHerramienta", "modificacion", "OfertaEmpleoConocimientoHerramientaServiceImpl");
		
		try {
			entity    = converter.toOfertaEmpleoConocimientoHerramienta(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toOfertaEmpleoConocimientoHerramientaDTO(newEntity, dto);
			
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

