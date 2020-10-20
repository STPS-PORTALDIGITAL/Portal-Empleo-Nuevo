package stps.gob.mx.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.converters.TipoInstitucionEducativaConverter;
import stps.gob.mx.domain.TipoInstitucionEducativa;
import stps.gob.mx.dto.TipoInstitucionEducativaDTO;
import stps.gob.mx.repositories.TipoInstitucionEducativaRepository;



@Service
public class TipoInstitucionEducativaServiceImpl implements  TipoInstitucionEducativaService{
	final static Logger log = Logger.getLogger(TipoInstitucionEducativaServiceImpl.class);
	
	
	@Autowired
	LogService logService;
	
	@Autowired
	TipoInstitucionEducativaRepository repository;

	/********************************************************************************************************
	 * Nombre del metodo: 	Alta de TipoInstitucionEducativa
	 * Descripcion: 		Metodo que implementa el servicio para el alta de TipoInstitucionEducativa
	 * Entrada/Salida:		TipoInstitucionEducativaDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Alta_TipoInstitucionEducativa_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public TipoInstitucionEducativaDTO alta(TipoInstitucionEducativaDTO dto) {
		TipoInstitucionEducativa 			entity 		= new TipoInstitucionEducativa();
		TipoInstitucionEducativa 			newEntity 	= new TipoInstitucionEducativa();
		TipoInstitucionEducativaConverter 	converter 	= new TipoInstitucionEducativaConverter();
		
		dto=(TipoInstitucionEducativaDTO)logService.setValues(dto, "TipoInstitucionEducativa", "alta", "TipoInstitucionEducativaServiceImpl");
		
		try {
			entity    = converter.toTipoInstitucionEducativaAlta(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toTipoInstitucionEducativaDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Baja de TipoInstitucionEducativa
	 * Descripcion: 		Metodo que implementa el servicio para la baja de TipoInstitucionEducativa
	 * Entrada/Salida:		TipoInstitucionEducativaDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Baja_TipoInstitucionEducativa_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public TipoInstitucionEducativaDTO baja(TipoInstitucionEducativaDTO dto) {
		TipoInstitucionEducativa 			entity 		= new TipoInstitucionEducativa();
		TipoInstitucionEducativa 			newEntity 	= new TipoInstitucionEducativa();
		TipoInstitucionEducativaConverter 	converter 	= new TipoInstitucionEducativaConverter();
		
		dto=(TipoInstitucionEducativaDTO)logService.setValues(dto, "TipoInstitucionEducativa", "baja", "TipoInstitucionEducativaServiceImpl");
		
		try {
			entity    = converter.toTipoInstitucionEducativaBaja(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toTipoInstitucionEducativaDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Consulta de TipoInstitucionEducativa
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de TipoInstitucionEducativa
	 * Entrada:				TipoInstitucionEducativaDTO
	 * Salida:				List<TipoInstitucionEducativaDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Consulta_TipoInstitucionEducativa_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<TipoInstitucionEducativaDTO> consulta(TipoInstitucionEducativaDTO dto) {
		TipoInstitucionEducativaDTO 		out 		= new TipoInstitucionEducativaDTO();
		TipoInstitucionEducativa 			entity 		= new TipoInstitucionEducativa();
		List<TipoInstitucionEducativa> 	list 		= new ArrayList<TipoInstitucionEducativa>();	
		List<TipoInstitucionEducativaDTO> 	finalList 	= new ArrayList<TipoInstitucionEducativaDTO>();
		TipoInstitucionEducativaConverter 	converter 	= new TipoInstitucionEducativaConverter();
		
		dto=(TipoInstitucionEducativaDTO)logService.setValues(dto, "TipoInstitucionEducativa", "consulta", "TipoInstitucionEducativaServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<TipoInstitucionEducativa>) repository.findAllRecords(Constantes.ACTIVO);
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTA_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new TipoInstitucionEducativa();
						out 		= new TipoInstitucionEducativaDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toTipoInstitucionEducativaDTO(entity, out);
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
	 * Nombre del metodo: 	Consulta de TipoInstitucionEducativa por Id
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de TipoInstitucionEducativa por Id
	 * Entrada:				TipoInstitucionEducativaDTO
	 * Salida:				List<TipoInstitucionEducativaDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_ConsultaId_TipoInstitucionEducativa_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<TipoInstitucionEducativaDTO> consultaId(TipoInstitucionEducativaDTO dto) {
		TipoInstitucionEducativaDTO 		out 		= new TipoInstitucionEducativaDTO();
		TipoInstitucionEducativa 			entity 		= new TipoInstitucionEducativa();
		List<TipoInstitucionEducativa> 	list 		= new ArrayList<TipoInstitucionEducativa>();	
		List<TipoInstitucionEducativaDTO> 	finalList 	= new ArrayList<TipoInstitucionEducativaDTO>();
		TipoInstitucionEducativaConverter 	converter 	= new TipoInstitucionEducativaConverter();
		
		dto=(TipoInstitucionEducativaDTO)logService.setValues(dto, "TipoInstitucionEducativa", "consultaId", "TipoInstitucionEducativaServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<TipoInstitucionEducativa>) repository.findById(Integer.parseInt(dto.getId()));
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTAID_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new TipoInstitucionEducativa();
						out 		= new TipoInstitucionEducativaDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toTipoInstitucionEducativaDTO(entity, out);
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
	 * Nombre del metodo: 	Modificacion de TipoInstitucionEducativa 
	 * Descripcion: 		Metodo que implementa el servicio para la modificacion de TipoInstitucionEducativa
	 * Entrada/Salida:		TipoInstitucionEducativaDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Modifificacion_TipoInstitucionEducativa_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public TipoInstitucionEducativaDTO modificacion(TipoInstitucionEducativaDTO dto) {
		TipoInstitucionEducativa 			entity 		= new TipoInstitucionEducativa();
		TipoInstitucionEducativa 			newEntity 	= new TipoInstitucionEducativa();
		TipoInstitucionEducativaConverter 	converter 	= new TipoInstitucionEducativaConverter();
		
		dto=(TipoInstitucionEducativaDTO)logService.setValues(dto, "TipoInstitucionEducativa", "modificacion", "TipoInstitucionEducativaServiceImpl");
		
		try {
			entity    = converter.toTipoInstitucionEducativa(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toTipoInstitucionEducativaDTO(newEntity, dto);
			
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

