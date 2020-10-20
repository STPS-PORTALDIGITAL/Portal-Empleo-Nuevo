package stps.gob.mx.dto;

public class CurriculumIdiomaDTO  extends RequestDTO{
	private String id;
	private String idCurriculum;
	private String idIdioma;
	private String dominioIdioma;
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
	public String getIdIdioma() {
		return idIdioma;
	}
	public void setIdIdioma(String idIdioma) {
		this.idIdioma = idIdioma;
	}
	public String getDominioIdioma() {
		return dominioIdioma;
	}
	public void setDominioIdioma(String dominioIdioma) {
		this.dominioIdioma = dominioIdioma;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
}
