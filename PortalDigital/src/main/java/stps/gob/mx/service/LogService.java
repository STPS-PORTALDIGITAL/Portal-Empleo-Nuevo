package stps.gob.mx.service;

import stps.gob.mx.dto.RequestDTO;


public interface LogService {
	Long recordLog(RequestDTO vo);
	RequestDTO recordException(Exception e, RequestDTO vo);
	RequestDTO setValues(RequestDTO vo, String servicio, String metodo, String clazz);
	
}
