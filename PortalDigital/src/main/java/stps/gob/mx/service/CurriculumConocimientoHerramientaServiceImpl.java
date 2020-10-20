package stps.gob.mx.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.converters.CurriculumConocimientoHerramientaConverter;
import stps.gob.mx.domain.CurriculumConocimientoHerramienta;
import stps.gob.mx.dto.CurriculumConocimientoHerramientaDTO;
import stps.gob.mx.repositories.CurriculumConocimientoHerramientaRepository;



@Service
public class CurriculumConocimientoHerramientaServiceImpl implements  CurriculumConocimientoHerramientaService{
	final static Logger log = Logger.getLogger(CurriculumConocimientoHerramientaServiceImpl.class);
	
	
	@Autowired
	LogService logService;
	
	@Autowired
	CurriculumConocimientoHerramientaRepository repository;

	/********************************************************************************************************
	 * Nombre del metodo: 	Alta de CurriculumConocimientoHerramienta
	 * Descripcion: 		Metodo que implementa el servicio para el alta de CurriculumConocimientoHerramienta
	 * Entrada/Salida:		CurriculumConocimientoHerramientaDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Alta_CurriculumConocimientoHerramienta_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public CurriculumConocimientoHerramientaDTO alta(CurriculumConocimientoHerramientaDTO dto) {
		CurriculumConocimientoHerramienta 			entity 		= new CurriculumConocimientoHerramienta();
		CurriculumConocimientoHerramienta 			newEntity 	= new CurriculumConocimientoHerramienta();
		CurriculumConocimientoHerramientaConverter 	converter 	= new CurriculumConocimientoHerramientaConverter();
		
		dto=(CurriculumConocimientoHerramientaDTO)logService.setValues(dto, "CurriculumConocimientoHerramienta", "alta", "CurriculumConocimientoHerramientaServiceImpl");
		
		try {
			entity    = converter.toCurriculumConocimientoHerramientaAlta(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toCurriculumConocimientoHerramientaDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Baja de CurriculumConocimientoHerramienta
	 * Descripcion: 		Metodo que implementa el servicio para la baja de CurriculumConocimientoHerramienta
	 * Entrada/Salida:		CurriculumConocimientoHerramientaDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Baja_CurriculumConocimientoHerramienta_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public CurriculumConocimientoHerramientaDTO baja(CurriculumConocimientoHerramientaDTO dto) {
		CurriculumConocimientoHerramienta 			entity 		= new CurriculumConocimientoHerramienta();
		CurriculumConocimientoHerramienta 			newEntity 	= new CurriculumConocimientoHerramienta();
		CurriculumConocimientoHerramientaConverter 	converter 	= new CurriculumConocimientoHerramientaConverter();
		
		dto=(CurriculumConocimientoHerramientaDTO)logService.setValues(dto, "CurriculumConocimientoHerramienta", "baja", "CurriculumConocimientoHerramientaServiceImpl");
		
		try {
			entity    = converter.toCurriculumConocimientoHerramientaBaja(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toCurriculumConocimientoHerramientaDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Consulta de CurriculumConocimientoHerramienta
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de CurriculumConocimientoHerramienta
	 * Entrada:				CurriculumConocimientoHerramientaDTO
	 * Salida:				List<CurriculumConocimientoHerramientaDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Consulta_CurriculumConocimientoHerramienta_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<CurriculumConocimientoHerramientaDTO> consulta(CurriculumConocimientoHerramientaDTO dto) {
		CurriculumConocimientoHerramientaDTO 		out 		= new CurriculumConocimientoHerramientaDTO();
		CurriculumConocimientoHerramienta 			entity 		= new CurriculumConocimientoHerramienta();
		List<CurriculumConocimientoHerramienta> 	list 		= new ArrayList<CurriculumConocimientoHerramienta>();	
		List<CurriculumConocimientoHerramientaDTO> 	finalList 	= new ArrayList<CurriculumConocimientoHerramientaDTO>();
		CurriculumConocimientoHerramientaConverter 	converter 	= new CurriculumConocimientoHerramientaConverter();
		
		dto=(CurriculumConocimientoHerramientaDTO)logService.setValues(dto, "CurriculumConocimientoHerramienta", "consulta", "CurriculumConocimientoHerramientaServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<CurriculumConocimientoHerramienta>) repository.findAllRecords(Constantes.ACTIVO);
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTA_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new CurriculumConocimientoHerramienta();
						out 		= new CurriculumConocimientoHerramientaDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toCurriculumConocimientoHerramientaDTO(entity, out);
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
	 * Nombre del metodo: 	Consulta de CurriculumConocimientoHerramienta por Id
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de CurriculumConocimientoHerramienta por Id
	 * Entrada:				CurriculumConocimientoHerramientaDTO
	 * Salida:				List<CurriculumConocimientoHerramientaDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_ConsultaId_CurriculumConocimientoHerramienta_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<CurriculumConocimientoHerramientaDTO> consultaId(CurriculumConocimientoHerramientaDTO dto) {
		CurriculumConocimientoHerramientaDTO 		out 		= new CurriculumConocimientoHerramientaDTO();
		CurriculumConocimientoHerramienta 			entity 		= new CurriculumConocimientoHerramienta();
		List<CurriculumConocimientoHerramienta> 	list 		= new ArrayList<CurriculumConocimientoHerramienta>();	
		List<CurriculumConocimientoHerramientaDTO> 	finalList 	= new ArrayList<CurriculumConocimientoHerramientaDTO>();
		CurriculumConocimientoHerramientaConverter 	converter 	= new CurriculumConocimientoHerramientaConverter();
		
		dto=(CurriculumConocimientoHerramientaDTO)logService.setValues(dto, "CurriculumConocimientoHerramienta", "consultaId", "CurriculumConocimientoHerramientaServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<CurriculumConocimientoHerramienta>) repository.findById(Integer.parseInt(dto.getId()));
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTAID_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new CurriculumConocimientoHerramienta();
						out 		= new CurriculumConocimientoHerramientaDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toCurriculumConocimientoHerramientaDTO(entity, out);
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
	 * Nombre del metodo: 	Modificacion de CurriculumConocimientoHerramienta 
	 * Descripcion: 		Metodo que implementa el servicio para la modificacion de CurriculumConocimientoHerramienta
	 * Entrada/Salida:		CurriculumConocimientoHerramientaDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Modifificacion_CurriculumConocimientoHerramienta_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public CurriculumConocimientoHerramientaDTO modificacion(CurriculumConocimientoHerramientaDTO dto) {
		CurriculumConocimientoHerramienta 			entity 		= new CurriculumConocimientoHerramienta();
		CurriculumConocimientoHerramienta 			newEntity 	= new CurriculumConocimientoHerramienta();
		CurriculumConocimientoHerramientaConverter 	converter 	= new CurriculumConocimientoHerramientaConverter();
		
		dto=(CurriculumConocimientoHerramientaDTO)logService.setValues(dto, "CurriculumConocimientoHerramienta", "modificacion", "CurriculumConocimientoHerramientaServiceImpl");
		
		try {
			entity    = converter.toCurriculumConocimientoHerramienta(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toCurriculumConocimientoHerramientaDTO(newEntity, dto);
			
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

