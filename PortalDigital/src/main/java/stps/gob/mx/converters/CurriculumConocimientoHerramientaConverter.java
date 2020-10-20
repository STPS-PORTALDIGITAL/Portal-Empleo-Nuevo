package stps.gob.mx.converters;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.domain.CurriculumConocimientoHerramienta;
import stps.gob.mx.dto.CurriculumConocimientoHerramientaDTO;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class CurriculumConocimientoHerramientaConverter {
	final static Logger log = Logger.getLogger(CurriculumConocimientoHerramientaConverter.class);
	
	public CurriculumConocimientoHerramientaDTO toCurriculumConocimientoHerramientaDTO (CurriculumConocimientoHerramienta data, CurriculumConocimientoHerramientaDTO out) {
		
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
	
	public CurriculumConocimientoHerramienta toCurriculumConocimientoHerramienta (CurriculumConocimientoHerramientaDTO data, CurriculumConocimientoHerramienta out) {
		
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
	
public CurriculumConocimientoHerramienta toCurriculumConocimientoHerramientaAlta (CurriculumConocimientoHerramientaDTO data, CurriculumConocimientoHerramienta out) {
		
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



public CurriculumConocimientoHerramienta toCurriculumConocimientoHerramientaBaja (CurriculumConocimientoHerramientaDTO data, CurriculumConocimientoHerramienta out) {
	
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
	
	
	public CurriculumConocimientoHerramientaDTO toCopy (CurriculumConocimientoHerramientaDTO in, CurriculumConocimientoHerramientaDTO out) {
			
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
