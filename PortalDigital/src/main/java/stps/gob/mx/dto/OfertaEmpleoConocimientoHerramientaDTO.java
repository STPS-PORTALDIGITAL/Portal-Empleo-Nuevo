package stps.gob.mx.dto;

public class OfertaEmpleoConocimientoHerramientaDTO  extends RequestDTO{
	private String id;
	private String idOfertaEmpleo;
	private String idConocimientoHerramienta;
	private String aniosExperiencia;
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
	public String getIdConocimientoHerramienta() {
		return idConocimientoHerramienta;
	}
	public void setIdConocimientoHerramienta(String idConocimientoHerramienta) {
		this.idConocimientoHerramienta = idConocimientoHerramienta;
	}
	public String getAniosExperiencia() {
		return aniosExperiencia;
	}
	public void setAniosExperiencia(String aniosExperiencia) {
		this.aniosExperiencia = aniosExperiencia;
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
