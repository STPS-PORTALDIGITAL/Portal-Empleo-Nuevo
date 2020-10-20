package stps.gob.mx.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.dto.StandDTO;


@Service
public class StandServiceImpl implements  StandService{

	@Autowired
	LogService logService;

	/********************************************************************************************************
	 * Nombre del metodo: 	Alta de Stand
	 * Descripcion: 		Metodo que implementa el servicio para el alta de Stand
	 * Entrada/Salida:		StandDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Alta_Stand_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public StandDTO alta(StandDTO dto) {

		dto=(StandDTO)logService.setValues(dto, "Stand", "alta", "StandServiceImpl");
		
		try {
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
	 * Nombre del metodo: 	Baja de Stand
	 * Descripcion: 		Metodo que implementa el servicio para la baja de Stand
	 * Entrada/Salida:		StandDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Baja_Stand_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public StandDTO baja(StandDTO dto) {
		StandDTO out = new StandDTO();
		dto=(StandDTO)logService.setValues(dto, "Stand", "baja", "StandServiceImpl");
		
		try {
			dto.setComments(Constantes.BAJA_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
			out.setMessage(dto.getComments());
			out.setResult(Constantes.TRUE);
		}catch(Exception e) {
			dto.setComments(Constantes.ERROR_EXCEPCION+"/"+dto.getServicio()+"/"+dto.getMetodo());
			out.setMessage(dto.getComments());
			logService.recordException(e, dto);	
		}
		logService.recordLog(dto);
		
		return out;
	}

	/********************************************************************************************************
	 * Nombre del metodo: 	Consulta de Stand
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de Stand
	 * Entrada:				StandDTO
	 * Salida:				List<StandDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Consulta_Stand_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<StandDTO> consulta(StandDTO dto) {
		StandDTO out = new StandDTO();
		List<StandDTO> list = new ArrayList<StandDTO>();
		
		dto=(StandDTO)logService.setValues(dto, "Stand", "consulta", "StandServiceImpl");
		
		try {
			dto.setComments(Constantes.CONSULTA_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
			out.setMessage(dto.getComments());
			out.setResult(Constantes.TRUE);
			list.add(out);
		}catch(Exception e) {
			dto.setComments(Constantes.ERROR_EXCEPCION+"/"+dto.getServicio()+"/"+dto.getMetodo());
			out.setMessage(dto.getComments());
			logService.recordException(e, dto);	
		}
		logService.recordLog(dto);
		
		return list;
	}

	/********************************************************************************************************
	 * Nombre del metodo: 	Consulta de Stand por Id
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de Stand por Id
	 * Entrada:				StandDTO
	 * Salida:				List<StandDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_ConsultaId_Stand_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<StandDTO> consultaId(StandDTO dto) {
		StandDTO out = new StandDTO();
		List<StandDTO> list = new ArrayList<StandDTO>();
		
		dto=(StandDTO)logService.setValues(dto, "Stand", "consultaId", "StandServiceImpl");
		
		try {
			dto.setComments(Constantes.CONSULTAID_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
			out.setMessage(dto.getComments());
			out.setResult(Constantes.TRUE);
			list.add(out);
		}catch(Exception e) {
			dto.setComments(Constantes.ERROR_EXCEPCION+"/"+dto.getServicio()+"/"+dto.getMetodo());
			out.setMessage(dto.getComments());
			logService.recordException(e, dto);	
		}
		logService.recordLog(dto);
		
		return list;
	}

	/********************************************************************************************************
	 * Nombre del metodo: 	Modificacion de Stand 
	 * Descripcion: 		Metodo que implementa el servicio para la modificacion de Stand
	 * Entrada/Salida:		StandDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Modifificacion_Stand_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public StandDTO modificacion(StandDTO dto) {
		StandDTO out = new StandDTO();
		dto=(StandDTO)logService.setValues(dto, "Stand", "modificacion", "StandServiceImpl");
		
		try {
			dto.setComments(Constantes.MODIFICACION_EXITOSA +" /"+dto.getServicio()+"/"+dto.getMetodo());
			out.setMessage(dto.getComments());
			out.setResult(Constantes.TRUE);
		}catch(Exception e) {
			dto.setComments(Constantes.ERROR_EXCEPCION+"/"+dto.getServicio()+"/"+dto.getMetodo());
			out.setMessage(dto.getComments());
			logService.recordException(e, dto);	
		}
		logService.recordLog(dto);
		
		return out;
	}


}

