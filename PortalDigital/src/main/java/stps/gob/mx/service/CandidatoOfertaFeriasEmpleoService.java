package stps.gob.mx.service;

import java.util.List;

import stps.gob.mx.dto.CandidatoOfertaFeriasEmpleoDTO;

public interface CandidatoOfertaFeriasEmpleoService {
	CandidatoOfertaFeriasEmpleoDTO alta(CandidatoOfertaFeriasEmpleoDTO dto);
	CandidatoOfertaFeriasEmpleoDTO baja(CandidatoOfertaFeriasEmpleoDTO dto);
	List<CandidatoOfertaFeriasEmpleoDTO> consulta(CandidatoOfertaFeriasEmpleoDTO dto);
	List<CandidatoOfertaFeriasEmpleoDTO> consultaId(CandidatoOfertaFeriasEmpleoDTO dto);
	CandidatoOfertaFeriasEmpleoDTO modificacion(CandidatoOfertaFeriasEmpleoDTO dto);
}
