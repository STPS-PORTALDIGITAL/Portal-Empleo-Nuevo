package stps.gob.mx.converters;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.domain.Persona;
import stps.gob.mx.dto.PersonaDTO;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class PersonaConverter {
	final static Logger log = Logger.getLogger(PersonaConverter.class);
	
	public PersonaDTO toPersonaDTO (Persona data, PersonaDTO out) {
		
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
	
	public Persona toPersona (PersonaDTO data, Persona out) {
		
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
	
public Persona toPersonaAlta (PersonaDTO data, Persona out) {
		
		BasicConfigurator.configure();
		try {
			PropertyUtils.copyProperties(out,data);
			out.setEstatus(Constantes.ACTIVO);
			out.setId(Integer.parseInt(data.getId()));
		}catch(Exception e) {
			StackTraceElement element[] = e.getStackTrace();
			for (int a=0; a < element.length; a++){
				log.error(element[a]);
			}

		}
		return out;
	}



public Persona toPersonaBaja (PersonaDTO data, Persona out) {
	
	BasicConfigurator.configure();
	try {
		PropertyUtils.copyProperties(out,data);
		out.setEstatus(Constantes.INACTIVO);	
		out.setId(Integer.parseInt(data.getId()));
	}catch(Exception e) {
		StackTraceElement element[] = e.getStackTrace();
		for (int a=0; a < element.length; a++){
			log.error(element[a]);
		}

	}
	return out;
}
	
	
	public PersonaDTO toCopy (PersonaDTO in, PersonaDTO out) {
			
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
