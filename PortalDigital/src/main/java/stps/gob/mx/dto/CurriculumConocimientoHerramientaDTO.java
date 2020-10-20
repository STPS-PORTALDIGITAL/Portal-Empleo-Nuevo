package stps.gob.mx.dto;

public class CurriculumConocimientoHerramientaDTO  extends RequestDTO{
	private String id;
	private String idCurriculum;
	private String idConocimientoherramienta;
	private String aniosExperiencia;
	private String certificado;
	private String estatus;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdCurriculum() {
		return idCurriculum;
	}
	public void setIdCurriculum(String idCurriculum) {
		this.idCurriculum = idCurriculum;
	}
	public String getIdConocimientoherramienta() {
		return idConocimientoherramienta;
	}
	public void setIdConocimientoherramienta(String idConocimientoherramienta) {
		this.idConocimientoherramienta = idConocimientoherramienta;
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
