package stps.gob.mx.converters;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.domain.PerfilBusquedaEmpleo;
import stps.gob.mx.dto.PerfilBusquedaEmpleoDTO;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class PerfilBusquedaEmpleoConverter {
	final static Logger log = Logger.getLogger(PerfilBusquedaEmpleoConverter.class);
	
	public PerfilBusquedaEmpleoDTO toPerfilBusquedaEmpleoDTO (PerfilBusquedaEmpleo data, PerfilBusquedaEmpleoDTO out) {
		
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
	
	public PerfilBusquedaEmpleo toPerfilBusquedaEmpleo (PerfilBusquedaEmpleoDTO data, PerfilBusquedaEmpleo out) {
		
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
	
public PerfilBusquedaEmpleo toPerfilBusquedaEmpleoAlta (PerfilBusquedaEmpleoDTO data, PerfilBusquedaEmpleo out) {
		
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



public PerfilBusquedaEmpleo toPerfilBusquedaEmpleoBaja (PerfilBusquedaEmpleoDTO data, PerfilBusquedaEmpleo out) {
	
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
	
	
	public PerfilBusquedaEmpleoDTO toCopy (PerfilBusquedaEmpleoDTO in, PerfilBusquedaEmpleoDTO out) {
			
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
