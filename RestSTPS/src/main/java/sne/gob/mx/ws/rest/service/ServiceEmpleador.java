package sne.gob.mx.ws.rest.service;

import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import sne.gob.mx.general.services.LogService;
import sne.gob.mx.portal.service.impl.EmpleadorServiceImpl;
import sne.gob.mx.ws.rest.vo.EmpleadorRequestVO;
import sne.gob.mx.ws.rest.vo.EmpleadorResponseVO;


@Path("/Empleador")
public class ServiceEmpleador {
final static Logger log = Logger.getLogger(ServiceEmpleador.class);



/************************************************************************************
 * NOMBRE:			Alta de Empleador
 * DESCRIPCIÓN:		Método que provee el alta de una Empleador
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Empleador es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/alta")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public EmpleadorResponseVO alta(EmpleadorRequestVO vo) {
	EmpleadorResponseVO 	out 			= new EmpleadorResponseVO();
	EmpleadorServiceImpl	Empleador 	= new EmpleadorServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (EmpleadorRequestVO)logService.setValues(vo, "Empleador", "alta", "ServiceEmpleador.class");
	try {
			out=(EmpleadorResponseVO)Empleador.alta(vo);
	}catch(Exception e) {	
		logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Baja de Empleador
 * DESCRIPCIÓN:		Método que provee la baja de una Empleador
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 23/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Empleador es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/baja")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public EmpleadorResponseVO baja(EmpleadorRequestVO vo) {
	EmpleadorResponseVO 	out 			= new EmpleadorResponseVO();
	EmpleadorServiceImpl	Empleador 	= new EmpleadorServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (EmpleadorRequestVO)logService.setValues(vo, "Empleador", "baja", "ServiceEmpleador.class");
	try {
		    out=(EmpleadorResponseVO)Empleador.baja(vo);	
	}catch(Exception e) {
		out = (EmpleadorResponseVO)logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Consulta de Empleador
 * DESCRIPCIÓN:		Método que provee la consulta de una Empleador
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Empleador es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 *  
 * ***********************************************************************************/
@POST
@Path("/consulta")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public EmpleadorResponseVO consulta(EmpleadorRequestVO vo) {
	EmpleadorResponseVO 	out 			= new EmpleadorResponseVO();
	EmpleadorServiceImpl	Empleador 	= new EmpleadorServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (EmpleadorRequestVO)logService.setValues(vo, "Empleador", "consulta", "ServiceEmpleador.class");
	try {
		    out=(EmpleadorResponseVO)Empleador.consulta(vo);	
	}catch(Exception e) {
		out = (EmpleadorResponseVO)logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Consulta de Empleador
 * DESCRIPCIÓN:		Método que provee la consulta de una Empleador por registro individual
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Empleador es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/consultaId")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public EmpleadorResponseVO consultaId(EmpleadorRequestVO vo) {
	EmpleadorResponseVO 	out 			= new EmpleadorResponseVO();
	EmpleadorServiceImpl	Empleador 	= new EmpleadorServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (EmpleadorRequestVO)logService.setValues(vo, "Empleador", "consultaId", "ServiceEmpleador.class");
	try {
		    out=(EmpleadorResponseVO)Empleador.consultaId(vo);	
	}catch(Exception e) {
		out = (EmpleadorResponseVO)logService.recordException(e,vo);
	}
	return out;
}



/************************************************************************************
 * NOMBRE:			Modificacion de Empleador
 * DESCRIPCIÓN:		Método que provee la modificacion de una Empleador
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Empleador es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/modificacion")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public EmpleadorResponseVO modificacion(EmpleadorRequestVO vo) {
	EmpleadorResponseVO 	out 			= new EmpleadorResponseVO();
	EmpleadorServiceImpl	Empleador 	= new EmpleadorServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (EmpleadorRequestVO)logService.setValues(vo, "Empleador", "modificacion", "ServiceEmpleador.class");
	try {
		    out=(EmpleadorResponseVO)Empleador.modificacion(vo);	
	}catch(Exception e) {
		out = (EmpleadorResponseVO)logService.recordException(e,vo);
	}
	return out;
}


}
