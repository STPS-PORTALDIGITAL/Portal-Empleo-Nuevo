package stps.gob.mx.dto;

public class FeriaEmpleoDTO extends RequestDTO{
	private String idFeria;
	private String idEmpleador;
	private String nombre;
	private String pais;
	private String estado;
	private String municipio;
	private String direccion;
	private String comentarios;
	private String estatus;
	
	
	public String getIdFeria() {
		return idFeria;
	}
	public void setIdFeria(String idFeria) {
		this.idFeria = idFeria;
	}
	public String getIdEmpleador() {
		return idEmpleador;
	}
	public void setIdEmpleador(String idEmpleador) {
		this.idEmpleador = idEmpleador;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
	

}
