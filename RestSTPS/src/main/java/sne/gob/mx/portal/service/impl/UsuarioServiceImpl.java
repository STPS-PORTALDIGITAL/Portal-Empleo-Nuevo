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
import sne.gob.mx.ws.rest.vo.UsuarioObjectVO;
import sne.gob.mx.ws.rest.vo.UsuarioRequestVO;
import sne.gob.mx.ws.rest.vo.UsuarioResponseVO;
import sne.gob.mx.ws.rest.vo.RequestVO;
import sne.gob.mx.ws.rest.vo.ResponseVO;

public class UsuarioServiceImpl implements Service {
	final static Logger log = Logger.getLogger(UsuarioServiceImpl.class);
	
	/************************************************************************************
	 * NOMBRE:			Alta de Usuario
	 * DESCRIPCIÓN:		Método que provee el alta de un Usuario
	 * AUTOR:			JDGR
	 * FECHA:			07/May/2020
	 * CONTRATO:		TBD
	 * --------------------------H I S T Ó R I C O---------------------------------------
	 * FECHA		VERSION			AUTOR			COMENTARIOS
	 * 07/May/2020	1.0001			JDGR			Baseline
	 * 11/May/2020	1.0002			JDGR			Homologación de los servicios log/security
	 * 12/May/2020	1.0003			JDGR			Update metodos getQuery/getDescripcionQuery
	 * 
	 * ***********************************************************************************/
	public ResponseVO alta(RequestVO vo) {
		UsuarioRequestVO 	in 				= new UsuarioRequestVO();
		UsuarioResponseVO 	out 			= new UsuarioResponseVO();
		UsuarioObjectVO 	obj				= new UsuarioObjectVO();
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
				
				in = (UsuarioRequestVO)vo;
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
			vo.setClazz("UsuarioServiceImpl.class");
			out = (UsuarioResponseVO)logService.recordException(e,vo);
		}
		return out;
			
	}
	/************************************************************************************
	 * NOMBRE:			Baja de Usuario
	 * DESCRIPCIÓN:		Método que provee la baja de un Usuario
	 * AUTOR:			JDGR
	 * FECHA:			07/May/2020
	 * CONTRATO:		TBD
	 * --------------------------H I S T Ó R I C O---------------------------------------
	 * FECHA		VERSION			AUTOR			COMENTARIOS
	 * 07/May/2020	1.0001			JDGR			Baseline
	 * 11/May/2020	1.0002			JDGR			Homologación de los servicios log/security
	 * 12/May/2020	1.0003			JDGR			Update metodos getQuery/getDescripcionQuery
	 * 
	 * ***********************************************************************************/
	public ResponseVO baja(RequestVO vo) {
		UsuarioRequestVO 	in 				= new UsuarioRequestVO();
		UsuarioResponseVO 	out 			= new UsuarioResponseVO();
		UsuarioObjectVO 	obj				= new UsuarioObjectVO();
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
				
				in = (UsuarioRequestVO)vo;
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
			vo.setClazz("UsuarioServiceImpl.class");
			out = (UsuarioResponseVO)logService.recordException(e,vo);
		}
		return out;

	}
	/************************************************************************************
	 * NOMBRE:			Consulta de Usuario
	 * DESCRIPCIÓN:		Método que provee la consulta de un Usuario
	 * AUTOR:			JDGR
	 * FECHA:			07/May/2020
	 * CONTRATO:		TBD
	 * --------------------------H I S T Ó R I C O---------------------------------------
	 * FECHA		VERSION			AUTOR			COMENTARIOS
	 * 07/May/2020	1.0001			JDGR			Baseline
	 * 11/May/2020	1.0002			JDGR			Homologación de los servicios log/security
	 * 12/May/2020	1.0003			JDGR			Update metodos getQuery/getDescripcionQuery
	 * 
	 * ***********************************************************************************/
	public ResponseVO consulta(RequestVO vo) {
		UsuarioRequestVO 	in 				= new UsuarioRequestVO();
		UsuarioResponseVO 	out 			= new UsuarioResponseVO();
		UsuarioObjectVO 	obj				= new UsuarioObjectVO();
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
				
				in = (UsuarioRequestVO)vo;
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
			vo.setClazz("UsuarioServiceImpl.class");
			out = (UsuarioResponseVO)logService.recordException(e,vo);
		}
		return out;

	}
	/************************************************************************************
	 * NOMBRE:			Consulta de Usuario x Id
	 * DESCRIPCIÓN:		Método que provee la consulta de un Usuario x Id
	 * AUTOR:			JDGR
	 * FECHA:			07/May/2020
	 * CONTRATO:		TBD
	 * --------------------------H I S T Ó R I C O---------------------------------------
	 * FECHA		VERSION			AUTOR			COMENTARIOS
	 * 07/May/2020	1.0001			JDGR			Baseline
	 * 11/May/2020	1.0002			JDGR			Homologacion de los servicios log/security
	 * 12/May/2020	1.0003			JDGR			Update metodos getQuery/getDescripcionQuery
	 * 
	 * ***********************************************************************************/
	public ResponseVO consultaId(RequestVO vo) {
		UsuarioRequestVO 		in 				= new UsuarioRequestVO();
		UsuarioResponseVO 		out 			= new UsuarioResponseVO();
		UsuarioObjectVO 		obj				= new UsuarioObjectVO();
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
				
				in = (UsuarioRequestVO)vo;
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
			vo.setClazz("UsuarioServiceImpl.class");
			out = (UsuarioResponseVO)logService.recordException(e,vo);
		}
		return out;
	}
	/************************************************************************************
	 * NOMBRE:			Modificacion de Usuario
	 * DESCRIPCIÓN:		Método que provee la modificacion de un Usuario
	 * AUTOR:			JDGR
	 * FECHA:			07/May/2020
	 * CONTRATO:		TBD
	 * --------------------------H I S T Ó R I C O---------------------------------------
	 * FECHA		VERSION			AUTOR			COMENTARIOS
	 * 07/May/2020	1.0001			JDGR			Baseline
	 * 11/May/2020	1.0002			JDGR			Homologacion de los servicios log/security
	 * 12/May/2020	1.0003			JDGR			Update metodos getQuery/getDescripcionQuery
	 * 
	 * ***********************************************************************************/
	public ResponseVO modificacion(RequestVO vo) {
		UsuarioRequestVO 	in 				= new UsuarioRequestVO();
		UsuarioResponseVO 	out 			= new UsuarioResponseVO();
		UsuarioObjectVO 	obj				= new UsuarioObjectVO();
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
				
				in = (UsuarioRequestVO)vo;
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
			vo.setClazz("UsuarioServiceImpl.class");
			out = (UsuarioResponseVO)logService.recordException(e,vo);
		}
		return out;


}
	
	
}
