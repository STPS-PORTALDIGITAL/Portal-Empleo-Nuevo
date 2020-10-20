package sne.gob.mx.ws.rest.service;

import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import sne.gob.mx.general.services.LogService;
import sne.gob.mx.portal.service.impl.GeneracionFoliosServiceImpl;
import sne.gob.mx.ws.rest.vo.GeneracionFoliosRequestVO;
import sne.gob.mx.ws.rest.vo.GeneracionFoliosResponseVO;


@Path("/GeneracionFolios")
public class ServiceGeneracionFolios {
final static Logger log = Logger.getLogger(ServiceGeneracionFolios.class);



/************************************************************************************
 * NOMBRE:			Alta de GeneracionFolios
 * DESCRIPCIÓN:		Método que provee el alta de una GeneracionFolios
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla GeneracionFolios es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/alta")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public GeneracionFoliosResponseVO alta(GeneracionFoliosRequestVO vo) {
	GeneracionFoliosResponseVO 	out 			= new GeneracionFoliosResponseVO();
	GeneracionFoliosServiceImpl	GeneracionFolios 	= new GeneracionFoliosServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (GeneracionFoliosRequestVO)logService.setValues(vo, "GeneracionFolios", "alta", "ServiceGeneracionFolios.class");
	try {
			out=(GeneracionFoliosResponseVO)GeneracionFolios.alta(vo);
	}catch(Exception e) {	
		logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Baja de GeneracionFolios
 * DESCRIPCIÓN:		Método que provee la baja de una GeneracionFolios
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 23/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla GeneracionFolios es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/baja")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public GeneracionFoliosResponseVO baja(GeneracionFoliosRequestVO vo) {
	GeneracionFoliosResponseVO 	out 			= new GeneracionFoliosResponseVO();
	GeneracionFoliosServiceImpl	GeneracionFolios 	= new GeneracionFoliosServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (GeneracionFoliosRequestVO)logService.setValues(vo, "GeneracionFolios", "baja", "ServiceGeneracionFolios.class");
	try {
		    out=(GeneracionFoliosResponseVO)GeneracionFolios.baja(vo);	
	}catch(Exception e) {
		out = (GeneracionFoliosResponseVO)logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Consulta de GeneracionFolios
 * DESCRIPCIÓN:		Método que provee la consulta de una GeneracionFolios
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla GeneracionFolios es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 *  
 * ***********************************************************************************/
@POST
@Path("/consulta")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public GeneracionFoliosResponseVO consulta(GeneracionFoliosRequestVO vo) {
	GeneracionFoliosResponseVO 	out 			= new GeneracionFoliosResponseVO();
	GeneracionFoliosServiceImpl	GeneracionFolios 	= new GeneracionFoliosServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (GeneracionFoliosRequestVO)logService.setValues(vo, "GeneracionFolios", "consulta", "ServiceGeneracionFolios.class");
	try {
		    out=(GeneracionFoliosResponseVO)GeneracionFolios.consulta(vo);	
	}catch(Exception e) {
		out = (GeneracionFoliosResponseVO)logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Consulta de GeneracionFolios
 * DESCRIPCIÓN:		Método que provee la consulta de una GeneracionFolios por registro individual
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla GeneracionFolios es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/consultaId")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public GeneracionFoliosResponseVO consultaId(GeneracionFoliosRequestVO vo) {
	GeneracionFoliosResponseVO 	out 			= new GeneracionFoliosResponseVO();
	GeneracionFoliosServiceImpl	GeneracionFolios 	= new GeneracionFoliosServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (GeneracionFoliosRequestVO)logService.setValues(vo, "GeneracionFolios", "consultaId", "ServiceGeneracionFolios.class");
	try {
		    out=(GeneracionFoliosResponseVO)GeneracionFolios.consultaId(vo);	
	}catch(Exception e) {
		out = (GeneracionFoliosResponseVO)logService.recordException(e,vo);
	}
	return out;
}



/************************************************************************************
 * NOMBRE:			Modificacion de GeneracionFolios
 * DESCRIPCIÓN:		Método que provee la modificacion de una GeneracionFolios
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla GeneracionFolios es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/modificacion")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public GeneracionFoliosResponseVO modificacion(GeneracionFoliosRequestVO vo) {
	GeneracionFoliosResponseVO 	out 			= new GeneracionFoliosResponseVO();
	GeneracionFoliosServiceImpl	GeneracionFolios 	= new GeneracionFoliosServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (GeneracionFoliosRequestVO)logService.setValues(vo, "GeneracionFolios", "modificacion", "ServiceGeneracionFolios.class");
	try {
		    out=(GeneracionFoliosResponseVO)GeneracionFolios.modificacion(vo);	
	}catch(Exception e) {
		out = (GeneracionFoliosResponseVO)logService.recordException(e,vo);
	}
	return out;
}


}
