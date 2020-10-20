package stps.gob.mx.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.converters.PerfilBusquedaEmpleoConverter;
import stps.gob.mx.domain.PerfilBusquedaEmpleo;
import stps.gob.mx.dto.PerfilBusquedaEmpleoDTO;
import stps.gob.mx.repositories.PerfilBusquedaEmpleoRepository;



@Service
public class PerfilBusquedaEmpleoServiceImpl implements  PerfilBusquedaEmpleoService{
	final static Logger log = Logger.getLogger(PerfilBusquedaEmpleoServiceImpl.class);
	
	
	@Autowired
	LogService logService;
	
	@Autowired
	PerfilBusquedaEmpleoRepository repository;

	/********************************************************************************************************
	 * Nombre del metodo: 	Alta de PerfilBusquedaEmpleo
	 * Descripcion: 		Metodo que implementa el servicio para el alta de PerfilBusquedaEmpleo
	 * Entrada/Salida:		PerfilBusquedaEmpleoDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Alta_PerfilBusquedaEmpleo_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public PerfilBusquedaEmpleoDTO alta(PerfilBusquedaEmpleoDTO dto) {
		PerfilBusquedaEmpleo 			entity 		= new PerfilBusquedaEmpleo();
		PerfilBusquedaEmpleo 			newEntity 	= new PerfilBusquedaEmpleo();
		PerfilBusquedaEmpleoConverter 	converter 	= new PerfilBusquedaEmpleoConverter();
		
		dto=(PerfilBusquedaEmpleoDTO)logService.setValues(dto, "PerfilBusquedaEmpleo", "alta", "PerfilBusquedaEmpleoServiceImpl");
		
		try {
			entity    = converter.toPerfilBusquedaEmpleoAlta(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toPerfilBusquedaEmpleoDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Baja de PerfilBusquedaEmpleo
	 * Descripcion: 		Metodo que implementa el servicio para la baja de PerfilBusquedaEmpleo
	 * Entrada/Salida:		PerfilBusquedaEmpleoDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Baja_PerfilBusquedaEmpleo_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public PerfilBusquedaEmpleoDTO baja(PerfilBusquedaEmpleoDTO dto) {
		PerfilBusquedaEmpleo 			entity 		= new PerfilBusquedaEmpleo();
		PerfilBusquedaEmpleo 			newEntity 	= new PerfilBusquedaEmpleo();
		PerfilBusquedaEmpleoConverter 	converter 	= new PerfilBusquedaEmpleoConverter();
		
		dto=(PerfilBusquedaEmpleoDTO)logService.setValues(dto, "PerfilBusquedaEmpleo", "baja", "PerfilBusquedaEmpleoServiceImpl");
		
		try {
			entity    = converter.toPerfilBusquedaEmpleoBaja(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toPerfilBusquedaEmpleoDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Consulta de PerfilBusquedaEmpleo
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de PerfilBusquedaEmpleo
	 * Entrada:				PerfilBusquedaEmpleoDTO
	 * Salida:				List<PerfilBusquedaEmpleoDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Consulta_PerfilBusquedaEmpleo_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<PerfilBusquedaEmpleoDTO> consulta(PerfilBusquedaEmpleoDTO dto) {
		PerfilBusquedaEmpleoDTO 		out 		= new PerfilBusquedaEmpleoDTO();
		PerfilBusquedaEmpleo 			entity 		= new PerfilBusquedaEmpleo();
		List<PerfilBusquedaEmpleo> 	list 		= new ArrayList<PerfilBusquedaEmpleo>();	
		List<PerfilBusquedaEmpleoDTO> 	finalList 	= new ArrayList<PerfilBusquedaEmpleoDTO>();
		PerfilBusquedaEmpleoConverter 	converter 	= new PerfilBusquedaEmpleoConverter();
		
		dto=(PerfilBusquedaEmpleoDTO)logService.setValues(dto, "PerfilBusquedaEmpleo", "consulta", "PerfilBusquedaEmpleoServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<PerfilBusquedaEmpleo>) repository.findAllRecords(Constantes.ACTIVO);
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTA_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new PerfilBusquedaEmpleo();
						out 		= new PerfilBusquedaEmpleoDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toPerfilBusquedaEmpleoDTO(entity, out);
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
	 * Nombre del metodo: 	Consulta de PerfilBusquedaEmpleo por Id
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de PerfilBusquedaEmpleo por Id
	 * Entrada:				PerfilBusquedaEmpleoDTO
	 * Salida:				List<PerfilBusquedaEmpleoDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_ConsultaId_PerfilBusquedaEmpleo_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<PerfilBusquedaEmpleoDTO> consultaId(PerfilBusquedaEmpleoDTO dto) {
		PerfilBusquedaEmpleoDTO 		out 		= new PerfilBusquedaEmpleoDTO();
		PerfilBusquedaEmpleo 			entity 		= new PerfilBusquedaEmpleo();
		List<PerfilBusquedaEmpleo> 	list 		= new ArrayList<PerfilBusquedaEmpleo>();	
		List<PerfilBusquedaEmpleoDTO> 	finalList 	= new ArrayList<PerfilBusquedaEmpleoDTO>();
		PerfilBusquedaEmpleoConverter 	converter 	= new PerfilBusquedaEmpleoConverter();
		
		dto=(PerfilBusquedaEmpleoDTO)logService.setValues(dto, "PerfilBusquedaEmpleo", "consultaId", "PerfilBusquedaEmpleoServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<PerfilBusquedaEmpleo>) repository.findById(Integer.parseInt(dto.getId()));
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTAID_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new PerfilBusquedaEmpleo();
						out 		= new PerfilBusquedaEmpleoDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toPerfilBusquedaEmpleoDTO(entity, out);
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
	 * Nombre del metodo: 	Modificacion de PerfilBusquedaEmpleo 
	 * Descripcion: 		Metodo que implementa el servicio para la modificacion de PerfilBusquedaEmpleo
	 * Entrada/Salida:		PerfilBusquedaEmpleoDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Modifificacion_PerfilBusquedaEmpleo_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public PerfilBusquedaEmpleoDTO modificacion(PerfilBusquedaEmpleoDTO dto) {
		PerfilBusquedaEmpleo 			entity 		= new PerfilBusquedaEmpleo();
		PerfilBusquedaEmpleo 			newEntity 	= new PerfilBusquedaEmpleo();
		PerfilBusquedaEmpleoConverter 	converter 	= new PerfilBusquedaEmpleoConverter();
		
		dto=(PerfilBusquedaEmpleoDTO)logService.setValues(dto, "PerfilBusquedaEmpleo", "modificacion", "PerfilBusquedaEmpleoServiceImpl");
		
		try {
			entity    = converter.toPerfilBusquedaEmpleo(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toPerfilBusquedaEmpleoDTO(newEntity, dto);
			
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

