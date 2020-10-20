package sne.gob.mx.ws.rest.service;

import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import sne.gob.mx.general.services.LogService;
import sne.gob.mx.portal.service.impl.PerfilServiceImpl;
import sne.gob.mx.ws.rest.vo.PerfilRequestVO;
import sne.gob.mx.ws.rest.vo.PerfilResponseVO;


@Path("/Perfil")
public class ServicePerfil {
final static Logger log = Logger.getLogger(ServicePerfil.class);



/************************************************************************************
 * NOMBRE:			Alta de Perfil
 * DESCRIPCIÓN:		Método que provee el alta de una Perfil
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Perfil es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/alta")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public PerfilResponseVO alta(PerfilRequestVO vo) {
	PerfilResponseVO 	out 			= new PerfilResponseVO();
	PerfilServiceImpl	Perfil 	= new PerfilServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (PerfilRequestVO)logService.setValues(vo, "Perfil", "alta", "ServicePerfil.class");
	try {
			out=(PerfilResponseVO)Perfil.alta(vo);
	}catch(Exception e) {	
		logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Baja de Perfil
 * DESCRIPCIÓN:		Método que provee la baja de una Perfil
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 23/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Perfil es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/baja")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public PerfilResponseVO baja(PerfilRequestVO vo) {
	PerfilResponseVO 	out 			= new PerfilResponseVO();
	PerfilServiceImpl	Perfil 	= new PerfilServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (PerfilRequestVO)logService.setValues(vo, "Perfil", "baja", "ServicePerfil.class");
	try {
		    out=(PerfilResponseVO)Perfil.baja(vo);	
	}catch(Exception e) {
		out = (PerfilResponseVO)logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Consulta de Perfil
 * DESCRIPCIÓN:		Método que provee la consulta de una Perfil
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Perfil es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 *  
 * ***********************************************************************************/
@POST
@Path("/consulta")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public PerfilResponseVO consulta(PerfilRequestVO vo) {
	PerfilResponseVO 	out 			= new PerfilResponseVO();
	PerfilServiceImpl	Perfil 	= new PerfilServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (PerfilRequestVO)logService.setValues(vo, "Perfil", "consulta", "ServicePerfil.class");
	try {
		    out=(PerfilResponseVO)Perfil.consulta(vo);	
	}catch(Exception e) {
		out = (PerfilResponseVO)logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Consulta de Perfil
 * DESCRIPCIÓN:		Método que provee la consulta de una Perfil por registro individual
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Perfil es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/consultaId")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public PerfilResponseVO consultaId(PerfilRequestVO vo) {
	PerfilResponseVO 	out 			= new PerfilResponseVO();
	PerfilServiceImpl	Perfil 	= new PerfilServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (PerfilRequestVO)logService.setValues(vo, "Perfil", "consultaId", "ServicePerfil.class");
	try {
		    out=(PerfilResponseVO)Perfil.consultaId(vo);	
	}catch(Exception e) {
		out = (PerfilResponseVO)logService.recordException(e,vo);
	}
	return out;
}



/************************************************************************************
 * NOMBRE:			Modificacion de Perfil
 * DESCRIPCIÓN:		Método que provee la modificacion de una Perfil
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Perfil es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/modificacion")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public PerfilResponseVO modificacion(PerfilRequestVO vo) {
	PerfilResponseVO 	out 			= new PerfilResponseVO();
	PerfilServiceImpl	Perfil 	= new PerfilServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (PerfilRequestVO)logService.setValues(vo, "Perfil", "modificacion", "ServicePerfil.class");
	try {
		    out=(PerfilResponseVO)Perfil.modificacion(vo);	
	}catch(Exception e) {
		out = (PerfilResponseVO)logService.recordException(e,vo);
	}
	return out;
}


}
