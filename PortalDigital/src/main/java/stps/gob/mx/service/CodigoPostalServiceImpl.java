package stps.gob.mx.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.converters.CodigoPostalConverter;
import stps.gob.mx.domain.CodigoPostal;
import stps.gob.mx.dto.CodigoPostalDTO;
import stps.gob.mx.repositories.CodigoPostalRepository;



@Service
public class CodigoPostalServiceImpl implements  CodigoPostalService{
	final static Logger log = Logger.getLogger(CodigoPostalServiceImpl.class);
	
	
	@Autowired
	LogService logService;
	
	@Autowired
	CodigoPostalRepository repository;

	/********************************************************************************************************
	 * Nombre del metodo: 	Alta de CodigoPostal
	 * Descripcion: 		Metodo que implementa el servicio para el alta de CodigoPostal
	 * Entrada/Salida:		CodigoPostalDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Alta_CodigoPostal_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public CodigoPostalDTO alta(CodigoPostalDTO dto) {
		CodigoPostal 			entity 		= new CodigoPostal();
		CodigoPostal 			newEntity 	= new CodigoPostal();
		CodigoPostalConverter 	converter 	= new CodigoPostalConverter();
		
		dto=(CodigoPostalDTO)logService.setValues(dto, "CodigoPostal", "alta", "CodigoPostalServiceImpl");
		
		try {
			entity    = converter.toCodigoPostalAlta(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toCodigoPostalDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Baja de CodigoPostal
	 * Descripcion: 		Metodo que implementa el servicio para la baja de CodigoPostal
	 * Entrada/Salida:		CodigoPostalDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Baja_CodigoPostal_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public CodigoPostalDTO baja(CodigoPostalDTO dto) {
		CodigoPostal 			entity 		= new CodigoPostal();
		CodigoPostal 			newEntity 	= new CodigoPostal();
		CodigoPostalConverter 	converter 	= new CodigoPostalConverter();
		
		dto=(CodigoPostalDTO)logService.setValues(dto, "CodigoPostal", "baja", "CodigoPostalServiceImpl");
		
		try {
			entity    = converter.toCodigoPostalBaja(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toCodigoPostalDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Consulta de CodigoPostal
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de CodigoPostal
	 * Entrada:				CodigoPostalDTO
	 * Salida:				List<CodigoPostalDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Consulta_CodigoPostal_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<CodigoPostalDTO> consulta(CodigoPostalDTO dto) {
		CodigoPostalDTO 		out 		= new CodigoPostalDTO();
		CodigoPostal 			entity 		= new CodigoPostal();
		List<CodigoPostal> 	list 		= new ArrayList<CodigoPostal>();	
		List<CodigoPostalDTO> 	finalList 	= new ArrayList<CodigoPostalDTO>();
		CodigoPostalConverter 	converter 	= new CodigoPostalConverter();
		
		dto=(CodigoPostalDTO)logService.setValues(dto, "CodigoPostal", "consulta", "CodigoPostalServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<CodigoPostal>) repository.findAllRecords(Constantes.ACTIVO);
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTA_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new CodigoPostal();
						out 		= new CodigoPostalDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toCodigoPostalDTO(entity, out);
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
	 * Nombre del metodo: 	Consulta de CodigoPostal por Id
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de CodigoPostal por Id
	 * Entrada:				CodigoPostalDTO
	 * Salida:				List<CodigoPostalDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_ConsultaId_CodigoPostal_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<CodigoPostalDTO> consultaId(CodigoPostalDTO dto) {
		CodigoPostalDTO 		out 		= new CodigoPostalDTO();
		CodigoPostal 			entity 		= new CodigoPostal();
		List<CodigoPostal> 	list 		= new ArrayList<CodigoPostal>();	
		List<CodigoPostalDTO> 	finalList 	= new ArrayList<CodigoPostalDTO>();
		CodigoPostalConverter 	converter 	= new CodigoPostalConverter();
		
		dto=(CodigoPostalDTO)logService.setValues(dto, "CodigoPostal", "consultaId", "CodigoPostalServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<CodigoPostal>) repository.findById(Integer.parseInt(dto.getId()));
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTAID_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new CodigoPostal();
						out 		= new CodigoPostalDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toCodigoPostalDTO(entity, out);
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
	 * Nombre del metodo: 	Modificacion de CodigoPostal 
	 * Descripcion: 		Metodo que implementa el servicio para la modificacion de CodigoPostal
	 * Entrada/Salida:		CodigoPostalDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Modifificacion_CodigoPostal_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public CodigoPostalDTO modificacion(CodigoPostalDTO dto) {
		CodigoPostal 			entity 		= new CodigoPostal();
		CodigoPostal 			newEntity 	= new CodigoPostal();
		CodigoPostalConverter 	converter 	= new CodigoPostalConverter();
		
		dto=(CodigoPostalDTO)logService.setValues(dto, "CodigoPostal", "modificacion", "CodigoPostalServiceImpl");
		
		try {
			entity    = converter.toCodigoPostal(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toCodigoPostalDTO(newEntity, dto);
			
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

