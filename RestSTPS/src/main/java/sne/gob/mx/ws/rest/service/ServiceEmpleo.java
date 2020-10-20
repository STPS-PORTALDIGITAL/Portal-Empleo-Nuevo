package sne.gob.mx.ws.rest.service;

import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import sne.gob.mx.general.services.LogService;
import sne.gob.mx.portal.service.impl.EmpleoServiceImpl;
import sne.gob.mx.ws.rest.vo.EmpleoRequestVO;
import sne.gob.mx.ws.rest.vo.EmpleoResponseVO;


@Path("/Empleo")
public class ServiceEmpleo {
final static Logger log = Logger.getLogger(ServiceEmpleo.class);



/************************************************************************************
 * NOMBRE:			Alta de Empleo
 * DESCRIPCIÓN:		Método que provee el alta de una Empleo
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Empleo es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/alta")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public EmpleoResponseVO alta(EmpleoRequestVO vo) {
	EmpleoResponseVO 	out 			= new EmpleoResponseVO();
	EmpleoServiceImpl	Empleo 	= new EmpleoServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (EmpleoRequestVO)logService.setValues(vo, "Empleo", "alta", "ServiceEmpleo.class");
	try {
			out=(EmpleoResponseVO)Empleo.alta(vo);
	}catch(Exception e) {	
		logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Baja de Empleo
 * DESCRIPCIÓN:		Método que provee la baja de una Empleo
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 23/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Empleo es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/baja")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public EmpleoResponseVO baja(EmpleoRequestVO vo) {
	EmpleoResponseVO 	out 			= new EmpleoResponseVO();
	EmpleoServiceImpl	Empleo 	= new EmpleoServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (EmpleoRequestVO)logService.setValues(vo, "Empleo", "baja", "ServiceEmpleo.class");
	try {
		    out=(EmpleoResponseVO)Empleo.baja(vo);	
	}catch(Exception e) {
		out = (EmpleoResponseVO)logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Consulta de Empleo
 * DESCRIPCIÓN:		Método que provee la consulta de una Empleo
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Empleo es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 *  
 * ***********************************************************************************/
@POST
@Path("/consulta")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public EmpleoResponseVO consulta(EmpleoRequestVO vo) {
	EmpleoResponseVO 	out 			= new EmpleoResponseVO();
	EmpleoServiceImpl	Empleo 	= new EmpleoServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (EmpleoRequestVO)logService.setValues(vo, "Empleo", "consulta", "ServiceEmpleo.class");
	try {
		    out=(EmpleoResponseVO)Empleo.consulta(vo);	
	}catch(Exception e) {
		out = (EmpleoResponseVO)logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Consulta de Empleo
 * DESCRIPCIÓN:		Método que provee la consulta de una Empleo por registro individual
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Empleo es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/consultaId")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public EmpleoResponseVO consultaId(EmpleoRequestVO vo) {
	EmpleoResponseVO 	out 			= new EmpleoResponseVO();
	EmpleoServiceImpl	Empleo 	= new EmpleoServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (EmpleoRequestVO)logService.setValues(vo, "Empleo", "consultaId", "ServiceEmpleo.class");
	try {
		    out=(EmpleoResponseVO)Empleo.consultaId(vo);	
	}catch(Exception e) {
		out = (EmpleoResponseVO)logService.recordException(e,vo);
	}
	return out;
}



/************************************************************************************
 * NOMBRE:			Modificacion de Empleo
 * DESCRIPCIÓN:		Método que provee la modificacion de una Empleo
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Empleo es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/modificacion")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public EmpleoResponseVO modificacion(EmpleoRequestVO vo) {
	EmpleoResponseVO 	out 			= new EmpleoResponseVO();
	EmpleoServiceImpl	Empleo 	= new EmpleoServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (EmpleoRequestVO)logService.setValues(vo, "Empleo", "modificacion", "ServiceEmpleo.class");
	try {
		    out=(EmpleoResponseVO)Empleo.modificacion(vo);	
	}catch(Exception e) {
		out = (EmpleoResponseVO)logService.recordException(e,vo);
	}
	return out;
}


}
