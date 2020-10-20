package stps.gob.mx.converters;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.domain.SectorGiro;
import stps.gob.mx.dto.SectorGiroDTO;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class SectorGiroConverter {
	final static Logger log = Logger.getLogger(SectorGiroConverter.class);
	
	public SectorGiroDTO toSectorGiroDTO (SectorGiro data, SectorGiroDTO out) {
		
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
	
	public SectorGiro toSectorGiro (SectorGiroDTO data, SectorGiro out) {
		
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
	
public SectorGiro toSectorGiroAlta (SectorGiroDTO data, SectorGiro out) {
		
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



public SectorGiro toSectorGiroBaja (SectorGiroDTO data, SectorGiro out) {
	
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
	
	
	public SectorGiroDTO toCopy (SectorGiroDTO in, SectorGiroDTO out) {
			
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
