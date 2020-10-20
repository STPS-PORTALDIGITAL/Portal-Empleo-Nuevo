package sne.gob.mx.ws.rest.service;

import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import sne.gob.mx.general.services.LogService;
import sne.gob.mx.portal.service.impl.EntidadFederativaServiceImpl;
import sne.gob.mx.ws.rest.vo.EntidadFederativaRequestVO;
import sne.gob.mx.ws.rest.vo.EntidadFederativaResponseVO;


@Path("/EntidadFederativa")
public class ServiceEntidadFederativa {
final static Logger log = Logger.getLogger(ServiceEntidadFederativa.class);



/************************************************************************************
 * NOMBRE:			Alta de EntidadFederativa
 * DESCRIPCIÓN:		Método que provee el alta de una EntidadFederativa
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla EntidadFederativa es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/alta")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public EntidadFederativaResponseVO alta(EntidadFederativaRequestVO vo) {
	EntidadFederativaResponseVO 	out 			= new EntidadFederativaResponseVO();
	EntidadFederativaServiceImpl	EntidadFederativa 	= new EntidadFederativaServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (EntidadFederativaRequestVO)logService.setValues(vo, "EntidadFederativa", "alta", "ServiceEntidadFederativa.class");
	try {
			out=(EntidadFederativaResponseVO)EntidadFederativa.alta(vo);
	}catch(Exception e) {	
		logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Baja de EntidadFederativa
 * DESCRIPCIÓN:		Método que provee la baja de una EntidadFederativa
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 23/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla EntidadFederativa es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/baja")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public EntidadFederativaResponseVO baja(EntidadFederativaRequestVO vo) {
	EntidadFederativaResponseVO 	out 			= new EntidadFederativaResponseVO();
	EntidadFederativaServiceImpl	EntidadFederativa 	= new EntidadFederativaServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (EntidadFederativaRequestVO)logService.setValues(vo, "EntidadFederativa", "baja", "ServiceEntidadFederativa.class");
	try {
		    out=(EntidadFederativaResponseVO)EntidadFederativa.baja(vo);	
	}catch(Exception e) {
		out = (EntidadFederativaResponseVO)logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Consulta de EntidadFederativa
 * DESCRIPCIÓN:		Método que provee la consulta de una EntidadFederativa
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla EntidadFederativa es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 *  
 * ***********************************************************************************/
@POST
@Path("/consulta")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public EntidadFederativaResponseVO consulta(EntidadFederativaRequestVO vo) {
	EntidadFederativaResponseVO 	out 			= new EntidadFederativaResponseVO();
	EntidadFederativaServiceImpl	EntidadFederativa 	= new EntidadFederativaServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (EntidadFederativaRequestVO)logService.setValues(vo, "EntidadFederativa", "consulta", "ServiceEntidadFederativa.class");
	try {
		    out=(EntidadFederativaResponseVO)EntidadFederativa.consulta(vo);	
	}catch(Exception e) {
		out = (EntidadFederativaResponseVO)logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Consulta de EntidadFederativa
 * DESCRIPCIÓN:		Método que provee la consulta de una EntidadFederativa por registro individual
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla EntidadFederativa es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/consultaId")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public EntidadFederativaResponseVO consultaId(EntidadFederativaRequestVO vo) {
	EntidadFederativaResponseVO 	out 			= new EntidadFederativaResponseVO();
	EntidadFederativaServiceImpl	EntidadFederativa 	= new EntidadFederativaServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (EntidadFederativaRequestVO)logService.setValues(vo, "EntidadFederativa", "consultaId", "ServiceEntidadFederativa.class");
	try {
		    out=(EntidadFederativaResponseVO)EntidadFederativa.consultaId(vo);	
	}catch(Exception e) {
		out = (EntidadFederativaResponseVO)logService.recordException(e,vo);
	}
	return out;
}



/************************************************************************************
 * NOMBRE:			Modificacion de EntidadFederativa
 * DESCRIPCIÓN:		Método que provee la modificacion de una EntidadFederativa
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla EntidadFederativa es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/modificacion")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public EntidadFederativaResponseVO modificacion(EntidadFederativaRequestVO vo) {
	EntidadFederativaResponseVO 	out 				= new EntidadFederativaResponseVO();
	EntidadFederativaServiceImpl	EntidadFederativa 	= new EntidadFederativaServiceImpl();
	LogService						logService			= new LogService();
	
	BasicConfigurator.configure();
	vo = (EntidadFederativaRequestVO)logService.setValues(vo, "EntidadFederativa", "modificacion", "ServiceEntidadFederativa.class");
	try {
		    out=(EntidadFederativaResponseVO)EntidadFederativa.modificacion(vo);	
	}catch(Exception e) {
		out = (EntidadFederativaResponseVO)logService.recordException(e,vo);
	}
	return out;
}


}
