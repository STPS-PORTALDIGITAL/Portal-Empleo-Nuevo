package stps.gob.mx.converters;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.domain.RolesResponsabilidades;
import stps.gob.mx.dto.RolesResponsabilidadesDTO;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class RolesResponsabilidadesConverter {
	final static Logger log = Logger.getLogger(RolesResponsabilidadesConverter.class);
	
	public RolesResponsabilidadesDTO toRolesResponsabilidadesDTO (RolesResponsabilidades data, RolesResponsabilidadesDTO out) {
		
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
	
	public RolesResponsabilidades toRolesResponsabilidades (RolesResponsabilidadesDTO data, RolesResponsabilidades out) {
		
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
	
public RolesResponsabilidades toRolesResponsabilidadesAlta (RolesResponsabilidadesDTO data, RolesResponsabilidades out) {
		
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



public RolesResponsabilidades toRolesResponsabilidadesBaja (RolesResponsabilidadesDTO data, RolesResponsabilidades out) {
	
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
	
	
	public RolesResponsabilidadesDTO toCopy (RolesResponsabilidadesDTO in, RolesResponsabilidadesDTO out) {
			
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
