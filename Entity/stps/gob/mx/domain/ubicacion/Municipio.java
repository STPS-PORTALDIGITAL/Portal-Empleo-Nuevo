package stps.gob.mx.domain.ubicacion;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Set;


/**
 * The persistent class for the municipio database table.
 * 
 */
@Entity
@NamedQuery(name="Municipio.findAll", query="SELECT m FROM Municipio m")
@Table(name = "municipio", schema = "ubicacion")
public class Municipio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String descripcion;

	private Integer estatus;

	@Column(name="id_entidad")
	private Integer idEntidad;

	@Column(name="id_municipio")
	private Integer idMunicipio;

	//bi-directional many-to-one association to Codigopostal
	@OneToMany(mappedBy="municipio")
	private Set<Codigopostal> codigopostals;

	//bi-directional many-to-one association to Colonia
	@OneToMany(mappedBy="municipio")
	private Set<Colonia> colonias;

	//bi-directional many-to-one association to Ciudad
	@ManyToOne
	@JoinColumn(name="id_ciudad")
	private Ciudad ciudad;

	//bi-directional many-to-one association to Ubicacion
	@OneToMany(mappedBy="municipio")
	private Set<Ubicacion> ubicacions;

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

	public Integer getIdEntidad() {
		return this.idEntidad;
	}

	public void setIdEntidad(Integer idEntidad) {
		this.idEntidad = idEntidad;
	}

	public Integer getIdMunicipio() {
		return this.idMunicipio;
	}

	public void setIdMunicipio(Integer idMunicipio) {
		this.idMunicipio = idMunicipio;
	}

	public Set<Codigopostal> getCodigopostals() {
		return this.codigopostals;
	}

	public void setCodigopostals(Set<Codigopostal> codigopostals) {
		this.codigopostals = codigopostals;
	}

	public Codigopostal addCodigopostal(Codigopostal codigopostal) {
		getCodigopostals().add(codigopostal);
		codigopostal.setMunicipio(this);

		return codigopostal;
	}

	public Codigopostal removeCodigopostal(Codigopostal codigopostal) {
		getCodigopostals().remove(codigopostal);
		codigopostal.setMunicipio(null);

		return codigopostal;
	}

	public Set<Colonia> getColonias() {
		return this.colonias;
	}

	public void setColonias(Set<Colonia> colonias) {
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

	public Set<Ubicacion> getUbicacions() {
		return this.ubicacions;
	}

	public void setUbicacions(Set<Ubicacion> ubicacions) {
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