package sne.gob.mx.general.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Logger;

import sne.gob.mx.bo.EntryBO;
import sne.gob.mx.db.connection.ConnectionJDBC;
import sne.gob.mx.ws.rest.vo.RequestVO;

public class SecurityService {
final static Logger log = Logger.getLogger(PropertieService.class);

	public SecurityService(){}
	
	/************************************************************************************
	 * NOMBRE:			checkPermisos
	 * DESCRIPCIÓN:		Método que valida los permisos del usuario sobre el servicio
	 * AUTOR:			JDGR
	 * FECHA:			09/May/2020
	 * CONTRATO:		TBD
	 * --------------------------H I S T Ó R I C O---------------------------------------
	 * FECHA		VERSION			AUTOR			COMENTARIOS
	 * 09/May/2020	1.0001			JDGR			Baseline
	 * 
	 * ***********************************************************************************/
	public boolean checkPermisos (RequestVO vo) {
		boolean 						flag 			= true;
		String							expSQL			= new String("");
		Connection 						conn 			= null;
		ConnectionJDBC					jdbc			= new ConnectionJDBC();
		Statement 						st 				= null;
		ResultSet 						rs 				= null;
		EntryBO 						object    		= new EntryBO();
		PropertieService				propService 	= new PropertieService();
		
		try {
			object 	= propService.fillBO("entry.Properties");
			conn 	= jdbc.getConnectionPostgresql(object);
			//expSQL  = jdbc.getQuery("Security", "check");	
			
			/*st = conn.createStatement();
			rs = st.executeQuery(expSQL);
			
			while (rs.next()){
				
			}
			st.close();
			rs.close();*/
			conn.close();
		}catch(Exception e) {
			StackTraceElement element[] = e.getStackTrace();
			for (int a=0; a < element.length; a++){
				log.error(element[a]);
			}
		}
		return flag;
	}
	
	
	
}
