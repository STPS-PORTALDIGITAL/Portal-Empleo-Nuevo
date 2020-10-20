package stps.gob.mx.dto;



public class ContactoEmpleadorDTO  extends RequestDTO{

	private String id;
	private String idEmpleador;
	private String idTipoContacto;
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private String estatus;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdEmpleador() {
		return idEmpleador;
	}
	public void setIdEmpleador(String idEmpleador) {
		this.idEmpleador = idEmpleador;
	}
	public String getIdTipoContacto() {
		return idTipoContacto;
	}
	public void setIdTipoContacto(String idTipoContacto) {
		this.idTipoContacto = idTipoContacto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPrimerApellido() {
		return primerApellido;
	}
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	public String getSegundoApellido() {
		return segundoApellido;
	}
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
	

}
