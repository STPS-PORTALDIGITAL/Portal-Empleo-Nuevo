package sne.gob.mx.ws.rest.service;

import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import sne.gob.mx.general.services.LogService;
import sne.gob.mx.portal.service.impl.MunicipioServiceImpl;
import sne.gob.mx.ws.rest.vo.MunicipioRequestVO;
import sne.gob.mx.ws.rest.vo.MunicipioResponseVO;


@Path("/Municipio")
public class ServiceMunicipio {
final static Logger log = Logger.getLogger(ServiceMunicipio.class);



/************************************************************************************
 * NOMBRE:			Alta de Municipio
 * DESCRIPCIÓN:		Método que provee el alta de una Municipio
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Municipio es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/alta")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public MunicipioResponseVO alta(MunicipioRequestVO vo) {
	MunicipioResponseVO 	out 			= new MunicipioResponseVO();
	MunicipioServiceImpl	Municipio 	= new MunicipioServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (MunicipioRequestVO)logService.setValues(vo, "Municipio", "alta", "ServiceMunicipio.class");
	try {
			out=(MunicipioResponseVO)Municipio.alta(vo);
	}catch(Exception e) {	
		logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Baja de Municipio
 * DESCRIPCIÓN:		Método que provee la baja de una Municipio
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 23/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Municipio es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/baja")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public MunicipioResponseVO baja(MunicipioRequestVO vo) {
	MunicipioResponseVO 	out 			= new MunicipioResponseVO();
	MunicipioServiceImpl	Municipio 	= new MunicipioServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (MunicipioRequestVO)logService.setValues(vo, "Municipio", "baja", "ServiceMunicipio.class");
	try {
		    out=(MunicipioResponseVO)Municipio.baja(vo);	
	}catch(Exception e) {
		out = (MunicipioResponseVO)logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Consulta de Municipio
 * DESCRIPCIÓN:		Método que provee la consulta de una Municipio
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Municipio es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 *  
 * ***********************************************************************************/
@POST
@Path("/consulta")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public MunicipioResponseVO consulta(MunicipioRequestVO vo) {
	MunicipioResponseVO 	out 			= new MunicipioResponseVO();
	MunicipioServiceImpl	Municipio 	= new MunicipioServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (MunicipioRequestVO)logService.setValues(vo, "Municipio", "consulta", "ServiceMunicipio.class");
	try {
		    out=(MunicipioResponseVO)Municipio.consulta(vo);	
	}catch(Exception e) {
		out = (MunicipioResponseVO)logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Consulta de Municipio
 * DESCRIPCIÓN:		Método que provee la consulta de una Municipio por registro individual
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Municipio es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/consultaId")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public MunicipioResponseVO consultaId(MunicipioRequestVO vo) {
	MunicipioResponseVO 	out 			= new MunicipioResponseVO();
	MunicipioServiceImpl	Municipio 	= new MunicipioServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (MunicipioRequestVO)logService.setValues(vo, "Municipio", "consultaId", "ServiceMunicipio.class");
	try {
		    out=(MunicipioResponseVO)Municipio.consultaId(vo);	
	}catch(Exception e) {
		out = (MunicipioResponseVO)logService.recordException(e,vo);
	}
	return out;
}



/************************************************************************************
 * NOMBRE:			Modificacion de Municipio
 * DESCRIPCIÓN:		Método que provee la modificacion de una Municipio
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Municipio es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/modificacion")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public MunicipioResponseVO modificacion(MunicipioRequestVO vo) {
	MunicipioResponseVO 	out 			= new MunicipioResponseVO();
	MunicipioServiceImpl	Municipio 	= new MunicipioServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (MunicipioRequestVO)logService.setValues(vo, "Municipio", "modificacion", "ServiceMunicipio.class");
	try {
		    out=(MunicipioResponseVO)Municipio.modificacion(vo);	
	}catch(Exception e) {
		out = (MunicipioResponseVO)logService.recordException(e,vo);
	}
	return out;
}


}
