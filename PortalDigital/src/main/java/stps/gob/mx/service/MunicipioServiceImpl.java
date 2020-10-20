package stps.gob.mx.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.converters.MunicipioConverter;
import stps.gob.mx.domain.Municipio;
import stps.gob.mx.dto.MunicipioDTO;
import stps.gob.mx.repositories.MunicipioRepository;



@Service
public class MunicipioServiceImpl implements  MunicipioService{
	final static Logger log = Logger.getLogger(MunicipioServiceImpl.class);
	
	
	@Autowired
	LogService logService;
	
	@Autowired
	MunicipioRepository repository;

	/********************************************************************************************************
	 * Nombre del metodo: 	Alta de Municipio
	 * Descripcion: 		Metodo que implementa el servicio para el alta de Municipio
	 * Entrada/Salida:		MunicipioDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Alta_Municipio_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public MunicipioDTO alta(MunicipioDTO dto) {
		Municipio 			entity 		= new Municipio();
		Municipio 			newEntity 	= new Municipio();
		MunicipioConverter 	converter 	= new MunicipioConverter();
		
		dto=(MunicipioDTO)logService.setValues(dto, "Municipio", "alta", "MunicipioServiceImpl");
		
		try {
			entity    = converter.toMunicipioAlta(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toMunicipioDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Baja de Municipio
	 * Descripcion: 		Metodo que implementa el servicio para la baja de Municipio
	 * Entrada/Salida:		MunicipioDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Baja_Municipio_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public MunicipioDTO baja(MunicipioDTO dto) {
		Municipio 			entity 		= new Municipio();
		Municipio 			newEntity 	= new Municipio();
		MunicipioConverter 	converter 	= new MunicipioConverter();
		
		dto=(MunicipioDTO)logService.setValues(dto, "Municipio", "baja", "MunicipioServiceImpl");
		
		try {
			entity    = converter.toMunicipioBaja(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toMunicipioDTO(newEntity, dto);
			
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
	 * Nombre del metodo: 	Consulta de Municipio
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de Municipio
	 * Entrada:				MunicipioDTO
	 * Salida:				List<MunicipioDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Consulta_Municipio_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<MunicipioDTO> consulta(MunicipioDTO dto) {
		MunicipioDTO 		out 		= new MunicipioDTO();
		Municipio 			entity 		= new Municipio();
		List<Municipio> 	list 		= new ArrayList<Municipio>();	
		List<MunicipioDTO> 	finalList 	= new ArrayList<MunicipioDTO>();
		MunicipioConverter 	converter 	= new MunicipioConverter();
		
		dto=(MunicipioDTO)logService.setValues(dto, "Municipio", "consulta", "MunicipioServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<Municipio>) repository.findAllRecords(Constantes.ACTIVO);
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTA_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new Municipio();
						out 		= new MunicipioDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toMunicipioDTO(entity, out);
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
	 * Nombre del metodo: 	Consulta de Municipio por Id
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de Municipio por Id
	 * Entrada:				MunicipioDTO
	 * Salida:				List<MunicipioDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_ConsultaId_Municipio_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<MunicipioDTO> consultaId(MunicipioDTO dto) {
		MunicipioDTO 		out 		= new MunicipioDTO();
		Municipio 			entity 		= new Municipio();
		List<Municipio> 	list 		= new ArrayList<Municipio>();	
		List<MunicipioDTO> 	finalList 	= new ArrayList<MunicipioDTO>();
		MunicipioConverter 	converter 	= new MunicipioConverter();
		
		dto=(MunicipioDTO)logService.setValues(dto, "Municipio", "consultaId", "MunicipioServiceImpl");

		
		BasicConfigurator.configure();
		try {	
		
			list = (List<Municipio>) repository.findById(Integer.parseInt(dto.getId()));
			if (list != null) {
				if (list.size() > 0) {
					dto.setComments(Constantes.CONSULTAID_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
					dto.setMessage(out.getComments());
					dto.setResult(Constantes.TRUE);	
					for (int i=0; i < list.size(); i++) {
						entity 		= new Municipio();
						out 		= new MunicipioDTO();
						//out			= dto;
						entity = list.get(i);
						out = converter.toMunicipioDTO(entity, out);
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
	 * Nombre del metodo: 	Modificacion de Municipio 
	 * Descripcion: 		Metodo que implementa el servicio para la modificacion de Municipio
	 * Entrada/Salida:		MunicipioDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Modifificacion_Municipio_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public MunicipioDTO modificacion(MunicipioDTO dto) {
		Municipio 			entity 		= new Municipio();
		Municipio 			newEntity 	= new Municipio();
		MunicipioConverter 	converter 	= new MunicipioConverter();
		
		dto=(MunicipioDTO)logService.setValues(dto, "Municipio", "modificacion", "MunicipioServiceImpl");
		
		try {
			entity    = converter.toMunicipio(dto, entity);
			newEntity = repository.save(entity);
			dto       = converter.toMunicipioDTO(newEntity, dto);
			
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

