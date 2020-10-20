package sne.gob.mx.ws.rest.service;

import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import sne.gob.mx.general.services.LogService;
import sne.gob.mx.portal.service.impl.RolesResponsabilidadesServiceImpl;
import sne.gob.mx.ws.rest.vo.RolesResponsabilidadesRequestVO;
import sne.gob.mx.ws.rest.vo.RolesResponsabilidadesResponseVO;


@Path("/RolesResponsabilidades")
public class ServiceRolesResponsabilidades {
final static Logger log = Logger.getLogger(ServiceRolesResponsabilidades.class);



/************************************************************************************
 * NOMBRE:			Alta de RolesResponsabilidades
 * DESCRIPCIÓN:		Método que provee el alta de una RolesResponsabilidades
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla RolesResponsabilidades es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/alta")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public RolesResponsabilidadesResponseVO alta(RolesResponsabilidadesRequestVO vo) {
	RolesResponsabilidadesResponseVO 	out 			= new RolesResponsabilidadesResponseVO();
	RolesResponsabilidadesServiceImpl	RolesResponsabilidades 	= new RolesResponsabilidadesServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (RolesResponsabilidadesRequestVO)logService.setValues(vo, "RolesResponsabilidades", "alta", "ServiceRolesResponsabilidades.class");
	try {
			out=(RolesResponsabilidadesResponseVO)RolesResponsabilidades.alta(vo);
	}catch(Exception e) {	
		logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Baja de RolesResponsabilidades
 * DESCRIPCIÓN:		Método que provee la baja de una RolesResponsabilidades
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 23/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla RolesResponsabilidades es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/baja")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public RolesResponsabilidadesResponseVO baja(RolesResponsabilidadesRequestVO vo) {
	RolesResponsabilidadesResponseVO 	out 			= new RolesResponsabilidadesResponseVO();
	RolesResponsabilidadesServiceImpl	RolesResponsabilidades 	= new RolesResponsabilidadesServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (RolesResponsabilidadesRequestVO)logService.setValues(vo, "RolesResponsabilidades", "baja", "ServiceRolesResponsabilidades.class");
	try {
		    out=(RolesResponsabilidadesResponseVO)RolesResponsabilidades.baja(vo);	
	}catch(Exception e) {
		out = (RolesResponsabilidadesResponseVO)logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Consulta de RolesResponsabilidades
 * DESCRIPCIÓN:		Método que provee la consulta de una RolesResponsabilidades
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla RolesResponsabilidades es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 *  
 * ***********************************************************************************/
@POST
@Path("/consulta")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public RolesResponsabilidadesResponseVO consulta(RolesResponsabilidadesRequestVO vo) {
	RolesResponsabilidadesResponseVO 	out 			= new RolesResponsabilidadesResponseVO();
	RolesResponsabilidadesServiceImpl	RolesResponsabilidades 	= new RolesResponsabilidadesServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (RolesResponsabilidadesRequestVO)logService.setValues(vo, "RolesResponsabilidades", "consulta", "ServiceRolesResponsabilidades.class");
	try {
		    out=(RolesResponsabilidadesResponseVO)RolesResponsabilidades.consulta(vo);	
	}catch(Exception e) {
		out = (RolesResponsabilidadesResponseVO)logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Consulta de RolesResponsabilidades
 * DESCRIPCIÓN:		Método que provee la consulta de una RolesResponsabilidades por registro individual
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla RolesResponsabilidades es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/consultaId")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public RolesResponsabilidadesResponseVO consultaId(RolesResponsabilidadesRequestVO vo) {
	RolesResponsabilidadesResponseVO 	out 			= new RolesResponsabilidadesResponseVO();
	RolesResponsabilidadesServiceImpl	RolesResponsabilidades 	= new RolesResponsabilidadesServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (RolesResponsabilidadesRequestVO)logService.setValues(vo, "RolesResponsabilidades", "consultaId", "ServiceRolesResponsabilidades.class");
	try {
		    out=(RolesResponsabilidadesResponseVO)RolesResponsabilidades.consultaId(vo);	
	}catch(Exception e) {
		out = (RolesResponsabilidadesResponseVO)logService.recordException(e,vo);
	}
	return out;
}



/************************************************************************************
 * NOMBRE:			Modificacion de RolesResponsabilidades
 * DESCRIPCIÓN:		Método que provee la modificacion de una RolesResponsabilidades
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla RolesResponsabilidades es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/modificacion")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public RolesResponsabilidadesResponseVO modificacion(RolesResponsabilidadesRequestVO vo) {
	RolesResponsabilidadesResponseVO 	out 			= new RolesResponsabilidadesResponseVO();
	RolesResponsabilidadesServiceImpl	RolesResponsabilidades 	= new RolesResponsabilidadesServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (RolesResponsabilidadesRequestVO)logService.setValues(vo, "RolesResponsabilidades", "modificacion", "ServiceRolesResponsabilidades.class");
	try {
		    out=(RolesResponsabilidadesResponseVO)RolesResponsabilidades.modificacion(vo);	
	}catch(Exception e) {
		out = (RolesResponsabilidadesResponseVO)logService.recordException(e,vo);
	}
	return out;
}


}
