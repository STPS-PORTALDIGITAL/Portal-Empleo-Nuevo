package stps.gob.mx.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.converters.RolesUsuarioConverter;
import stps.gob.mx.domain.RolesUsuario;
import stps.gob.mx.dto.RolesUsuarioDTO;
import stps.gob.mx.repositories.RolesUsuarioRepository;



@Service
public class RolesUsuarioServiceImpl implements  RolesUsuarioService{
	final static Logger log = Logger.getLogger(RolesUsuarioServiceImpl.class);
	
	
	@Autowired
	LogService logService;
	
	@Autowired
	RolesUsuarioRepository repository;

	/********************************************************************************************************
	 * Nombre del metodo: 	Alta de RolesUsuario
	 * Descripcion: 		Metodo que implementa el servicio para el alta de RolesUsuario
	 * Entrada/Salida:		RolesUsuarioDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Alta_RolesUsuario_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public RolesUsuarioDTO alta(RolesUsuarioDTO dto) {
		RolesUsuario 			entity 		= new RolesUsuario();
		RolesUsuario 			newEntity 	= new RolesUsuario();
		RolesUsuarioConverter 	converter 	= new RolesUsuarioConverter();
		
		dto=(RolesUsuarioDTO)logService.setValues(dto, "RolesUsuario", "alta", "RolesUsuarioServiceImpl");
		
		try {
			entity    = converter.toRolesUsuarioAlta(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toRolesUsuarioDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Baja de RolesUsuario
	 * Descripcion: 		Metodo que implementa el servicio para la baja de RolesUsuario
	 * Entrada/Salida:		RolesUsuarioDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Baja_RolesUsuario_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public RolesUsuarioDTO baja(RolesUsuarioDTO dto) {
		RolesUsuario 			entity 		= new RolesUsuario();
		RolesUsuario 			newEntity 	= new RolesUsuario();
		RolesUsuarioConverter 	converter 	= new RolesUsuarioConverter();
		
		dto=(RolesUsuarioDTO)logService.setValues(dto, "RolesUsuario", "baja", "RolesUsuarioServiceImpl");
		
		try {
			entity    = converter.toRolesUsuarioBaja(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toRolesUsuarioDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Consulta de RolesUsuario
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de RolesUsuario
	 * Entrada:				RolesUsuarioDTO
	 * Salida:				List<RolesUsuarioDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Consulta_RolesUsuario_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<RolesUsuarioDTO> consulta(RolesUsuarioDTO dto) {
		RolesUsuarioDTO 		out 		= new RolesUsuarioDTO();
		RolesUsuario 			entity 		= new RolesUsuario();
		List<RolesUsuario> 	list 		= new ArrayList<RolesUsuario>();	
		List<RolesUsuarioDTO> 	finalList 	= new ArrayList<RolesUsuarioDTO>();
		RolesUsuarioConverter 	converter 	= new RolesUsuarioConverter();
		
		dto=(RolesUsuarioDTO)logService.setValues(dto, "RolesUsuario", "consulta", "RolesUsuarioServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<RolesUsuario>) repository.findAllRecords(Constantes.ACTIVO);
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTA_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new RolesUsuario();
						out 		= new RolesUsuarioDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toRolesUsuarioDTO(entity, out);
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
	 * Nombre del metodo: 	Consulta de RolesUsuario por Id
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de RolesUsuario por Id
	 * Entrada:				RolesUsuarioDTO
	 * Salida:				List<RolesUsuarioDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_ConsultaId_RolesUsuario_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<RolesUsuarioDTO> consultaId(RolesUsuarioDTO dto) {
		RolesUsuarioDTO 		out 		= new RolesUsuarioDTO();
		RolesUsuario 			entity 		= new RolesUsuario();
		List<RolesUsuario> 	list 		= new ArrayList<RolesUsuario>();	
		List<RolesUsuarioDTO> 	finalList 	= new ArrayList<RolesUsuarioDTO>();
		RolesUsuarioConverter 	converter 	= new RolesUsuarioConverter();
		
		dto=(RolesUsuarioDTO)logService.setValues(dto, "RolesUsuario", "consultaId", "RolesUsuarioServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<RolesUsuario>) repository.findById(Integer.parseInt(dto.getId()));
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTAID_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new RolesUsuario();
						out 		= new RolesUsuarioDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toRolesUsuarioDTO(entity, out);
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
	 * Nombre del metodo: 	Modificacion de RolesUsuario 
	 * Descripcion: 		Metodo que implementa el servicio para la modificacion de RolesUsuario
	 * Entrada/Salida:		RolesUsuarioDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Modifificacion_RolesUsuario_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public RolesUsuarioDTO modificacion(RolesUsuarioDTO dto) {
		RolesUsuario 			entity 		= new RolesUsuario();
		RolesUsuario 			newEntity 	= new RolesUsuario();
		RolesUsuarioConverter 	converter 	= new RolesUsuarioConverter();
		
		dto=(RolesUsuarioDTO)logService.setValues(dto, "RolesUsuario", "modificacion", "RolesUsuarioServiceImpl");
		
		try {
			entity    = converter.toRolesUsuario(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toRolesUsuarioDTO(newEntity, dto);
			
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

