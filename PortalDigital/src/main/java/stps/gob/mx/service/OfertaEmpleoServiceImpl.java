package stps.gob.mx.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stps.gob.mx.constantes.Constantes;
import stps.gob.mx.converters.OfertaEmpleoConverter;
import stps.gob.mx.domain.OfertaEmpleo;
import stps.gob.mx.dto.OfertaEmpleoDTO;
import stps.gob.mx.repositories.OfertaEmpleoRepository;



@Service
public class OfertaEmpleoServiceImpl implements  OfertaEmpleoService{
	final static Logger log = Logger.getLogger(OfertaEmpleoServiceImpl.class);
	
	
	@Autowired
	LogService logService;
	
	@Autowired
	OfertaEmpleoRepository repository;

	@Override
	public OfertaEmpleoDTO alta(OfertaEmpleoDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OfertaEmpleoDTO baja(OfertaEmpleoDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OfertaEmpleoDTO> consulta(OfertaEmpleoDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OfertaEmpleoDTO> consultaId(OfertaEmpleoDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OfertaEmpleoDTO modificacion(OfertaEmpleoDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	

}

