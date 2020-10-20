package stps.gob.mx.dto;

import java.util.List;

public class InicioDTO {
	private List<String> listaEmpleos;//ok
	private List<String> listaMunicipiosEntidad;
	private List<String> listaFerias;
	private List<String> listaConvocatorias;
	private int numeroOfertasEmpleo;//ok
	private int numeroCandidatos;
	
	
	public List<String> getListaEmpleos() {
		return listaEmpleos;
	}
	public void setListaEmpleos(List<String> listaEmpleos) {
		this.listaEmpleos = listaEmpleos;
	}
	public List<String> getListaMunicipiosEntidad() {
		return listaMunicipiosEntidad;
	}
	public void setListaMunicipiosEntidad(List<String> listaMunicipiosEntidad) {
		this.listaMunicipiosEntidad = listaMunicipiosEntidad;
	}
	
	public List<String> getListaFerias() {
		return listaFerias;
	}
	public void setListaFerias(List<String> listaFerias) {
		this.listaFerias = listaFerias;
	}
	public List<String> getListaConvocatorias() {
		return listaConvocatorias;
	}
	public void setListaConvocatorias(List<String> listaConvocatorias) {
		this.listaConvocatorias = listaConvocatorias;
	}
	public int getNumeroOfertasEmpleo() {
		return numeroOfertasEmpleo;
	}
	public void setNumeroOfertasEmpleo(int numeroOfertasEmpleo) {
		this.numeroOfertasEmpleo = numeroOfertasEmpleo;
	}
	public int getNumeroCandidatos() {
		return numeroCandidatos;
	}
	public void setNumeroCandidatos(int numeroCandidatos) {
		this.numeroCandidatos = numeroCandidatos;
	}
	
	
	
	
}
