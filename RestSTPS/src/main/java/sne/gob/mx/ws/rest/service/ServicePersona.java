package sne.gob.mx.ws.rest.service;

import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import sne.gob.mx.general.services.LogService;
import sne.gob.mx.portal.service.impl.PersonaServiceImpl;
import sne.gob.mx.ws.rest.vo.PersonaRequestVO;
import sne.gob.mx.ws.rest.vo.PersonaResponseVO;


@Path("/Persona")
public class ServicePersona {
final static Logger log = Logger.getLogger(ServicePersona.class);



/************************************************************************************
 * NOMBRE:			Alta de Persona
 * DESCRIPCIÓN:		Método que provee el alta de una Persona
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Persona es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/alta")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public PersonaResponseVO alta(PersonaRequestVO vo) {
	PersonaResponseVO 	out 			= new PersonaResponseVO();
	PersonaServiceImpl	Persona 	= new PersonaServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (PersonaRequestVO)logService.setValues(vo, "Persona", "alta", "ServicePersona.class");
	try {
			out=(PersonaResponseVO)Persona.alta(vo);
	}catch(Exception e) {	
		logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Baja de Persona
 * DESCRIPCIÓN:		Método que provee la baja de una Persona
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 23/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Persona es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/baja")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public PersonaResponseVO baja(PersonaRequestVO vo) {
	PersonaResponseVO 	out 			= new PersonaResponseVO();
	PersonaServiceImpl	Persona 	= new PersonaServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (PersonaRequestVO)logService.setValues(vo, "Persona", "baja", "ServicePersona.class");
	try {
		    out=(PersonaResponseVO)Persona.baja(vo);	
	}catch(Exception e) {
		out = (PersonaResponseVO)logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Consulta de Persona
 * DESCRIPCIÓN:		Método que provee la consulta de una Persona
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Persona es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 *  
 * ***********************************************************************************/
@POST
@Path("/consulta")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public PersonaResponseVO consulta(PersonaRequestVO vo) {
	PersonaResponseVO 	out 			= new PersonaResponseVO();
	PersonaServiceImpl	Persona 	= new PersonaServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (PersonaRequestVO)logService.setValues(vo, "Persona", "consulta", "ServicePersona.class");
	try {
		    out=(PersonaResponseVO)Persona.consulta(vo);	
	}catch(Exception e) {
		out = (PersonaResponseVO)logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Consulta de Persona
 * DESCRIPCIÓN:		Método que provee la consulta de una Persona por registro individual
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Persona es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/consultaId")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public PersonaResponseVO consultaId(PersonaRequestVO vo) {
	PersonaResponseVO 	out 			= new PersonaResponseVO();
	PersonaServiceImpl	Persona 	= new PersonaServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (PersonaRequestVO)logService.setValues(vo, "Persona", "consultaId", "ServicePersona.class");
	try {
		    out=(PersonaResponseVO)Persona.consultaId(vo);	
	}catch(Exception e) {
		out = (PersonaResponseVO)logService.recordException(e,vo);
	}
	return out;
}



/************************************************************************************
 * NOMBRE:			Modificacion de Persona
 * DESCRIPCIÓN:		Método que provee la modificacion de una Persona
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Persona es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/modificacion")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public PersonaResponseVO modificacion(PersonaRequestVO vo) {
	PersonaResponseVO 	out 			= new PersonaResponseVO();
	PersonaServiceImpl	Persona 	= new PersonaServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (PersonaRequestVO)logService.setValues(vo, "Persona", "modificacion", "ServicePersona.class");
	try {
		    out=(PersonaResponseVO)Persona.modificacion(vo);	
	}catch(Exception e) {
		out = (PersonaResponseVO)logService.recordException(e,vo);
	}
	return out;
}


}
