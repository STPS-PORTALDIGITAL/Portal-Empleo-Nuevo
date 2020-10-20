package stps.gob.mx.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.converters.RolesResponsabilidadesConverter;
import stps.gob.mx.domain.RolesResponsabilidades;
import stps.gob.mx.dto.RolesResponsabilidadesDTO;
import stps.gob.mx.repositories.RolesResponsabilidadesRepository;



@Service
public class RolesResponsabilidadesServiceImpl implements  RolesResponsabilidadesService{
	final static Logger log = Logger.getLogger(RolesResponsabilidadesServiceImpl.class);
	
	
	@Autowired
	LogService logService;
	
	@Autowired
	RolesResponsabilidadesRepository repository;

	/********************************************************************************************************
	 * Nombre del metodo: 	Alta de RolesResponsabilidades
	 * Descripcion: 		Metodo que implementa el servicio para el alta de RolesResponsabilidades
	 * Entrada/Salida:		RolesResponsabilidadesDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Alta_RolesResponsabilidades_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public RolesResponsabilidadesDTO alta(RolesResponsabilidadesDTO dto) {
		RolesResponsabilidades 			entity 		= new RolesResponsabilidades();
		RolesResponsabilidades 			newEntity 	= new RolesResponsabilidades();
		RolesResponsabilidadesConverter 	converter 	= new RolesResponsabilidadesConverter();
		
		dto=(RolesResponsabilidadesDTO)logService.setValues(dto, "RolesResponsabilidades", "alta", "RolesResponsabilidadesServiceImpl");
		
		try {
			entity    = converter.toRolesResponsabilidadesAlta(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toRolesResponsabilidadesDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Baja de RolesResponsabilidades
	 * Descripcion: 		Metodo que implementa el servicio para la baja de RolesResponsabilidades
	 * Entrada/Salida:		RolesResponsabilidadesDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Baja_RolesResponsabilidades_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public RolesResponsabilidadesDTO baja(RolesResponsabilidadesDTO dto) {
		RolesResponsabilidades 			entity 		= new RolesResponsabilidades();
		RolesResponsabilidades 			newEntity 	= new RolesResponsabilidades();
		RolesResponsabilidadesConverter 	converter 	= new RolesResponsabilidadesConverter();
		
		dto=(RolesResponsabilidadesDTO)logService.setValues(dto, "RolesResponsabilidades", "baja", "RolesResponsabilidadesServiceImpl");
		
		try {
			entity    = converter.toRolesResponsabilidadesBaja(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toRolesResponsabilidadesDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Consulta de RolesResponsabilidades
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de RolesResponsabilidades
	 * Entrada:				RolesResponsabilidadesDTO
	 * Salida:				List<RolesResponsabilidadesDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Consulta_RolesResponsabilidades_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<RolesResponsabilidadesDTO> consulta(RolesResponsabilidadesDTO dto) {
		RolesResponsabilidadesDTO 		out 		= new RolesResponsabilidadesDTO();
		RolesResponsabilidades 			entity 		= new RolesResponsabilidades();
		List<RolesResponsabilidades> 	list 		= new ArrayList<RolesResponsabilidades>();	
		List<RolesResponsabilidadesDTO> 	finalList 	= new ArrayList<RolesResponsabilidadesDTO>();
		RolesResponsabilidadesConverter 	converter 	= new RolesResponsabilidadesConverter();
		
		dto=(RolesResponsabilidadesDTO)logService.setValues(dto, "RolesResponsabilidades", "consulta", "RolesResponsabilidadesServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<RolesResponsabilidades>) repository.findAllRecords(Constantes.ACTIVO);
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTA_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new RolesResponsabilidades();
						out 		= new RolesResponsabilidadesDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toRolesResponsabilidadesDTO(entity, out);
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
	 * Nombre del metodo: 	Consulta de RolesResponsabilidades por Id
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de RolesResponsabilidades por Id
	 * Entrada:				RolesResponsabilidadesDTO
	 * Salida:				List<RolesResponsabilidadesDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_ConsultaId_RolesResponsabilidades_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<RolesResponsabilidadesDTO> consultaId(RolesResponsabilidadesDTO dto) {
		RolesResponsabilidadesDTO 		out 		= new RolesResponsabilidadesDTO();
		RolesResponsabilidades 			entity 		= new RolesResponsabilidades();
		List<RolesResponsabilidades> 	list 		= new ArrayList<RolesResponsabilidades>();	
		List<RolesResponsabilidadesDTO> 	finalList 	= new ArrayList<RolesResponsabilidadesDTO>();
		RolesResponsabilidadesConverter 	converter 	= new RolesResponsabilidadesConverter();
		
		dto=(RolesResponsabilidadesDTO)logService.setValues(dto, "RolesResponsabilidades", "consultaId", "RolesResponsabilidadesServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<RolesResponsabilidades>) repository.findById(Integer.parseInt(dto.getId()));
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTAID_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new RolesResponsabilidades();
						out 		= new RolesResponsabilidadesDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toRolesResponsabilidadesDTO(entity, out);
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
	 * Nombre del metodo: 	Modificacion de RolesResponsabilidades 
	 * Descripcion: 		Metodo que implementa el servicio para la modificacion de RolesResponsabilidades
	 * Entrada/Salida:		RolesResponsabilidadesDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Modifificacion_RolesResponsabilidades_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public RolesResponsabilidadesDTO modificacion(RolesResponsabilidadesDTO dto) {
		RolesResponsabilidades 			entity 		= new RolesResponsabilidades();
		RolesResponsabilidades 			newEntity 	= new RolesResponsabilidades();
		RolesResponsabilidadesConverter 	converter 	= new RolesResponsabilidadesConverter();
		
		dto=(RolesResponsabilidadesDTO)logService.setValues(dto, "RolesResponsabilidades", "modificacion", "RolesResponsabilidadesServiceImpl");
		
		try {
			entity    = converter.toRolesResponsabilidades(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toRolesResponsabilidadesDTO(newEntity, dto);
			
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

