package stps.gob.mx.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the codigopostal database table.
 * 
 */
@Entity
@Table(name="codigopostal", schema="ubicacion")
//@NamedQuery(name="Codigopostal.findAll", query="SELECT c FROM Codigopostal c")
public class CodigoPostal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="codigo_postal")
	private String codigoPostal;

	private Integer estatus;

	@Column(name="siisne_municipio")
	private Integer siisneMunicipio;

	@Column(name="zip_plus")
	private String zipPlus;

	//bi-directional many-to-one association to Entidad
	@ManyToOne
	@JoinColumn(name="id_entidad")
	private Entidad entidad;

	//bi-directional many-to-one association to Municipio
	@ManyToOne
	@JoinColumn(name="id_municipio")
	private Municipio municipio;

	//bi-directional many-to-one association to Colonia
	@OneToMany(mappedBy="codigopostal")
	private List<Colonia> colonias;

	//bi-directional many-to-one association to Ubicacion
	@OneToMany(mappedBy="codigopostal")
	private List<Ubicacion> ubicacions;

	public CodigoPostal() {
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

	public Integer getSiisneMunicipio() {
		return this.siisneMunicipio;
	}

	public void setSiisneMunicipio(Integer siisneMunicipio) {
		this.siisneMunicipio = siisneMunicipio;
	}

	public String getZipPlus() {
		return this.zipPlus;
	}

	public void setZipPlus(String zipPlus) {
		this.zipPlus = zipPlus;
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

	public List<Colonia> getColonias() {
		return this.colonias;
	}

	public void setColonias(List<Colonia> colonias) {
		this.colonias = colonias;
	}

	public Colonia addColonia(Colonia colonia) {
		getColonias().add(colonia);
		colonia.setCodigopostal(this);

		return colonia;
	}

	public Colonia removeColonia(Colonia colonia) {
		getColonias().remove(colonia);
		colonia.setCodigopostal(null);

		return colonia;
	}

	public List<Ubicacion> getUbicacions() {
		return this.ubicacions;
	}

	public void setUbicacions(List<Ubicacion> ubicacions) {
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