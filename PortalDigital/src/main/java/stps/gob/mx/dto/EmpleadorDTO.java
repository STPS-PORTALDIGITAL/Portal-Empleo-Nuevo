package stps.gob.mx.dto;



public class EmpleadorDTO  extends RequestDTO {
	private String id;
	private String nombre;
	private String rfc;
	private String descripcion;
	private String idUsuario;
	private String idUbicacion;
	private String idSectorGiro;
	private String idTipoEmpresa;
	private String estatus;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRfc() {
		return rfc;
	}
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getIdUbicacion() {
		return idUbicacion;
	}
	public void setIdUbicacion(String idUbicacion) {
		this.idUbicacion = idUbicacion;
	}
	public String getIdSectorGiro() {
		return idSectorGiro;
	}
	public void setIdSectorGiro(String idSectorGiro) {
		this.idSectorGiro = idSectorGiro;
	}
	public String getIdTipoEmpresa() {
		return idTipoEmpresa;
	}
	public void setIdTipoEmpresa(String idTipoEmpresa) {
		this.idTipoEmpresa = idTipoEmpresa;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
	

	
	
}
