package stps.gob.mx.domain.vinculacion;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;


/**
 * The persistent class for the disponibilidad database table.
 * 
 */
@Entity
@NamedQuery(name="Disponibilidad.findAll", query="SELECT d FROM Disponibilidad d")
@Table(name = "disponibilidad", schema = "vinculacion")
public class Disponibilidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private Boolean disponible;

	private Integer estatus;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Column(name="folio_atencion")
	private String folioAtencion;

	private Timestamp horafin;

	private Timestamp horaini;

	@Column(name="id_empleador")
	private Integer idEmpleador;

	@Column(name="id_usuario_consultor")
	private Integer idUsuarioConsultor;

	//bi-directional many-to-one association to Oficina
	@ManyToOne
	@JoinColumn(name="id_oficina")
	private Oficina oficina;

	public Disponibilidad() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getDisponible() {
		return this.disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}

	public Integer getEstatus() {
		return this.estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getFolioAtencion() {
		return this.folioAtencion;
	}

	public void setFolioAtencion(String folioAtencion) {
		this.folioAtencion = folioAtencion;
	}

	public Timestamp getHorafin() {
		return this.horafin;
	}

	public void setHorafin(Timestamp horafin) {
		this.horafin = horafin;
	}

	public Timestamp getHoraini() {
		return this.horaini;
	}

	public void setHoraini(Timestamp horaini) {
		this.horaini = horaini;
	}

	public Integer getIdEmpleador() {
		return this.idEmpleador;
	}

	public void setIdEmpleador(Integer idEmpleador) {
		this.idEmpleador = idEmpleador;
	}

	public Integer getIdUsuarioConsultor() {
		return this.idUsuarioConsultor;
	}

	public void setIdUsuarioConsultor(Integer idUsuarioConsultor) {
		this.idUsuarioConsultor = idUsuarioConsultor;
	}

	public Oficina getOficina() {
		return this.oficina;
	}

	public void setOficina(Oficina oficina) {
		this.oficina = oficina;
	}

}