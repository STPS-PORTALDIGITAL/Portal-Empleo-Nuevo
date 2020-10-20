package stps.gob.mx.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.converters.UsuarioConverter;
import stps.gob.mx.domain.Usuario;
import stps.gob.mx.dto.UsuarioDTO;
import stps.gob.mx.repositories.UsuarioRepository;



@Service
public class UsuarioServiceImpl implements  UsuarioService{
	final static Logger log = Logger.getLogger(UsuarioServiceImpl.class);
	
	
	@Autowired
	LogService logService;
	
	@Autowired
	UsuarioRepository repository;

	/********************************************************************************************************
	 * Nombre del metodo: 	Alta de Usuario
	 * Descripcion: 		Metodo que implementa el servicio para el alta de Usuario
	 * Entrada/Salida:		UsuarioDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Alta_Usuario_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public UsuarioDTO alta(UsuarioDTO dto) {
		Usuario 			entity 		= new Usuario();
		Usuario 			newEntity 	= new Usuario();
		UsuarioConverter 	converter 	= new UsuarioConverter();
		
		dto=(UsuarioDTO)logService.setValues(dto, "Usuario", "alta", "UsuarioServiceImpl");
		
		try {
			entity    = converter.toUsuarioAlta(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toUsuarioDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Baja de Usuario
	 * Descripcion: 		Metodo que implementa el servicio para la baja de Usuario
	 * Entrada/Salida:		UsuarioDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Baja_Usuario_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public UsuarioDTO baja(UsuarioDTO dto) {
		Usuario 			entity 		= new Usuario();
		Usuario 			newEntity 	= new Usuario();
		UsuarioConverter 	converter 	= new UsuarioConverter();
		
		dto=(UsuarioDTO)logService.setValues(dto, "Usuario", "baja", "UsuarioServiceImpl");
		
		try {
			entity    = converter.toUsuarioBaja(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toUsuarioDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Consulta de Usuario
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de Usuario
	 * Entrada:				UsuarioDTO
	 * Salida:				List<UsuarioDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Consulta_Usuario_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<UsuarioDTO> consulta(UsuarioDTO dto) {
		UsuarioDTO 		out 		= new UsuarioDTO();
		Usuario 			entity 		= new Usuario();
		List<Usuario> 	list 		= new ArrayList<Usuario>();	
		List<UsuarioDTO> 	finalList 	= new ArrayList<UsuarioDTO>();
		UsuarioConverter 	converter 	= new UsuarioConverter();
		
		dto=(UsuarioDTO)logService.setValues(dto, "Usuario", "consulta", "UsuarioServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<Usuario>) repository.findAllRecords(Constantes.ACTIVO);
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTA_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new Usuario();
						out 		= new UsuarioDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toUsuarioDTO(entity, out);
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
	 * Nombre del metodo: 	Consulta de Usuario por Id
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de Usuario por Id
	 * Entrada:				UsuarioDTO
	 * Salida:				List<UsuarioDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_ConsultaId_Usuario_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<UsuarioDTO> consultaId(UsuarioDTO dto) {
		UsuarioDTO 		out 		= new UsuarioDTO();
		Usuario 			entity 		= new Usuario();
		List<Usuario> 	list 		= new ArrayList<Usuario>();	
		List<UsuarioDTO> 	finalList 	= new ArrayList<UsuarioDTO>();
		UsuarioConverter 	converter 	= new UsuarioConverter();
		
		dto=(UsuarioDTO)logService.setValues(dto, "Usuario", "consultaId", "UsuarioServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<Usuario>) repository.findById(Integer.parseInt(dto.getId()));
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTAID_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new Usuario();
						out 		= new UsuarioDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toUsuarioDTO(entity, out);
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
	 * Nombre del metodo: 	Modificacion de Usuario 
	 * Descripcion: 		Metodo que implementa el servicio para la modificacion de Usuario
	 * Entrada/Salida:		UsuarioDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Modifificacion_Usuario_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public UsuarioDTO modificacion(UsuarioDTO dto) {
		Usuario 			entity 		= new Usuario();
		Usuario 			newEntity 	= new Usuario();
		UsuarioConverter 	converter 	= new UsuarioConverter();
		
		dto=(UsuarioDTO)logService.setValues(dto, "Usuario", "modificacion", "UsuarioServiceImpl");
		
		try {
			entity    = converter.toUsuario(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toUsuarioDTO(newEntity, dto);
			
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

