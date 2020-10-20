package sne.gob.mx.ws.rest.service;

import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import sne.gob.mx.general.services.LogService;
import sne.gob.mx.portal.service.impl.VacanteServiceImpl;
import sne.gob.mx.ws.rest.vo.VacanteRequestVO;
import sne.gob.mx.ws.rest.vo.VacanteResponseVO;


@Path("/Vacante")
public class ServiceVacante {
final static Logger log = Logger.getLogger(ServiceVacante.class);



/************************************************************************************
 * NOMBRE:			Alta de Vacante
 * DESCRIPCIÓN:		Método que provee el alta de una Vacante
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Vacante es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/alta")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public VacanteResponseVO alta(VacanteRequestVO vo) {
	VacanteResponseVO 	out 			= new VacanteResponseVO();
	VacanteServiceImpl	Vacante 	= new VacanteServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (VacanteRequestVO)logService.setValues(vo, "Vacante", "alta", "ServiceVacante.class");
	try {
			out=(VacanteResponseVO)Vacante.alta(vo);
	}catch(Exception e) {	
		logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Baja de Vacante
 * DESCRIPCIÓN:		Método que provee la baja de una Vacante
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 23/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Vacante es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/baja")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public VacanteResponseVO baja(VacanteRequestVO vo) {
	VacanteResponseVO 	out 			= new VacanteResponseVO();
	VacanteServiceImpl	Vacante 	= new VacanteServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (VacanteRequestVO)logService.setValues(vo, "Vacante", "baja", "ServiceVacante.class");
	try {
		    out=(VacanteResponseVO)Vacante.baja(vo);	
	}catch(Exception e) {
		out = (VacanteResponseVO)logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Consulta de Vacante
 * DESCRIPCIÓN:		Método que provee la consulta de una Vacante
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Vacante es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 *  
 * ***********************************************************************************/
@POST
@Path("/consulta")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public VacanteResponseVO consulta(VacanteRequestVO vo) {
	VacanteResponseVO 	out 			= new VacanteResponseVO();
	VacanteServiceImpl	Vacante 	= new VacanteServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (VacanteRequestVO)logService.setValues(vo, "Vacante", "consulta", "ServiceVacante.class");
	try {
		    out=(VacanteResponseVO)Vacante.consulta(vo);	
	}catch(Exception e) {
		out = (VacanteResponseVO)logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Consulta de Vacante
 * DESCRIPCIÓN:		Método que provee la consulta de una Vacante por registro individual
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Vacante es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/consultaId")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public VacanteResponseVO consultaId(VacanteRequestVO vo) {
	VacanteResponseVO 	out 			= new VacanteResponseVO();
	VacanteServiceImpl	Vacante 	= new VacanteServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (VacanteRequestVO)logService.setValues(vo, "Vacante", "consultaId", "ServiceVacante.class");
	try {
		    out=(VacanteResponseVO)Vacante.consultaId(vo);	
	}catch(Exception e) {
		out = (VacanteResponseVO)logService.recordException(e,vo);
	}
	return out;
}



/************************************************************************************
 * NOMBRE:			Modificacion de Vacante
 * DESCRIPCIÓN:		Método que provee la modificacion de una Vacante
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Vacante es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/modificacion")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public VacanteResponseVO modificacion(VacanteRequestVO vo) {
	VacanteResponseVO 	out 			= new VacanteResponseVO();
	VacanteServiceImpl	Vacante 	= new VacanteServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (VacanteRequestVO)logService.setValues(vo, "Vacante", "modificacion", "ServiceVacante.class");
	try {
		    out=(VacanteResponseVO)Vacante.modificacion(vo);	
	}catch(Exception e) {
		out = (VacanteResponseVO)logService.recordException(e,vo);
	}
	return out;
}


}
