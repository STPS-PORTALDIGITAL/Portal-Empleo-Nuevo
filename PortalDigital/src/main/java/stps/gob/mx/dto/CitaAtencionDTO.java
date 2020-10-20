package stps.gob.mx.dto;


public class CitaAtencionDTO  extends RequestDTO{
	private String id;
	private String folioAtencion;
	private String idPersona;
	private String estatusCita;
	private String fechayhora;
	private String idOficina;
	private String idUsuarioConsejero;
	private String idUsuarioAtencion;
	private String estatus;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFolioAtencion() {
		return folioAtencion;
	}
	public void setFolioAtencion(String folioAtencion) {
		this.folioAtencion = folioAtencion;
	}
	public String getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(String idPersona) {
		this.idPersona = idPersona;
	}
	public String getEstatusCita() {
		return estatusCita;
	}
	public void setEstatusCita(String estatusCita) {
		this.estatusCita = estatusCita;
	}
	public String getFechayhora() {
		return fechayhora;
	}
	public void setFechayhora(String fechayhora) {
		this.fechayhora = fechayhora;
	}
	public String getIdOficina() {
		return idOficina;
	}
	public void setIdOficina(String idOficina) {
		this.idOficina = idOficina;
	}
	public String getIdUsuarioConsejero() {
		return idUsuarioConsejero;
	}
	public void setIdUsuarioConsejero(String idUsuarioConsejero) {
		this.idUsuarioConsejero = idUsuarioConsejero;
	}
	public String getIdUsuarioAtencion() {
		return idUsuarioAtencion;
	}
	public void setIdUsuarioAtencion(String idUsuarioAtencion) {
		this.idUsuarioAtencion = idUsuarioAtencion;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
	
}
