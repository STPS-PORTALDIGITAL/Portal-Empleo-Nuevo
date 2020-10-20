package stps.gob.mx.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.converters.NivelEducativoConverter;
import stps.gob.mx.domain.NivelEducativo;
import stps.gob.mx.dto.NivelEducativoDTO;
import stps.gob.mx.repositories.NivelEducativoRepository;



@Service
public class NivelEducativoServiceImpl implements  NivelEducativoService{
	final static Logger log = Logger.getLogger(NivelEducativoServiceImpl.class);
	
	
	@Autowired
	LogService logService;
	
	@Autowired
	NivelEducativoRepository repository;

	/********************************************************************************************************
	 * Nombre del metodo: 	Alta de NivelEducativo
	 * Descripcion: 		Metodo que implementa el servicio para el alta de NivelEducativo
	 * Entrada/Salida:		NivelEducativoDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Alta_NivelEducativo_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public NivelEducativoDTO alta(NivelEducativoDTO dto) {
		NivelEducativo 			entity 		= new NivelEducativo();
		NivelEducativo 			newEntity 	= new NivelEducativo();
		NivelEducativoConverter 	converter 	= new NivelEducativoConverter();
		
		dto=(NivelEducativoDTO)logService.setValues(dto, "NivelEducativo", "alta", "NivelEducativoServiceImpl");
		
		try {
			entity    = converter.toNivelEducativoAlta(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toNivelEducativoDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Baja de NivelEducativo
	 * Descripcion: 		Metodo que implementa el servicio para la baja de NivelEducativo
	 * Entrada/Salida:		NivelEducativoDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Baja_NivelEducativo_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public NivelEducativoDTO baja(NivelEducativoDTO dto) {
		NivelEducativo 			entity 		= new NivelEducativo();
		NivelEducativo 			newEntity 	= new NivelEducativo();
		NivelEducativoConverter 	converter 	= new NivelEducativoConverter();
		
		dto=(NivelEducativoDTO)logService.setValues(dto, "NivelEducativo", "baja", "NivelEducativoServiceImpl");
		
		try {
			entity    = converter.toNivelEducativoBaja(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toNivelEducativoDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Consulta de NivelEducativo
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de NivelEducativo
	 * Entrada:				NivelEducativoDTO
	 * Salida:				List<NivelEducativoDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Consulta_NivelEducativo_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<NivelEducativoDTO> consulta(NivelEducativoDTO dto) {
		NivelEducativoDTO 		out 		= new NivelEducativoDTO();
		NivelEducativo 			entity 		= new NivelEducativo();
		List<NivelEducativo> 	list 		= new ArrayList<NivelEducativo>();	
		List<NivelEducativoDTO> 	finalList 	= new ArrayList<NivelEducativoDTO>();
		NivelEducativoConverter 	converter 	= new NivelEducativoConverter();
		
		dto=(NivelEducativoDTO)logService.setValues(dto, "NivelEducativo", "consulta", "NivelEducativoServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<NivelEducativo>) repository.findAllRecords(Constantes.ACTIVO);
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTA_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new NivelEducativo();
						out 		= new NivelEducativoDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toNivelEducativoDTO(entity, out);
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
	 * Nombre del metodo: 	Consulta de NivelEducativo por Id
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de NivelEducativo por Id
	 * Entrada:				NivelEducativoDTO
	 * Salida:				List<NivelEducativoDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_ConsultaId_NivelEducativo_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<NivelEducativoDTO> consultaId(NivelEducativoDTO dto) {
		NivelEducativoDTO 		out 		= new NivelEducativoDTO();
		NivelEducativo 			entity 		= new NivelEducativo();
		List<NivelEducativo> 	list 		= new ArrayList<NivelEducativo>();	
		List<NivelEducativoDTO> 	finalList 	= new ArrayList<NivelEducativoDTO>();
		NivelEducativoConverter 	converter 	= new NivelEducativoConverter();
		
		dto=(NivelEducativoDTO)logService.setValues(dto, "NivelEducativo", "consultaId", "NivelEducativoServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<NivelEducativo>) repository.findById(Integer.parseInt(dto.getId()));
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTAID_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new NivelEducativo();
						out 		= new NivelEducativoDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toNivelEducativoDTO(entity, out);
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
	 * Nombre del metodo: 	Modificacion de NivelEducativo 
	 * Descripcion: 		Metodo que implementa el servicio para la modificacion de NivelEducativo
	 * Entrada/Salida:		NivelEducativoDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Modifificacion_NivelEducativo_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public NivelEducativoDTO modificacion(NivelEducativoDTO dto) {
		NivelEducativo 			entity 		= new NivelEducativo();
		NivelEducativo 			newEntity 	= new NivelEducativo();
		NivelEducativoConverter 	converter 	= new NivelEducativoConverter();
		
		dto=(NivelEducativoDTO)logService.setValues(dto, "NivelEducativo", "modificacion", "NivelEducativoServiceImpl");
		
		try {
			entity    = converter.toNivelEducativo(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toNivelEducativoDTO(newEntity, dto);
			
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

