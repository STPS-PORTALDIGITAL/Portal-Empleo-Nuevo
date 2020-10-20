package stps.gob.mx.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.converters.ContactoEmpleadorConverter;
import stps.gob.mx.domain.ContactoEmpleador;
import stps.gob.mx.dto.ContactoEmpleadorDTO;
import stps.gob.mx.repositories.ContactoEmpleadorRepository;



@Service
public class ContactoEmpleadorServiceImpl implements  ContactoEmpleadorService{
	final static Logger log = Logger.getLogger(ContactoEmpleadorServiceImpl.class);
	
	
	@Autowired
	LogService logService;
	
	@Autowired
	ContactoEmpleadorRepository repository;

	/********************************************************************************************************
	 * Nombre del metodo: 	Alta de ContactoEmpleador
	 * Descripcion: 		Metodo que implementa el servicio para el alta de ContactoEmpleador
	 * Entrada/Salida:		ContactoEmpleadorDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Alta_ContactoEmpleador_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public ContactoEmpleadorDTO alta(ContactoEmpleadorDTO dto) {
		ContactoEmpleador 			entity 		= new ContactoEmpleador();
		ContactoEmpleador 			newEntity 	= new ContactoEmpleador();
		ContactoEmpleadorConverter 	converter 	= new ContactoEmpleadorConverter();
		
		dto=(ContactoEmpleadorDTO)logService.setValues(dto, "ContactoEmpleador", "alta", "ContactoEmpleadorServiceImpl");
		
		try {
			entity    = converter.toContactoEmpleadorAlta(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toContactoEmpleadorDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Baja de ContactoEmpleador
	 * Descripcion: 		Metodo que implementa el servicio para la baja de ContactoEmpleador
	 * Entrada/Salida:		ContactoEmpleadorDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Baja_ContactoEmpleador_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public ContactoEmpleadorDTO baja(ContactoEmpleadorDTO dto) {
		ContactoEmpleador 			entity 		= new ContactoEmpleador();
		ContactoEmpleador 			newEntity 	= new ContactoEmpleador();
		ContactoEmpleadorConverter 	converter 	= new ContactoEmpleadorConverter();
		
		dto=(ContactoEmpleadorDTO)logService.setValues(dto, "ContactoEmpleador", "baja", "ContactoEmpleadorServiceImpl");
		
		try {
			entity    = converter.toContactoEmpleadorBaja(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toContactoEmpleadorDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Consulta de ContactoEmpleador
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de ContactoEmpleador
	 * Entrada:				ContactoEmpleadorDTO
	 * Salida:				List<ContactoEmpleadorDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Consulta_ContactoEmpleador_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<ContactoEmpleadorDTO> consulta(ContactoEmpleadorDTO dto) {
		ContactoEmpleadorDTO 		out 		= new ContactoEmpleadorDTO();
		ContactoEmpleador 			entity 		= new ContactoEmpleador();
		List<ContactoEmpleador> 	list 		= new ArrayList<ContactoEmpleador>();	
		List<ContactoEmpleadorDTO> 	finalList 	= new ArrayList<ContactoEmpleadorDTO>();
		ContactoEmpleadorConverter 	converter 	= new ContactoEmpleadorConverter();
		
		dto=(ContactoEmpleadorDTO)logService.setValues(dto, "ContactoEmpleador", "consulta", "ContactoEmpleadorServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<ContactoEmpleador>) repository.findAllRecords(Constantes.ACTIVO);
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTA_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new ContactoEmpleador();
						out 		= new ContactoEmpleadorDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toContactoEmpleadorDTO(entity, out);
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
	 * Nombre del metodo: 	Consulta de ContactoEmpleador por Id
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de ContactoEmpleador por Id
	 * Entrada:				ContactoEmpleadorDTO
	 * Salida:				List<ContactoEmpleadorDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_ConsultaId_ContactoEmpleador_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<ContactoEmpleadorDTO> consultaId(ContactoEmpleadorDTO dto) {
		ContactoEmpleadorDTO 		out 		= new ContactoEmpleadorDTO();
		ContactoEmpleador 			entity 		= new ContactoEmpleador();
		List<ContactoEmpleador> 	list 		= new ArrayList<ContactoEmpleador>();	
		List<ContactoEmpleadorDTO> 	finalList 	= new ArrayList<ContactoEmpleadorDTO>();
		ContactoEmpleadorConverter 	converter 	= new ContactoEmpleadorConverter();
		
		dto=(ContactoEmpleadorDTO)logService.setValues(dto, "ContactoEmpleador", "consultaId", "ContactoEmpleadorServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<ContactoEmpleador>) repository.findById(Integer.parseInt(dto.getId()));
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTAID_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new ContactoEmpleador();
						out 		= new ContactoEmpleadorDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toContactoEmpleadorDTO(entity, out);
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
	 * Nombre del metodo: 	Modificacion de ContactoEmpleador 
	 * Descripcion: 		Metodo que implementa el servicio para la modificacion de ContactoEmpleador
	 * Entrada/Salida:		ContactoEmpleadorDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Modifificacion_ContactoEmpleador_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public ContactoEmpleadorDTO modificacion(ContactoEmpleadorDTO dto) {
		ContactoEmpleador 			entity 		= new ContactoEmpleador();
		ContactoEmpleador 			newEntity 	= new ContactoEmpleador();
		ContactoEmpleadorConverter 	converter 	= new ContactoEmpleadorConverter();
		
		dto=(ContactoEmpleadorDTO)logService.setValues(dto, "ContactoEmpleador", "modificacion", "ContactoEmpleadorServiceImpl");
		
		try {
			entity    = converter.toContactoEmpleador(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toContactoEmpleadorDTO(newEntity, dto);
			
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

