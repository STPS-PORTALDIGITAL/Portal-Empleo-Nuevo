package stps.gob.mx.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.converters.EmpleadorConverter;
import stps.gob.mx.domain.Empleador;
import stps.gob.mx.dto.EmpleadorDTO;
import stps.gob.mx.repositories.EmpleadorRepository;



@Service
public class EmpleadorServiceImpl implements  EmpleadorService{
	final static Logger log = Logger.getLogger(EmpleadorServiceImpl.class);
	
	
	@Autowired
	LogService logService;
	
	@Autowired
	EmpleadorRepository repository;

	/********************************************************************************************************
	 * Nombre del metodo: 	Alta de Empleador
	 * Descripcion: 		Metodo que implementa el servicio para el alta de Empleador
	 * Entrada/Salida:		EmpleadorDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Alta_Empleador_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public EmpleadorDTO alta(EmpleadorDTO dto) {
		Empleador 			entity 		= new Empleador();
		Empleador 			newEntity 	= new Empleador();
		EmpleadorConverter 	converter 	= new EmpleadorConverter();
		
		dto=(EmpleadorDTO)logService.setValues(dto, "Empleador", "alta", "EmpleadorServiceImpl");
		
		try {
			entity    = converter.toEmpleadorAlta(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toEmpleadorDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Baja de Empleador
	 * Descripcion: 		Metodo que implementa el servicio para la baja de Empleador
	 * Entrada/Salida:		EmpleadorDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Baja_Empleador_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public EmpleadorDTO baja(EmpleadorDTO dto) {
		Empleador 			entity 		= new Empleador();
		Empleador 			newEntity 	= new Empleador();
		EmpleadorConverter 	converter 	= new EmpleadorConverter();
		
		dto=(EmpleadorDTO)logService.setValues(dto, "Empleador", "baja", "EmpleadorServiceImpl");
		
		try {
			entity    = converter.toEmpleadorBaja(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toEmpleadorDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Consulta de Empleador
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de Empleador
	 * Entrada:				EmpleadorDTO
	 * Salida:				List<EmpleadorDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Consulta_Empleador_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<EmpleadorDTO> consulta(EmpleadorDTO dto) {
		EmpleadorDTO 		out 		= new EmpleadorDTO();
		Empleador 			entity 		= new Empleador();
		List<Empleador> 	list 		= new ArrayList<Empleador>();	
		List<EmpleadorDTO> 	finalList 	= new ArrayList<EmpleadorDTO>();
		EmpleadorConverter 	converter 	= new EmpleadorConverter();
		
		dto=(EmpleadorDTO)logService.setValues(dto, "Empleador", "consulta", "EmpleadorServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<Empleador>) repository.findAllRecords(Constantes.ACTIVO);
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTA_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new Empleador();
						out 		= new EmpleadorDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toEmpleadorDTO(entity, out);
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
	 * Nombre del metodo: 	Consulta de Empleador por Id
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de Empleador por Id
	 * Entrada:				EmpleadorDTO
	 * Salida:				List<EmpleadorDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_ConsultaId_Empleador_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<EmpleadorDTO> consultaId(EmpleadorDTO dto) {
		EmpleadorDTO 		out 		= new EmpleadorDTO();
		Empleador 			entity 		= new Empleador();
		List<Empleador> 	list 		= new ArrayList<Empleador>();	
		List<EmpleadorDTO> 	finalList 	= new ArrayList<EmpleadorDTO>();
		EmpleadorConverter 	converter 	= new EmpleadorConverter();
		
		dto=(EmpleadorDTO)logService.setValues(dto, "Empleador", "consultaId", "EmpleadorServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<Empleador>) repository.findById(Integer.parseInt(dto.getId()));
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTAID_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new Empleador();
						out 		= new EmpleadorDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toEmpleadorDTO(entity, out);
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
	 * Nombre del metodo: 	Modificacion de Empleador 
	 * Descripcion: 		Metodo que implementa el servicio para la modificacion de Empleador
	 * Entrada/Salida:		EmpleadorDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Modifificacion_Empleador_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public EmpleadorDTO modificacion(EmpleadorDTO dto) {
		Empleador 			entity 		= new Empleador();
		Empleador 			newEntity 	= new Empleador();
		EmpleadorConverter 	converter 	= new EmpleadorConverter();
		
		dto=(EmpleadorDTO)logService.setValues(dto, "Empleador", "modificacion", "EmpleadorServiceImpl");
		
		try {
			entity    = converter.toEmpleador(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toEmpleadorDTO(newEntity, dto);
			
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

