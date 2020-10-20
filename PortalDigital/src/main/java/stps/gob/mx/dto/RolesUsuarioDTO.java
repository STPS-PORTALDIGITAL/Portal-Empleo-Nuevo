package stps.gob.mx.dto;



public class RolesUsuarioDTO extends RequestDTO{
	
	private String id;
	private String idUsuario;
	private String idRoles;
	private String estatus;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getIdRoles() {
		return idRoles;
	}
	public void setIdRoles(String idRoles) {
		this.idRoles = idRoles;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
	
	
	
	
	
	
	
}
