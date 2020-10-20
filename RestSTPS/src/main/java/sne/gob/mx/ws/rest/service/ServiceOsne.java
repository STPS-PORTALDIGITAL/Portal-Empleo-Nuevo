package sne.gob.mx.ws.rest.service;

import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import sne.gob.mx.general.services.LogService;
import sne.gob.mx.portal.service.impl.OsneServiceImpl;
import sne.gob.mx.ws.rest.vo.OsneRequestVO;
import sne.gob.mx.ws.rest.vo.OsneResponseVO;


@Path("/Osne")
public class ServiceOsne {
final static Logger log = Logger.getLogger(ServiceOsne.class);



/************************************************************************************
 * NOMBRE:			Alta de Osne
 * DESCRIPCIÓN:		Método que provee el alta de una Osne
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Osne es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/alta")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public OsneResponseVO alta(OsneRequestVO vo) {
	OsneResponseVO 	out 			= new OsneResponseVO();
	OsneServiceImpl	Osne 	= new OsneServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (OsneRequestVO)logService.setValues(vo, "Osne", "alta", "ServiceOsne.class");
	try {
			out=(OsneResponseVO)Osne.alta(vo);
	}catch(Exception e) {	
		logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Baja de Osne
 * DESCRIPCIÓN:		Método que provee la baja de una Osne
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 23/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Osne es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/baja")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public OsneResponseVO baja(OsneRequestVO vo) {
	OsneResponseVO 	out 			= new OsneResponseVO();
	OsneServiceImpl	Osne 	= new OsneServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (OsneRequestVO)logService.setValues(vo, "Osne", "baja", "ServiceOsne.class");
	try {
		    out=(OsneResponseVO)Osne.baja(vo);	
	}catch(Exception e) {
		out = (OsneResponseVO)logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Consulta de Osne
 * DESCRIPCIÓN:		Método que provee la consulta de una Osne
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Osne es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 *  
 * ***********************************************************************************/
@POST
@Path("/consulta")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public OsneResponseVO consulta(OsneRequestVO vo) {
	OsneResponseVO 	out 			= new OsneResponseVO();
	OsneServiceImpl	Osne 	= new OsneServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (OsneRequestVO)logService.setValues(vo, "Osne", "consulta", "ServiceOsne.class");
	try {
		    out=(OsneResponseVO)Osne.consulta(vo);	
	}catch(Exception e) {
		out = (OsneResponseVO)logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Consulta de Osne
 * DESCRIPCIÓN:		Método que provee la consulta de una Osne por registro individual
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Osne es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/consultaId")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public OsneResponseVO consultaId(OsneRequestVO vo) {
	OsneResponseVO 	out 			= new OsneResponseVO();
	OsneServiceImpl	Osne 	= new OsneServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (OsneRequestVO)logService.setValues(vo, "Osne", "consultaId", "ServiceOsne.class");
	try {
		    out=(OsneResponseVO)Osne.consultaId(vo);	
	}catch(Exception e) {
		out = (OsneResponseVO)logService.recordException(e,vo);
	}
	return out;
}



/************************************************************************************
 * NOMBRE:			Modificacion de Osne
 * DESCRIPCIÓN:		Método que provee la modificacion de una Osne
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Osne es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/modificacion")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public OsneResponseVO modificacion(OsneRequestVO vo) {
	OsneResponseVO 	out 			= new OsneResponseVO();
	OsneServiceImpl	Osne 	= new OsneServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (OsneRequestVO)logService.setValues(vo, "Osne", "modificacion", "ServiceOsne.class");
	try {
		    out=(OsneResponseVO)Osne.modificacion(vo);	
	}catch(Exception e) {
		out = (OsneResponseVO)logService.recordException(e,vo);
	}
	return out;
}


}
