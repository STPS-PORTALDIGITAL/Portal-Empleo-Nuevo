package stps.gob.mx.converters;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.domain.Usuario;
import stps.gob.mx.dto.UsuarioDTO;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class UsuarioConverter {
	final static Logger log = Logger.getLogger(UsuarioConverter.class);
	
	public UsuarioDTO toUsuarioDTO (Usuario data, UsuarioDTO out) {
		
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
	
	public Usuario toUsuario (UsuarioDTO data, Usuario out) {
		
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
	
public Usuario toUsuarioAlta (UsuarioDTO data, Usuario out) {
		
		BasicConfigurator.configure();
		try {
			out.setUsuario(data.getUsuario());
			out.setPasswrd(data.getPasswrd());
			out.setEmail(data.getEmail());
			out.setEstatus(Constantes.ACTIVO);
			out.setActive(Constantes.FALSE);
			out.setIdTipousuario(Integer.parseInt(data.getId_tipousuario()));
			out.setIdUsuario(Integer.parseInt(data.getIdUsuario()));
		}catch(Exception e) {
			StackTraceElement element[] = e.getStackTrace();
			for (int a=0; a < element.length; a++){
				log.error(element[a]);
			}

		}
		return out;
	}



public Usuario toUsuarioBaja (UsuarioDTO data, Usuario out) {
	
	BasicConfigurator.configure();
	try {
		PropertyUtils.copyProperties(out,data);
		out.setEstatus(Constantes.INACTIVO);	
	}catch(Exception e) {
		StackTraceElement element[] = e.getStackTrace();
		for (int a=0; a < element.length; a++){
			log.error(element[a]);
		}

	}
	return out;
}
	
	
	public UsuarioDTO toCopy (UsuarioDTO in, UsuarioDTO out) {
			
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
