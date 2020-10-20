package stps.gob.mx.converters;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.domain.OfertaEmpleoHabilidadCompetencia;
import stps.gob.mx.dto.OfertaEmpleoHabilidadCompetenciaDTO;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class OfertaEmpleoHabilidadCompetenciaConverter {
	final static Logger log = Logger.getLogger(OfertaEmpleoHabilidadCompetenciaConverter.class);
	
	public OfertaEmpleoHabilidadCompetenciaDTO toOfertaEmpleoHabilidadCompetenciaDTO (OfertaEmpleoHabilidadCompetencia data, OfertaEmpleoHabilidadCompetenciaDTO out) {
		
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
	
	public OfertaEmpleoHabilidadCompetencia toOfertaEmpleoHabilidadCompetencia (OfertaEmpleoHabilidadCompetenciaDTO data, OfertaEmpleoHabilidadCompetencia out) {
		
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
	
public OfertaEmpleoHabilidadCompetencia toOfertaEmpleoHabilidadCompetenciaAlta (OfertaEmpleoHabilidadCompetenciaDTO data, OfertaEmpleoHabilidadCompetencia out) {
		
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



public OfertaEmpleoHabilidadCompetencia toOfertaEmpleoHabilidadCompetenciaBaja (OfertaEmpleoHabilidadCompetenciaDTO data, OfertaEmpleoHabilidadCompetencia out) {
	
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
	
	
	public OfertaEmpleoHabilidadCompetenciaDTO toCopy (OfertaEmpleoHabilidadCompetenciaDTO in, OfertaEmpleoHabilidadCompetenciaDTO out) {
			
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
