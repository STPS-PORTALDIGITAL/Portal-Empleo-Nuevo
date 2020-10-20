package stps.gob.mx.converters;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.domain.CurriculumOtrosEstudios;
import stps.gob.mx.dto.CurriculumOtrosEstudiosDTO;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class CurriculumOtrosEstudiosConverter {
	final static Logger log = Logger.getLogger(CurriculumOtrosEstudiosConverter.class);
	
	public CurriculumOtrosEstudiosDTO toCurriculumOtrosEstudiosDTO (CurriculumOtrosEstudios data, CurriculumOtrosEstudiosDTO out) {
		
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
	
	public CurriculumOtrosEstudios toCurriculumOtrosEstudios (CurriculumOtrosEstudiosDTO data, CurriculumOtrosEstudios out) {
		
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
	
public CurriculumOtrosEstudios toCurriculumOtrosEstudiosAlta (CurriculumOtrosEstudiosDTO data, CurriculumOtrosEstudios out) {
		
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



public CurriculumOtrosEstudios toCurriculumOtrosEstudiosBaja (CurriculumOtrosEstudiosDTO data, CurriculumOtrosEstudios out) {
	
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
	
	
	public CurriculumOtrosEstudiosDTO toCopy (CurriculumOtrosEstudiosDTO in, CurriculumOtrosEstudiosDTO out) {
			
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
