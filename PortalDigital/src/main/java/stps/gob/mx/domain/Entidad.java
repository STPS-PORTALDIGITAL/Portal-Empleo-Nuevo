package stps.gob.mx.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the entidad database table.
 * 
 */
@Entity
@Table(name="entidad", schema="ubicacion")
//@NamedQuery(name="Entidad.findAll", query="SELECT e FROM Entidad e")
public class Entidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String descripcion;

	private Integer estatus;

	//bi-directional many-to-one association to Ciudad
	@OneToMany(mappedBy="entidad")
	private List<Ciudad> ciudads;

	//bi-directional many-to-one association to Codigopostal
	@OneToMany(mappedBy="entidad")
	private List<CodigoPostal> codigopostals;

	//bi-directional many-to-one association to Colonia
	@OneToMany(mappedBy="entidad")
	private List<Colonia> colonias;

	//bi-directional many-to-one association to Pai
	@ManyToOne
	@JoinColumn(name="id_pais")
	private Pais pai;

	//bi-directional many-to-one association to Municipio
	@OneToMany(mappedBy="entidad")
	private List<Municipio> municipios;

	//bi-directional many-to-one association to Ubicacion
	@OneToMany(mappedBy="entidad")
	private List<Ubicacion> ubicacions;

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

	public List<Ciudad> getCiudads() {
		return this.ciudads;
	}

	public void setCiudads(List<Ciudad> ciudads) {
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

	public List<CodigoPostal> getCodigopostals() {
		return this.codigopostals;
	}

	public void setCodigopostals(List<CodigoPostal> codigopostals) {
		this.codigopostals = codigopostals;
	}

	public CodigoPostal addCodigopostal(CodigoPostal codigopostal) {
		getCodigopostals().add(codigopostal);
		codigopostal.setEntidad(this);

		return codigopostal;
	}

	public CodigoPostal removeCodigopostal(CodigoPostal codigopostal) {
		getCodigopostals().remove(codigopostal);
		codigopostal.setEntidad(null);

		return codigopostal;
	}

	public List<Colonia> getColonias() {
		return this.colonias;
	}

	public void setColonias(List<Colonia> colonias) {
		this.colonias = colonias;
	}

	public Colonia addColonia(Colonia colonia) {
		getColonias().add(colonia);
		colonia.setEntidad(this);

		return colonia;
	}

	public Colonia removeColonia(Colonia colonia) {
		getColonias().remove(colonia);
		colonia.setEntidad(null);

		return colonia;
	}

	public Pais getPai() {
		return this.pai;
	}

	public void setPai(Pais pai) {
		this.pai = pai;
	}

	public List<Municipio> getMunicipios() {
		return this.municipios;
	}

	public void setMunicipios(List<Municipio> municipios) {
		this.municipios = municipios;
	}

	public Municipio addMunicipio(Municipio municipio) {
		getMunicipios().add(municipio);
		municipio.setEntidad(this);

		return municipio;
	}

	public Municipio removeMunicipio(Municipio municipio) {
		getMunicipios().remove(municipio);
		municipio.setEntidad(null);

		return municipio;
	}

	public List<Ubicacion> getUbicacions() {
		return this.ubicacions;
	}

	public void setUbicacions(List<Ubicacion> ubicacions) {
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