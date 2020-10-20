package stps.gob.mx.domain.ubicacion;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Set;


/**
 * The persistent class for the pais database table.
 * 
 */
@Entity
@Table(name="pais", schema = "ubicacion")
@NamedQuery(name="Pais.findAll", query="SELECT p FROM Pais p")
public class Pais implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String descripcion;

	private Integer estatus;

	//bi-directional many-to-one association to Entidad
	@OneToMany(mappedBy="pai")
	private Set<Entidad> entidads;

	//bi-directional many-to-one association to Ubicacion
	@OneToMany(mappedBy="pai")
	private Set<Ubicacion> ubicacions;

	public Pais() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getEstatus() {
		return this.estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	public Set<Entidad> getEntidads() {
		return this.entidads;
	}

	public void setEntidads(Set<Entidad> entidads) {
		this.entidads = entidads;
	}

	public Entidad addEntidad(Entidad entidad) {
		getEntidads().add(entidad);
		entidad.setPai(this);

		return entidad;
	}

	public Entidad removeEntidad(Entidad entidad) {
		getEntidads().remove(entidad);
		entidad.setPai(null);

		return entidad;
	}

	public Set<Ubicacion> getUbicacions() {
		return this.ubicacions;
	}

	public void setUbicacions(Set<Ubicacion> ubicacions) {
		this.ubicacions = ubicacions;
	}

	public Ubicacion addUbicacion(Ubicacion ubicacion) {
		getUbicacions().add(ubicacion);
		ubicacion.setPai(this);

		return ubicacion;
	}

	public Ubicacion removeUbicacion(Ubicacion ubicacion) {
		getUbicacions().remove(ubicacion);
		ubicacion.setPai(null);

		return ubicacion;
	}

}