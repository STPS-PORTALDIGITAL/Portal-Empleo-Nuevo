package sne.gob.mx.portal.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import sne.gob.mx.bo.EntryBO;
import sne.gob.mx.db.connection.ConnectionJDBC;
import sne.gob.mx.general.services.LogService;
import sne.gob.mx.general.services.PropertieService;
import sne.gob.mx.general.services.SecurityService;
import sne.gob.mx.portal.service.Service;
import sne.gob.mx.service.constantes.Constantes;
import sne.gob.mx.ws.rest.vo.EmpleoObjectVO;
import sne.gob.mx.ws.rest.vo.EmpleoRequestVO;
import sne.gob.mx.ws.rest.vo.EmpleoResponseVO;
import sne.gob.mx.ws.rest.vo.RequestVO;
import sne.gob.mx.ws.rest.vo.ResponseVO;

public class  EmpleoServiceImpl implements Service {
	final static Logger log = Logger.getLogger( EmpleoServiceImpl.class);
	
	/************************************************************************************
	 * NOMBRE:			Alta de  Empleo
	 * DESCRIPCI�N:		M�todo que provee el alta de un  Empleo
	 * AUTOR:			JDGR
	 * FECHA:			07/May/2020
	 * CONTRATO:		TBD
	 * --------------------------H I S T � R I C O---------------------------------------
	 * FECHA		VERSION			AUTOR			COMENTARIOS
	 * 07/May/2020	1.0001			JDGR			Baseline
	 * 11/May/2020	1.0002			JDGR			Homologaci�n de los servicios log/security
	 * 12/May/2020	1.0003			JDGR			Update metodos getQuery/getDescripcionQuery
	 * 
	 * ***********************************************************************************/
	public ResponseVO alta(RequestVO vo) {
		 EmpleoRequestVO 	in 				= new  EmpleoRequestVO();
		 EmpleoResponseVO 	out 			= new  EmpleoResponseVO();
		 EmpleoObjectVO 	obj				= new  EmpleoObjectVO();
		Connection 				conn 			= null;
		ConnectionJDBC			jdbc			= new ConnectionJDBC();
		EntryBO 				object    		= new EntryBO();
		PropertieService		connectService 	= new PropertieService();
		PreparedStatement 		pstmt			= null;
		String					expSQL			= new String("");
		String					descQuery		= new String("");
		SecurityService			security		= new SecurityService();
		LogService				logService		= new LogService();
		
		BasicConfigurator.configure();
		try {
			if (security.checkPermisos(vo)) {
				object 		= connectService.fillBO("entry.Properties");
				conn 		= jdbc.getConnectionPostgresql(object);
				expSQL  	= jdbc.getQuery(vo);
				descQuery 	= jdbc.getDescripcionQuery(vo);
				pstmt		= conn.prepareStatement(expSQL);
				
				in = ( EmpleoRequestVO)vo;
				obj = in.getVo();
				
				out.setDescQuery(descQuery);
				out.setResult(Constantes.TRUE);
				out.setMessage(Constantes.OPERACION_EXITOSA);
				
				vo.setDescQuery(descQuery);
				logService.recordLog(vo);
				
				pstmt.close();
				conn.close();
			}else {
				out.setResult(Constantes.FALSE);
				out.setMessage(Constantes.NO_PERMISO);
			}
		}catch(Exception e) {
			vo.setClazz(" EmpleoServiceImpl.class");
			out = ( EmpleoResponseVO)logService.recordException(e,vo);
		}
		return out;
			
	}
	/************************************************************************************
	 * NOMBRE:			Baja de  Empleo
	 * DESCRIPCI�N:		M�todo que provee la baja de un  Empleo
	 * AUTOR:			JDGR
	 * FECHA:			07/May/2020
	 * CONTRATO:		TBD
	 * --------------------------H I S T � R I C O---------------------------------------
	 * FECHA		VERSION			AUTOR			COMENTARIOS
	 * 07/May/2020	1.0001			JDGR			Baseline
	 * 11/May/2020	1.0002			JDGR			Homologaci�n de los servicios log/security
	 * 12/May/2020	1.0003			JDGR			Update metodos getQuery/getDescripcionQuery
	 * 
	 * ***********************************************************************************/
	public ResponseVO baja(RequestVO vo) {
		 EmpleoRequestVO 	in 				= new  EmpleoRequestVO();
		 EmpleoResponseVO 	out 			= new  EmpleoResponseVO();
		 EmpleoObjectVO 	obj				= new  EmpleoObjectVO();
		Connection 				conn 			= null;
		ConnectionJDBC			jdbc			= new ConnectionJDBC();
		EntryBO 				object    		= new EntryBO();
		PropertieService		connectService 	= new PropertieService();
		PreparedStatement 		pstmt			= null;
		String					expSQL			= new String("");
		SecurityService			security		= new SecurityService();
		LogService				logService		= new LogService();
		String					descQuery		= new String("");
		
		BasicConfigurator.configure();
		try {
			if (security.checkPermisos(vo)) {
				object 		= connectService.fillBO("entry.Properties");
				conn 		= jdbc.getConnectionPostgresql(object);
				expSQL  	= jdbc.getQuery(vo);
				descQuery 	= jdbc.getDescripcionQuery(vo);
				pstmt		= conn.prepareStatement(expSQL);
				
				in = ( EmpleoRequestVO)vo;
				obj = in.getVo();
				
				out.setDescQuery(descQuery);
				out.setResult(Constantes.TRUE);
				out.setMessage(Constantes.OPERACION_EXITOSA);
				
				vo.setDescQuery(descQuery);
				logService.recordLog(vo);
				
				pstmt.close();
				conn.close();
			}else {
				out.setResult(Constantes.FALSE);
				out.setMessage(Constantes.NO_PERMISO);
			}
		}catch(Exception e) {
			vo.setClazz(" EmpleoServiceImpl.class");
			out = ( EmpleoResponseVO)logService.recordException(e,vo);
		}
		return out;

	}
	/************************************************************************************
	 * NOMBRE:			Consulta de  Empleo
	 * DESCRIPCI�N:		M�todo que provee la consulta de un  Empleo
	 * AUTOR:			JDGR
	 * FECHA:			07/May/2020
	 * CONTRATO:		TBD
	 * --------------------------H I S T � R I C O---------------------------------------
	 * FECHA		VERSION			AUTOR			COMENTARIOS
	 * 07/May/2020	1.0001			JDGR			Baseline
	 * 11/May/2020	1.0002			JDGR			Homologaci�n de los servicios log/security
	 * 12/May/2020	1.0003			JDGR			Update metodos getQuery/getDescripcionQuery
	 * 
	 * ***********************************************************************************/
	public ResponseVO consulta(RequestVO vo) {
		 EmpleoRequestVO 	in 				= new  EmpleoRequestVO();
		 EmpleoResponseVO 	out 			= new  EmpleoResponseVO();
		 EmpleoObjectVO 	obj				= new  EmpleoObjectVO();
		Connection 				conn 			= null;
		ConnectionJDBC			jdbc			= new ConnectionJDBC();
		EntryBO 				object    		= new EntryBO();
		PropertieService		connectService 	= new PropertieService();
		Statement 				st				= null;
		String					expSQL			= new String("");
		SecurityService			security		= new SecurityService();
		LogService				logService		= new LogService();
		String					descQuery		= new String("");
		
		BasicConfigurator.configure();
		try {
			if (security.checkPermisos(vo)) {
				object 		= connectService.fillBO("entry.Properties");
				conn 		= jdbc.getConnectionPostgresql(object);
				expSQL  	= jdbc.getQuery(vo);	
				descQuery 	= jdbc.getDescripcionQuery(vo);
				st 			= conn.createStatement();
				
				in = ( EmpleoRequestVO)vo;
				obj = in.getVo();
				
				out.setDescQuery(descQuery);
				out.setResult(Constantes.TRUE);
				out.setMessage(Constantes.OPERACION_EXITOSA);
				
				vo.setDescQuery(descQuery);
				logService.recordLog(vo);
				
				st.close();
				conn.close();
			}else {
				out.setResult(Constantes.FALSE);
				out.setMessage(Constantes.NO_PERMISO);
			}
		}catch(Exception e) {
			vo.setClazz(" EmpleoServiceImpl.class");
			out = ( EmpleoResponseVO)logService.recordException(e,vo);
		}
		return out;

	}
	/************************************************************************************
	 * NOMBRE:			Consulta de  Empleo x Id
	 * DESCRIPCI�N:		M�todo que provee la consulta de un  Empleo x Id
	 * AUTOR:			JDGR
	 * FECHA:			07/May/2020
	 * CONTRATO:		TBD
	 * --------------------------H I S T � R I C O---------------------------------------
	 * FECHA		VERSION			AUTOR			COMENTARIOS
	 * 07/May/2020	1.0001			JDGR			Baseline
	 * 11/May/2020	1.0002			JDGR			Homologacion de los servicios log/security
	 * 12/May/2020	1.0003			JDGR			Update metodos getQuery/getDescripcionQuery
	 * 
	 * ***********************************************************************************/
	public ResponseVO consultaId(RequestVO vo) {
		 EmpleoRequestVO 		in 				= new  EmpleoRequestVO();
		 EmpleoResponseVO 		out 			= new  EmpleoResponseVO();
		 EmpleoObjectVO 		obj				= new  EmpleoObjectVO();
		Connection 					conn 			= null;
		ConnectionJDBC				jdbc			= new ConnectionJDBC();
		EntryBO 					object    		= new EntryBO();
		PropertieService			connectService 	= new PropertieService();
		PreparedStatement 			pstmt			= null;
		String						expSQL			= new String("");
		SecurityService				security		= new SecurityService();
		LogService					logService		= new LogService();
		String						descQuery		= new String("");
		
		BasicConfigurator.configure();
		try {
			if (security.checkPermisos(vo)) {
				object 		= connectService.fillBO("entry.Properties");
				conn 		= jdbc.getConnectionPostgresql(object);
				expSQL  	= jdbc.getQuery(vo);
				descQuery 	= jdbc.getDescripcionQuery(vo);
				pstmt		= conn.prepareStatement(expSQL);
				
				in = ( EmpleoRequestVO)vo;
				obj = in.getVo();
				
				out.setDescQuery(descQuery);
				out.setResult(Constantes.TRUE);
				out.setMessage(Constantes.OPERACION_EXITOSA);
				
				vo.setDescQuery(descQuery);
				logService.recordLog(vo);
				
				pstmt.close();
				conn.close();
			}else {
				out.setResult(Constantes.FALSE);
				out.setMessage(Constantes.NO_PERMISO);
			}
		}catch(Exception e) {
			vo.setClazz(" EmpleoServiceImpl.class");
			out = ( EmpleoResponseVO)logService.recordException(e,vo);
		}
		return out;
	}
	/************************************************************************************
	 * NOMBRE:			Modificacion de  Empleo
	 * DESCRIPCI�N:		M�todo que provee la modificacion de un  Empleo
	 * AUTOR:			JDGR
	 * FECHA:			07/May/2020
	 * CONTRATO:		TBD
	 * --------------------------H I S T � R I C O---------------------------------------
	 * FECHA		VERSION			AUTOR			COMENTARIOS
	 * 07/May/2020	1.0001			JDGR			Baseline
	 * 11/May/2020	1.0002			JDGR			Homologacion de los servicios log/security
	 * 12/May/2020	1.0003			JDGR			Update metodos getQuery/getDescripcionQuery
	 * 
	 * ***********************************************************************************/
	public ResponseVO modificacion(RequestVO vo) {
		 EmpleoRequestVO 	in 				= new  EmpleoRequestVO();
		 EmpleoResponseVO 	out 			= new  EmpleoResponseVO();
		 EmpleoObjectVO 	obj				= new  EmpleoObjectVO();
		Connection 				conn 			= null;
		ConnectionJDBC			jdbc			= new ConnectionJDBC();
		EntryBO 				object    		= new EntryBO();
		PropertieService		connectService 	= new PropertieService();
		PreparedStatement 		pstmt			= null;
		String					expSQL			= new String("");
		SecurityService			security		= new SecurityService();
		LogService				logService		= new LogService();
		String					descQuery		= new String("");
		
		
		BasicConfigurator.configure();
		try {
			if (security.checkPermisos(vo)) {
				object 		= connectService.fillBO("entry.Properties");
				conn 		= jdbc.getConnectionPostgresql(object);
				expSQL  	= jdbc.getQuery(vo);
				descQuery 	= jdbc.getDescripcionQuery(vo);
				pstmt		= conn.prepareStatement(expSQL);
				
				in = ( EmpleoRequestVO)vo;
				obj = in.getVo();
				
				out.setDescQuery(descQuery);
				out.setResult(Constantes.TRUE);
				out.setMessage(Constantes.OPERACION_EXITOSA);
				
				vo.setDescQuery(descQuery);
				logService.recordLog(vo);
				
				pstmt.close();
				conn.close();
			}else {
				out.setResult(Constantes.FALSE);
				out.setMessage(Constantes.NO_PERMISO);
			}
		}catch(Exception e) {
			vo.setClazz(" EmpleoServiceImpl.class");
			out = ( EmpleoResponseVO)logService.recordException(e,vo);
		}
		return out;


}
	
	
}
