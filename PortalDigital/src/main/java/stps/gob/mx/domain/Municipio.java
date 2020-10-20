package stps.gob.mx.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the municipio database table.
 * 
 */
@Entity
@Table(name="municipio", schema="ubicacion")
//@NamedQuery(name="Municipio.findAll", query="SELECT m FROM Municipio m")
public class Municipio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String descripcion;

	private Integer estatus;

	@Column(name="siisne_municipio")
	private Integer siisneMunicipio;

	//bi-directional many-to-one association to Codigopostal
	@OneToMany(mappedBy="municipio")
	private List<CodigoPostal> codigopostals;

	//bi-directional many-to-one association to Colonia
	@OneToMany(mappedBy="municipio")
	private List<Colonia> colonias;

	//bi-directional many-to-one association to Ciudad
	@ManyToOne
	@JoinColumn(name="id_ciudad")
	private Ciudad ciudad;

	//bi-directional many-to-one association to Entidad
	@ManyToOne
	@JoinColumn(name="id_entidad")
	private Entidad entidad;

	//bi-directional many-to-one association to Ubicacion
	@OneToMany(mappedBy="municipio")
	private List<Ubicacion> ubicacions;

	public Municipio() {
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

	public Integer getSiisneMunicipio() {
		return this.siisneMunicipio;
	}

	public void setSiisneMunicipio(Integer siisneMunicipio) {
		this.siisneMunicipio = siisneMunicipio;
	}

	public List<CodigoPostal> getCodigopostals() {
		return this.codigopostals;
	}

	public void setCodigopostals(List<CodigoPostal> codigopostals) {
		this.codigopostals = codigopostals;
	}

	public CodigoPostal addCodigopostal(CodigoPostal codigopostal) {
		getCodigopostals().add(codigopostal);
		codigopostal.setMunicipio(this);

		return codigopostal;
	}

	public CodigoPostal removeCodigopostal(CodigoPostal codigopostal) {
		getCodigopostals().remove(codigopostal);
		codigopostal.setMunicipio(null);

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
		colonia.setMunicipio(this);

		return colonia;
	}

	public Colonia removeColonia(Colonia colonia) {
		getColonias().remove(colonia);
		colonia.setMunicipio(null);

		return colonia;
	}

	public Ciudad getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public Entidad getEntidad() {
		return this.entidad;
	}

	public void setEntidad(Entidad entidad) {
		this.entidad = entidad;
	}

	public List<Ubicacion> getUbicacions() {
		return this.ubicacions;
	}

	public void setUbicacions(List<Ubicacion> ubicacions) {
		this.ubicacions = ubicacions;
	}

	public Ubicacion addUbicacion(Ubicacion ubicacion) {
		getUbicacions().add(ubicacion);
		ubicacion.setMunicipio(this);

		return ubicacion;
	}

	public Ubicacion removeUbicacion(Ubicacion ubicacion) {
		getUbicacions().remove(ubicacion);
		ubicacion.setMunicipio(null);

		return ubicacion;
	}

}