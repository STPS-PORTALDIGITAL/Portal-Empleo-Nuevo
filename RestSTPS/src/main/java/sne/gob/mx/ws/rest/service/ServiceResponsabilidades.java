package sne.gob.mx.ws.rest.service;

import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import sne.gob.mx.general.services.LogService;
import sne.gob.mx.portal.service.impl.ResponsabilidadesServiceImpl;
import sne.gob.mx.ws.rest.vo.ResponsabilidadesRequestVO;
import sne.gob.mx.ws.rest.vo.ResponsabilidadesResponseVO;


@Path("/Responsabilidades")
public class ServiceResponsabilidades {
final static Logger log = Logger.getLogger(ServiceResponsabilidades.class);



/************************************************************************************
 * NOMBRE:			Alta de Responsabilidades
 * DESCRIPCIÓN:		Método que provee el alta de una Responsabilidades
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Responsabilidades es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/alta")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public ResponsabilidadesResponseVO alta(ResponsabilidadesRequestVO vo) {
	ResponsabilidadesResponseVO 	out 			= new ResponsabilidadesResponseVO();
	ResponsabilidadesServiceImpl	Responsabilidades 	= new ResponsabilidadesServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (ResponsabilidadesRequestVO)logService.setValues(vo, "Responsabilidades", "alta", "ServiceResponsabilidades.class");
	try {
			out=(ResponsabilidadesResponseVO)Responsabilidades.alta(vo);
	}catch(Exception e) {	
		logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Baja de Responsabilidades
 * DESCRIPCIÓN:		Método que provee la baja de una Responsabilidades
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 23/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Responsabilidades es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/baja")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public ResponsabilidadesResponseVO baja(ResponsabilidadesRequestVO vo) {
	ResponsabilidadesResponseVO 	out 			= new ResponsabilidadesResponseVO();
	ResponsabilidadesServiceImpl	Responsabilidades 	= new ResponsabilidadesServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (ResponsabilidadesRequestVO)logService.setValues(vo, "Responsabilidades", "baja", "ServiceResponsabilidades.class");
	try {
		    out=(ResponsabilidadesResponseVO)Responsabilidades.baja(vo);	
	}catch(Exception e) {
		out = (ResponsabilidadesResponseVO)logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Consulta de Responsabilidades
 * DESCRIPCIÓN:		Método que provee la consulta de una Responsabilidades
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Responsabilidades es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 *  
 * ***********************************************************************************/
@POST
@Path("/consulta")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public ResponsabilidadesResponseVO consulta(ResponsabilidadesRequestVO vo) {
	ResponsabilidadesResponseVO 	out 			= new ResponsabilidadesResponseVO();
	ResponsabilidadesServiceImpl	Responsabilidades 	= new ResponsabilidadesServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (ResponsabilidadesRequestVO)logService.setValues(vo, "Responsabilidades", "consulta", "ServiceResponsabilidades.class");
	try {
		    out=(ResponsabilidadesResponseVO)Responsabilidades.consulta(vo);	
	}catch(Exception e) {
		out = (ResponsabilidadesResponseVO)logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Consulta de Responsabilidades
 * DESCRIPCIÓN:		Método que provee la consulta de una Responsabilidades por registro individual
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Responsabilidades es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/consultaId")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public ResponsabilidadesResponseVO consultaId(ResponsabilidadesRequestVO vo) {
	ResponsabilidadesResponseVO 	out 			= new ResponsabilidadesResponseVO();
	ResponsabilidadesServiceImpl	Responsabilidades 	= new ResponsabilidadesServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (ResponsabilidadesRequestVO)logService.setValues(vo, "Responsabilidades", "consultaId", "ServiceResponsabilidades.class");
	try {
		    out=(ResponsabilidadesResponseVO)Responsabilidades.consultaId(vo);	
	}catch(Exception e) {
		out = (ResponsabilidadesResponseVO)logService.recordException(e,vo);
	}
	return out;
}



/************************************************************************************
 * NOMBRE:			Modificacion de Responsabilidades
 * DESCRIPCIÓN:		Método que provee la modificacion de una Responsabilidades
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Responsabilidades es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/modificacion")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public ResponsabilidadesResponseVO modificacion(ResponsabilidadesRequestVO vo) {
	ResponsabilidadesResponseVO 	out 			= new ResponsabilidadesResponseVO();
	ResponsabilidadesServiceImpl	Responsabilidades 	= new ResponsabilidadesServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (ResponsabilidadesRequestVO)logService.setValues(vo, "Responsabilidades", "modificacion", "ServiceResponsabilidades.class");
	try {
		    out=(ResponsabilidadesResponseVO)Responsabilidades.modificacion(vo);	
	}catch(Exception e) {
		out = (ResponsabilidadesResponseVO)logService.recordException(e,vo);
	}
	return out;
}


}
