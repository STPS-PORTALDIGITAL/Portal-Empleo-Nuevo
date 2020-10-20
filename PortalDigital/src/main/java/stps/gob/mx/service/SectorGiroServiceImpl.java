package stps.gob.mx.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.converters.SectorGiroConverter;
import stps.gob.mx.domain.SectorGiro;
import stps.gob.mx.dto.SectorGiroDTO;
import stps.gob.mx.repositories.SectorGiroRepository;



@Service
public class SectorGiroServiceImpl implements  SectorGiroService{
	final static Logger log = Logger.getLogger(SectorGiroServiceImpl.class);
	
	
	@Autowired
	LogService logService;
	
	@Autowired
	SectorGiroRepository repository;

	/********************************************************************************************************
	 * Nombre del metodo: 	Alta de SectorGiro
	 * Descripcion: 		Metodo que implementa el servicio para el alta de SectorGiro
	 * Entrada/Salida:		SectorGiroDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Alta_SectorGiro_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public SectorGiroDTO alta(SectorGiroDTO dto) {
		SectorGiro 			entity 		= new SectorGiro();
		SectorGiro 			newEntity 	= new SectorGiro();
		SectorGiroConverter 	converter 	= new SectorGiroConverter();
		
		dto=(SectorGiroDTO)logService.setValues(dto, "SectorGiro", "alta", "SectorGiroServiceImpl");
		
		try {
			entity    = converter.toSectorGiroAlta(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toSectorGiroDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Baja de SectorGiro
	 * Descripcion: 		Metodo que implementa el servicio para la baja de SectorGiro
	 * Entrada/Salida:		SectorGiroDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Baja_SectorGiro_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public SectorGiroDTO baja(SectorGiroDTO dto) {
		SectorGiro 			entity 		= new SectorGiro();
		SectorGiro 			newEntity 	= new SectorGiro();
		SectorGiroConverter 	converter 	= new SectorGiroConverter();
		
		dto=(SectorGiroDTO)logService.setValues(dto, "SectorGiro", "baja", "SectorGiroServiceImpl");
		
		try {
			entity    = converter.toSectorGiroBaja(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toSectorGiroDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Consulta de SectorGiro
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de SectorGiro
	 * Entrada:				SectorGiroDTO
	 * Salida:				List<SectorGiroDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Consulta_SectorGiro_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<SectorGiroDTO> consulta(SectorGiroDTO dto) {
		SectorGiroDTO 		out 		= new SectorGiroDTO();
		SectorGiro 			entity 		= new SectorGiro();
		List<SectorGiro> 	list 		= new ArrayList<SectorGiro>();	
		List<SectorGiroDTO> 	finalList 	= new ArrayList<SectorGiroDTO>();
		SectorGiroConverter 	converter 	= new SectorGiroConverter();
		
		dto=(SectorGiroDTO)logService.setValues(dto, "SectorGiro", "consulta", "SectorGiroServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<SectorGiro>) repository.findAllRecords(Constantes.ACTIVO);
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTA_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new SectorGiro();
						out 		= new SectorGiroDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toSectorGiroDTO(entity, out);
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
	 * Nombre del metodo: 	Consulta de SectorGiro por Id
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de SectorGiro por Id
	 * Entrada:				SectorGiroDTO
	 * Salida:				List<SectorGiroDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_ConsultaId_SectorGiro_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<SectorGiroDTO> consultaId(SectorGiroDTO dto) {
		SectorGiroDTO 		out 		= new SectorGiroDTO();
		SectorGiro 			entity 		= new SectorGiro();
		List<SectorGiro> 	list 		= new ArrayList<SectorGiro>();	
		List<SectorGiroDTO> 	finalList 	= new ArrayList<SectorGiroDTO>();
		SectorGiroConverter 	converter 	= new SectorGiroConverter();
		
		dto=(SectorGiroDTO)logService.setValues(dto, "SectorGiro", "consultaId", "SectorGiroServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<SectorGiro>) repository.findById(Integer.parseInt(dto.getId()));
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTAID_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new SectorGiro();
						out 		= new SectorGiroDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toSectorGiroDTO(entity, out);
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
	 * Nombre del metodo: 	Modificacion de SectorGiro 
	 * Descripcion: 		Metodo que implementa el servicio para la modificacion de SectorGiro
	 * Entrada/Salida:		SectorGiroDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Modifificacion_SectorGiro_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public SectorGiroDTO modificacion(SectorGiroDTO dto) {
		SectorGiro 			entity 		= new SectorGiro();
		SectorGiro 			newEntity 	= new SectorGiro();
		SectorGiroConverter 	converter 	= new SectorGiroConverter();
		
		dto=(SectorGiroDTO)logService.setValues(dto, "SectorGiro", "modificacion", "SectorGiroServiceImpl");
		
		try {
			entity    = converter.toSectorGiro(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toSectorGiroDTO(newEntity, dto);
			
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

