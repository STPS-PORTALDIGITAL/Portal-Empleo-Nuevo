package stps.gob.mx.converters;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.domain.OfertaEmpleo;
import stps.gob.mx.dto.OfertaEmpleoDTO;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class OfertaEmpleoConverter {
	final static Logger log = Logger.getLogger(OfertaEmpleoConverter.class);
	
	public OfertaEmpleoDTO toOfertaEmpleoDTO (OfertaEmpleo data, OfertaEmpleoDTO out) {
		
		BasicConfigurator.configure();
		try {
			PropertyUtils.copyProperties(out,data);
		}catch(Exception e) {
			StackTraceElement element[] = e.getStackTrace();
			for (int a=0; a < element.length; a++){
				log.error(element[a]);
			}

		}
		return out;
	}
	
	public OfertaEmpleo toOfertaEmpleo (OfertaEmpleoDTO data, OfertaEmpleo out) {
		
		BasicConfigurator.configure();
		try {
			PropertyUtils.copyProperties(out,data);
		}catch(Exception e) {
			StackTraceElement element[] = e.getStackTrace();
			for (int a=0; a < element.length; a++){
				log.error(element[a]);
			}

		}
		return out;
	}
	
public OfertaEmpleo toOfertaEmpleoAlta (OfertaEmpleoDTO data, OfertaEmpleo out) {
		
		BasicConfigurator.configure();
		try {
			PropertyUtils.copyProperties(out,data);

		}catch(Exception e) {
			StackTraceElement element[] = e.getStackTrace();
			for (int a=0; a < element.length; a++){
				log.error(element[a]);
			}

		}
		return out;
	}



public OfertaEmpleo toOfertaEmpleoBaja (OfertaEmpleoDTO data, OfertaEmpleo out) {
	
	BasicConfigurator.configure();
	try {
		PropertyUtils.copyProperties(out,data);

	}catch(Exception e) {
		StackTraceElement element[] = e.getStackTrace();
		for (int a=0; a < element.length; a++){
			log.error(element[a]);
		}

	}
	return out;
}
	
	
	public OfertaEmpleoDTO toCopy (OfertaEmpleoDTO in, OfertaEmpleoDTO out) {
			
			BasicConfigurator.configure();
			try {
				PropertyUtils.copyProperties(out,in);
			}catch(Exception e) {
				StackTraceElement element[] = e.getStackTrace();
				for (int a=0; a < element.length; a++){
					log.error(element[a]);
				}
	
			}
			return out;
		}
	
	
}
