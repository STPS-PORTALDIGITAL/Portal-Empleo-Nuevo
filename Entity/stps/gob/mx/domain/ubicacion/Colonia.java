package stps.gob.mx.domain.ubicacion;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Set;


/**
 * The persistent class for the colonia database table.
 * 
 */
@Entity
@NamedQuery(name="Colonia.findAll", query="SELECT c FROM Colonia c")
@Table(name = "colonia", schema = "ubicacion")
public class Colonia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name="codigo_postal")
	private String codigoPostal;

	private String descripcion;

	private Integer estatus;

	@Column(name="id_codigopostal")
	private Integer idCodigopostal;

	@Column(name="id_entidad")
	private Integer idEntidad;

	//bi-directional many-to-one association to Codigopostal
	@OneToMany(mappedBy="colonia")
	private Set<Codigopostal> codigopostals;

	//bi-directional many-to-one association to Municipio
	@ManyToOne
	@JoinColumn(name="id_municipio")
	private Municipio municipio;

	//bi-directional many-to-one association to Ubicacion
	@OneToMany(mappedBy="colonia")
	private Set<Ubicacion> ubicacions;

	public Colonia() {
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

	public Integer getIdCodigopostal() {
		return this.idCodigopostal;
	}

	public void setIdCodigopostal(Integer idCodigopostal) {
		this.idCodigopostal = idCodigopostal;
	}

	public Integer getIdEntidad() {
		return this.idEntidad;
	}

	public void setIdEntidad(Integer idEntidad) {
		this.idEntidad = idEntidad;
	}

	public Set<Codigopostal> getCodigopostals() {
		return this.codigopostals;
	}

	public void setCodigopostals(Set<Codigopostal> codigopostals) {
		this.codigopostals = codigopostals;
	}

	public Codigopostal addCodigopostal(Codigopostal codigopostal) {
		getCodigopostals().add(codigopostal);
		codigopostal.setColonia(this);

		return codigopostal;
	}

	public Codigopostal removeCodigopostal(Codigopostal codigopostal) {
		getCodigopostals().remove(codigopostal);
		codigopostal.setColonia(null);

		return codigopostal;
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
		ubicacion.setColonia(this);

		return ubicacion;
	}

	public Ubicacion removeUbicacion(Ubicacion ubicacion) {
		getUbicacions().remove(ubicacion);
		ubicacion.setColonia(null);

		return ubicacion;
	}

}