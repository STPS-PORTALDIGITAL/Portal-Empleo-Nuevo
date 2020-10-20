package stps.gob.mx.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.converters.TipoContactoConverter;
import stps.gob.mx.domain.TipoContacto;
import stps.gob.mx.dto.TipoContactoDTO;
import stps.gob.mx.repositories.TipoContactoRepository;



@Service
public class TipoContactoServiceImpl implements  TipoContactoService{
	final static Logger log = Logger.getLogger(TipoContactoServiceImpl.class);
	
	
	@Autowired
	LogService logService;
	
	@Autowired
	TipoContactoRepository repository;

	/********************************************************************************************************
	 * Nombre del metodo: 	Alta de TipoContacto
	 * Descripcion: 		Metodo que implementa el servicio para el alta de TipoContacto
	 * Entrada/Salida:		TipoContactoDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Alta_TipoContacto_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public TipoContactoDTO alta(TipoContactoDTO dto) {
		TipoContacto 			entity 		= new TipoContacto();
		TipoContacto 			newEntity 	= new TipoContacto();
		TipoContactoConverter 	converter 	= new TipoContactoConverter();
		
		dto=(TipoContactoDTO)logService.setValues(dto, "TipoContacto", "alta", "TipoContactoServiceImpl");
		
		try {
			entity    = converter.toTipoContactoAlta(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toTipoContactoDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Baja de TipoContacto
	 * Descripcion: 		Metodo que implementa el servicio para la baja de TipoContacto
	 * Entrada/Salida:		TipoContactoDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Baja_TipoContacto_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public TipoContactoDTO baja(TipoContactoDTO dto) {
		TipoContacto 			entity 		= new TipoContacto();
		TipoContacto 			newEntity 	= new TipoContacto();
		TipoContactoConverter 	converter 	= new TipoContactoConverter();
		
		dto=(TipoContactoDTO)logService.setValues(dto, "TipoContacto", "baja", "TipoContactoServiceImpl");
		
		try {
			entity    = converter.toTipoContactoBaja(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toTipoContactoDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Consulta de TipoContacto
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de TipoContacto
	 * Entrada:				TipoContactoDTO
	 * Salida:				List<TipoContactoDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Consulta_TipoContacto_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<TipoContactoDTO> consulta(TipoContactoDTO dto) {
		TipoContactoDTO 		out 		= new TipoContactoDTO();
		TipoContacto 			entity 		= new TipoContacto();
		List<TipoContacto> 	list 		= new ArrayList<TipoContacto>();	
		List<TipoContactoDTO> 	finalList 	= new ArrayList<TipoContactoDTO>();
		TipoContactoConverter 	converter 	= new TipoContactoConverter();
		
		dto=(TipoContactoDTO)logService.setValues(dto, "TipoContacto", "consulta", "TipoContactoServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<TipoContacto>) repository.findAllRecords(Constantes.ACTIVO);
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTA_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new TipoContacto();
						out 		= new TipoContactoDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toTipoContactoDTO(entity, out);
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
	 * Nombre del metodo: 	Consulta de TipoContacto por Id
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de TipoContacto por Id
	 * Entrada:				TipoContactoDTO
	 * Salida:				List<TipoContactoDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_ConsultaId_TipoContacto_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<TipoContactoDTO> consultaId(TipoContactoDTO dto) {
		TipoContactoDTO 		out 		= new TipoContactoDTO();
		TipoContacto 			entity 		= new TipoContacto();
		List<TipoContacto> 	list 		= new ArrayList<TipoContacto>();	
		List<TipoContactoDTO> 	finalList 	= new ArrayList<TipoContactoDTO>();
		TipoContactoConverter 	converter 	= new TipoContactoConverter();
		
		dto=(TipoContactoDTO)logService.setValues(dto, "TipoContacto", "consultaId", "TipoContactoServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<TipoContacto>) repository.findById(Integer.parseInt(dto.getId()));
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTAID_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new TipoContacto();
						out 		= new TipoContactoDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toTipoContactoDTO(entity, out);
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
	 * Nombre del metodo: 	Modificacion de TipoContacto 
	 * Descripcion: 		Metodo que implementa el servicio para la modificacion de TipoContacto
	 * Entrada/Salida:		TipoContactoDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Modifificacion_TipoContacto_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public TipoContactoDTO modificacion(TipoContactoDTO dto) {
		TipoContacto 			entity 		= new TipoContacto();
		TipoContacto 			newEntity 	= new TipoContacto();
		TipoContactoConverter 	converter 	= new TipoContactoConverter();
		
		dto=(TipoContactoDTO)logService.setValues(dto, "TipoContacto", "modificacion", "TipoContactoServiceImpl");
		
		try {
			entity    = converter.toTipoContacto(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toTipoContactoDTO(newEntity, dto);
			
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

