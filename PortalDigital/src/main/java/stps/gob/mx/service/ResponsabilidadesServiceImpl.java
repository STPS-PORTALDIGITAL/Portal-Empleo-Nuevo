package stps.gob.mx.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.converters.ResponsabilidadesConverter;
import stps.gob.mx.domain.Responsabilidades;
import stps.gob.mx.dto.ResponsabilidadesDTO;
import stps.gob.mx.repositories.ResponsabilidadesRepository;



@Service
public class ResponsabilidadesServiceImpl implements  ResponsabilidadesService{
	final static Logger log = Logger.getLogger(ResponsabilidadesServiceImpl.class);
	
	
	@Autowired
	LogService logService;
	
	@Autowired
	ResponsabilidadesRepository repository;

	/********************************************************************************************************
	 * Nombre del metodo: 	Alta de Responsabilidades
	 * Descripcion: 		Metodo que implementa el servicio para el alta de Responsabilidades
	 * Entrada/Salida:		ResponsabilidadesDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Alta_Responsabilidades_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public ResponsabilidadesDTO alta(ResponsabilidadesDTO dto) {
		Responsabilidades 			entity 		= new Responsabilidades();
		Responsabilidades 			newEntity 	= new Responsabilidades();
		ResponsabilidadesConverter 	converter 	= new ResponsabilidadesConverter();
		
		dto=(ResponsabilidadesDTO)logService.setValues(dto, "Responsabilidades", "alta", "ResponsabilidadesServiceImpl");
		
		try {
			entity    = converter.toResponsabilidadesAlta(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toResponsabilidadesDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Baja de Responsabilidades
	 * Descripcion: 		Metodo que implementa el servicio para la baja de Responsabilidades
	 * Entrada/Salida:		ResponsabilidadesDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Baja_Responsabilidades_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public ResponsabilidadesDTO baja(ResponsabilidadesDTO dto) {
		Responsabilidades 			entity 		= new Responsabilidades();
		Responsabilidades 			newEntity 	= new Responsabilidades();
		ResponsabilidadesConverter 	converter 	= new ResponsabilidadesConverter();
		
		dto=(ResponsabilidadesDTO)logService.setValues(dto, "Responsabilidades", "baja", "ResponsabilidadesServiceImpl");
		
		try {
			entity    = converter.toResponsabilidadesBaja(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toResponsabilidadesDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Consulta de Responsabilidades
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de Responsabilidades
	 * Entrada:				ResponsabilidadesDTO
	 * Salida:				List<ResponsabilidadesDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Consulta_Responsabilidades_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<ResponsabilidadesDTO> consulta(ResponsabilidadesDTO dto) {
		ResponsabilidadesDTO 		out 		= new ResponsabilidadesDTO();
		Responsabilidades 			entity 		= new Responsabilidades();
		List<Responsabilidades> 	list 		= new ArrayList<Responsabilidades>();	
		List<ResponsabilidadesDTO> 	finalList 	= new ArrayList<ResponsabilidadesDTO>();
		ResponsabilidadesConverter 	converter 	= new ResponsabilidadesConverter();
		
		dto=(ResponsabilidadesDTO)logService.setValues(dto, "Responsabilidades", "consulta", "ResponsabilidadesServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<Responsabilidades>) repository.findAllRecords(Constantes.ACTIVO);
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTA_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new Responsabilidades();
						out 		= new ResponsabilidadesDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toResponsabilidadesDTO(entity, out);
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
	 * Nombre del metodo: 	Consulta de Responsabilidades por Id
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de Responsabilidades por Id
	 * Entrada:				ResponsabilidadesDTO
	 * Salida:				List<ResponsabilidadesDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_ConsultaId_Responsabilidades_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<ResponsabilidadesDTO> consultaId(ResponsabilidadesDTO dto) {
		ResponsabilidadesDTO 		out 		= new ResponsabilidadesDTO();
		Responsabilidades 			entity 		= new Responsabilidades();
		List<Responsabilidades> 	list 		= new ArrayList<Responsabilidades>();	
		List<ResponsabilidadesDTO> 	finalList 	= new ArrayList<ResponsabilidadesDTO>();
		ResponsabilidadesConverter 	converter 	= new ResponsabilidadesConverter();
		
		dto=(ResponsabilidadesDTO)logService.setValues(dto, "Responsabilidades", "consultaId", "ResponsabilidadesServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<Responsabilidades>) repository.findById(Integer.parseInt(dto.getId()));
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTAID_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new Responsabilidades();
						out 		= new ResponsabilidadesDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toResponsabilidadesDTO(entity, out);
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
	 * Nombre del metodo: 	Modificacion de Responsabilidades 
	 * Descripcion: 		Metodo que implementa el servicio para la modificacion de Responsabilidades
	 * Entrada/Salida:		ResponsabilidadesDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Modifificacion_Responsabilidades_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public ResponsabilidadesDTO modificacion(ResponsabilidadesDTO dto) {
		Responsabilidades 			entity 		= new Responsabilidades();
		Responsabilidades 			newEntity 	= new Responsabilidades();
		ResponsabilidadesConverter 	converter 	= new ResponsabilidadesConverter();
		
		dto=(ResponsabilidadesDTO)logService.setValues(dto, "Responsabilidades", "modificacion", "ResponsabilidadesServiceImpl");
		
		try {
			entity    = converter.toResponsabilidades(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toResponsabilidadesDTO(newEntity, dto);
			
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

