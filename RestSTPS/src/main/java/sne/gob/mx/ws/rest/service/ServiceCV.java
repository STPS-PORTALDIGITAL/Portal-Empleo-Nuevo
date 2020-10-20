package sne.gob.mx.ws.rest.service;

import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import sne.gob.mx.general.services.LogService;
import sne.gob.mx.portal.service.impl.CVServiceImpl;
import sne.gob.mx.ws.rest.vo.CVRequestVO;
import sne.gob.mx.ws.rest.vo.CVResponseVO;


@Path("/CV")
public class ServiceCV {
final static Logger log = Logger.getLogger(ServiceCV.class);



/************************************************************************************
 * NOMBRE:			Alta de CV
 * DESCRIPCIÓN:		Método que provee el alta de una CV
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla CV es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/alta")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public CVResponseVO alta(CVRequestVO vo) {
	CVResponseVO 	out 			= new CVResponseVO();
	CVServiceImpl	CV 	= new CVServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (CVRequestVO)logService.setValues(vo, "CV", "alta", "ServiceCV.class");
	try {
			out=(CVResponseVO)CV.alta(vo);
	}catch(Exception e) {	
		logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Baja de CV
 * DESCRIPCIÓN:		Método que provee la baja de una CV
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 23/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla CV es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/baja")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public CVResponseVO baja(CVRequestVO vo) {
	CVResponseVO 	out 			= new CVResponseVO();
	CVServiceImpl	CV 	= new CVServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (CVRequestVO)logService.setValues(vo, "CV", "baja", "ServiceCV.class");
	try {
		    out=(CVResponseVO)CV.baja(vo);	
	}catch(Exception e) {
		out = (CVResponseVO)logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Consulta de CV
 * DESCRIPCIÓN:		Método que provee la consulta de una CV
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla CV es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 *  
 * ***********************************************************************************/
@POST
@Path("/consulta")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public CVResponseVO consulta(CVRequestVO vo) {
	CVResponseVO 	out 			= new CVResponseVO();
	CVServiceImpl	CV 	= new CVServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (CVRequestVO)logService.setValues(vo, "CV", "consulta", "ServiceCV.class");
	try {
		    out=(CVResponseVO)CV.consulta(vo);	
	}catch(Exception e) {
		out = (CVResponseVO)logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Consulta de CV
 * DESCRIPCIÓN:		Método que provee la consulta de una CV por registro individual
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla CV es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/consultaId")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public CVResponseVO consultaId(CVRequestVO vo) {
	CVResponseVO 	out 			= new CVResponseVO();
	CVServiceImpl	CV 	= new CVServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (CVRequestVO)logService.setValues(vo, "CV", "consultaId", "ServiceCV.class");
	try {
		    out=(CVResponseVO)CV.consultaId(vo);	
	}catch(Exception e) {
		out = (CVResponseVO)logService.recordException(e,vo);
	}
	return out;
}



/************************************************************************************
 * NOMBRE:			Modificacion de CV
 * DESCRIPCIÓN:		Método que provee la modificacion de una CV
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla CV es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/modificacion")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public CVResponseVO modificacion(CVRequestVO vo) {
	CVResponseVO 	out 			= new CVResponseVO();
	CVServiceImpl	CV 	= new CVServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (CVRequestVO)logService.setValues(vo, "CV", "modificacion", "ServiceCV.class");
	try {
		    out=(CVResponseVO)CV.modificacion(vo);	
	}catch(Exception e) {
		out = (CVResponseVO)logService.recordException(e,vo);
	}
	return out;
}


}
