package sne.gob.mx.ws.rest.service;

import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import sne.gob.mx.general.services.LogService;
import sne.gob.mx.portal.service.impl.NotificacionesServiceImpl;
import sne.gob.mx.ws.rest.vo.NotificacionesRequestVO;
import sne.gob.mx.ws.rest.vo.NotificacionesResponseVO;


@Path("/Notificaciones")
public class ServiceNotificaciones {
final static Logger log = Logger.getLogger(ServiceNotificaciones.class);



/************************************************************************************
 * NOMBRE:			Alta de Notificaciones
 * DESCRIPCIÓN:		Método que provee el alta de una Notificaciones
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Notificaciones es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/alta")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public NotificacionesResponseVO alta(NotificacionesRequestVO vo) {
	NotificacionesResponseVO 	out 			= new NotificacionesResponseVO();
	NotificacionesServiceImpl	Notificaciones 	= new NotificacionesServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (NotificacionesRequestVO)logService.setValues(vo, "Notificaciones", "alta", "ServiceNotificaciones.class");
	try {
			out=(NotificacionesResponseVO)Notificaciones.alta(vo);
	}catch(Exception e) {	
		logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Baja de Notificaciones
 * DESCRIPCIÓN:		Método que provee la baja de una Notificaciones
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 23/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Notificaciones es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/baja")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public NotificacionesResponseVO baja(NotificacionesRequestVO vo) {
	NotificacionesResponseVO 	out 			= new NotificacionesResponseVO();
	NotificacionesServiceImpl	Notificaciones 	= new NotificacionesServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (NotificacionesRequestVO)logService.setValues(vo, "Notificaciones", "baja", "ServiceNotificaciones.class");
	try {
		    out=(NotificacionesResponseVO)Notificaciones.baja(vo);	
	}catch(Exception e) {
		out = (NotificacionesResponseVO)logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Consulta de Notificaciones
 * DESCRIPCIÓN:		Método que provee la consulta de una Notificaciones
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Notificaciones es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 *  
 * ***********************************************************************************/
@POST
@Path("/consulta")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public NotificacionesResponseVO consulta(NotificacionesRequestVO vo) {
	NotificacionesResponseVO 	out 			= new NotificacionesResponseVO();
	NotificacionesServiceImpl	Notificaciones 	= new NotificacionesServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (NotificacionesRequestVO)logService.setValues(vo, "Notificaciones", "consulta", "ServiceNotificaciones.class");
	try {
		    out=(NotificacionesResponseVO)Notificaciones.consulta(vo);	
	}catch(Exception e) {
		out = (NotificacionesResponseVO)logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Consulta de Notificaciones
 * DESCRIPCIÓN:		Método que provee la consulta de una Notificaciones por registro individual
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Notificaciones es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/consultaId")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public NotificacionesResponseVO consultaId(NotificacionesRequestVO vo) {
	NotificacionesResponseVO 	out 			= new NotificacionesResponseVO();
	NotificacionesServiceImpl	Notificaciones 	= new NotificacionesServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (NotificacionesRequestVO)logService.setValues(vo, "Notificaciones", "consultaId", "ServiceNotificaciones.class");
	try {
		    out=(NotificacionesResponseVO)Notificaciones.consultaId(vo);	
	}catch(Exception e) {
		out = (NotificacionesResponseVO)logService.recordException(e,vo);
	}
	return out;
}



/************************************************************************************
 * NOMBRE:			Modificacion de Notificaciones
 * DESCRIPCIÓN:		Método que provee la modificacion de una Notificaciones
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Notificaciones es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/modificacion")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public NotificacionesResponseVO modificacion(NotificacionesRequestVO vo) {
	NotificacionesResponseVO 	out 			= new NotificacionesResponseVO();
	NotificacionesServiceImpl	Notificaciones 	= new NotificacionesServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (NotificacionesRequestVO)logService.setValues(vo, "Notificaciones", "modificacion", "ServiceNotificaciones.class");
	try {
		    out=(NotificacionesResponseVO)Notificaciones.modificacion(vo);	
	}catch(Exception e) {
		out = (NotificacionesResponseVO)logService.recordException(e,vo);
	}
	return out;
}


}
