package stps.gob.mx.dto;

public class CurriculumDTO  extends RequestDTO{
	private String id;
	private String idPersona;
	private String idNivelEducativo;
	private String expectativaDiasLaborales;
	private String expectativaInteresesPersonales;
	private String expectativaSalarioMensual;
	private String disponibilidadMovilidad;
	private String disponibilidadViajar;
	private String idBuscadorTrabajo;
	private String estatus;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(String idPersona) {
		this.idPersona = idPersona;
	}
	public String getIdNivelEducativo() {
		return idNivelEducativo;
	}
	public void setIdNivelEducativo(String idNivelEducativo) {
		this.idNivelEducativo = idNivelEducativo;
	}
	public String getExpectativaDiasLaborales() {
		return expectativaDiasLaborales;
	}
	public void setExpectativaDiasLaborales(String expectativaDiasLaborales) {
		this.expectativaDiasLaborales = expectativaDiasLaborales;
	}
	public String getExpectativaInteresesPersonales() {
		return expectativaInteresesPersonales;
	}
	public void setExpectativaInteresesPersonales(String expectativaInteresesPersonales) {
		this.expectativaInteresesPersonales = expectativaInteresesPersonales;
	}
	public String getExpectativaSalarioMensual() {
		return expectativaSalarioMensual;
	}
	public void setExpectativaSalarioMensual(String expectativaSalarioMensual) {
		this.expectativaSalarioMensual = expectativaSalarioMensual;
	}
	public String getDisponibilidadMovilidad() {
		return disponibilidadMovilidad;
	}
	public void setDisponibilidadMovilidad(String disponibilidadMovilidad) {
		this.disponibilidadMovilidad = disponibilidadMovilidad;
	}
	public String getDisponibilidadViajar() {
		return disponibilidadViajar;
	}
	public void setDisponibilidadViajar(String disponibilidadViajar) {
		this.disponibilidadViajar = disponibilidadViajar;
	}
	public String getIdBuscadorTrabajo() {
		return idBuscadorTrabajo;
	}
	public void setIdBuscadorTrabajo(String idBuscadorTrabajo) {
		this.idBuscadorTrabajo = idBuscadorTrabajo;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
	
}
