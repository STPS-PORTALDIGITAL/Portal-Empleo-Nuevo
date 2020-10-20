package stps.gob.mx.domain.ubicacion;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Set;


/**
 * The persistent class for the codigopostal database table.
 * 
 */
@Entity
@NamedQuery(name="Codigopostal.findAll", query="SELECT c FROM Codigopostal c")
@Table(name = "codigopostal", schema = "ubicacion")
public class Codigopostal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name="codigo_postal")
	private String codigoPostal;

	private Integer estatus;

	@Column(name="zip_plus")
	private String zipPlus;

	//bi-directional many-to-one association to Colonia
	@ManyToOne
	@JoinColumn(name="id_colonia")
	private Colonia colonia;

	//bi-directional many-to-one association to Entidad
	@ManyToOne
	@JoinColumn(name="id_entidad")
	private Entidad entidad;

	//bi-directional many-to-one association to Municipio
	@ManyToOne
	@JoinColumn(name="id_municipio")
	private Municipio municipio;

	//bi-directional many-to-one association to Ubicacion
	@OneToMany(mappedBy="codigopostal")
	private Set<Ubicacion> ubicacions;

	public Codigopostal() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigoPostal() {
		return this.codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public Integer getEstatus() {
		return this.estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	public String getZipPlus() {
		return this.zipPlus;
	}

	public void setZipPlus(String zipPlus) {
		this.zipPlus = zipPlus;
	}

	public Colonia getColonia() {
		return this.colonia;
	}

	public void setColonia(Colonia colonia) {
		this.colonia = colonia;
	}

	public Entidad getEntidad() {
		return this.entidad;
	}

	public void setEntidad(Entidad entidad) {
		this.entidad = entidad;
	}

	public Municipio getMunicipio() {
		return this.municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public Set<Ubicacion> getUbicacions() {
		return this.ubicacions;
	}

	public void setUbicacions(Set<Ubicacion> ubicacions) {
		this.ubicacions = ubicacions;
	}

	public Ubicacion addUbicacion(Ubicacion ubicacion) {
		getUbicacions().add(ubicacion);
		ubicacion.setCodigopostal(this);

		return ubicacion;
	}

	public Ubicacion removeUbicacion(Ubicacion ubicacion) {
		getUbicacions().remove(ubicacion);
		ubicacion.setCodigopostal(null);

		return ubicacion;
	}

}