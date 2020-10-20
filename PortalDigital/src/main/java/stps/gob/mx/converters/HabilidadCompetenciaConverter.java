package stps.gob.mx.converters;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.domain.HabilidadCompetencia;
import stps.gob.mx.dto.HabilidadCompetenciaDTO;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class HabilidadCompetenciaConverter {
	final static Logger log = Logger.getLogger(HabilidadCompetenciaConverter.class);
	
	public HabilidadCompetenciaDTO toHabilidadCompetenciaDTO (HabilidadCompetencia data, HabilidadCompetenciaDTO out) {
		
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
	
	public HabilidadCompetencia toHabilidadCompetencia (HabilidadCompetenciaDTO data, HabilidadCompetencia out) {
		
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
	
public HabilidadCompetencia toHabilidadCompetenciaAlta (HabilidadCompetenciaDTO data, HabilidadCompetencia out) {
		
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



public HabilidadCompetencia toHabilidadCompetenciaBaja (HabilidadCompetenciaDTO data, HabilidadCompetencia out) {
	
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
	
	
	public HabilidadCompetenciaDTO toCopy (HabilidadCompetenciaDTO in, HabilidadCompetenciaDTO out) {
			
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
