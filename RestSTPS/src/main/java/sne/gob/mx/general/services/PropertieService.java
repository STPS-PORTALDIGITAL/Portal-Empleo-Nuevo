package sne.gob.mx.general.services;

import org.apache.log4j.Logger;
import sne.gob.mx.bo.EntryBO;

public class PropertieService {
	final static Logger log = Logger.getLogger(PropertieService.class);

	
	public PropertieService(){}
	
	
	public EntryBO fillBO(String entryProperties){
		EntryBO				bo						= new EntryBO();
		UtilsSeguridad 		utils 					= new UtilsSeguridad();
		ReadProperties		prop					= new ReadProperties();
		

		try{
			bo.setUrl(prop.getProperty("postgres.url", entryProperties).trim() 							!= null ? utils.desencripta(prop.getProperty("postgres.url", entryProperties).trim()):"");
			bo.setUsername(prop.getProperty("postgres.username", entryProperties).trim() 				!= null ? utils.desencripta(prop.getProperty("postgres.username", entryProperties).trim()):"");
			bo.setPassword(prop.getProperty("postgres.password", entryProperties).trim() 				!= null ? utils.desencripta(prop.getProperty("postgres.password", entryProperties).trim()):"");
			bo.setUrlDB(prop.getProperty("postgres.urlDB", entryProperties).trim() 						!= null ? utils.desencripta(prop.getProperty("postgres.urlDB", entryProperties).trim()):"");
			bo.setUsernameDB(prop.getProperty("postgres.usernameDB", entryProperties).trim() 			!= null ? utils.desencripta(prop.getProperty("postgres.usernameDB", entryProperties).trim()):"");
			bo.setPasswordDB(prop.getProperty("postgres.passwordDB", entryProperties).trim() 			!= null ? utils.desencripta(prop.getProperty("postgres.passwordDB", entryProperties).trim()):"");
					
		}catch(Exception e){
			log.error(e.getCause()+":"+e.getMessage());
		}
		return bo;
	}
}
