package stps.gob.mx.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.converters.TipoEmpresaConverter;
import stps.gob.mx.domain.TipoEmpresa;
import stps.gob.mx.dto.TipoEmpresaDTO;
import stps.gob.mx.repositories.TipoEmpresaRepository;



@Service
public class TipoEmpresaServiceImpl implements  TipoEmpresaService{
	final static Logger log = Logger.getLogger(TipoEmpresaServiceImpl.class);
	
	
	@Autowired
	LogService logService;
	
	@Autowired
	TipoEmpresaRepository repository;

	/********************************************************************************************************
	 * Nombre del metodo: 	Alta de TipoEmpresa
	 * Descripcion: 		Metodo que implementa el servicio para el alta de TipoEmpresa
	 * Entrada/Salida:		TipoEmpresaDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Alta_TipoEmpresa_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public TipoEmpresaDTO alta(TipoEmpresaDTO dto) {
		TipoEmpresa 			entity 		= new TipoEmpresa();
		TipoEmpresa 			newEntity 	= new TipoEmpresa();
		TipoEmpresaConverter 	converter 	= new TipoEmpresaConverter();
		
		dto=(TipoEmpresaDTO)logService.setValues(dto, "TipoEmpresa", "alta", "TipoEmpresaServiceImpl");
		
		try {
			entity    = converter.toTipoEmpresaAlta(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toTipoEmpresaDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Baja de TipoEmpresa
	 * Descripcion: 		Metodo que implementa el servicio para la baja de TipoEmpresa
	 * Entrada/Salida:		TipoEmpresaDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Baja_TipoEmpresa_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public TipoEmpresaDTO baja(TipoEmpresaDTO dto) {
		TipoEmpresa 			entity 		= new TipoEmpresa();
		TipoEmpresa 			newEntity 	= new TipoEmpresa();
		TipoEmpresaConverter 	converter 	= new TipoEmpresaConverter();
		
		dto=(TipoEmpresaDTO)logService.setValues(dto, "TipoEmpresa", "baja", "TipoEmpresaServiceImpl");
		
		try {
			entity    = converter.toTipoEmpresaBaja(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toTipoEmpresaDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Consulta de TipoEmpresa
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de TipoEmpresa
	 * Entrada:				TipoEmpresaDTO
	 * Salida:				List<TipoEmpresaDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Consulta_TipoEmpresa_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<TipoEmpresaDTO> consulta(TipoEmpresaDTO dto) {
		TipoEmpresaDTO 		out 		= new TipoEmpresaDTO();
		TipoEmpresa 			entity 		= new TipoEmpresa();
		List<TipoEmpresa> 	list 		= new ArrayList<TipoEmpresa>();	
		List<TipoEmpresaDTO> 	finalList 	= new ArrayList<TipoEmpresaDTO>();
		TipoEmpresaConverter 	converter 	= new TipoEmpresaConverter();
		
		dto=(TipoEmpresaDTO)logService.setValues(dto, "TipoEmpresa", "consulta", "TipoEmpresaServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<TipoEmpresa>) repository.findAllRecords(Constantes.ACTIVO);
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTA_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new TipoEmpresa();
						out 		= new TipoEmpresaDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toTipoEmpresaDTO(entity, out);
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
	 * Nombre del metodo: 	Consulta de TipoEmpresa por Id
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de TipoEmpresa por Id
	 * Entrada:				TipoEmpresaDTO
	 * Salida:				List<TipoEmpresaDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_ConsultaId_TipoEmpresa_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<TipoEmpresaDTO> consultaId(TipoEmpresaDTO dto) {
		TipoEmpresaDTO 		out 		= new TipoEmpresaDTO();
		TipoEmpresa 			entity 		= new TipoEmpresa();
		List<TipoEmpresa> 	list 		= new ArrayList<TipoEmpresa>();	
		List<TipoEmpresaDTO> 	finalList 	= new ArrayList<TipoEmpresaDTO>();
		TipoEmpresaConverter 	converter 	= new TipoEmpresaConverter();
		
		dto=(TipoEmpresaDTO)logService.setValues(dto, "TipoEmpresa", "consultaId", "TipoEmpresaServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<TipoEmpresa>) repository.findById(Integer.parseInt(dto.getId()));
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTAID_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new TipoEmpresa();
						out 		= new TipoEmpresaDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toTipoEmpresaDTO(entity, out);
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
	 * Nombre del metodo: 	Modificacion de TipoEmpresa 
	 * Descripcion: 		Metodo que implementa el servicio para la modificacion de TipoEmpresa
	 * Entrada/Salida:		TipoEmpresaDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Modifificacion_TipoEmpresa_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public TipoEmpresaDTO modificacion(TipoEmpresaDTO dto) {
		TipoEmpresa 			entity 		= new TipoEmpresa();
		TipoEmpresa 			newEntity 	= new TipoEmpresa();
		TipoEmpresaConverter 	converter 	= new TipoEmpresaConverter();
		
		dto=(TipoEmpresaDTO)logService.setValues(dto, "TipoEmpresa", "modificacion", "TipoEmpresaServiceImpl");
		
		try {
			entity    = converter.toTipoEmpresa(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toTipoEmpresaDTO(newEntity, dto);
			
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

