package stps.gob.mx.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.converters.CurriculumOtrosEstudiosConverter;
import stps.gob.mx.domain.CurriculumOtrosEstudios;
import stps.gob.mx.dto.CurriculumOtrosEstudiosDTO;
import stps.gob.mx.repositories.CurriculumOtrosEstudiosRepository;



@Service
public class CurriculumOtrosEstudiosServiceImpl implements  CurriculumOtrosEstudiosService{
	final static Logger log = Logger.getLogger(CurriculumOtrosEstudiosServiceImpl.class);
	
	
	@Autowired
	LogService logService;
	
	@Autowired
	CurriculumOtrosEstudiosRepository repository;

	/********************************************************************************************************
	 * Nombre del metodo: 	Alta de CurriculumOtrosEstudios
	 * Descripcion: 		Metodo que implementa el servicio para el alta de CurriculumOtrosEstudios
	 * Entrada/Salida:		CurriculumOtrosEstudiosDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Alta_CurriculumOtrosEstudios_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public CurriculumOtrosEstudiosDTO alta(CurriculumOtrosEstudiosDTO dto) {
		CurriculumOtrosEstudios 			entity 		= new CurriculumOtrosEstudios();
		CurriculumOtrosEstudios 			newEntity 	= new CurriculumOtrosEstudios();
		CurriculumOtrosEstudiosConverter 	converter 	= new CurriculumOtrosEstudiosConverter();
		
		dto=(CurriculumOtrosEstudiosDTO)logService.setValues(dto, "CurriculumOtrosEstudios", "alta", "CurriculumOtrosEstudiosServiceImpl");
		
		try {
			entity    = converter.toCurriculumOtrosEstudiosAlta(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toCurriculumOtrosEstudiosDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Baja de CurriculumOtrosEstudios
	 * Descripcion: 		Metodo que implementa el servicio para la baja de CurriculumOtrosEstudios
	 * Entrada/Salida:		CurriculumOtrosEstudiosDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Baja_CurriculumOtrosEstudios_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public CurriculumOtrosEstudiosDTO baja(CurriculumOtrosEstudiosDTO dto) {
		CurriculumOtrosEstudios 			entity 		= new CurriculumOtrosEstudios();
		CurriculumOtrosEstudios 			newEntity 	= new CurriculumOtrosEstudios();
		CurriculumOtrosEstudiosConverter 	converter 	= new CurriculumOtrosEstudiosConverter();
		
		dto=(CurriculumOtrosEstudiosDTO)logService.setValues(dto, "CurriculumOtrosEstudios", "baja", "CurriculumOtrosEstudiosServiceImpl");
		
		try {
			entity    = converter.toCurriculumOtrosEstudiosBaja(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toCurriculumOtrosEstudiosDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Consulta de CurriculumOtrosEstudios
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de CurriculumOtrosEstudios
	 * Entrada:				CurriculumOtrosEstudiosDTO
	 * Salida:				List<CurriculumOtrosEstudiosDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Consulta_CurriculumOtrosEstudios_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<CurriculumOtrosEstudiosDTO> consulta(CurriculumOtrosEstudiosDTO dto) {
		CurriculumOtrosEstudiosDTO 		out 		= new CurriculumOtrosEstudiosDTO();
		CurriculumOtrosEstudios 			entity 		= new CurriculumOtrosEstudios();
		List<CurriculumOtrosEstudios> 	list 		= new ArrayList<CurriculumOtrosEstudios>();	
		List<CurriculumOtrosEstudiosDTO> 	finalList 	= new ArrayList<CurriculumOtrosEstudiosDTO>();
		CurriculumOtrosEstudiosConverter 	converter 	= new CurriculumOtrosEstudiosConverter();
		
		dto=(CurriculumOtrosEstudiosDTO)logService.setValues(dto, "CurriculumOtrosEstudios", "consulta", "CurriculumOtrosEstudiosServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<CurriculumOtrosEstudios>) repository.findAllRecords(Constantes.ACTIVO);
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTA_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new CurriculumOtrosEstudios();
						out 		= new CurriculumOtrosEstudiosDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toCurriculumOtrosEstudiosDTO(entity, out);
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
	 * Nombre del metodo: 	Consulta de CurriculumOtrosEstudios por Id
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de CurriculumOtrosEstudios por Id
	 * Entrada:				CurriculumOtrosEstudiosDTO
	 * Salida:				List<CurriculumOtrosEstudiosDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_ConsultaId_CurriculumOtrosEstudios_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<CurriculumOtrosEstudiosDTO> consultaId(CurriculumOtrosEstudiosDTO dto) {
		CurriculumOtrosEstudiosDTO 		out 		= new CurriculumOtrosEstudiosDTO();
		CurriculumOtrosEstudios 			entity 		= new CurriculumOtrosEstudios();
		List<CurriculumOtrosEstudios> 	list 		= new ArrayList<CurriculumOtrosEstudios>();	
		List<CurriculumOtrosEstudiosDTO> 	finalList 	= new ArrayList<CurriculumOtrosEstudiosDTO>();
		CurriculumOtrosEstudiosConverter 	converter 	= new CurriculumOtrosEstudiosConverter();
		
		dto=(CurriculumOtrosEstudiosDTO)logService.setValues(dto, "CurriculumOtrosEstudios", "consultaId", "CurriculumOtrosEstudiosServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<CurriculumOtrosEstudios>) repository.findById(Integer.parseInt(dto.getId()));
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTAID_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new CurriculumOtrosEstudios();
						out 		= new CurriculumOtrosEstudiosDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toCurriculumOtrosEstudiosDTO(entity, out);
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
	 * Nombre del metodo: 	Modificacion de CurriculumOtrosEstudios 
	 * Descripcion: 		Metodo que implementa el servicio para la modificacion de CurriculumOtrosEstudios
	 * Entrada/Salida:		CurriculumOtrosEstudiosDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Modifificacion_CurriculumOtrosEstudios_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public CurriculumOtrosEstudiosDTO modificacion(CurriculumOtrosEstudiosDTO dto) {
		CurriculumOtrosEstudios 			entity 		= new CurriculumOtrosEstudios();
		CurriculumOtrosEstudios 			newEntity 	= new CurriculumOtrosEstudios();
		CurriculumOtrosEstudiosConverter 	converter 	= new CurriculumOtrosEstudiosConverter();
		
		dto=(CurriculumOtrosEstudiosDTO)logService.setValues(dto, "CurriculumOtrosEstudios", "modificacion", "CurriculumOtrosEstudiosServiceImpl");
		
		try {
			entity    = converter.toCurriculumOtrosEstudios(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toCurriculumOtrosEstudiosDTO(newEntity, dto);
			
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

