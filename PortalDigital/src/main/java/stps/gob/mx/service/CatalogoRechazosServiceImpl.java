package stps.gob.mx.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.dto.CatalogoRechazosDTO;


@Service
public class CatalogoRechazosServiceImpl implements  CatalogoRechazosService{

	@Autowired
	LogService logService;

	/********************************************************************************************************
	 * Nombre del metodo: 	Alta de CatalogoRechazos
	 * Descripcion: 		Metodo que implementa el servicio para el alta de CatalogoRechazos
	 * Entrada/Salida:		CatalogoRechazosDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Alta_CatalogoRechazos_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public CatalogoRechazosDTO alta(CatalogoRechazosDTO dto) {

		dto=(CatalogoRechazosDTO)logService.setValues(dto, "CatalogoRechazos", "alta", "CatalogoRechazosServiceImpl");
		
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
	 * Nombre del metodo: 	Baja de CatalogoRechazos
	 * Descripcion: 		Metodo que implementa el servicio para la baja de CatalogoRechazos
	 * Entrada/Salida:		CatalogoRechazosDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Baja_CatalogoRechazos_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public CatalogoRechazosDTO baja(CatalogoRechazosDTO dto) {
		CatalogoRechazosDTO out = new CatalogoRechazosDTO();
		dto=(CatalogoRechazosDTO)logService.setValues(dto, "CatalogoRechazos", "baja", "CatalogoRechazosServiceImpl");
		
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
	 * Nombre del metodo: 	Consulta de CatalogoRechazos
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de CatalogoRechazos
	 * Entrada:				CatalogoRechazosDTO
	 * Salida:				List<CatalogoRechazosDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Consulta_CatalogoRechazos_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<CatalogoRechazosDTO> consulta(CatalogoRechazosDTO dto) {
		CatalogoRechazosDTO out = new CatalogoRechazosDTO();
		List<CatalogoRechazosDTO> list = new ArrayList<CatalogoRechazosDTO>();
		
		dto=(CatalogoRechazosDTO)logService.setValues(dto, "CatalogoRechazos", "consulta", "CatalogoRechazosServiceImpl");
		
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
	 * Nombre del metodo: 	Consulta de CatalogoRechazos por Id
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de CatalogoRechazos por Id
	 * Entrada:				CatalogoRechazosDTO
	 * Salida:				List<CatalogoRechazosDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_ConsultaId_CatalogoRechazos_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<CatalogoRechazosDTO> consultaId(CatalogoRechazosDTO dto) {
		CatalogoRechazosDTO out = new CatalogoRechazosDTO();
		List<CatalogoRechazosDTO> list = new ArrayList<CatalogoRechazosDTO>();
		
		dto=(CatalogoRechazosDTO)logService.setValues(dto, "CatalogoRechazos", "consultaId", "CatalogoRechazosServiceImpl");
		
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
	 * Nombre del metodo: 	Modificacion de CatalogoRechazos 
	 * Descripcion: 		Metodo que implementa el servicio para la modificacion de CatalogoRechazos
	 * Entrada/Salida:		CatalogoRechazosDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Modifificacion_CatalogoRechazos_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public CatalogoRechazosDTO modificacion(CatalogoRechazosDTO dto) {
		CatalogoRechazosDTO out = new CatalogoRechazosDTO();
		dto=(CatalogoRechazosDTO)logService.setValues(dto, "CatalogoRechazos", "modificacion", "CatalogoRechazosServiceImpl");
		
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

