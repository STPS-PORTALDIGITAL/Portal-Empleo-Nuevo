package sne.gob.mx.ws.rest.service;

import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import sne.gob.mx.general.services.LogService;
import sne.gob.mx.portal.service.impl.DisponibilidadServiceImpl;
import sne.gob.mx.ws.rest.vo.DisponibilidadRequestVO;
import sne.gob.mx.ws.rest.vo.DisponibilidadResponseVO;


@Path("/Disponibilidad")
public class ServiceDisponibilidad {
final static Logger log = Logger.getLogger(ServiceDisponibilidad.class);



/************************************************************************************
 * NOMBRE:			Alta de Disponibilidad
 * DESCRIPCIÓN:		Método que provee el alta de una Disponibilidad
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Disponibilidad es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/alta")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public DisponibilidadResponseVO alta(DisponibilidadRequestVO vo) {
	DisponibilidadResponseVO 	out 			= new DisponibilidadResponseVO();
	DisponibilidadServiceImpl	Disponibilidad 	= new DisponibilidadServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (DisponibilidadRequestVO)logService.setValues(vo, "Disponibilidad", "alta", "ServiceDisponibilidad.class");
	try {
			out=(DisponibilidadResponseVO)Disponibilidad.alta(vo);
	}catch(Exception e) {	
		logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Baja de Disponibilidad
 * DESCRIPCIÓN:		Método que provee la baja de una Disponibilidad
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 23/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Disponibilidad es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/baja")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public DisponibilidadResponseVO baja(DisponibilidadRequestVO vo) {
	DisponibilidadResponseVO 	out 			= new DisponibilidadResponseVO();
	DisponibilidadServiceImpl	Disponibilidad 	= new DisponibilidadServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (DisponibilidadRequestVO)logService.setValues(vo, "Disponibilidad", "baja", "ServiceDisponibilidad.class");
	try {
		    out=(DisponibilidadResponseVO)Disponibilidad.baja(vo);	
	}catch(Exception e) {
		out = (DisponibilidadResponseVO)logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Consulta de Disponibilidad
 * DESCRIPCIÓN:		Método que provee la consulta de una Disponibilidad
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Disponibilidad es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 *  
 * ***********************************************************************************/
@POST
@Path("/consulta")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public DisponibilidadResponseVO consulta(DisponibilidadRequestVO vo) {
	DisponibilidadResponseVO 	out 			= new DisponibilidadResponseVO();
	DisponibilidadServiceImpl	Disponibilidad 	= new DisponibilidadServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (DisponibilidadRequestVO)logService.setValues(vo, "Disponibilidad", "consulta", "ServiceDisponibilidad.class");
	try {
		    out=(DisponibilidadResponseVO)Disponibilidad.consulta(vo);	
	}catch(Exception e) {
		out = (DisponibilidadResponseVO)logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Consulta de Disponibilidad
 * DESCRIPCIÓN:		Método que provee la consulta de una Disponibilidad por registro individual
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Disponibilidad es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/consultaId")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public DisponibilidadResponseVO consultaId(DisponibilidadRequestVO vo) {
	DisponibilidadResponseVO 	out 			= new DisponibilidadResponseVO();
	DisponibilidadServiceImpl	Disponibilidad 	= new DisponibilidadServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (DisponibilidadRequestVO)logService.setValues(vo, "Disponibilidad", "consultaId", "ServiceDisponibilidad.class");
	try {
		    out=(DisponibilidadResponseVO)Disponibilidad.consultaId(vo);	
	}catch(Exception e) {
		out = (DisponibilidadResponseVO)logService.recordException(e,vo);
	}
	return out;
}



/************************************************************************************
 * NOMBRE:			Modificacion de Disponibilidad
 * DESCRIPCIÓN:		Método que provee la modificacion de una Disponibilidad
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Disponibilidad es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/modificacion")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public DisponibilidadResponseVO modificacion(DisponibilidadRequestVO vo) {
	DisponibilidadResponseVO 	out 			= new DisponibilidadResponseVO();
	DisponibilidadServiceImpl	Disponibilidad 	= new DisponibilidadServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (DisponibilidadRequestVO)logService.setValues(vo, "Disponibilidad", "modificacion", "ServiceDisponibilidad.class");
	try {
		    out=(DisponibilidadResponseVO)Disponibilidad.modificacion(vo);	
	}catch(Exception e) {
		out = (DisponibilidadResponseVO)logService.recordException(e,vo);
	}
	return out;
}


}
