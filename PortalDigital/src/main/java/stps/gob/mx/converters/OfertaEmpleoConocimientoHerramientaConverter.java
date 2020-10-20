package stps.gob.mx.converters;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.domain.OfertaEmpleoConocimientoHerramienta;
import stps.gob.mx.dto.OfertaEmpleoConocimientoHerramientaDTO;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class OfertaEmpleoConocimientoHerramientaConverter {
	final static Logger log = Logger.getLogger(OfertaEmpleoConocimientoHerramientaConverter.class);
	
	public OfertaEmpleoConocimientoHerramientaDTO toOfertaEmpleoConocimientoHerramientaDTO (OfertaEmpleoConocimientoHerramienta data, OfertaEmpleoConocimientoHerramientaDTO out) {
		
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
	
	public OfertaEmpleoConocimientoHerramienta toOfertaEmpleoConocimientoHerramienta (OfertaEmpleoConocimientoHerramientaDTO data, OfertaEmpleoConocimientoHerramienta out) {
		
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
	
public OfertaEmpleoConocimientoHerramienta toOfertaEmpleoConocimientoHerramientaAlta (OfertaEmpleoConocimientoHerramientaDTO data, OfertaEmpleoConocimientoHerramienta out) {
		
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



public OfertaEmpleoConocimientoHerramienta toOfertaEmpleoConocimientoHerramientaBaja (OfertaEmpleoConocimientoHerramientaDTO data, OfertaEmpleoConocimientoHerramienta out) {
	
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
	
	
	public OfertaEmpleoConocimientoHerramientaDTO toCopy (OfertaEmpleoConocimientoHerramientaDTO in, OfertaEmpleoConocimientoHerramientaDTO out) {
			
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
