package sne.gob.mx.ws.rest.service;

import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import sne.gob.mx.general.services.LogService;
import sne.gob.mx.portal.service.impl.CandidatoServiceImpl;
import sne.gob.mx.ws.rest.vo.CandidatoRequestVO;
import sne.gob.mx.ws.rest.vo.CandidatoResponseVO;


@Path("/Candidato")
public class ServiceCandidato {
final static Logger log = Logger.getLogger(ServiceCandidato.class);



/************************************************************************************
 * NOMBRE:			Alta de Candidato
 * DESCRIPCIÓN:		Método que provee el alta de una Candidato
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Candidato es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/alta")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public CandidatoResponseVO alta(CandidatoRequestVO vo) {
	CandidatoResponseVO 	out 			= new CandidatoResponseVO();
	CandidatoServiceImpl	Candidato 	= new CandidatoServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (CandidatoRequestVO)logService.setValues(vo, "Candidato", "alta", "ServiceCandidato.class");
	try {
			out=(CandidatoResponseVO)Candidato.alta(vo);
	}catch(Exception e) {	
		logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Baja de Candidato
 * DESCRIPCIÓN:		Método que provee la baja de una Candidato
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 23/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Candidato es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/baja")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public CandidatoResponseVO baja(CandidatoRequestVO vo) {
	CandidatoResponseVO 	out 			= new CandidatoResponseVO();
	CandidatoServiceImpl	Candidato 	= new CandidatoServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (CandidatoRequestVO)logService.setValues(vo, "Candidato", "baja", "ServiceCandidato.class");
	try {
		    out=(CandidatoResponseVO)Candidato.baja(vo);	
	}catch(Exception e) {
		out = (CandidatoResponseVO)logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Consulta de Candidato
 * DESCRIPCIÓN:		Método que provee la consulta de una Candidato
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Candidato es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 *  
 * ***********************************************************************************/
@POST
@Path("/consulta")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public CandidatoResponseVO consulta(CandidatoRequestVO vo) {
	CandidatoResponseVO 	out 			= new CandidatoResponseVO();
	CandidatoServiceImpl	Candidato 	= new CandidatoServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (CandidatoRequestVO)logService.setValues(vo, "Candidato", "consulta", "ServiceCandidato.class");
	try {
		    out=(CandidatoResponseVO)Candidato.consulta(vo);	
	}catch(Exception e) {
		out = (CandidatoResponseVO)logService.recordException(e,vo);
	}
	return out;
}

/************************************************************************************
 * NOMBRE:			Consulta de Candidato
 * DESCRIPCIÓN:		Método que provee la consulta de una Candidato por registro individual
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Candidato es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/consultaId")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public CandidatoResponseVO consultaId(CandidatoRequestVO vo) {
	CandidatoResponseVO 	out 			= new CandidatoResponseVO();
	CandidatoServiceImpl	Candidato 	= new CandidatoServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (CandidatoRequestVO)logService.setValues(vo, "Candidato", "consultaId", "ServiceCandidato.class");
	try {
		    out=(CandidatoResponseVO)Candidato.consultaId(vo);	
	}catch(Exception e) {
		out = (CandidatoResponseVO)logService.recordException(e,vo);
	}
	return out;
}



/************************************************************************************
 * NOMBRE:			Modificacion de Candidato
 * DESCRIPCIÓN:		Método que provee la modificacion de una Candidato
 * AUTOR:			JDGR
 * FECHA:			30/Abr/2020
 * CONTRATO:		TBD
 * --------------------------H I S T Ó R I C O---------------------------------------
 * FECHA		VERSION			AUTOR			COMENTARIOS
 * 30/Abr/20	1.0001			JDGR			Baseline
 * 08/May/20	1.0002			JDGR			Tabla Candidato es agregada a Postgres
 * 12/May/20	1.0003			JDGR			Se agrega servicio de excepciones
 * 
 * ***********************************************************************************/
@POST
@Path("/modificacion")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public CandidatoResponseVO modificacion(CandidatoRequestVO vo) {
	CandidatoResponseVO 	out 			= new CandidatoResponseVO();
	CandidatoServiceImpl	Candidato 	= new CandidatoServiceImpl();
	LogService				logService		= new LogService();
	
	BasicConfigurator.configure();
	vo = (CandidatoRequestVO)logService.setValues(vo, "Candidato", "modificacion", "ServiceCandidato.class");
	try {
		    out=(CandidatoResponseVO)Candidato.modificacion(vo);	
	}catch(Exception e) {
		out = (CandidatoResponseVO)logService.recordException(e,vo);
	}
	return out;
}


}
