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
import sne.gob.mx.ws.rest.vo.EntidadFederativaObjectVO;
import sne.gob.mx.ws.rest.vo.EntidadFederativaRequestVO;
import sne.gob.mx.ws.rest.vo.EntidadFederativaResponseVO;
import sne.gob.mx.ws.rest.vo.RequestVO;
import sne.gob.mx.ws.rest.vo.ResponseVO;

public class EntidadFederativaServiceImpl implements Service {
	final static Logger log = Logger.getLogger(EntidadFederativaServiceImpl.class);
	
	/************************************************************************************
	 * NOMBRE:			Alta de EntidadFederativa
	 * DESCRIPCI�N:		M�todo que provee el alta de un EntidadFederativa
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
		EntidadFederativaRequestVO 	in 				= new EntidadFederativaRequestVO();
		EntidadFederativaResponseVO 	out 			= new EntidadFederativaResponseVO();
		EntidadFederativaObjectVO 	obj				= new EntidadFederativaObjectVO();
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
				
				in = (EntidadFederativaRequestVO)vo;
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
			vo.setClazz("EntidadFederativaServiceImpl.class");
			out = (EntidadFederativaResponseVO)logService.recordException(e,vo);
		}
		return out;
			
	}
	/************************************************************************************
	 * NOMBRE:			Baja de EntidadFederativa
	 * DESCRIPCI�N:		M�todo que provee la baja de un EntidadFederativa
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
		EntidadFederativaRequestVO 	in 				= new EntidadFederativaRequestVO();
		EntidadFederativaResponseVO 	out 			= new EntidadFederativaResponseVO();
		EntidadFederativaObjectVO 	obj				= new EntidadFederativaObjectVO();
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
				
				in = (EntidadFederativaRequestVO)vo;
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
			vo.setClazz("EntidadFederativaServiceImpl.class");
			out = (EntidadFederativaResponseVO)logService.recordException(e,vo);
		}
		return out;

	}
	/************************************************************************************
	 * NOMBRE:			Consulta de EntidadFederativa
	 * DESCRIPCI�N:		M�todo que provee la consulta de un EntidadFederativa
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
		EntidadFederativaRequestVO 	in 				= new EntidadFederativaRequestVO();
		EntidadFederativaResponseVO 	out 			= new EntidadFederativaResponseVO();
		EntidadFederativaObjectVO 	obj				= new EntidadFederativaObjectVO();
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
				
				in = (EntidadFederativaRequestVO)vo;
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
			vo.setClazz("EntidadFederativaServiceImpl.class");
			out = (EntidadFederativaResponseVO)logService.recordException(e,vo);
		}
		return out;

	}
	/************************************************************************************
	 * NOMBRE:			Consulta de EntidadFederativa x Id
	 * DESCRIPCI�N:		M�todo que provee la consulta de un EntidadFederativa x Id
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
		EntidadFederativaRequestVO 		in 				= new EntidadFederativaRequestVO();
		EntidadFederativaResponseVO 		out 			= new EntidadFederativaResponseVO();
		EntidadFederativaObjectVO 		obj				= new EntidadFederativaObjectVO();
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
				
				in = (EntidadFederativaRequestVO)vo;
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
			vo.setClazz("EntidadFederativaServiceImpl.class");
			out = (EntidadFederativaResponseVO)logService.recordException(e,vo);
		}
		return out;
	}
	/************************************************************************************
	 * NOMBRE:			Modificacion de EntidadFederativa
	 * DESCRIPCI�N:		M�todo que provee la modificacion de un EntidadFederativa
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
		EntidadFederativaRequestVO 	in 				= new EntidadFederativaRequestVO();
		EntidadFederativaResponseVO 	out 			= new EntidadFederativaResponseVO();
		EntidadFederativaObjectVO 	obj				= new EntidadFederativaObjectVO();
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
				
				in = (EntidadFederativaRequestVO)vo;
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
			vo.setClazz("EntidadFederativaServiceImpl.class");
			out = (EntidadFederativaResponseVO)logService.recordException(e,vo);
		}
		return out;


}
	
	
}
