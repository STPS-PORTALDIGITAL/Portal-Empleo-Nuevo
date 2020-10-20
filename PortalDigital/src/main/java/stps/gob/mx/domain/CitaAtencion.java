package stps.gob.mx.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the citaatencion database table.
 * 
 */
@Entity
@Table(name="citaatencion", schema="vinculacion")
//@NamedQuery(name="Citaatencion.findAll", query="SELECT c FROM Citaatencion c")
public class CitaAtencion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private Integer estatus;

	private String estatuscita;

	private Timestamp fechayhora;

	@Column(name="folio_atencion")
	private String folioAtencion;

	@Column(name="id_persona")
	private Integer idPersona;

	@Column(name="id_usuario_atencion")
	private Integer idUsuarioAtencion;

	@Column(name="id_usuario_consejero")
	private Integer idUsuarioConsejero;

	//bi-directional many-to-one association to Oficina
	@ManyToOne
	@JoinColumn(name="id_oficina")
	private Oficina oficina;

	public CitaAtencion() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEstatus() {
		return this.estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	public String getEstatuscita() {
		return this.estatuscita;
	}

	public void setEstatuscita(String estatuscita) {
		this.estatuscita = estatuscita;
	}

	public Timestamp getFechayhora() {
		return this.fechayhora;
	}

	public void setFechayhora(Timestamp fechayhora) {
		this.fechayhora = fechayhora;
	}

	public String getFolioAtencion() {
		return this.folioAtencion;
	}

	public void setFolioAtencion(String folioAtencion) {
		this.folioAtencion = folioAtencion;
	}

	public Integer getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public Integer getIdUsuarioAtencion() {
		return this.idUsuarioAtencion;
	}

	public void setIdUsuarioAtencion(Integer idUsuarioAtencion) {
		this.idUsuarioAtencion = idUsuarioAtencion;
	}

	public Integer getIdUsuarioConsejero() {
		return this.idUsuarioConsejero;
	}

	public void setIdUsuarioConsejero(Integer idUsuarioConsejero) {
		this.idUsuarioConsejero = idUsuarioConsejero;
	}

	public Oficina getOficina() {
		return this.oficina;
	}

	public void setOficina(Oficina oficina) {
		this.oficina = oficina;
	}

}