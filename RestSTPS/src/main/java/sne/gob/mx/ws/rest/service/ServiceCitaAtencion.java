package sne.gob.mx.ws.rest.service;

import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import sne.gob.mx.general.services.LogService;
import sne.gob.mx.portal.service.impl.CitaAtencionServiceImpl;
import sne.gob.mx.ws.rest.vo.CitaAtencionRequestVO;
import sne.gob.mx.ws.rest.vo.CitaAtencionResponseVO;


@Path("/CitaAtencion")
public class ServiceCitaAtencion {
final static Logger log = Logger.getLogger(ServiceCitaAtencion.class);



/************************************************************************************
 * NOMBRE:			Alta de CitaAtencion
 * DESCRIPCIÓN:		Método que provee el alta de una CitaAtencion
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla CitaAtencion es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/alta")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public CitaAtencionResponseVO alta(CitaAtencionRequestVO vo) {
	CitaAtencionResponseVO 	out 			= new CitaAtencionResponseVO();
	CitaAtencionServiceImpl	citaAtencion 	= new CitaAtencionServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (CitaAtencionRequestVO)logService.setValues(vo, "CitaAtencion", "alta", "ServiceCitaAtencion.class");
	try {
			out=(CitaAtencionResponseVO)citaAtencion.alta(vo);
	}catch(Exception e) {	
		logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Baja de CitaAtencion
 * DESCRIPCIÓN:		Método que provee la baja de una CitaAtencion
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 23/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla CitaAtencion es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/baja")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public CitaAtencionResponseVO baja(CitaAtencionRequestVO vo) {
	CitaAtencionResponseVO 	out 			= new CitaAtencionResponseVO();
	CitaAtencionServiceImpl	citaAtencion 	= new CitaAtencionServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (CitaAtencionRequestVO)logService.setValues(vo, "CitaAtencion", "baja", "ServiceCitaAtencion.class");
	try {
		    out=(CitaAtencionResponseVO)citaAtencion.baja(vo);	
	}catch(Exception e) {
		out = (CitaAtencionResponseVO)logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Consulta de CitaAtencion
 * DESCRIPCIÓN:		Método que provee la consulta de una CitaAtencion
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla CitaAtencion es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 *  
 * ***********************************************************************************/
@POST
@Path("/consulta")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public CitaAtencionResponseVO consulta(CitaAtencionRequestVO vo) {
	CitaAtencionResponseVO 	out 			= new CitaAtencionResponseVO();
	CitaAtencionServiceImpl	citaAtencion 	= new CitaAtencionServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (CitaAtencionRequestVO)logService.setValues(vo, "CitaAtencion", "consulta", "ServiceCitaAtencion.class");
	try {
		    out=(CitaAtencionResponseVO)citaAtencion.consulta(vo);	
	}catch(Exception e) {
		out = (CitaAtencionResponseVO)logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Consulta de CitaAtencion
 * DESCRIPCIÓN:		Método que provee la consulta de una CitaAtencion por registro individual
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla CitaAtencion es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/consultaId")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public CitaAtencionResponseVO consultaId(CitaAtencionRequestVO vo) {
	CitaAtencionResponseVO 	out 			= new CitaAtencionResponseVO();
	CitaAtencionServiceImpl	citaAtencion 	= new CitaAtencionServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (CitaAtencionRequestVO)logService.setValues(vo, "CitaAtencion", "consultaId", "ServiceCitaAtencion.class");
	try {
		    out=(CitaAtencionResponseVO)citaAtencion.consultaId(vo);	
	}catch(Exception e) {
		out = (CitaAtencionResponseVO)logService.recordException(e,vo);
	}
	return out;
}



/************************************************************************************
 * NOMBRE:			Modificacion de CitaAtencion
 * DESCRIPCIÓN:		Método que provee la modificacion de una CitaAtencion
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla CitaAtencion es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/modificacion")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public CitaAtencionResponseVO modificacion(CitaAtencionRequestVO vo) {
	CitaAtencionResponseVO 	out 			= new CitaAtencionResponseVO();
	CitaAtencionServiceImpl	citaAtencion 	= new CitaAtencionServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (CitaAtencionRequestVO)logService.setValues(vo, "CitaAtencion", "modificacion", "ServiceCitaAtencion.class");
	try {
		    out=(CitaAtencionResponseVO)citaAtencion.modificacion(vo);	
	}catch(Exception e) {
		out = (CitaAtencionResponseVO)logService.recordException(e,vo);
	}
	return out;
}


}
