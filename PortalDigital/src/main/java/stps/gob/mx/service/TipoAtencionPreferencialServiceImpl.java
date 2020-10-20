package stps.gob.mx.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.converters.TipoAtencionPreferencialConverter;
import stps.gob.mx.domain.TipoAtencionPreferencial;
import stps.gob.mx.dto.TipoAtencionPreferencialDTO;
import stps.gob.mx.repositories.TipoAtencionPreferencialRepository;



@Service
public class TipoAtencionPreferencialServiceImpl implements  TipoAtencionPreferencialService{
	final static Logger log = Logger.getLogger(TipoAtencionPreferencialServiceImpl.class);
	
	
	@Autowired
	LogService logService;
	
	@Autowired
	TipoAtencionPreferencialRepository repository;

	/********************************************************************************************************
	 * Nombre del metodo: 	Alta de TipoAtencionPreferencial
	 * Descripcion: 		Metodo que implementa el servicio para el alta de TipoAtencionPreferencial
	 * Entrada/Salida:		TipoAtencionPreferencialDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Alta_TipoAtencionPreferencial_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public TipoAtencionPreferencialDTO alta(TipoAtencionPreferencialDTO dto) {
		TipoAtencionPreferencial 			entity 		= new TipoAtencionPreferencial();
		TipoAtencionPreferencial 			newEntity 	= new TipoAtencionPreferencial();
		TipoAtencionPreferencialConverter 	converter 	= new TipoAtencionPreferencialConverter();
		
		dto=(TipoAtencionPreferencialDTO)logService.setValues(dto, "TipoAtencionPreferencial", "alta", "TipoAtencionPreferencialServiceImpl");
		
		try {
			entity    = converter.toTipoAtencionPreferencialAlta(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toTipoAtencionPreferencialDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Baja de TipoAtencionPreferencial
	 * Descripcion: 		Metodo que implementa el servicio para la baja de TipoAtencionPreferencial
	 * Entrada/Salida:		TipoAtencionPreferencialDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Baja_TipoAtencionPreferencial_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public TipoAtencionPreferencialDTO baja(TipoAtencionPreferencialDTO dto) {
		TipoAtencionPreferencial 			entity 		= new TipoAtencionPreferencial();
		TipoAtencionPreferencial 			newEntity 	= new TipoAtencionPreferencial();
		TipoAtencionPreferencialConverter 	converter 	= new TipoAtencionPreferencialConverter();
		
		dto=(TipoAtencionPreferencialDTO)logService.setValues(dto, "TipoAtencionPreferencial", "baja", "TipoAtencionPreferencialServiceImpl");
		
		try {
			entity    = converter.toTipoAtencionPreferencialBaja(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toTipoAtencionPreferencialDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Consulta de TipoAtencionPreferencial
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de TipoAtencionPreferencial
	 * Entrada:				TipoAtencionPreferencialDTO
	 * Salida:				List<TipoAtencionPreferencialDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Consulta_TipoAtencionPreferencial_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<TipoAtencionPreferencialDTO> consulta(TipoAtencionPreferencialDTO dto) {
		TipoAtencionPreferencialDTO 		out 		= new TipoAtencionPreferencialDTO();
		TipoAtencionPreferencial 			entity 		= new TipoAtencionPreferencial();
		List<TipoAtencionPreferencial> 	list 		= new ArrayList<TipoAtencionPreferencial>();	
		List<TipoAtencionPreferencialDTO> 	finalList 	= new ArrayList<TipoAtencionPreferencialDTO>();
		TipoAtencionPreferencialConverter 	converter 	= new TipoAtencionPreferencialConverter();
		
		dto=(TipoAtencionPreferencialDTO)logService.setValues(dto, "TipoAtencionPreferencial", "consulta", "TipoAtencionPreferencialServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<TipoAtencionPreferencial>) repository.findAllRecords(Constantes.ACTIVO);
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTA_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new TipoAtencionPreferencial();
						out 		= new TipoAtencionPreferencialDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toTipoAtencionPreferencialDTO(entity, out);
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
	 * Nombre del metodo: 	Consulta de TipoAtencionPreferencial por Id
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de TipoAtencionPreferencial por Id
	 * Entrada:				TipoAtencionPreferencialDTO
	 * Salida:				List<TipoAtencionPreferencialDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_ConsultaId_TipoAtencionPreferencial_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<TipoAtencionPreferencialDTO> consultaId(TipoAtencionPreferencialDTO dto) {
		TipoAtencionPreferencialDTO 		out 		= new TipoAtencionPreferencialDTO();
		TipoAtencionPreferencial 			entity 		= new TipoAtencionPreferencial();
		List<TipoAtencionPreferencial> 	list 		= new ArrayList<TipoAtencionPreferencial>();	
		List<TipoAtencionPreferencialDTO> 	finalList 	= new ArrayList<TipoAtencionPreferencialDTO>();
		TipoAtencionPreferencialConverter 	converter 	= new TipoAtencionPreferencialConverter();
		
		dto=(TipoAtencionPreferencialDTO)logService.setValues(dto, "TipoAtencionPreferencial", "consultaId", "TipoAtencionPreferencialServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<TipoAtencionPreferencial>) repository.findById(Integer.parseInt(dto.getId()));
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTAID_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new TipoAtencionPreferencial();
						out 		= new TipoAtencionPreferencialDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toTipoAtencionPreferencialDTO(entity, out);
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
	 * Nombre del metodo: 	Modificacion de TipoAtencionPreferencial 
	 * Descripcion: 		Metodo que implementa el servicio para la modificacion de TipoAtencionPreferencial
	 * Entrada/Salida:		TipoAtencionPreferencialDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Modifificacion_TipoAtencionPreferencial_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public TipoAtencionPreferencialDTO modificacion(TipoAtencionPreferencialDTO dto) {
		TipoAtencionPreferencial 			entity 		= new TipoAtencionPreferencial();
		TipoAtencionPreferencial 			newEntity 	= new TipoAtencionPreferencial();
		TipoAtencionPreferencialConverter 	converter 	= new TipoAtencionPreferencialConverter();
		
		dto=(TipoAtencionPreferencialDTO)logService.setValues(dto, "TipoAtencionPreferencial", "modificacion", "TipoAtencionPreferencialServiceImpl");
		
		try {
			entity    = converter.toTipoAtencionPreferencial(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toTipoAtencionPreferencialDTO(newEntity, dto);
			
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

