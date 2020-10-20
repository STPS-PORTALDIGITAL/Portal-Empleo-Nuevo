package stps.gob.mx.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.converters.ColoniaConverter;
import stps.gob.mx.domain.Colonia;
import stps.gob.mx.dto.ColoniaDTO;
import stps.gob.mx.repositories.ColoniaRepository;



@Service
public class ColoniaServiceImpl implements  ColoniaService{
	final static Logger log = Logger.getLogger(ColoniaServiceImpl.class);
	
	
	@Autowired
	LogService logService;
	
	@Autowired
	ColoniaRepository repository;

	/********************************************************************************************************
	 * Nombre del metodo: 	Alta de Colonia
	 * Descripcion: 		Metodo que implementa el servicio para el alta de Colonia
	 * Entrada/Salida:		ColoniaDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Alta_Colonia_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public ColoniaDTO alta(ColoniaDTO dto) {
		Colonia 			entity 		= new Colonia();
		Colonia 			newEntity 	= new Colonia();
		ColoniaConverter 	converter 	= new ColoniaConverter();
		
		dto=(ColoniaDTO)logService.setValues(dto, "Colonia", "alta", "ColoniaServiceImpl");
		
		try {
			entity    = converter.toColoniaAlta(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toColoniaDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Baja de Colonia
	 * Descripcion: 		Metodo que implementa el servicio para la baja de Colonia
	 * Entrada/Salida:		ColoniaDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Baja_Colonia_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public ColoniaDTO baja(ColoniaDTO dto) {
		Colonia 			entity 		= new Colonia();
		Colonia 			newEntity 	= new Colonia();
		ColoniaConverter 	converter 	= new ColoniaConverter();
		
		dto=(ColoniaDTO)logService.setValues(dto, "Colonia", "baja", "ColoniaServiceImpl");
		
		try {
			entity    = converter.toColoniaBaja(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toColoniaDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Consulta de Colonia
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de Colonia
	 * Entrada:				ColoniaDTO
	 * Salida:				List<ColoniaDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Consulta_Colonia_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<ColoniaDTO> consulta(ColoniaDTO dto) {
		ColoniaDTO 		out 		= new ColoniaDTO();
		Colonia 			entity 		= new Colonia();
		List<Colonia> 	list 		= new ArrayList<Colonia>();	
		List<ColoniaDTO> 	finalList 	= new ArrayList<ColoniaDTO>();
		ColoniaConverter 	converter 	= new ColoniaConverter();
		
		dto=(ColoniaDTO)logService.setValues(dto, "Colonia", "consulta", "ColoniaServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<Colonia>) repository.findAllRecords(Constantes.ACTIVO);
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTA_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new Colonia();
						out 		= new ColoniaDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toColoniaDTO(entity, out);
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
	 * Nombre del metodo: 	Consulta de Colonia por Id
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de Colonia por Id
	 * Entrada:				ColoniaDTO
	 * Salida:				List<ColoniaDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_ConsultaId_Colonia_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<ColoniaDTO> consultaId(ColoniaDTO dto) {
		ColoniaDTO 		out 		= new ColoniaDTO();
		Colonia 			entity 		= new Colonia();
		List<Colonia> 	list 		= new ArrayList<Colonia>();	
		List<ColoniaDTO> 	finalList 	= new ArrayList<ColoniaDTO>();
		ColoniaConverter 	converter 	= new ColoniaConverter();
		
		dto=(ColoniaDTO)logService.setValues(dto, "Colonia", "consultaId", "ColoniaServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<Colonia>) repository.findById(Integer.parseInt(dto.getId()));
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTAID_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new Colonia();
						out 		= new ColoniaDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toColoniaDTO(entity, out);
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
	 * Nombre del metodo: 	Modificacion de Colonia 
	 * Descripcion: 		Metodo que implementa el servicio para la modificacion de Colonia
	 * Entrada/Salida:		ColoniaDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Modifificacion_Colonia_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public ColoniaDTO modificacion(ColoniaDTO dto) {
		Colonia 			entity 		= new Colonia();
		Colonia 			newEntity 	= new Colonia();
		ColoniaConverter 	converter 	= new ColoniaConverter();
		
		dto=(ColoniaDTO)logService.setValues(dto, "Colonia", "modificacion", "ColoniaServiceImpl");
		
		try {
			entity    = converter.toColonia(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toColoniaDTO(newEntity, dto);
			
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

