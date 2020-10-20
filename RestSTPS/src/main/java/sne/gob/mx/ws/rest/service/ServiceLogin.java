package sne.gob.mx.ws.rest.service;



import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import sne.gob.mx.general.services.LogService;
import sne.gob.mx.portal.service.impl.CVServiceImpl;
import sne.gob.mx.portal.service.impl.LoginServiceImpl;
import sne.gob.mx.ws.rest.vo.CVResponseVO;
import sne.gob.mx.ws.rest.vo.LoginRequestVO;
import sne.gob.mx.ws.rest.vo.LoginResponseVO;
import sne.gob.mx.ws.rest.vo.VOUsuario;

@Path("/Login")
public class ServiceLogin {
	final static Logger log = Logger.getLogger(ServiceLogin.class);
	/************************************************************************************
	 * NOMBRE:			validaUsuario
	 * DESCRIPCIÓN:		Método que valida al usuario
	 * AUTOR:			JDGR
	 * FECHA:			09/May/2020
	 * CONTRATO:		TBD
	 * --------------------------H I S T Ó R I C O---------------------------------------
	 * FECHA		VERSION			AUTOR			COMENTARIOS
	 * 09/May/2020	1.0001			JDGR			Baseline
	 * 
	 * ***********************************************************************************/
	@POST
	@Path("/validaUsuario")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public LoginResponseVO validaUsuario(LoginRequestVO vo) {
		LoginResponseVO 	out = new LoginResponseVO();
		LoginServiceImpl	login 	= new LoginServiceImpl();
		LogService				logService		= new LogService();
		
		BasicConfigurator.configure();
		vo = (LoginRequestVO)logService.setValues(vo, "Login", "validaUsuario", "ServiceLogin.class");
		try {
			    out=(LoginResponseVO)login.validaUsuario(vo);	
		}catch(Exception e) {
			logService.recordException(e,vo);
		}
		return out;
	}
	
}
