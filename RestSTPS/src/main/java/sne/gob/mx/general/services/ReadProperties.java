package sne.gob.mx.general.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;
import org.apache.log4j.Logger;



public class ReadProperties {
	final static Logger log = Logger.getLogger(ReadProperties.class);

	
	public String getProperty(String getProp, String entryProperties){
		File  aqui = new File(".");
		Properties propiedades = new Properties();
		String path = new String("");
		String prop = new String("");
		String ruta = new String("");
		
		try{
			path = aqui.getAbsolutePath();
			
			ruta = path.replace(".", "").replace("\\", "/")+entryProperties;
			//log.info("ruta: "+ruta);
		 propiedades.load(new FileInputStream(ruta));
		 //log.info("getProp: "+getProp);
		 //log.info(String.valueOf(propiedades.getProperty(getProp)));
		 if (propiedades.getProperty(getProp) != null){
			 prop = propiedades.getProperty(getProp);
		 }else{
			 log.error("Prop: "+getProp+" no encontrada");
			 prop="N/D";
		 }
		}catch(Exception e){
			log.error(e.getCause()+" "+e.getMessage());
		}
		return prop;
	}
	
	
	public void setProperty(String setProp, String entryProperties, String value){
		File  aqui = new File(".");
		Properties propiedades = new Properties();
		String path = new String("");
		String ruta = new String("");
		
		try{
			path = aqui.getAbsolutePath();
			
			ruta = path.replace(".", "").replace("\\", "/")+entryProperties;
			//log.info("ruta en setProperty: "+ruta);
		 propiedades.load(new FileInputStream(ruta));
		 //log.info("setProp: "+setProp);
		 //log.info(String.valueOf(propiedades.getProperty(setProp)));

			 propiedades.setProperty(setProp,value);
			String prop = propiedades.getProperty(setProp);
			
			File f = new File(ruta);
	        OutputStream out = new FileOutputStream( f );
	        propiedades.store(out, "This is an optional header comment string");
			
			//log.info("new value for "+setProp+": "+prop);

		}catch(Exception e){
			log.error(e.getCause()+" "+e.getMessage());
		}
	}
	
	
	
}
