package stps.gob.mx.dto;



public class NotificacionDTO  extends RequestDTO{
	private String id;
	private String asunto;
	private String mensaje;
	private String fechaEnvio;
	private String esAlerta;
	private String medioDifusion;
	private String emisor;
	private String remitente;
	private String estatusNotificacion;
	private String estatus;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public String getFechaEnvio() {
		return fechaEnvio;
	}
	public void setFechaEnvio(String fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}
	public String getEsAlerta() {
		return esAlerta;
	}
	public void setEsAlerta(String esAlerta) {
		this.esAlerta = esAlerta;
	}
	public String getMedioDifusion() {
		return medioDifusion;
	}
	public void setMedioDifusion(String medioDifusion) {
		this.medioDifusion = medioDifusion;
	}
	public String getEmisor() {
		return emisor;
	}
	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}
	public String getRemitente() {
		return remitente;
	}
	public void setRemitente(String remitente) {
		this.remitente = remitente;
	}
	public String getEstatusNotificacion() {
		return estatusNotificacion;
	}
	public void setEstatusNotificacion(String estatusNotificacion) {
		this.estatusNotificacion = estatusNotificacion;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
	
}
