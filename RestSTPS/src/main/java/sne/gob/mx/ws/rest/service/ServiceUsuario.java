package sne.gob.mx.ws.rest.service;

import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import sne.gob.mx.general.services.LogService;
import sne.gob.mx.portal.service.impl.UsuarioServiceImpl;
import sne.gob.mx.ws.rest.vo.UsuarioRequestVO;
import sne.gob.mx.ws.rest.vo.UsuarioResponseVO;


@Path("/Usuario")
public class ServiceUsuario {
final static Logger log = Logger.getLogger(ServiceUsuario.class);



/************************************************************************************
 * NOMBRE:			Alta de Usuario
 * DESCRIPCIÓN:		Método que provee el alta de una Usuario
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Usuario es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/alta")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public UsuarioResponseVO alta(UsuarioRequestVO vo) {
	UsuarioResponseVO 	out 			= new UsuarioResponseVO();
	UsuarioServiceImpl	Usuario 	= new UsuarioServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (UsuarioRequestVO)logService.setValues(vo, "Usuario", "alta", "ServiceUsuario.class");
	try {
			out=(UsuarioResponseVO)Usuario.alta(vo);
	}catch(Exception e) {	
		logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Baja de Usuario
 * DESCRIPCIÓN:		Método que provee la baja de una Usuario
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 23/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Usuario es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/baja")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public UsuarioResponseVO baja(UsuarioRequestVO vo) {
	UsuarioResponseVO 	out 			= new UsuarioResponseVO();
	UsuarioServiceImpl	Usuario 	= new UsuarioServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (UsuarioRequestVO)logService.setValues(vo, "Usuario", "baja", "ServiceUsuario.class");
	try {
		    out=(UsuarioResponseVO)Usuario.baja(vo);	
	}catch(Exception e) {
		out = (UsuarioResponseVO)logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Consulta de Usuario
 * DESCRIPCIÓN:		Método que provee la consulta de una Usuario
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Usuario es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 *  
 * ***********************************************************************************/
@POST
@Path("/consulta")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public UsuarioResponseVO consulta(UsuarioRequestVO vo) {
	UsuarioResponseVO 	out 			= new UsuarioResponseVO();
	UsuarioServiceImpl	Usuario 	= new UsuarioServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (UsuarioRequestVO)logService.setValues(vo, "Usuario", "consulta", "ServiceUsuario.class");
	try {
		    out=(UsuarioResponseVO)Usuario.consulta(vo);	
	}catch(Exception e) {
		out = (UsuarioResponseVO)logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Consulta de Usuario
 * DESCRIPCIÓN:		Método que provee la consulta de una Usuario por registro individual
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Usuario es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/consultaId")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public UsuarioResponseVO consultaId(UsuarioRequestVO vo) {
	UsuarioResponseVO 	out 			= new UsuarioResponseVO();
	UsuarioServiceImpl	Usuario 	= new UsuarioServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (UsuarioRequestVO)logService.setValues(vo, "Usuario", "consultaId", "ServiceUsuario.class");
	try {
		    out=(UsuarioResponseVO)Usuario.consultaId(vo);	
	}catch(Exception e) {
		out = (UsuarioResponseVO)logService.recordException(e,vo);
	}
	return out;
}



/************************************************************************************
 * NOMBRE:			Modificacion de Usuario
 * DESCRIPCIÓN:		Método que provee la modificacion de una Usuario
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Usuario es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/modificacion")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public UsuarioResponseVO modificacion(UsuarioRequestVO vo) {
	UsuarioResponseVO 	out 			= new UsuarioResponseVO();
	UsuarioServiceImpl	Usuario 	= new UsuarioServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (UsuarioRequestVO)logService.setValues(vo, "Usuario", "modificacion", "ServiceUsuario.class");
	try {
		    out=(UsuarioResponseVO)Usuario.modificacion(vo);	
	}catch(Exception e) {
		out = (UsuarioResponseVO)logService.recordException(e,vo);
	}
	return out;
}


}
