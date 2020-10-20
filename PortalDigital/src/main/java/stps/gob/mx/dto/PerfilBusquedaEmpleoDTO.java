package stps.gob.mx.dto;



public class PerfilBusquedaEmpleoDTO extends RequestDTO{
	
	private String id;
	private String id_persona;
	private String id_escolaridad;
	private String id_expectativa_laboral;
	private String disponibilidad_movilidad;
	private String disponibilidad_viajar;
	private String estatus;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getId_persona() {
		return id_persona;
	}
	public void setId_persona(String id_persona) {
		this.id_persona = id_persona;
	}
	public String getId_escolaridad() {
		return id_escolaridad;
	}
	public void setId_escolaridad(String id_escolaridad) {
		this.id_escolaridad = id_escolaridad;
	}
	public String getId_expectativa_laboral() {
		return id_expectativa_laboral;
	}
	public void setId_expectativa_laboral(String id_expectativa_laboral) {
		this.id_expectativa_laboral = id_expectativa_laboral;
	}
	public String getDisponibilidad_movilidad() {
		return disponibilidad_movilidad;
	}
	public void setDisponibilidad_movilidad(String disponibilidad_movilidad) {
		this.disponibilidad_movilidad = disponibilidad_movilidad;
	}
	public String getDisponibilidad_viajar() {
		return disponibilidad_viajar;
	}
	public void setDisponibilidad_viajar(String disponibilidad_viajar) {
		this.disponibilidad_viajar = disponibilidad_viajar;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
	
}
