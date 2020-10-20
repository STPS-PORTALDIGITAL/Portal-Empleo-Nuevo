package stps.gob.mx.dto;

public class DisponibilidadDTO  extends RequestDTO{
	private String id;
	private String idOficina;
	private String fecha;
	private String horaIni;
	private String horaFin;
	private String idUsuarioConsultor;
	private String disponible;
	private String idEmpleador;
	private String folioAtencion;
	private String estatus;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdOficina() {
		return idOficina;
	}
	public void setIdOficina(String idOficina) {
		this.idOficina = idOficina;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHoraIni() {
		return horaIni;
	}
	public void setHoraIni(String horaIni) {
		this.horaIni = horaIni;
	}
	public String getHoraFin() {
		return horaFin;
	}
	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}
	public String getIdUsuarioConsultor() {
		return idUsuarioConsultor;
	}
	public void setIdUsuarioConsultor(String idUsuarioConsultor) {
		this.idUsuarioConsultor = idUsuarioConsultor;
	}
	public String getDisponible() {
		return disponible;
	}
	public void setDisponible(String disponible) {
		this.disponible = disponible;
	}
	public String getIdEmpleador() {
		return idEmpleador;
	}
	public void setIdEmpleador(String idEmpleador) {
		this.idEmpleador = idEmpleador;
	}
	public String getFolioAtencion() {
		return folioAtencion;
	}
	public void setFolioAtencion(String folioAtencion) {
		this.folioAtencion = folioAtencion;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
	
	
}
