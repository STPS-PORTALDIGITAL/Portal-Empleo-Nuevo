package stps.gob.mx.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.dto.CandidatoOfertaFeriasEmpleoDTO;


@Service
public class CandidatoOfertaFeriasEmpleoServiceImpl implements  CandidatoOfertaFeriasEmpleoService{

	@Autowired
	LogService logService;

	/********************************************************************************************************
	 * Nombre del metodo: 	Alta de CandidatoOfertaFeriasEmpleo
	 * Descripcion: 		Metodo que implementa el servicio para el alta de CandidatoOfertaFeriasEmpleo
	 * Entrada/Salida:		CandidatoOfertaFeriasEmpleoDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Alta_CandidatoOfertaFeriasEmpleo_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public CandidatoOfertaFeriasEmpleoDTO alta(CandidatoOfertaFeriasEmpleoDTO dto) {

		dto=(CandidatoOfertaFeriasEmpleoDTO)logService.setValues(dto, "CandidatoOfertaFeriasEmpleo", "alta", "CandidatoOfertaFeriasEmpleoServiceImpl");
		
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
	 * Nombre del metodo: 	Baja de CandidatoOfertaFeriasEmpleo
	 * Descripcion: 		Metodo que implementa el servicio para la baja de CandidatoOfertaFeriasEmpleo
	 * Entrada/Salida:		CandidatoOfertaFeriasEmpleoDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Baja_CandidatoOfertaFeriasEmpleo_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public CandidatoOfertaFeriasEmpleoDTO baja(CandidatoOfertaFeriasEmpleoDTO dto) {
		CandidatoOfertaFeriasEmpleoDTO out = new CandidatoOfertaFeriasEmpleoDTO();
		dto=(CandidatoOfertaFeriasEmpleoDTO)logService.setValues(dto, "CandidatoOfertaFeriasEmpleo", "baja", "CandidatoOfertaFeriasEmpleoServiceImpl");
		
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
	 * Nombre del metodo: 	Consulta de CandidatoOfertaFeriasEmpleo
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de CandidatoOfertaFeriasEmpleo
	 * Entrada:				CandidatoOfertaFeriasEmpleoDTO
	 * Salida:				List<CandidatoOfertaFeriasEmpleoDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Consulta_CandidatoOfertaFeriasEmpleo_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<CandidatoOfertaFeriasEmpleoDTO> consulta(CandidatoOfertaFeriasEmpleoDTO dto) {
		CandidatoOfertaFeriasEmpleoDTO out = new CandidatoOfertaFeriasEmpleoDTO();
		List<CandidatoOfertaFeriasEmpleoDTO> list = new ArrayList<CandidatoOfertaFeriasEmpleoDTO>();
		
		dto=(CandidatoOfertaFeriasEmpleoDTO)logService.setValues(dto, "CandidatoOfertaFeriasEmpleo", "consulta", "CandidatoOfertaFeriasEmpleoServiceImpl");
		
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
	 * Nombre del metodo: 	Consulta de CandidatoOfertaFeriasEmpleo por Id
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de CandidatoOfertaFeriasEmpleo por Id
	 * Entrada:				CandidatoOfertaFeriasEmpleoDTO
	 * Salida:				List<CandidatoOfertaFeriasEmpleoDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_ConsultaId_CandidatoOfertaFeriasEmpleo_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<CandidatoOfertaFeriasEmpleoDTO> consultaId(CandidatoOfertaFeriasEmpleoDTO dto) {
		CandidatoOfertaFeriasEmpleoDTO out = new CandidatoOfertaFeriasEmpleoDTO();
		List<CandidatoOfertaFeriasEmpleoDTO> list = new ArrayList<CandidatoOfertaFeriasEmpleoDTO>();
		
		dto=(CandidatoOfertaFeriasEmpleoDTO)logService.setValues(dto, "CandidatoOfertaFeriasEmpleo", "consultaId", "CandidatoOfertaFeriasEmpleoServiceImpl");
		
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
	 * Nombre del metodo: 	Modificacion de CandidatoOfertaFeriasEmpleo 
	 * Descripcion: 		Metodo que implementa el servicio para la modificacion de CandidatoOfertaFeriasEmpleo
	 * Entrada/Salida:		CandidatoOfertaFeriasEmpleoDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Modifificacion_CandidatoOfertaFeriasEmpleo_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public CandidatoOfertaFeriasEmpleoDTO modificacion(CandidatoOfertaFeriasEmpleoDTO dto) {
		CandidatoOfertaFeriasEmpleoDTO out = new CandidatoOfertaFeriasEmpleoDTO();
		dto=(CandidatoOfertaFeriasEmpleoDTO)logService.setValues(dto, "CandidatoOfertaFeriasEmpleo", "modificacion", "CandidatoOfertaFeriasEmpleoServiceImpl");
		
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

