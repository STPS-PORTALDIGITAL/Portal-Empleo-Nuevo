package sne.gob.mx.ws.rest.service;

import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import sne.gob.mx.general.services.LogService;
import sne.gob.mx.portal.service.impl.ConvocatoriaServiceImpl;
import sne.gob.mx.ws.rest.vo.ConvocatoriaRequestVO;
import sne.gob.mx.ws.rest.vo.ConvocatoriaResponseVO;


@Path("/Convocatoria")
public class ServiceConvocatoria {
final static Logger log = Logger.getLogger(ServiceConvocatoria.class);



/************************************************************************************
 * NOMBRE:			Alta de Convocatoria
 * DESCRIPCI�N:		M�todo que provee el alta de una Convocatoria
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T � R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Convocatoria es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/alta")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public ConvocatoriaResponseVO alta(ConvocatoriaRequestVO vo) {
	ConvocatoriaResponseVO 	out 			= new ConvocatoriaResponseVO();
	ConvocatoriaServiceImpl	Convocatoria 	= new ConvocatoriaServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (ConvocatoriaRequestVO)logService.setValues(vo, "Convocatoria", "alta", "ServiceConvocatoria.class");
	try {
			out=(ConvocatoriaResponseVO)Convocatoria.alta(vo);
	}catch(Exception e) {	
		logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Baja de Convocatoria
 * DESCRIPCI�N:		M�todo que provee la baja de una Convocatoria
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T � R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 23/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Convocatoria es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/baja")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public ConvocatoriaResponseVO baja(ConvocatoriaRequestVO vo) {
	ConvocatoriaResponseVO 	out 			= new ConvocatoriaResponseVO();
	ConvocatoriaServiceImpl	Convocatoria 	= new ConvocatoriaServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (ConvocatoriaRequestVO)logService.setValues(vo, "Convocatoria", "baja", "ServiceConvocatoria.class");
	try {
		    out=(ConvocatoriaResponseVO)Convocatoria.baja(vo);	
	}catch(Exception e) {
		out = (ConvocatoriaResponseVO)logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Consulta de Convocatoria
 * DESCRIPCI�N:		M�todo que provee la consulta de una Convocatoria
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T � R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Convocatoria es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 *  
 * ***********************************************************************************/
@POST
@Path("/consulta")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public ConvocatoriaResponseVO consulta(ConvocatoriaRequestVO vo) {
	ConvocatoriaResponseVO 	out 			= new ConvocatoriaResponseVO();
	ConvocatoriaServiceImpl	Convocatoria 	= new ConvocatoriaServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (ConvocatoriaRequestVO)logService.setValues(vo, "Convocatoria", "consulta", "ServiceConvocatoria.class");
	try {
		    out=(ConvocatoriaResponseVO)Convocatoria.consulta(vo);	
	}catch(Exception e) {
		out = (ConvocatoriaResponseVO)logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Consulta de Convocatoria
 * DESCRIPCI�N:		M�todo que provee la consulta de una Convocatoria por registro individual
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T � R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Convocatoria es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/consultaId")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public ConvocatoriaResponseVO consultaId(ConvocatoriaRequestVO vo) {
	ConvocatoriaResponseVO 	out 			= new ConvocatoriaResponseVO();
	ConvocatoriaServiceImpl	Convocatoria 	= new ConvocatoriaServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (ConvocatoriaRequestVO)logService.setValues(vo, "Convocatoria", "consultaId", "ServiceConvocatoria.class");
	try {
		    out=(ConvocatoriaResponseVO)Convocatoria.consultaId(vo);	
	}catch(Exception e) {
		out = (ConvocatoriaResponseVO)logService.recordException(e,vo);
	}
	return out;
}



/************************************************************************************
 * NOMBRE:			Modificacion de Convocatoria
 * DESCRIPCI�N:		M�todo que provee la modificacion de una Convocatoria
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T � R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Convocatoria es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/modificacion")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public ConvocatoriaResponseVO modificacion(ConvocatoriaRequestVO vo) {
	ConvocatoriaResponseVO 	out 			= new ConvocatoriaResponseVO();
	ConvocatoriaServiceImpl	Convocatoria 	= new ConvocatoriaServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (ConvocatoriaRequestVO)logService.setValues(vo, "Convocatoria", "modificacion", "ServiceConvocatoria.class");
	try {
		    out=(ConvocatoriaResponseVO)Convocatoria.modificacion(vo);	
	}catch(Exception e) {
		out = (ConvocatoriaResponseVO)logService.recordException(e,vo);
	}
	return out;
}


}
