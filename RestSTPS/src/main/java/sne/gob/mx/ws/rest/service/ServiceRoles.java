package sne.gob.mx.ws.rest.service;

import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import sne.gob.mx.general.services.LogService;
import sne.gob.mx.portal.service.impl.RolesServiceImpl;
import sne.gob.mx.ws.rest.vo.RolesRequestVO;
import sne.gob.mx.ws.rest.vo.RolesResponseVO;


@Path("/Roles")
public class ServiceRoles {
final static Logger log = Logger.getLogger(ServiceRoles.class);



/************************************************************************************
 * NOMBRE:			Alta de Roles
 * DESCRIPCIÓN:		Método que provee el alta de una Roles
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Roles es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/alta")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public RolesResponseVO alta(RolesRequestVO vo) {
	RolesResponseVO 	out 			= new RolesResponseVO();
	RolesServiceImpl	Roles 	= new RolesServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (RolesRequestVO)logService.setValues(vo, "Roles", "alta", "ServiceRoles.class");
	try {
			out=(RolesResponseVO)Roles.alta(vo);
	}catch(Exception e) {	
		logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Baja de Roles
 * DESCRIPCIÓN:		Método que provee la baja de una Roles
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 23/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Roles es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/baja")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public RolesResponseVO baja(RolesRequestVO vo) {
	RolesResponseVO 	out 			= new RolesResponseVO();
	RolesServiceImpl	Roles 	= new RolesServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (RolesRequestVO)logService.setValues(vo, "Roles", "baja", "ServiceRoles.class");
	try {
		    out=(RolesResponseVO)Roles.baja(vo);	
	}catch(Exception e) {
		out = (RolesResponseVO)logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Consulta de Roles
 * DESCRIPCIÓN:		Método que provee la consulta de una Roles
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Roles es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 *  
 * ***********************************************************************************/
@POST
@Path("/consulta")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public RolesResponseVO consulta(RolesRequestVO vo) {
	RolesResponseVO 	out 			= new RolesResponseVO();
	RolesServiceImpl	Roles 	= new RolesServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (RolesRequestVO)logService.setValues(vo, "Roles", "consulta", "ServiceRoles.class");
	try {
		    out=(RolesResponseVO)Roles.consulta(vo);	
	}catch(Exception e) {
		out = (RolesResponseVO)logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Consulta de Roles
 * DESCRIPCIÓN:		Método que provee la consulta de una Roles por registro individual
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Roles es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/consultaId")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public RolesResponseVO consultaId(RolesRequestVO vo) {
	RolesResponseVO 	out 			= new RolesResponseVO();
	RolesServiceImpl	Roles 	= new RolesServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (RolesRequestVO)logService.setValues(vo, "Roles", "consultaId", "ServiceRoles.class");
	try {
		    out=(RolesResponseVO)Roles.consultaId(vo);	
	}catch(Exception e) {
		out = (RolesResponseVO)logService.recordException(e,vo);
	}
	return out;
}



/************************************************************************************
 * NOMBRE:			Modificacion de Roles
 * DESCRIPCIÓN:		Método que provee la modificacion de una Roles
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Roles es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/modificacion")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public RolesResponseVO modificacion(RolesRequestVO vo) {
	RolesResponseVO 	out 			= new RolesResponseVO();
	RolesServiceImpl	Roles 	= new RolesServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (RolesRequestVO)logService.setValues(vo, "Roles", "modificacion", "ServiceRoles.class");
	try {
		    out=(RolesResponseVO)Roles.modificacion(vo);	
	}catch(Exception e) {
		out = (RolesResponseVO)logService.recordException(e,vo);
	}
	return out;
}


}
