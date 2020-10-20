package stps.gob.mx.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.converters.PaisConverter;
import stps.gob.mx.domain.Pais;
import stps.gob.mx.dto.PaisDTO;
import stps.gob.mx.repositories.PaisRepository;



@Service
public class PaisServiceImpl implements  PaisService{
	final static Logger log = Logger.getLogger(PaisServiceImpl.class);
	
	
	@Autowired
	LogService logService;
	
	@Autowired
	PaisRepository repository;

	/********************************************************************************************************
	 * Nombre del metodo: 	Alta de Pais
	 * Descripcion: 		Metodo que implementa el servicio para el alta de Pais
	 * Entrada/Salida:		PaisDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Alta_Pais_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public PaisDTO alta(PaisDTO dto) {
		Pais 			entity 		= new Pais();
		Pais 			newEntity 	= new Pais();
		PaisConverter 	converter 	= new PaisConverter();
		
		dto=(PaisDTO)logService.setValues(dto, "Pais", "alta", "PaisServiceImpl");
		
		try {
			entity    = converter.toPaisAlta(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toPaisDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Baja de Pais
	 * Descripcion: 		Metodo que implementa el servicio para la baja de Pais
	 * Entrada/Salida:		PaisDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Baja_Pais_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public PaisDTO baja(PaisDTO dto) {
		Pais 			entity 		= new Pais();
		Pais 			newEntity 	= new Pais();
		PaisConverter 	converter 	= new PaisConverter();
		
		dto=(PaisDTO)logService.setValues(dto, "Pais", "baja", "PaisServiceImpl");
		
		try {
			entity    = converter.toPaisBaja(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toPaisDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Consulta de Pais
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de Pais
	 * Entrada:				PaisDTO
	 * Salida:				List<PaisDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Consulta_Pais_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<PaisDTO> consulta(PaisDTO dto) {
		PaisDTO 		out 		= new PaisDTO();
		Pais 			entity 		= new Pais();
		List<Pais> 	list 		= new ArrayList<Pais>();	
		List<PaisDTO> 	finalList 	= new ArrayList<PaisDTO>();
		PaisConverter 	converter 	= new PaisConverter();
		
		dto=(PaisDTO)logService.setValues(dto, "Pais", "consulta", "PaisServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<Pais>) repository.findAllRecords(Constantes.ACTIVO);
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTA_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new Pais();
						out 		= new PaisDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toPaisDTO(entity, out);
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
	 * Nombre del metodo: 	Consulta de Pais por Id
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de Pais por Id
	 * Entrada:				PaisDTO
	 * Salida:				List<PaisDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_ConsultaId_Pais_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<PaisDTO> consultaId(PaisDTO dto) {
		PaisDTO 		out 		= new PaisDTO();
		Pais 			entity 		= new Pais();
		List<Pais> 	list 		= new ArrayList<Pais>();	
		List<PaisDTO> 	finalList 	= new ArrayList<PaisDTO>();
		PaisConverter 	converter 	= new PaisConverter();
		
		dto=(PaisDTO)logService.setValues(dto, "Pais", "consultaId", "PaisServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<Pais>) repository.findById(Integer.parseInt(dto.getId()));
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTAID_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new Pais();
						out 		= new PaisDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toPaisDTO(entity, out);
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
	 * Nombre del metodo: 	Modificacion de Pais 
	 * Descripcion: 		Metodo que implementa el servicio para la modificacion de Pais
	 * Entrada/Salida:		PaisDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Modifificacion_Pais_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public PaisDTO modificacion(PaisDTO dto) {
		Pais 			entity 		= new Pais();
		Pais 			newEntity 	= new Pais();
		PaisConverter 	converter 	= new PaisConverter();
		
		dto=(PaisDTO)logService.setValues(dto, "Pais", "modificacion", "PaisServiceImpl");
		
		try {
			entity    = converter.toPais(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toPaisDTO(newEntity, dto);
			
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

