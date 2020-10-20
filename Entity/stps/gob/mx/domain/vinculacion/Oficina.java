package stps.gob.mx.domain.vinculacion;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the oficina database table.
 * 
 */
@Entity
@NamedQuery(name="Oficina.findAll", query="SELECT o FROM Oficina o")
@Table(name = "oficina", schema = "vinculacion")
public class Oficina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private Integer estatus;

	private String oficina;

	//bi-directional many-to-one association to CitaAtencion
	@OneToMany(mappedBy="oficina")
	private Set<CitaAtencion> citaatencions;

	//bi-directional many-to-one association to Disponibilidad
	@OneToMany(mappedBy="oficina")
	private Set<Disponibilidad> disponibilidads;

	public Oficina() {
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

	public String getOficina() {
		return this.oficina;
	}

	public void setOficina(String oficina) {
		this.oficina = oficina;
	}

	public Set<CitaAtencion> getCitaatencions() {
		return this.citaatencions;
	}

	public void setCitaatencions(Set<CitaAtencion> citaatencions) {
		this.citaatencions = citaatencions;
	}

	public CitaAtencion addCitaatencion(CitaAtencion citaatencion) {
		getCitaatencions().add(citaatencion);
		citaatencion.setOficina(this);

		return citaatencion;
	}

	public CitaAtencion removeCitaatencion(CitaAtencion citaatencion) {
		getCitaatencions().remove(citaatencion);
		citaatencion.setOficina(null);

		return citaatencion;
	}

	public Set<Disponibilidad> getDisponibilidads() {
		return this.disponibilidads;
	}

	public void setDisponibilidads(Set<Disponibilidad> disponibilidads) {
		this.disponibilidads = disponibilidads;
	}

	public Disponibilidad addDisponibilidad(Disponibilidad disponibilidad) {
		getDisponibilidads().add(disponibilidad);
		disponibilidad.setOficina(this);

		return disponibilidad;
	}

	public Disponibilidad removeDisponibilidad(Disponibilidad disponibilidad) {
		getDisponibilidads().remove(disponibilidad);
		disponibilidad.setOficina(null);

		return disponibilidad;
	}

}