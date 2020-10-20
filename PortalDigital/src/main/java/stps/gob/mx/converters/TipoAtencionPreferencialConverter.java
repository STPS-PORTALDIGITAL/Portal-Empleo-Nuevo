package stps.gob.mx.converters;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.domain.TipoAtencionPreferencial;
import stps.gob.mx.dto.TipoAtencionPreferencialDTO;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class TipoAtencionPreferencialConverter {
	final static Logger log = Logger.getLogger(TipoAtencionPreferencialConverter.class);
	
	public TipoAtencionPreferencialDTO toTipoAtencionPreferencialDTO (TipoAtencionPreferencial data, TipoAtencionPreferencialDTO out) {
		
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
	
	public TipoAtencionPreferencial toTipoAtencionPreferencial (TipoAtencionPreferencialDTO data, TipoAtencionPreferencial out) {
		
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
	
public TipoAtencionPreferencial toTipoAtencionPreferencialAlta (TipoAtencionPreferencialDTO data, TipoAtencionPreferencial out) {
		
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



public TipoAtencionPreferencial toTipoAtencionPreferencialBaja (TipoAtencionPreferencialDTO data, TipoAtencionPreferencial out) {
	
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
	
	
	public TipoAtencionPreferencialDTO toCopy (TipoAtencionPreferencialDTO in, TipoAtencionPreferencialDTO out) {
			
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
