package stps.gob.mx.dto;

public class RolesResponsabilidadesDTO extends RequestDTO{
	private String id;
	private String idRoles;
	private String idResponsabilidades;
	private String estatus;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdRoles() {
		return idRoles;
	}
	public void setIdRoles(String idRoles) {
		this.idRoles = idRoles;
	}
	public String getIdResponsabilidades() {
		return idResponsabilidades;
	}
	public void setIdResponsabilidades(String idResponsabilidades) {
		this.idResponsabilidades = idResponsabilidades;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
	
	
}
