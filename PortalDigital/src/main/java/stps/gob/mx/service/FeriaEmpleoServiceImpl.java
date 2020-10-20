package stps.gob.mx.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.dto.FeriaEmpleoDTO;


@Service
public class FeriaEmpleoServiceImpl implements  FeriaEmpleoService{

	@Autowired
	LogService logService;

	/********************************************************************************************************
	 * Nombre del metodo: 	Alta de FeriaEmpleo
	 * Descripcion: 		Metodo que implementa el servicio para el alta de FeriaEmpleo
	 * Entrada/Salida:		FeriaEmpleoDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Alta_FeriaEmpleo_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public FeriaEmpleoDTO alta(FeriaEmpleoDTO dto) {

		dto=(FeriaEmpleoDTO)logService.setValues(dto, "FeriaEmpleo", "alta", "FeriaEmpleoServiceImpl");
		
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
	 * Nombre del metodo: 	Baja de FeriaEmpleo
	 * Descripcion: 		Metodo que implementa el servicio para la baja de FeriaEmpleo
	 * Entrada/Salida:		FeriaEmpleoDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Baja_FeriaEmpleo_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public FeriaEmpleoDTO baja(FeriaEmpleoDTO dto) {
		FeriaEmpleoDTO out = new FeriaEmpleoDTO();
		dto=(FeriaEmpleoDTO)logService.setValues(dto, "FeriaEmpleo", "baja", "FeriaEmpleoServiceImpl");
		
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
	 * Nombre del metodo: 	Consulta de FeriaEmpleo
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de FeriaEmpleo
	 * Entrada:				FeriaEmpleoDTO
	 * Salida:				List<FeriaEmpleoDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Consulta_FeriaEmpleo_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<FeriaEmpleoDTO> consulta(FeriaEmpleoDTO dto) {
		FeriaEmpleoDTO out = new FeriaEmpleoDTO();
		List<FeriaEmpleoDTO> list = new ArrayList<FeriaEmpleoDTO>();
		
		dto=(FeriaEmpleoDTO)logService.setValues(dto, "FeriaEmpleo", "consulta", "FeriaEmpleoServiceImpl");
		
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
	 * Nombre del metodo: 	Consulta de FeriaEmpleo por Id
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de FeriaEmpleo por Id
	 * Entrada:				FeriaEmpleoDTO
	 * Salida:				List<FeriaEmpleoDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_ConsultaId_FeriaEmpleo_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<FeriaEmpleoDTO> consultaId(FeriaEmpleoDTO dto) {
		FeriaEmpleoDTO out = new FeriaEmpleoDTO();
		List<FeriaEmpleoDTO> list = new ArrayList<FeriaEmpleoDTO>();
		
		dto=(FeriaEmpleoDTO)logService.setValues(dto, "FeriaEmpleo", "consultaId", "FeriaEmpleoServiceImpl");
		
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
	 * Nombre del metodo: 	Modificacion de FeriaEmpleo 
	 * Descripcion: 		Metodo que implementa el servicio para la modificacion de FeriaEmpleo
	 * Entrada/Salida:		FeriaEmpleoDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Modifificacion_FeriaEmpleo_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public FeriaEmpleoDTO modificacion(FeriaEmpleoDTO dto) {
		FeriaEmpleoDTO out = new FeriaEmpleoDTO();
		dto=(FeriaEmpleoDTO)logService.setValues(dto, "FeriaEmpleo", "modificacion", "FeriaEmpleoServiceImpl");
		
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

