package stps.gob.mx.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.converters.PersonaConverter;
import stps.gob.mx.domain.Persona;
import stps.gob.mx.dto.PersonaDTO;
import stps.gob.mx.repositories.PersonaRepository;



@Service
public class PersonaServiceImpl implements  PersonaService{
	final static Logger log = Logger.getLogger(PersonaServiceImpl.class);
	
	
	@Autowired
	LogService logService;
	
	@Autowired
	PersonaRepository repository;

	/********************************************************************************************************
	 * Nombre del metodo: 	Alta de Persona
	 * Descripcion: 		Metodo que implementa el servicio para el alta de Persona
	 * Entrada/Salida:		PersonaDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Alta_Persona_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public PersonaDTO alta(PersonaDTO dto) {
		Persona 			entity 		= new Persona();
		Persona 			newEntity 	= new Persona();
		PersonaConverter 	converter 	= new PersonaConverter();
		
		dto=(PersonaDTO)logService.setValues(dto, "Persona", "alta", "PersonaServiceImpl");
		
		try {
			entity    = converter.toPersonaAlta(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toPersonaDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Baja de Persona
	 * Descripcion: 		Metodo que implementa el servicio para la baja de Persona
	 * Entrada/Salida:		PersonaDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Baja_Persona_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public PersonaDTO baja(PersonaDTO dto) {
		Persona 			entity 		= new Persona();
		Persona 			newEntity 	= new Persona();
		PersonaConverter 	converter 	= new PersonaConverter();
		
		dto=(PersonaDTO)logService.setValues(dto, "Persona", "baja", "PersonaServiceImpl");
		
		try {
			entity    = converter.toPersonaBaja(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toPersonaDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Consulta de Persona
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de Persona
	 * Entrada:				PersonaDTO
	 * Salida:				List<PersonaDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Consulta_Persona_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<PersonaDTO> consulta(PersonaDTO dto) {
		PersonaDTO 		out 		= new PersonaDTO();
		Persona 			entity 		= new Persona();
		List<Persona> 	list 		= new ArrayList<Persona>();	
		List<PersonaDTO> 	finalList 	= new ArrayList<PersonaDTO>();
		PersonaConverter 	converter 	= new PersonaConverter();
		
		dto=(PersonaDTO)logService.setValues(dto, "Persona", "consulta", "PersonaServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<Persona>) repository.findAllRecords(Constantes.ACTIVO);
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTA_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new Persona();
						out 		= new PersonaDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toPersonaDTO(entity, out);
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
	 * Nombre del metodo: 	Consulta de Persona por Id
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de Persona por Id
	 * Entrada:				PersonaDTO
	 * Salida:				List<PersonaDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_ConsultaId_Persona_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<PersonaDTO> consultaId(PersonaDTO dto) {
		PersonaDTO 		out 		= new PersonaDTO();
		Persona 			entity 		= new Persona();
		List<Persona> 	list 		= new ArrayList<Persona>();	
		List<PersonaDTO> 	finalList 	= new ArrayList<PersonaDTO>();
		PersonaConverter 	converter 	= new PersonaConverter();
		
		dto=(PersonaDTO)logService.setValues(dto, "Persona", "consultaId", "PersonaServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<Persona>) repository.findById(Integer.parseInt(dto.getId()));
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTAID_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new Persona();
						out 		= new PersonaDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toPersonaDTO(entity, out);
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
	 * Nombre del metodo: 	Modificacion de Persona 
	 * Descripcion: 		Metodo que implementa el servicio para la modificacion de Persona
	 * Entrada/Salida:		PersonaDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Modifificacion_Persona_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public PersonaDTO modificacion(PersonaDTO dto) {
		Persona 			entity 		= new Persona();
		Persona 			newEntity 	= new Persona();
		PersonaConverter 	converter 	= new PersonaConverter();
		
		dto=(PersonaDTO)logService.setValues(dto, "Persona", "modificacion", "PersonaServiceImpl");
		
		try {
			entity    = converter.toPersona(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toPersonaDTO(newEntity, dto);
			
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

