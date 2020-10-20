package stps.gob.mx.converters;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.domain.TipoInstitucionEducativa;
import stps.gob.mx.dto.TipoInstitucionEducativaDTO;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class TipoInstitucionEducativaConverter {
	final static Logger log = Logger.getLogger(TipoInstitucionEducativaConverter.class);
	
	public TipoInstitucionEducativaDTO toTipoInstitucionEducativaDTO (TipoInstitucionEducativa data, TipoInstitucionEducativaDTO out) {
		
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
	
	public TipoInstitucionEducativa toTipoInstitucionEducativa (TipoInstitucionEducativaDTO data, TipoInstitucionEducativa out) {
		
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
	
public TipoInstitucionEducativa toTipoInstitucionEducativaAlta (TipoInstitucionEducativaDTO data, TipoInstitucionEducativa out) {
		
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



public TipoInstitucionEducativa toTipoInstitucionEducativaBaja (TipoInstitucionEducativaDTO data, TipoInstitucionEducativa out) {
	
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
	
	
	public TipoInstitucionEducativaDTO toCopy (TipoInstitucionEducativaDTO in, TipoInstitucionEducativaDTO out) {
			
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
