package stps.gob.mx.dto;

public class OfertaEmpleoHabilidadCompetenciaDTO  extends RequestDTO{
	private String id;
	private String idOfertaEmpleo;
	private String idHabiliddadCompetencia;
	private String certificado;
	private String estatus;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdOfertaEmpleo() {
		return idOfertaEmpleo;
	}
	public void setIdOfertaEmpleo(String idOfertaEmpleo) {
		this.idOfertaEmpleo = idOfertaEmpleo;
	}
	public String getIdHabiliddadCompetencia() {
		return idHabiliddadCompetencia;
	}
	public void setIdHabiliddadCompetencia(String idHabiliddadCompetencia) {
		this.idHabiliddadCompetencia = idHabiliddadCompetencia;
	}
	public String getCertificado() {
		return certificado;
	}
	public void setCertificado(String certificado) {
		this.certificado = certificado;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
	
	
}
