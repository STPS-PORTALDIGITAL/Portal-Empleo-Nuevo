package stps.gob.mx.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.dto.OfertaFeriaEmpleoDTO;


@Service
public class OfertaFeriaEmpleoServiceImpl implements  OfertaFeriaEmpleoService{

	@Autowired
	LogService logService;

	/********************************************************************************************************
	 * Nombre del metodo: 	Alta de OfertaFeriaEmpleo
	 * Descripcion: 		Metodo que implementa el servicio para el alta de OfertaFeriaEmpleo
	 * Entrada/Salida:		OfertaFeriaEmpleoDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Alta_OfertaFeriaEmpleo_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public OfertaFeriaEmpleoDTO alta(OfertaFeriaEmpleoDTO dto) {

		dto=(OfertaFeriaEmpleoDTO)logService.setValues(dto, "OfertaFeriaEmpleo", "alta", "OfertaFeriaEmpleoServiceImpl");
		
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
	 * Nombre del metodo: 	Baja de OfertaFeriaEmpleo
	 * Descripcion: 		Metodo que implementa el servicio para la baja de OfertaFeriaEmpleo
	 * Entrada/Salida:		OfertaFeriaEmpleoDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Baja_OfertaFeriaEmpleo_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public OfertaFeriaEmpleoDTO baja(OfertaFeriaEmpleoDTO dto) {
		OfertaFeriaEmpleoDTO out = new OfertaFeriaEmpleoDTO();
		dto=(OfertaFeriaEmpleoDTO)logService.setValues(dto, "OfertaFeriaEmpleo", "baja", "OfertaFeriaEmpleoServiceImpl");
		
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
	 * Nombre del metodo: 	Consulta de OfertaFeriaEmpleo
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de OfertaFeriaEmpleo
	 * Entrada:				OfertaFeriaEmpleoDTO
	 * Salida:				List<OfertaFeriaEmpleoDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Consulta_OfertaFeriaEmpleo_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<OfertaFeriaEmpleoDTO> consulta(OfertaFeriaEmpleoDTO dto) {
		OfertaFeriaEmpleoDTO out = new OfertaFeriaEmpleoDTO();
		List<OfertaFeriaEmpleoDTO> list = new ArrayList<OfertaFeriaEmpleoDTO>();
		
		dto=(OfertaFeriaEmpleoDTO)logService.setValues(dto, "OfertaFeriaEmpleo", "consulta", "OfertaFeriaEmpleoServiceImpl");
		
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
	 * Nombre del metodo: 	Consulta de OfertaFeriaEmpleo por Id
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de OfertaFeriaEmpleo por Id
	 * Entrada:				OfertaFeriaEmpleoDTO
	 * Salida:				List<OfertaFeriaEmpleoDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_ConsultaId_OfertaFeriaEmpleo_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<OfertaFeriaEmpleoDTO> consultaId(OfertaFeriaEmpleoDTO dto) {
		OfertaFeriaEmpleoDTO out = new OfertaFeriaEmpleoDTO();
		List<OfertaFeriaEmpleoDTO> list = new ArrayList<OfertaFeriaEmpleoDTO>();
		
		dto=(OfertaFeriaEmpleoDTO)logService.setValues(dto, "OfertaFeriaEmpleo", "consultaId", "OfertaFeriaEmpleoServiceImpl");
		
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
	 * Nombre del metodo: 	Modificacion de OfertaFeriaEmpleo 
	 * Descripcion: 		Metodo que implementa el servicio para la modificacion de OfertaFeriaEmpleo
	 * Entrada/Salida:		OfertaFeriaEmpleoDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Modifificacion_OfertaFeriaEmpleo_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public OfertaFeriaEmpleoDTO modificacion(OfertaFeriaEmpleoDTO dto) {
		OfertaFeriaEmpleoDTO out = new OfertaFeriaEmpleoDTO();
		dto=(OfertaFeriaEmpleoDTO)logService.setValues(dto, "OfertaFeriaEmpleo", "modificacion", "OfertaFeriaEmpleoServiceImpl");
		
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

