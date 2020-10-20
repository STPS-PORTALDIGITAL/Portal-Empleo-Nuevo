package sne.gob.mx.ws.rest.service;

import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import sne.gob.mx.general.services.LogService;
import sne.gob.mx.portal.service.impl.SeguimientoServiceImpl;
import sne.gob.mx.ws.rest.vo.SeguimientoRequestVO;
import sne.gob.mx.ws.rest.vo.SeguimientoResponseVO;


@Path("/Seguimiento")
public class ServiceSeguimiento {
final static Logger log = Logger.getLogger(ServiceSeguimiento.class);



/************************************************************************************
 * NOMBRE:			Alta de Seguimiento
 * DESCRIPCIÓN:		Método que provee el alta de una Seguimiento
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Seguimiento es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/alta")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public SeguimientoResponseVO alta(SeguimientoRequestVO vo) {
	SeguimientoResponseVO 	out 			= new SeguimientoResponseVO();
	SeguimientoServiceImpl	Seguimiento 	= new SeguimientoServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (SeguimientoRequestVO)logService.setValues(vo, "Seguimiento", "alta", "ServiceSeguimiento.class");
	try {
			out=(SeguimientoResponseVO)Seguimiento.alta(vo);
	}catch(Exception e) {	
		logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Baja de Seguimiento
 * DESCRIPCIÓN:		Método que provee la baja de una Seguimiento
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 23/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Seguimiento es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/baja")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public SeguimientoResponseVO baja(SeguimientoRequestVO vo) {
	SeguimientoResponseVO 	out 			= new SeguimientoResponseVO();
	SeguimientoServiceImpl	Seguimiento 	= new SeguimientoServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (SeguimientoRequestVO)logService.setValues(vo, "Seguimiento", "baja", "ServiceSeguimiento.class");
	try {
		    out=(SeguimientoResponseVO)Seguimiento.baja(vo);	
	}catch(Exception e) {
		out = (SeguimientoResponseVO)logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Consulta de Seguimiento
 * DESCRIPCIÓN:		Método que provee la consulta de una Seguimiento
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Seguimiento es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 *  
 * ***********************************************************************************/
@POST
@Path("/consulta")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public SeguimientoResponseVO consulta(SeguimientoRequestVO vo) {
	SeguimientoResponseVO 	out 			= new SeguimientoResponseVO();
	SeguimientoServiceImpl	Seguimiento 	= new SeguimientoServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (SeguimientoRequestVO)logService.setValues(vo, "Seguimiento", "consulta", "ServiceSeguimiento.class");
	try {
		    out=(SeguimientoResponseVO)Seguimiento.consulta(vo);	
	}catch(Exception e) {
		out = (SeguimientoResponseVO)logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Consulta de Seguimiento
 * DESCRIPCIÓN:		Método que provee la consulta de una Seguimiento por registro individual
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Seguimiento es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/consultaId")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public SeguimientoResponseVO consultaId(SeguimientoRequestVO vo) {
	SeguimientoResponseVO 	out 			= new SeguimientoResponseVO();
	SeguimientoServiceImpl	Seguimiento 	= new SeguimientoServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (SeguimientoRequestVO)logService.setValues(vo, "Seguimiento", "consultaId", "ServiceSeguimiento.class");
	try {
		    out=(SeguimientoResponseVO)Seguimiento.consultaId(vo);	
	}catch(Exception e) {
		out = (SeguimientoResponseVO)logService.recordException(e,vo);
	}
	return out;
}



/************************************************************************************
 * NOMBRE:			Modificacion de Seguimiento
 * DESCRIPCIÓN:		Método que provee la modificacion de una Seguimiento
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Seguimiento es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/modificacion")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public SeguimientoResponseVO modificacion(SeguimientoRequestVO vo) {
	SeguimientoResponseVO 	out 			= new SeguimientoResponseVO();
	SeguimientoServiceImpl	Seguimiento 	= new SeguimientoServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (SeguimientoRequestVO)logService.setValues(vo, "Seguimiento", "modificacion", "ServiceSeguimiento.class");
	try {
		    out=(SeguimientoResponseVO)Seguimiento.modificacion(vo);	
	}catch(Exception e) {
		out = (SeguimientoResponseVO)logService.recordException(e,vo);
	}
	return out;
}


}
