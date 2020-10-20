package stps.gob.mx.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.converters.TipoUsuarioConverter;
import stps.gob.mx.domain.TipoUsuario;
import stps.gob.mx.dto.TipoUsuarioDTO;
import stps.gob.mx.repositories.TipoUsuarioRepository;



@Service
public class TipoUsuarioServiceImpl implements  TipoUsuarioService{
	final static Logger log = Logger.getLogger(TipoUsuarioServiceImpl.class);
	
	
	@Autowired
	LogService logService;
	
	@Autowired
	TipoUsuarioRepository repository;

	/********************************************************************************************************
	 * Nombre del metodo: 	Alta de TipoPersona
	 * Descripcion: 		Metodo que implementa el servicio para el alta de TipoPersona
	 * Entrada/Salida:		TipoPersonaDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Alta_TipoPersona_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public TipoUsuarioDTO alta(TipoUsuarioDTO dto) {
		TipoUsuario 			entity 		= new TipoUsuario();
		TipoUsuario 			newEntity 	= new TipoUsuario();
		TipoUsuarioConverter 	converter 	= new TipoUsuarioConverter();
		
		dto=(TipoUsuarioDTO)logService.setValues(dto, "TipoPersona", "alta", "TipoPersonaServiceImpl");
		
		try {
			entity    = converter.toTipoPersonaAlta(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toTipoUsuarioDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Baja de TipoPersona
	 * Descripcion: 		Metodo que implementa el servicio para la baja de TipoPersona
	 * Entrada/Salida:		TipoPersonaDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Baja_TipoPersona_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public TipoUsuarioDTO baja(TipoUsuarioDTO dto) {
		TipoUsuario 			entity 		= new TipoUsuario();
		TipoUsuario 			newEntity 	= new TipoUsuario();
		TipoUsuarioConverter 	converter 	= new TipoUsuarioConverter();
		
		dto=(TipoUsuarioDTO)logService.setValues(dto, "TipoPersona", "baja", "TipoPersonaServiceImpl");
		
		try {
			entity    = converter.toTipoPersonaBaja(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toTipoUsuarioDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Consulta de TipoPersona
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de TipoPersona
	 * Entrada:				TipoPersonaDTO
	 * Salida:				List<TipoPersonaDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Consulta_TipoPersona_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<TipoUsuarioDTO> consulta(TipoUsuarioDTO dto) {
		TipoUsuarioDTO 		out 		= new TipoUsuarioDTO();
		TipoUsuario 			entity 		= new TipoUsuario();
		List<TipoUsuario> 	list 		= new ArrayList<TipoUsuario>();	
		List<TipoUsuarioDTO> 	finalList 	= new ArrayList<TipoUsuarioDTO>();
		TipoUsuarioConverter 	converter 	= new TipoUsuarioConverter();
		
		dto=(TipoUsuarioDTO)logService.setValues(dto, "TipoPersona", "consulta", "TipoPersonaServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			//list = (List<TipoUsuario>) repository.findAllRecords(Constantes.ACTIVO);
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTA_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new TipoUsuario();
						out 		= new TipoUsuarioDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toTipoUsuarioDTO(entity, out);
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
	 * Nombre del metodo: 	Consulta de TipoPersona por Id
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de TipoPersona por Id
	 * Entrada:				TipoPersonaDTO
	 * Salida:				List<TipoPersonaDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_ConsultaId_TipoPersona_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<TipoUsuarioDTO> consultaId(TipoUsuarioDTO dto) {
		TipoUsuarioDTO 		out 		= new TipoUsuarioDTO();
		TipoUsuario 			entity 		= new TipoUsuario();
		List<TipoUsuario> 	list 		= new ArrayList<TipoUsuario>();	
		List<TipoUsuarioDTO> 	finalList 	= new ArrayList<TipoUsuarioDTO>();
		TipoUsuarioConverter 	converter 	= new TipoUsuarioConverter();
		
		dto=(TipoUsuarioDTO)logService.setValues(dto, "TipoPersona", "consultaId", "TipoPersonaServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<TipoUsuario>) repository.findById(Integer.parseInt(dto.getId()));
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTAID_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new TipoUsuario();
						out 		= new TipoUsuarioDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toTipoUsuarioDTO(entity, out);
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
	 * Nombre del metodo: 	Modificacion de TipoPersona 
	 * Descripcion: 		Metodo que implementa el servicio para la modificacion de TipoPersona
	 * Entrada/Salida:		TipoPersonaDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Modifificacion_TipoPersona_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public TipoUsuarioDTO modificacion(TipoUsuarioDTO dto) {
		TipoUsuario 			entity 		= new TipoUsuario();
		TipoUsuario 			newEntity 	= new TipoUsuario();
		TipoUsuarioConverter 	converter 	= new TipoUsuarioConverter();
		
		dto=(TipoUsuarioDTO)logService.setValues(dto, "TipoPersona", "modificacion", "TipoPersonaServiceImpl");
		
		try {
			entity    = converter.toTipoUsuario(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toTipoUsuarioDTO(newEntity, dto);
			
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

