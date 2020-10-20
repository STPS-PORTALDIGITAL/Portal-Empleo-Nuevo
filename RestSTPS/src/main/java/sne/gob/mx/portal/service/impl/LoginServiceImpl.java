    package sne.gob.mx.portal.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import sne.gob.mx.bo.EntryBO;
import sne.gob.mx.db.connection.ConnectionJDBC;
import sne.gob.mx.general.services.LogService;
import sne.gob.mx.general.services.PropertieService;
import sne.gob.mx.portal.service.Service;
import sne.gob.mx.service.constantes.Constantes;
import sne.gob.mx.ws.rest.service.ServicePersona;
import sne.gob.mx.ws.rest.vo.CVObjectVO;
import sne.gob.mx.ws.rest.vo.CVRequestVO;
import sne.gob.mx.ws.rest.vo.CVResponseVO;
import sne.gob.mx.ws.rest.vo.LoginObjectVO;
import sne.gob.mx.ws.rest.vo.LoginRequestVO;
import sne.gob.mx.ws.rest.vo.LoginResponseVO;
import sne.gob.mx.ws.rest.vo.PerfilObjectVO;
import sne.gob.mx.ws.rest.vo.PerfilRequestVO;
import sne.gob.mx.ws.rest.vo.PerfilResponseVO;
import sne.gob.mx.ws.rest.vo.RequestVO;
import sne.gob.mx.ws.rest.vo.ResponseVO;

public class LoginServiceImpl implements Service {
	final static Logger log = Logger.getLogger(LoginServiceImpl.class);

	/************************************************************************************
	 * NOMBRE:			validaUsuario
	 * DESCRIPCIÓN:		Método que valida al usuario
	 * AUTOR:			JDGR
	 * FECHA:			09/May/2020
	 * CONTRATO:		TBD
	 * --------------------------H I S T Ó R I C O---------------------------------------
	 * FECHA		VERSION			AUTOR			COMENTARIOS
	 * 09/May/2020	1.0001			JDGR			Baseline
	 * 11/May2020	1.0002			JDGR			Se agregan los servicios de log/security
	 * 
	 * ***********************************************************************************/
	public ResponseVO validaUsuario(RequestVO vo) {
		LoginRequestVO 		in 				= new LoginRequestVO();
		LoginResponseVO 	out 			= new LoginResponseVO();
		LoginObjectVO 		obj				= new LoginObjectVO();
		Connection 			conn 			= null;
		ConnectionJDBC		jdbc			= new ConnectionJDBC();
		EntryBO 			object    		= new EntryBO();
		PropertieService	connectService 	= new PropertieService();
		PreparedStatement 	pstmt			= null;
		String				expSQL			= new String("");//Automatizar
		LogService			logService		= new LogService();		
		String				descQuery		= new String("");
		
		BasicConfigurator.configure();
		try {
			object 		= connectService.fillBO("entry.Properties");
			conn 		= jdbc.getConnectionPostgresql(object);
			expSQL  	= jdbc.getQuery(vo);	
			descQuery	= jdbc.getDescripcionQuery(vo);
			pstmt		= conn.prepareStatement(expSQL);
			
			in = (LoginRequestVO)vo;
			obj = in.getVo();
			
			out.setDescQuery(descQuery);
			out.setResult(Constantes.TRUE);
			out.setMessage(Constantes.OPERACION_EXITOSA);
			
			vo.setDescQuery(descQuery);
			logService.recordLog(vo);
			
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			vo.setClazz("LoginServiceImpl.class");
			out = (LoginResponseVO)logService.recordException(e,vo);
		}
		return out;
	}
	
	public ResponseVO alta(RequestVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseVO baja(RequestVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseVO consulta(RequestVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseVO consultaId(RequestVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResponseVO modificacion(RequestVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
