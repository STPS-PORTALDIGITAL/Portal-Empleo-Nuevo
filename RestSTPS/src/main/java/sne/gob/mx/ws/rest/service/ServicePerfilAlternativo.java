package sne.gob.mx.ws.rest.service;

import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import sne.gob.mx.general.services.LogService;
import sne.gob.mx.portal.service.impl.PerfilAlternativoServiceImpl;
import sne.gob.mx.ws.rest.vo.PerfilAlternativoRequestVO;
import sne.gob.mx.ws.rest.vo.PerfilAlternativoResponseVO;


@Path("/PerfilAlternativo")
public class ServicePerfilAlternativo {
final static Logger log = Logger.getLogger(ServicePerfilAlternativo.class);



/************************************************************************************
 * NOMBRE:			Alta de PerfilAlternativo
 * DESCRIPCIÓN:		Método que provee el alta de una PerfilAlternativo
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla PerfilAlternativo es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/alta")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public PerfilAlternativoResponseVO alta(PerfilAlternativoRequestVO vo) {
	PerfilAlternativoResponseVO 	out 			= new PerfilAlternativoResponseVO();
	PerfilAlternativoServiceImpl	PerfilAlternativo 	= new PerfilAlternativoServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (PerfilAlternativoRequestVO)logService.setValues(vo, "PerfilAlternativo", "alta", "ServicePerfilAlternativo.class");
	try {
			out=(PerfilAlternativoResponseVO)PerfilAlternativo.alta(vo);
	}catch(Exception e) {	
		logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Baja de PerfilAlternativo
 * DESCRIPCIÓN:		Método que provee la baja de una PerfilAlternativo
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 23/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla PerfilAlternativo es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/baja")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public PerfilAlternativoResponseVO baja(PerfilAlternativoRequestVO vo) {
	PerfilAlternativoResponseVO 	out 			= new PerfilAlternativoResponseVO();
	PerfilAlternativoServiceImpl	PerfilAlternativo 	= new PerfilAlternativoServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (PerfilAlternativoRequestVO)logService.setValues(vo, "PerfilAlternativo", "baja", "ServicePerfilAlternativo.class");
	try {
		    out=(PerfilAlternativoResponseVO)PerfilAlternativo.baja(vo);	
	}catch(Exception e) {
		out = (PerfilAlternativoResponseVO)logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Consulta de PerfilAlternativo
 * DESCRIPCIÓN:		Método que provee la consulta de una PerfilAlternativo
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla PerfilAlternativo es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 *  
 * ***********************************************************************************/
@POST
@Path("/consulta")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public PerfilAlternativoResponseVO consulta(PerfilAlternativoRequestVO vo) {
	PerfilAlternativoResponseVO 	out 			= new PerfilAlternativoResponseVO();
	PerfilAlternativoServiceImpl	PerfilAlternativo 	= new PerfilAlternativoServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (PerfilAlternativoRequestVO)logService.setValues(vo, "PerfilAlternativo", "consulta", "ServicePerfilAlternativo.class");
	try {
		    out=(PerfilAlternativoResponseVO)PerfilAlternativo.consulta(vo);	
	}catch(Exception e) {
		out = (PerfilAlternativoResponseVO)logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Consulta de PerfilAlternativo
 * DESCRIPCIÓN:		Método que provee la consulta de una PerfilAlternativo por registro individual
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla PerfilAlternativo es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/consultaId")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public PerfilAlternativoResponseVO consultaId(PerfilAlternativoRequestVO vo) {
	PerfilAlternativoResponseVO 	out 			= new PerfilAlternativoResponseVO();
	PerfilAlternativoServiceImpl	PerfilAlternativo 	= new PerfilAlternativoServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (PerfilAlternativoRequestVO)logService.setValues(vo, "PerfilAlternativo", "consultaId", "ServicePerfilAlternativo.class");
	try {
		    out=(PerfilAlternativoResponseVO)PerfilAlternativo.consultaId(vo);	
	}catch(Exception e) {
		out = (PerfilAlternativoResponseVO)logService.recordException(e,vo);
	}
	return out;
}



/************************************************************************************
 * NOMBRE:			Modificacion de PerfilAlternativo
 * DESCRIPCIÓN:		Método que provee la modificacion de una PerfilAlternativo
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla PerfilAlternativo es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/modificacion")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public PerfilAlternativoResponseVO modificacion(PerfilAlternativoRequestVO vo) {
	PerfilAlternativoResponseVO 	out 			= new PerfilAlternativoResponseVO();
	PerfilAlternativoServiceImpl	PerfilAlternativo 	= new PerfilAlternativoServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (PerfilAlternativoRequestVO)logService.setValues(vo, "PerfilAlternativo", "modificacion", "ServicePerfilAlternativo.class");
	try {
		    out=(PerfilAlternativoResponseVO)PerfilAlternativo.modificacion(vo);	
	}catch(Exception e) {
		out = (PerfilAlternativoResponseVO)logService.recordException(e,vo);
	}
	return out;
}


}
