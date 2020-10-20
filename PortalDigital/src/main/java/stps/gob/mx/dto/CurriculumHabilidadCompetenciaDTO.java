
package stps.gob.mx.dto;

public class CurriculumHabilidadCompetenciaDTO  extends RequestDTO{
	private String id;
	private String idCurriculum;
	private String idHabilidadCompetencia;
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
	public String getIdHabilidadCompetencia() {
		return idHabilidadCompetencia;
	}
	public void setIdHabilidadCompetencia(String idHabilidadCompetencia) {
		this.idHabilidadCompetencia = idHabilidadCompetencia;
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
