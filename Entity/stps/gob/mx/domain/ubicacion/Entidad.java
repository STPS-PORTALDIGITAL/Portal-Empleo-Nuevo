package stps.gob.mx.domain.ubicacion;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Set;


/**
 * The persistent class for the entidad database table.
 * 
 */
@Entity
@NamedQuery(name="Entidad.findAll", query="SELECT e FROM Entidad e")
@Table(name = "entidad", schema = "ubicacion")
public class Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String descripcion;

	private Integer estatus;

	//bi-directional many-to-one association to Ciudad
	@OneToMany(mappedBy="entidad")
	private Set<Ciudad> ciudads;

	//bi-directional many-to-one association to Codigopostal
	@OneToMany(mappedBy="entidad")
	private Set<Codigopostal> codigopostals;

	//bi-directional many-to-one association to Pai
	@ManyToOne
	@JoinColumn(name="id_pais")
	private Pais pai;

	//bi-directional many-to-one association to Ubicacion
	@OneToMany(mappedBy="entidad")
	private Set<Ubicacion> ubicacions;

	public Entidad() {
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

	public Set<Ciudad> getCiudads() {
		return this.ciudads;
	}

	public void setCiudads(Set<Ciudad> ciudads) {
		this.ciudads = ciudads;
	}

	public Ciudad addCiudad(Ciudad ciudad) {
		getCiudads().add(ciudad);
		ciudad.setEntidad(this);

		return ciudad;
	}

	public Ciudad removeCiudad(Ciudad ciudad) {
		getCiudads().remove(ciudad);
		ciudad.setEntidad(null);

		return ciudad;
	}

	public Set<Codigopostal> getCodigopostals() {
		return this.codigopostals;
	}

	public void setCodigopostals(Set<Codigopostal> codigopostals) {
		this.codigopostals = codigopostals;
	}

	public Codigopostal addCodigopostal(Codigopostal codigopostal) {
		getCodigopostals().add(codigopostal);
		codigopostal.setEntidad(this);

		return codigopostal;
	}

	public Codigopostal removeCodigopostal(Codigopostal codigopostal) {
		getCodigopostals().remove(codigopostal);
		codigopostal.setEntidad(null);

		return codigopostal;
	}

	public Pais getPai() {
		return this.pai;
	}

	public void setPai(Pais pai) {
		this.pai = pai;
	}

	public Set<Ubicacion> getUbicacions() {
		return this.ubicacions;
	}

	public void setUbicacions(Set<Ubicacion> ubicacions) {
		this.ubicacions = ubicacions;
	}

	public Ubicacion addUbicacion(Ubicacion ubicacion) {
		getUbicacions().add(ubicacion);
		ubicacion.setEntidad(this);

		return ubicacion;
	}

	public Ubicacion removeUbicacion(Ubicacion ubicacion) {
		getUbicacions().remove(ubicacion);
		ubicacion.setEntidad(null);

		return ubicacion;
	}

}