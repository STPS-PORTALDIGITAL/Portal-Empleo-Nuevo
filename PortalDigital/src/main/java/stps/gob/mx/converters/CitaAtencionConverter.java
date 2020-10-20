package stps.gob.mx.converters;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.domain.CitaAtencion;
import stps.gob.mx.dto.CitaAtencionDTO;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class CitaAtencionConverter {
	final static Logger log = Logger.getLogger(CitaAtencionConverter.class);
	
	public CitaAtencionDTO toCitaAtencionDTO (CitaAtencion data, CitaAtencionDTO out) {
		
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
	
	public CitaAtencion toCitaAtencion (CitaAtencionDTO data, CitaAtencion out) {
		
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
	
public CitaAtencion toCitaAtencionAlta (CitaAtencionDTO data, CitaAtencion out) {
		
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



public CitaAtencion toCitaAtencionBaja (CitaAtencionDTO data, CitaAtencion out) {
	
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
	
	
	public CitaAtencionDTO toCopy (CitaAtencionDTO in, CitaAtencionDTO out) {
			
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
