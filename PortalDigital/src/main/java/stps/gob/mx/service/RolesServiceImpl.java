package stps.gob.mx.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.converters.RolesConverter;
import stps.gob.mx.domain.Roles;
import stps.gob.mx.dto.RolesDTO;
import stps.gob.mx.repositories.RolesRepository;



@Service
public class RolesServiceImpl implements  RolesService{
	final static Logger log = Logger.getLogger(RolesServiceImpl.class);
	
	
	@Autowired
	LogService logService;
	
	@Autowired
	RolesRepository repository;

	/********************************************************************************************************
	 * Nombre del metodo: 	Alta de Roles
	 * Descripcion: 		Metodo que implementa el servicio para el alta de Roles
	 * Entrada/Salida:		RolesDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Alta_Roles_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public RolesDTO alta(RolesDTO dto) {
		Roles 			entity 		= new Roles();
		Roles 			newEntity 	= new Roles();
		RolesConverter 	converter 	= new RolesConverter();
		
		dto=(RolesDTO)logService.setValues(dto, "Roles", "alta", "RolesServiceImpl");
		
		try {
			entity    = converter.toRolesAlta(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toRolesDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Baja de Roles
	 * Descripcion: 		Metodo que implementa el servicio para la baja de Roles
	 * Entrada/Salida:		RolesDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Baja_Roles_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public RolesDTO baja(RolesDTO dto) {
		Roles 			entity 		= new Roles();
		Roles 			newEntity 	= new Roles();
		RolesConverter 	converter 	= new RolesConverter();
		
		dto=(RolesDTO)logService.setValues(dto, "Roles", "baja", "RolesServiceImpl");
		
		try {
			entity    = converter.toRolesBaja(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toRolesDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Consulta de Roles
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de Roles
	 * Entrada:				RolesDTO
	 * Salida:				List<RolesDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Consulta_Roles_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<RolesDTO> consulta(RolesDTO dto) {
		RolesDTO 		out 		= new RolesDTO();
		Roles 			entity 		= new Roles();
		List<Roles> 	list 		= new ArrayList<Roles>();	
		List<RolesDTO> 	finalList 	= new ArrayList<RolesDTO>();
		RolesConverter 	converter 	= new RolesConverter();
		
		dto=(RolesDTO)logService.setValues(dto, "Roles", "consulta", "RolesServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<Roles>) repository.findAllRecords(Constantes.ACTIVO);
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTA_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new Roles();
						out 		= new RolesDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toRolesDTO(entity, out);
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
	 * Nombre del metodo: 	Consulta de Roles por Id
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de Roles por Id
	 * Entrada:				RolesDTO
	 * Salida:				List<RolesDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_ConsultaId_Roles_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<RolesDTO> consultaId(RolesDTO dto) {
		RolesDTO 		out 		= new RolesDTO();
		Roles 			entity 		= new Roles();
		List<Roles> 	list 		= new ArrayList<Roles>();	
		List<RolesDTO> 	finalList 	= new ArrayList<RolesDTO>();
		RolesConverter 	converter 	= new RolesConverter();
		
		dto=(RolesDTO)logService.setValues(dto, "Roles", "consultaId", "RolesServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<Roles>) repository.findById(Integer.parseInt(dto.getId()));
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTAID_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new Roles();
						out 		= new RolesDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toRolesDTO(entity, out);
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
	 * Nombre del metodo: 	Modificacion de Roles 
	 * Descripcion: 		Metodo que implementa el servicio para la modificacion de Roles
	 * Entrada/Salida:		RolesDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Modifificacion_Roles_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public RolesDTO modificacion(RolesDTO dto) {
		Roles 			entity 		= new Roles();
		Roles 			newEntity 	= new Roles();
		RolesConverter 	converter 	= new RolesConverter();
		
		dto=(RolesDTO)logService.setValues(dto, "Roles", "modificacion", "RolesServiceImpl");
		
		try {
			entity    = converter.toRoles(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toRolesDTO(newEntity, dto);
			
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

