package stps.gob.mx.service;


import java.util.Date;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stps.gob.mx.domain.LogActivity;
import stps.gob.mx.dto.RequestDTO;

import stps.gob.mx.repositories.LogActivityRepository;


@Service
public class LogServiceImpl implements LogService  {
final static Logger log = Logger.getLogger(LogServiceImpl.class);

@Autowired
LogActivityRepository repository;



@Override
public Long recordLog(RequestDTO vo) {
	Date		 	date			= new Date();
	LogActivity	 	logActivity 	= new LogActivity();

	
	BasicConfigurator.configure();
	try {
		LogActivity entity = new LogActivity();
		entity.setIp(vo.getIp() != null ? vo.getIp():"127.0.0.1");
		entity.setIdUsuario(Long.parseLong(vo.getIdUsuario() != null ? vo.getIdUsuario():"0" ));
		entity.setServicio(vo.getServicio());
		entity.setMetodo(vo.getMetodo());
		entity.setClase(vo.getClase());
		entity.setFecha(date);
		entity.setComments(vo.getComments() != null ? vo.getComments():"No comments");
		logActivity = repository.save(entity);	
		
		
	}catch(Exception e) {
		StackTraceElement element[] = e.getStackTrace();
		for (int a=0; a < element.length; a++){
			log.error(element[a]);
		}
	}
	return logActivity.getIdLogActivity();
	
}

@Override
public RequestDTO recordException(Exception e, RequestDTO vo) {
	RequestDTO	out	= new RequestDTO();
	
	
	try {
		recordLog(vo);
		StackTraceElement element[] = e.getStackTrace();
		for (int a=0; a < element.length; a++){
			log.error(element[a]);
		}
	}catch(Exception err) {
		StackTraceElement element[] = err.getStackTrace();
		for (int a=0; a < element.length; a++){
			log.error(element[a]);
		}
	}
	return out;
}

@Override
public RequestDTO setValues(RequestDTO vo, String servicio, String metodo, String clase) {
	BasicConfigurator.configure();
	
	try {
		vo.setServicio(servicio);
		vo.setMetodo(metodo);
		vo.setClase(clase);
		if (vo.getToken() !=null) {
			if (vo.getToken().length() > 0) {
				
			}else {
				vo.setToken("S/D");
			}
		}else {
			vo.setToken("S/D");
		}
		//recordLog(vo);
	}catch(Exception e) {
		StackTraceElement element[] = e.getStackTrace();
		for (int a=0; a < element.length; a++){
			log.error(element[a]);
		}
	}
	return vo;
}




}
