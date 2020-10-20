package sne.gob.mx.portal.service;

import sne.gob.mx.ws.rest.vo.RequestVO;
import sne.gob.mx.ws.rest.vo.ResponseVO;


public interface Service {
	public ResponseVO alta(RequestVO vo);
	public ResponseVO baja(RequestVO vo);
	public ResponseVO consulta(RequestVO vo);
	public ResponseVO consultaId(RequestVO vo);
	public ResponseVO modificacion(RequestVO v);
	
}
