package stps.gob.mx.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.dto.ImagenStandDTO;


@Service
public class ImagenStandServiceImpl implements  ImagenStandService{

	@Autowired
	LogService logService;

	/********************************************************************************************************
	 * Nombre del metodo: 	Alta de ImagenStand
	 * Descripcion: 		Metodo que implementa el servicio para el alta de ImagenStand
	 * Entrada/Salida:		ImagenStandDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Alta_ImagenStand_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public ImagenStandDTO alta(ImagenStandDTO dto) {

		dto=(ImagenStandDTO)logService.setValues(dto, "ImagenStand", "alta", "ImagenStandServiceImpl");
		
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
	 * Nombre del metodo: 	Baja de ImagenStand
	 * Descripcion: 		Metodo que implementa el servicio para la baja de ImagenStand
	 * Entrada/Salida:		ImagenStandDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Baja_ImagenStand_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public ImagenStandDTO baja(ImagenStandDTO dto) {
		ImagenStandDTO out = new ImagenStandDTO();
		dto=(ImagenStandDTO)logService.setValues(dto, "ImagenStand", "baja", "ImagenStandServiceImpl");
		
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
	 * Nombre del metodo: 	Consulta de ImagenStand
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de ImagenStand
	 * Entrada:				ImagenStandDTO
	 * Salida:				List<ImagenStandDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Consulta_ImagenStand_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<ImagenStandDTO> consulta(ImagenStandDTO dto) {
		ImagenStandDTO out = new ImagenStandDTO();
		List<ImagenStandDTO> list = new ArrayList<ImagenStandDTO>();
		
		dto=(ImagenStandDTO)logService.setValues(dto, "ImagenStand", "consulta", "ImagenStandServiceImpl");
		
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
	 * Nombre del metodo: 	Consulta de ImagenStand por Id
	 * Descripcion: 		Metodo que implementa el servicio para la consulta de ImagenStand por Id
	 * Entrada:				ImagenStandDTO
	 * Salida:				List<ImagenStandDTO>
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_ConsultaId_ImagenStand_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public List<ImagenStandDTO> consultaId(ImagenStandDTO dto) {
		ImagenStandDTO out = new ImagenStandDTO();
		List<ImagenStandDTO> list = new ArrayList<ImagenStandDTO>();
		
		dto=(ImagenStandDTO)logService.setValues(dto, "ImagenStand", "consultaId", "ImagenStandServiceImpl");
		
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
	 * Nombre del metodo: 	Modificacion de ImagenStand 
	 * Descripcion: 		Metodo que implementa el servicio para la modificacion de ImagenStand
	 * Entrada/Salida:		ImagenStandDTO
	 * Autor:				JDGR
	 * Fecha:				09/Jun/2020
	 * Contrato:			Contrato_Modifificacion_ImagenStand_V01.docx
	 * --------------------------------H I S T O R I C O----------------------------------------------------
	 * FECHA			VERSION			AUTOR			COMENTARIOS
	 * 09/Jun/2020		1.0001			JDGR			Baseline
	 * 
	 ********************************************************************************************************/
	@Override
	public ImagenStandDTO modificacion(ImagenStandDTO dto) {
		ImagenStandDTO out = new ImagenStandDTO();
		dto=(ImagenStandDTO)logService.setValues(dto, "ImagenStand", "modificacion", "ImagenStandServiceImpl");
		
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

