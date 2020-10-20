package sne.gob.mx.general.services;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import sne.gob.mx.bo.EntryBO;
import sne.gob.mx.db.connection.ConnectionJDBC;
import sne.gob.mx.service.constantes.Constantes;
import sne.gob.mx.ws.rest.vo.RequestVO;
import sne.gob.mx.ws.rest.vo.ResponseVO;

public class LogService {
final static Logger log = Logger.getLogger(LogService.class);

	
	public LogService(){}
	
	/************************************************************************************
	 * NOMBRE:			recordLog
	 * DESCRIPCIÓN:		Método que provee el registro log de los servicios
	 * AUTOR:			JDGR
	 * FECHA:			09/May/2020
	 * CONTRATO:		TBD
	 * --------------------------H I S T Ó R I C O---------------------------------------
	 * FECHA		VERSION			AUTOR			COMENTARIOS
	 * 09/May/2020	1.0001			JDGR			Baseline
	 * 
	 * ***********************************************************************************/
	public void recordLog (RequestVO vo) {
		EntryBO 			object    		= new EntryBO();
		Connection 			conn 			= null;
		String				expSQL			= new String("");
		PreparedStatement 	pstmt			= null;
		ConnectionJDBC		jdbc			= new ConnectionJDBC();
		PropertieService	connectService 	= new PropertieService();
		
		BasicConfigurator.configure();
		try {
			object 	= connectService.fillBO("entry.Properties");
			conn 	= jdbc.getConnectionPostgresql(object);
			
			vo.setServicio("Log");
			vo.setAccion("recordLog");
			expSQL  = jdbc.getQuery(vo);	
			pstmt	= conn.prepareStatement(expSQL);
			
			//pstmt.executeUpdate();
			pstmt.close();
			conn.close();
			
		}catch(Exception e) {
			StackTraceElement element[] = e.getStackTrace();
			for (int a=0; a < element.length; a++){
				log.error(element[a]);
			}
		}
	}
	
	/************************************************************************************
	 * NOMBRE:			recordLog
	 * DESCRIPCIÓN:		Método que provee el registro log de los servicios
	 * AUTOR:			JDGR
	 * FECHA:			09/May/2020
	 * CONTRATO:		TBD
	 * --------------------------H I S T Ó R I C O---------------------------------------
	 * FECHA		VERSION			AUTOR			COMENTARIOS
	 * 12/May/2020	1.0001			JDGR			Baseline
	 * 
	 * ***********************************************************************************/
	public ResponseVO recordException (Exception error, RequestVO vo) {
		EntryBO 			object    		= new EntryBO();
		Connection 			conn 			= null;
		String				expSQL			= new String("");
		PreparedStatement 	pstmt			= null;
		ConnectionJDBC		jdbc			= new ConnectionJDBC();
		PropertieService	connectService 	= new PropertieService();
		ResponseVO			out				= new ResponseVO();
		
		BasicConfigurator.configure();
		try {
			
			StackTraceElement element[] = error.getStackTrace();
			for (int a=0; a < element.length; a++){
				log.error(element[a]);
			}
			vo.setServicio("Log");
			vo.setAccion("recordException");
			object 	= connectService.fillBO("entry.Properties");
			conn 	= jdbc.getConnectionPostgresql(object);
			expSQL  = jdbc.getDescripcionQuery(vo);	
			pstmt	= conn.prepareStatement(expSQL);
			
			//pstmt.executeUpdate();
			pstmt.close();
			conn.close();
			
			out.setResult(Constantes.FALSE);
			out.setMessage(Constantes.ERROR_EXCEPCION);
			
		}catch(Exception e) {
			StackTraceElement element[] = e.getStackTrace();
			for (int a=0; a < element.length; a++){
				log.error(element[a]);
			}
		}
		
		return out;
	}
	
	public RequestVO setValues(RequestVO vo, String servicio, String accion, String clazz) {
		try {
			vo.setServicio(servicio);
			vo.setAccion(accion);
			vo.setClazz(clazz);
		}catch(Exception e) {
			StackTraceElement element[] = e.getStackTrace();
			for (int a=0; a < element.length; a++){
				log.error(element[a]);
			}
		}
		return vo;
	}
	
	
	
	
}
