package stps.gob.mx.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.converters.OficinaConverter;
import stps.gob.mx.domain.Oficina;
import stps.gob.mx.dto.OficinaDTO;
import stps.gob.mx.repositories.OficinaRepository;



@Service
public class OficinaServiceImpl implements  OficinaService{
	final static Logger log = Logger.getLogger(OficinaServiceImpl.class);
	
	
	@Autowired
	LogService logService;
	
	@Autowired
	OficinaRepository repository;

	/********************************************************************************************************
	 * Nombre del metodo: 	Alta de Oficina
	 * Descripcion: 		Metodo que implementa el servicio para el alta de Oficina
	 * Entrada/Salida:		OficinaDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Alta_Oficina_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public OficinaDTO alta(OficinaDTO dto) {
		Oficina 			entity 		= new Oficina();
		Oficina 			newEntity 	= new Oficina();
		OficinaConverter 	converter 	= new OficinaConverter();
		
		dto=(OficinaDTO)logService.setValues(dto, "Oficina", "alta", "OficinaServiceImpl");
		
		try {
			entity    = converter.toOficinaAlta(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toOficinaDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Baja de Oficina
	 * Descripcion: 		Metodo que implementa el servicio para la baja de Oficina
	 * Entrada/Salida:		OficinaDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Baja_Oficina_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public OficinaDTO baja(OficinaDTO dto) {
		Oficina 			entity 		= new Oficina();
		Oficina 			newEntity 	= new Oficina();
		OficinaConverter 	converter 	= new OficinaConverter();
		
		dto=(OficinaDTO)logService.setValues(dto, "Oficina", "baja", "OficinaServiceImpl");
		
		try {
			entity    = converter.toOficinaBaja(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toOficinaDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Consulta de Oficina
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de Oficina
	 * Entrada:				OficinaDTO
	 * Salida:				List<OficinaDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Consulta_Oficina_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<OficinaDTO> consulta(OficinaDTO dto) {
		OficinaDTO 		out 		= new OficinaDTO();
		Oficina 			entity 		= new Oficina();
		List<Oficina> 	list 		= new ArrayList<Oficina>();	
		List<OficinaDTO> 	finalList 	= new ArrayList<OficinaDTO>();
		OficinaConverter 	converter 	= new OficinaConverter();
		
		dto=(OficinaDTO)logService.setValues(dto, "Oficina", "consulta", "OficinaServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<Oficina>) repository.findAllRecords(Constantes.ACTIVO);
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTA_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new Oficina();
						out 		= new OficinaDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toOficinaDTO(entity, out);
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
	 * Nombre del metodo: 	Consulta de Oficina por Id
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de Oficina por Id
	 * Entrada:				OficinaDTO
	 * Salida:				List<OficinaDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_ConsultaId_Oficina_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<OficinaDTO> consultaId(OficinaDTO dto) {
		OficinaDTO 		out 		= new OficinaDTO();
		Oficina 			entity 		= new Oficina();
		List<Oficina> 	list 		= new ArrayList<Oficina>();	
		List<OficinaDTO> 	finalList 	= new ArrayList<OficinaDTO>();
		OficinaConverter 	converter 	= new OficinaConverter();
		
		dto=(OficinaDTO)logService.setValues(dto, "Oficina", "consultaId", "OficinaServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<Oficina>) repository.findById(Integer.parseInt(dto.getId()));
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTAID_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new Oficina();
						out 		= new OficinaDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toOficinaDTO(entity, out);
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
	 * Nombre del metodo: 	Modificacion de Oficina 
	 * Descripcion: 		Metodo que implementa el servicio para la modificacion de Oficina
	 * Entrada/Salida:		OficinaDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Modifificacion_Oficina_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public OficinaDTO modificacion(OficinaDTO dto) {
		Oficina 			entity 		= new Oficina();
		Oficina 			newEntity 	= new Oficina();
		OficinaConverter 	converter 	= new OficinaConverter();
		
		dto=(OficinaDTO)logService.setValues(dto, "Oficina", "modificacion", "OficinaServiceImpl");
		
		try {
			entity    = converter.toOficina(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toOficinaDTO(newEntity, dto);
			
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

