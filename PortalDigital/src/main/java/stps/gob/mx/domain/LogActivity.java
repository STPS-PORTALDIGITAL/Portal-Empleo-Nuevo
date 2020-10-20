package stps.gob.mx.domain;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "logactivity")
@Entity 
public class LogActivity implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1067126268808675044L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idLogActivity")
	private long idLogActivity;
	@Column(name="idUsuario")
	private long idUsuario;
	@Column(name="servicio")
	private String servicio;
	@Column(name="metodo")
	private String metodo;
	@Column(name="clase")
	private String clase;
	@Column(name="ip")
	private String ip;
	@Column(name="fecha")
	private Date fecha;
	@Column(name="text_comments")
	private String comments;
	
	
	public long getIdLogActivity() {
		return idLogActivity;
	}
	public void setIdLogActivity(long idLogActivity) {
		this.idLogActivity = idLogActivity;
	}
	public long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getServicio() {
		return servicio;
	}
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
	public String getMetodo() {
		return metodo;
	}
	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}
	public String getClase() {
		return clase;
	}
	public void setClase(String clase) {
		this.clase = clase;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}



	
}
