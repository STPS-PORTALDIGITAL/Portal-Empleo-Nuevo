package stps.gob.mx.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the candidatos database table.
 * 
 */
@Entity
@Table(name="candidatos", schema="persona")
//@NamedQuery(name="Candidato.findAll", query="SELECT c FROM Candidato c")
public class Candidato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private Integer estatus;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_fin")
	private Date fechaFin;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_ini")
	private Date fechaIni;

	@Column(name="id_ofertaempleo")
	private Integer idOfertaempleo;

	@Column(name="me_interesa")
	private Boolean meInteresa;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="id_persona")
	private Persona persona;

	public Candidato() {
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

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaIni() {
		return this.fechaIni;
	}

	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}

	public Integer getIdOfertaempleo() {
		return this.idOfertaempleo;
	}

	public void setIdOfertaempleo(Integer idOfertaempleo) {
		this.idOfertaempleo = idOfertaempleo;
	}

	public Boolean getMeInteresa() {
		return this.meInteresa;
	}

	public void setMeInteresa(Boolean meInteresa) {
		this.meInteresa = meInteresa;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}