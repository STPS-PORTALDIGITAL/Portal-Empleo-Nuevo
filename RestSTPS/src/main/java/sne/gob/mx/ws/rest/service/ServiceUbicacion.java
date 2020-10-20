package sne.gob.mx.ws.rest.service;

import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import sne.gob.mx.general.services.LogService;
import sne.gob.mx.portal.service.impl.UbicacionServiceImpl;
import sne.gob.mx.ws.rest.vo.UbicacionRequestVO;
import sne.gob.mx.ws.rest.vo.UbicacionResponseVO;


@Path("/Ubicacion")
public class ServiceUbicacion {
final static Logger log = Logger.getLogger(ServiceUbicacion.class);



/************************************************************************************
 * NOMBRE:			Alta de Ubicacion
 * DESCRIPCIÓN:		Método que provee el alta de una Ubicacion
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Ubicacion es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/alta")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public UbicacionResponseVO alta(UbicacionRequestVO vo) {
	UbicacionResponseVO 	out 			= new UbicacionResponseVO();
	UbicacionServiceImpl	Ubicacion 	= new UbicacionServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (UbicacionRequestVO)logService.setValues(vo, "Ubicacion", "alta", "ServiceUbicacion.class");
	try {
			out=(UbicacionResponseVO)Ubicacion.alta(vo);
	}catch(Exception e) {	
		logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Baja de Ubicacion
 * DESCRIPCIÓN:		Método que provee la baja de una Ubicacion
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 23/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Ubicacion es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/baja")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public UbicacionResponseVO baja(UbicacionRequestVO vo) {
	UbicacionResponseVO 	out 			= new UbicacionResponseVO();
	UbicacionServiceImpl	Ubicacion 	= new UbicacionServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (UbicacionRequestVO)logService.setValues(vo, "Ubicacion", "baja", "ServiceUbicacion.class");
	try {
		    out=(UbicacionResponseVO)Ubicacion.baja(vo);	
	}catch(Exception e) {
		out = (UbicacionResponseVO)logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Consulta de Ubicacion
 * DESCRIPCIÓN:		Método que provee la consulta de una Ubicacion
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Ubicacion es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 *  
 * ***********************************************************************************/
@POST
@Path("/consulta")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public UbicacionResponseVO consulta(UbicacionRequestVO vo) {
	UbicacionResponseVO 	out 			= new UbicacionResponseVO();
	UbicacionServiceImpl	Ubicacion 	= new UbicacionServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (UbicacionRequestVO)logService.setValues(vo, "Ubicacion", "consulta", "ServiceUbicacion.class");
	try {
		    out=(UbicacionResponseVO)Ubicacion.consulta(vo);	
	}catch(Exception e) {
		out = (UbicacionResponseVO)logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Consulta de Ubicacion
 * DESCRIPCIÓN:		Método que provee la consulta de una Ubicacion por registro individual
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Ubicacion es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/consultaId")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public UbicacionResponseVO consultaId(UbicacionRequestVO vo) {
	UbicacionResponseVO 	out 			= new UbicacionResponseVO();
	UbicacionServiceImpl	Ubicacion 	= new UbicacionServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (UbicacionRequestVO)logService.setValues(vo, "Ubicacion", "consultaId", "ServiceUbicacion.class");
	try {
		    out=(UbicacionResponseVO)Ubicacion.consultaId(vo);	
	}catch(Exception e) {
		out = (UbicacionResponseVO)logService.recordException(e,vo);
	}
	return out;
}



/************************************************************************************
 * NOMBRE:			Modificacion de Ubicacion
 * DESCRIPCIÓN:		Método que provee la modificacion de una Ubicacion
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Ubicacion es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/modificacion")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public UbicacionResponseVO modificacion(UbicacionRequestVO vo) {
	UbicacionResponseVO 	out 			= new UbicacionResponseVO();
	UbicacionServiceImpl	Ubicacion 	= new UbicacionServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (UbicacionRequestVO)logService.setValues(vo, "Ubicacion", "modificacion", "ServiceUbicacion.class");
	try {
		    out=(UbicacionResponseVO)Ubicacion.modificacion(vo);	
	}catch(Exception e) {
		out = (UbicacionResponseVO)logService.recordException(e,vo);
	}
	return out;
}


}
