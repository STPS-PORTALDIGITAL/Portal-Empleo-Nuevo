package stps.gob.mx.domain.ubicacion;

import java.io.Serializable;
import javax.persistence.*;

import java.math.BigDecimal;


/**
 * The persistent class for the ubicacion database table.
 * 
 */
@Entity
@NamedQuery(name="Ubicacion.findAll", query="SELECT u FROM Ubicacion u")
@Table(schema = "ubicacion", name = "ubicacion")
public class Ubicacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String calle;

	private Integer estatus;

	@Column(name="id_propietario")
	private Integer idPropietario;

	@Column(name="id_tipoubicacion")
	private Integer idTipoubicacion;

	private BigDecimal latitud;

	private BigDecimal longitud;

	@Column(name="numero_exterior")
	private String numeroExterior;

	@Column(name="numero_interior")
	private String numeroInterior;

	private String oficina;

	//bi-directional many-to-one association to Codigopostal
	@ManyToOne
	@JoinColumn(name="id_codigopostal")
	private Codigopostal codigopostal;

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

	//bi-directional many-to-one association to Pai
	@ManyToOne
	@JoinColumn(name="id_pais")
	private Pais pai;

	public Ubicacion() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCalle() {
		return this.calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Integer getEstatus() {
		return this.estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	public Integer getIdPropietario() {
		return this.idPropietario;
	}

	public void setIdPropietario(Integer idPropietario) {
		this.idPropietario = idPropietario;
	}

	public Integer getIdTipoubicacion() {
		return this.idTipoubicacion;
	}

	public void setIdTipoubicacion(Integer idTipoubicacion) {
		this.idTipoubicacion = idTipoubicacion;
	}

	public BigDecimal getLatitud() {
		return this.latitud;
	}

	public void setLatitud(BigDecimal latitud) {
		this.latitud = latitud;
	}

	public BigDecimal getLongitud() {
		return this.longitud;
	}

	public void setLongitud(BigDecimal longitud) {
		this.longitud = longitud;
	}

	public String getNumeroExterior() {
		return this.numeroExterior;
	}

	public void setNumeroExterior(String numeroExterior) {
		this.numeroExterior = numeroExterior;
	}

	public String getNumeroInterior() {
		return this.numeroInterior;
	}

	public void setNumeroInterior(String numeroInterior) {
		this.numeroInterior = numeroInterior;
	}

	public String getOficina() {
		return this.oficina;
	}

	public void setOficina(String oficina) {
		this.oficina = oficina;
	}

	public Codigopostal getCodigopostal() {
		return this.codigopostal;
	}

	public void setCodigopostal(Codigopostal codigopostal) {
		this.codigopostal = codigopostal;
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

	public Pais getPai() {
		return this.pai;
	}

	public void setPai(Pais pai) {
		this.pai = pai;
	}

}