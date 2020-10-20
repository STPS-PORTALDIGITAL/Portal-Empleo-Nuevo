package stps.gob.mx.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the colonia database table.
 * 
 */
@Entity
@Table(name="colonia", schema="ubicacion")
//@NamedQuery(name="Colonia.findAll", query="SELECT c FROM Colonia c")
public class Colonia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String descripcion;

	private Integer estatus;

	@Column(name="siisne_codigopostal")
	private String siisneCodigopostal;

	@Column(name="siisne_municipio")
	private Integer siisneMunicipio;

	//bi-directional many-to-one association to Codigopostal
	@ManyToOne
	@JoinColumn(name="id_codigopostal")
	private CodigoPostal codigopostal;

	//bi-directional many-to-one association to Entidad
	@ManyToOne
	@JoinColumn(name="id_entidad")
	private Entidad entidad;

	//bi-directional many-to-one association to Municipio
	@ManyToOne
	@JoinColumn(name="id_municipio")
	private Municipio municipio;

	//bi-directional many-to-one association to Ubicacion
	@OneToMany(mappedBy="colonia")
	private List<Ubicacion> ubicacions;

	public Colonia() {
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

	public String getSiisneCodigopostal() {
		return this.siisneCodigopostal;
	}

	public void setSiisneCodigopostal(String siisneCodigopostal) {
		this.siisneCodigopostal = siisneCodigopostal;
	}

	public Integer getSiisneMunicipio() {
		return this.siisneMunicipio;
	}

	public void setSiisneMunicipio(Integer siisneMunicipio) {
		this.siisneMunicipio = siisneMunicipio;
	}

	public CodigoPostal getCodigopostal() {
		return this.codigopostal;
	}

	public void setCodigopostal(CodigoPostal codigopostal) {
		this.codigopostal = codigopostal;
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

	public List<Ubicacion> getUbicacions() {
		return this.ubicacions;
	}

	public void setUbicacions(List<Ubicacion> ubicacions) {
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