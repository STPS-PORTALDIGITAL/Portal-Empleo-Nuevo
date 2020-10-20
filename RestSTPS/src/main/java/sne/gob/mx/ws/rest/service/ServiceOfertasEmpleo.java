package sne.gob.mx.ws.rest.service;

import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import sne.gob.mx.general.services.LogService;
import sne.gob.mx.portal.service.impl.OfertasEmpleoServiceImpl;
import sne.gob.mx.ws.rest.vo.OfertasEmpleoRequestVO;
import sne.gob.mx.ws.rest.vo.OfertasEmpleoResponseVO;


@Path("/OfertasEmpleo")
public class ServiceOfertasEmpleo {
final static Logger log = Logger.getLogger(ServiceOfertasEmpleo.class);



/************************************************************************************
 * NOMBRE:			Alta de OfertasEmpleo
 * DESCRIPCIÓN:		Método que provee el alta de una OfertasEmpleo
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla OfertasEmpleo es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/alta")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public OfertasEmpleoResponseVO alta(OfertasEmpleoRequestVO vo) {
	OfertasEmpleoResponseVO 	out 			= new OfertasEmpleoResponseVO();
	OfertasEmpleoServiceImpl	OfertasEmpleo 	= new OfertasEmpleoServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (OfertasEmpleoRequestVO)logService.setValues(vo, "OfertasEmpleo", "alta", "ServiceOfertasEmpleo.class");
	try {
			out=(OfertasEmpleoResponseVO)OfertasEmpleo.alta(vo);
	}catch(Exception e) {	
		logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Baja de OfertasEmpleo
 * DESCRIPCIÓN:		Método que provee la baja de una OfertasEmpleo
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 23/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla OfertasEmpleo es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/baja")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public OfertasEmpleoResponseVO baja(OfertasEmpleoRequestVO vo) {
	OfertasEmpleoResponseVO 	out 			= new OfertasEmpleoResponseVO();
	OfertasEmpleoServiceImpl	OfertasEmpleo 	= new OfertasEmpleoServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (OfertasEmpleoRequestVO)logService.setValues(vo, "OfertasEmpleo", "baja", "ServiceOfertasEmpleo.class");
	try {
		    out=(OfertasEmpleoResponseVO)OfertasEmpleo.baja(vo);	
	}catch(Exception e) {
		out = (OfertasEmpleoResponseVO)logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Consulta de OfertasEmpleo
 * DESCRIPCIÓN:		Método que provee la consulta de una OfertasEmpleo
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla OfertasEmpleo es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 *  
 * ***********************************************************************************/
@POST
@Path("/consulta")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public OfertasEmpleoResponseVO consulta(OfertasEmpleoRequestVO vo) {
	OfertasEmpleoResponseVO 	out 			= new OfertasEmpleoResponseVO();
	OfertasEmpleoServiceImpl	OfertasEmpleo 	= new OfertasEmpleoServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (OfertasEmpleoRequestVO)logService.setValues(vo, "OfertasEmpleo", "consulta", "ServiceOfertasEmpleo.class");
	try {
		    out=(OfertasEmpleoResponseVO)OfertasEmpleo.consulta(vo);	
	}catch(Exception e) {
		out = (OfertasEmpleoResponseVO)logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Consulta de OfertasEmpleo
 * DESCRIPCIÓN:		Método que provee la consulta de una OfertasEmpleo por registro individual
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla OfertasEmpleo es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/consultaId")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public OfertasEmpleoResponseVO consultaId(OfertasEmpleoRequestVO vo) {
	OfertasEmpleoResponseVO 	out 			= new OfertasEmpleoResponseVO();
	OfertasEmpleoServiceImpl	OfertasEmpleo 	= new OfertasEmpleoServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (OfertasEmpleoRequestVO)logService.setValues(vo, "OfertasEmpleo", "consultaId", "ServiceOfertasEmpleo.class");
	try {
		    out=(OfertasEmpleoResponseVO)OfertasEmpleo.consultaId(vo);	
	}catch(Exception e) {
		out = (OfertasEmpleoResponseVO)logService.recordException(e,vo);
	}
	return out;
}



/************************************************************************************
 * NOMBRE:			Modificacion de OfertasEmpleo
 * DESCRIPCIÓN:		Método que provee la modificacion de una OfertasEmpleo
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla OfertasEmpleo es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/modificacion")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public OfertasEmpleoResponseVO modificacion(OfertasEmpleoRequestVO vo) {
	OfertasEmpleoResponseVO 	out 			= new OfertasEmpleoResponseVO();
	OfertasEmpleoServiceImpl	OfertasEmpleo 	= new OfertasEmpleoServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (OfertasEmpleoRequestVO)logService.setValues(vo, "OfertasEmpleo", "modificacion", "ServiceOfertasEmpleo.class");
	try {
		    out=(OfertasEmpleoResponseVO)OfertasEmpleo.modificacion(vo);	
	}catch(Exception e) {
		out = (OfertasEmpleoResponseVO)logService.recordException(e,vo);
	}
	return out;
}


}
