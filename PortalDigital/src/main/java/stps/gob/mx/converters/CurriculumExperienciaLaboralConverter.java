package stps.gob.mx.converters;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.domain.CurriculumExperienciaLaboral;
import stps.gob.mx.dto.CurriculumExperienciaLaboralDTO;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class CurriculumExperienciaLaboralConverter {
	final static Logger log = Logger.getLogger(CurriculumExperienciaLaboralConverter.class);
	
	public CurriculumExperienciaLaboralDTO toCurriculumExperienciaLaboralDTO (CurriculumExperienciaLaboral data, CurriculumExperienciaLaboralDTO out) {
		
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
	
	public CurriculumExperienciaLaboral toCurriculumExperienciaLaboral (CurriculumExperienciaLaboralDTO data, CurriculumExperienciaLaboral out) {
		
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
	
public CurriculumExperienciaLaboral toCurriculumExperienciaLaboralAlta (CurriculumExperienciaLaboralDTO data, CurriculumExperienciaLaboral out) {
		
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



public CurriculumExperienciaLaboral toCurriculumExperienciaLaboralBaja (CurriculumExperienciaLaboralDTO data, CurriculumExperienciaLaboral out) {
	
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
	
	
	public CurriculumExperienciaLaboralDTO toCopy (CurriculumExperienciaLaboralDTO in, CurriculumExperienciaLaboralDTO out) {
			
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
