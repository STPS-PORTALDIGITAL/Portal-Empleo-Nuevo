package stps.gob.mx.converters;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.domain.CurriculumHabilidadCompetencia;
import stps.gob.mx.dto.CurriculumHabilidadCompetenciaDTO;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class CurriculumHabilidadCompetenciaConverter {
	final static Logger log = Logger.getLogger(CurriculumHabilidadCompetenciaConverter.class);
	
	public CurriculumHabilidadCompetenciaDTO toCurriculumHabilidadCompetenciaDTO (CurriculumHabilidadCompetencia data, CurriculumHabilidadCompetenciaDTO out) {
		
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
	
	public CurriculumHabilidadCompetencia toCurriculumHabilidadCompetencia (CurriculumHabilidadCompetenciaDTO data, CurriculumHabilidadCompetencia out) {
		
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
	
public CurriculumHabilidadCompetencia toCurriculumHabilidadCompetenciaAlta (CurriculumHabilidadCompetenciaDTO data, CurriculumHabilidadCompetencia out) {
		
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



public CurriculumHabilidadCompetencia toCurriculumHabilidadCompetenciaBaja (CurriculumHabilidadCompetenciaDTO data, CurriculumHabilidadCompetencia out) {
	
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
	
	
	public CurriculumHabilidadCompetenciaDTO toCopy (CurriculumHabilidadCompetenciaDTO in, CurriculumHabilidadCompetenciaDTO out) {
			
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
