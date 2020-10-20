package stps.gob.mx.domain.vinculacion;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the notificacion database table.
 * 
 */
@Entity
@NamedQuery(name="Notificacion.findAll", query="SELECT n FROM Notificacion n")
@Table(name = "notificacion", schema = "vinculacion")
public class Notificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String asunto;

	private String emisor;

	@Column(name="es_alerta")
	private Boolean esAlerta;

	private Integer estatus;

	private String estatusnotificacion;

	private Timestamp fechaenvio;

	private String mediodifusion;

	private String mensaje;

	private String remitente;

	public Notificacion() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAsunto() {
		return this.asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getEmisor() {
		return this.emisor;
	}

	public void setEmisor(String emisor) {
		this.emisor = emisor;
	}

	public Boolean getEsAlerta() {
		return this.esAlerta;
	}

	public void setEsAlerta(Boolean esAlerta) {
		this.esAlerta = esAlerta;
	}

	public Integer getEstatus() {
		return this.estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	public String getEstatusnotificacion() {
		return this.estatusnotificacion;
	}

	public void setEstatusnotificacion(String estatusnotificacion) {
		this.estatusnotificacion = estatusnotificacion;
	}

	public Timestamp getFechaenvio() {
		return this.fechaenvio;
	}

	public void setFechaenvio(Timestamp fechaenvio) {
		this.fechaenvio = fechaenvio;
	}

	public String getMediodifusion() {
		return this.mediodifusion;
	}

	public void setMediodifusion(String mediodifusion) {
		this.mediodifusion = mediodifusion;
	}

	public String getMensaje() {
		return this.mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getRemitente() {
		return this.remitente;
	}

	public void setRemitente(String remitente) {
		this.remitente = remitente;
	}

}