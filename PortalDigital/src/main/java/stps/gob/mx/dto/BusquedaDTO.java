package stps.gob.mx.dto;

import java.util.List;

public class BusquedaDTO extends RequestDTO{
	private List<OfertaEmpleoDTO> listEmpleos;
	private List<CandidatoDTO> listCandidatos;
	private String que;
	private String donde;
	
	public List<OfertaEmpleoDTO> getListEmpleos() {
		return listEmpleos;
	}
	public void setListEmpleos(List<OfertaEmpleoDTO> listEmpleos) {
		this.listEmpleos = listEmpleos;
	}
	public List<CandidatoDTO> getListCandidatos() {
		return listCandidatos;
	}
	public void setListCandidatos(List<CandidatoDTO> listCandidatos) {
		this.listCandidatos = listCandidatos;
	}
	public String getQue() {
		return que;
	}
	public void setQue(String que) {
		this.que = que;
	}
	public String getDonde() {
		return donde;
	}
	public void setDonde(String donde) {
		this.donde = donde;
	}
	
	
	

}
