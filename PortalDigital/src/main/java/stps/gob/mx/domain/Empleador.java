package stps.gob.mx.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the empleador database table.
 * 
 */
@Entity
@Table(name="empleador", schema="oferta")
//@NamedQuery(name="Empleador.findAll", query="SELECT e FROM Empleador e")
public class Empleador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="correo_electronico")
	private String correoElectronico;

	@Column(name="create_at")
	private Timestamp createAt;

	private String curp;

	@Column(name="curp_validada")
	private Boolean curpValidada;

	@Column(name="delete_at")
	private Timestamp deleteAt;

	private String descripcion;

	private Integer estatus;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_constitucion")
	private Date fechaConstitucion;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;

	private Integer genero;

	@Column(name="id_motivo_no_validacion")
	private Integer idMotivoNoValidacion;

	@Column(name="id_sectorgiro")
	private Integer idSectorgiro;

	@Column(name="id_tipoempresa")
	private Integer idTipoempresa;

	@Column(name="id_tipopersona")
	private Integer idTipopersona;

	@Column(name="id_ubicacion")
	private Integer idUbicacion;

	@Column(name="id_usuario")
	private Integer idUsuario;

	@Column(name="lugar_nacimiento")
	private Integer lugarNacimiento;

	private String nombre;

	@Column(name="nombre_comercial")
	private String nombreComercial;

	@Column(name="primer_apellido")
	private String primerApellido;

	@Column(name="razon_social")
	private String razonSocial;

	private String rfc;

	@Column(name="segundo_apellido")
	private String segundoApellido;

	@Column(name="siisne_empresa_sne")
	private Integer siisneEmpresaSne;

	@Column(name="siisne_fuente")
	private Integer siisneFuente;

	@Column(name="siisne_id_actividad_economica")
	private Integer siisneIdActividadEconomica;

	@Column(name="siisne_id_empresa")
	private Integer siisneIdEmpresa;

	@Column(name="siisne_id_medio")
	private Integer siisneIdMedio;

	@Column(name="siisne_id_motivo_desactivacion")
	private Integer siisneIdMotivoDesactivacion;

	@Column(name="siisne_id_oficina")
	private Integer siisneIdOficina;

	@Column(name="siisne_id_portal_empleo")
	private String siisneIdPortalEmpleo;

	@Column(name="siisne_id_subsector")
	private Integer siisneIdSubsector;

	@Column(name="siisne_id_tipo_sociedad")
	private Integer siisneIdTipoSociedad;

	@Column(name="siisne_numero_empleados")
	private Integer siisneNumeroEmpleados;

	@Column(name="siisne_pagina_web")
	private String siisnePaginaWeb;

	@Column(name="siisne_rama")
	private Integer siisneRama;

	@Column(name="siisne_sector")
	private Integer siisneSector;

	@Column(name="siisne_tamanio")
	private Integer siisneTamanio;

	@Column(name="update_at")
	private Timestamp updateAt;

	private Integer usuario;

	//bi-directional many-to-one association to Contactoempleador
	@OneToMany(mappedBy="empleador")
	private List<ContactoEmpleador> contactoempleadors;

	//bi-directional many-to-one association to Ofertaempleo
	@OneToMany(mappedBy="empleador")
	private List<OfertaEmpleo> ofertaempleos;

	public Empleador() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCorreoElectronico() {
		return this.correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public Timestamp getCreateAt() {
		return this.createAt;
	}

	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}

	public String getCurp() {
		return this.curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public Boolean getCurpValidada() {
		return this.curpValidada;
	}

	public void setCurpValidada(Boolean curpValidada) {
		this.curpValidada = curpValidada;
	}

	public Timestamp getDeleteAt() {
		return this.deleteAt;
	}

	public void setDeleteAt(Timestamp deleteAt) {
		this.deleteAt = deleteAt;
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

	public Date getFechaConstitucion() {
		return this.fechaConstitucion;
	}

	public void setFechaConstitucion(Date fechaConstitucion) {
		this.fechaConstitucion = fechaConstitucion;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Integer getGenero() {
		return this.genero;
	}

	public void setGenero(Integer genero) {
		this.genero = genero;
	}

	public Integer getIdMotivoNoValidacion() {
		return this.idMotivoNoValidacion;
	}

	public void setIdMotivoNoValidacion(Integer idMotivoNoValidacion) {
		this.idMotivoNoValidacion = idMotivoNoValidacion;
	}

	public Integer getIdSectorgiro() {
		return this.idSectorgiro;
	}

	public void setIdSectorgiro(Integer idSectorgiro) {
		this.idSectorgiro = idSectorgiro;
	}

	public Integer getIdTipoempresa() {
		return this.idTipoempresa;
	}

	public void setIdTipoempresa(Integer idTipoempresa) {
		this.idTipoempresa = idTipoempresa;
	}

	public Integer getIdTipopersona() {
		return this.idTipopersona;
	}

	public void setIdTipopersona(Integer idTipopersona) {
		this.idTipopersona = idTipopersona;
	}

	public Integer getIdUbicacion() {
		return this.idUbicacion;
	}

	public void setIdUbicacion(Integer idUbicacion) {
		this.idUbicacion = idUbicacion;
	}

	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Integer getLugarNacimiento() {
		return this.lugarNacimiento;
	}

	public void setLugarNacimiento(Integer lugarNacimiento) {
		this.lugarNacimiento = lugarNacimiento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreComercial() {
		return this.nombreComercial;
	}

	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}

	public String getPrimerApellido() {
		return this.primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getRazonSocial() {
		return this.razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getRfc() {
		return this.rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getSegundoApellido() {
		return this.segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public Integer getSiisneEmpresaSne() {
		return this.siisneEmpresaSne;
	}

	public void setSiisneEmpresaSne(Integer siisneEmpresaSne) {
		this.siisneEmpresaSne = siisneEmpresaSne;
	}

	public Integer getSiisneFuente() {
		return this.siisneFuente;
	}

	public void setSiisneFuente(Integer siisneFuente) {
		this.siisneFuente = siisneFuente;
	}

	public Integer getSiisneIdActividadEconomica() {
		return this.siisneIdActividadEconomica;
	}

	public void setSiisneIdActividadEconomica(Integer siisneIdActividadEconomica) {
		this.siisneIdActividadEconomica = siisneIdActividadEconomica;
	}

	public Integer getSiisneIdEmpresa() {
		return this.siisneIdEmpresa;
	}

	public void setSiisneIdEmpresa(Integer siisneIdEmpresa) {
		this.siisneIdEmpresa = siisneIdEmpresa;
	}

	public Integer getSiisneIdMedio() {
		return this.siisneIdMedio;
	}

	public void setSiisneIdMedio(Integer siisneIdMedio) {
		this.siisneIdMedio = siisneIdMedio;
	}

	public Integer getSiisneIdMotivoDesactivacion() {
		return this.siisneIdMotivoDesactivacion;
	}

	public void setSiisneIdMotivoDesactivacion(Integer siisneIdMotivoDesactivacion) {
		this.siisneIdMotivoDesactivacion = siisneIdMotivoDesactivacion;
	}

	public Integer getSiisneIdOficina() {
		return this.siisneIdOficina;
	}

	public void setSiisneIdOficina(Integer siisneIdOficina) {
		this.siisneIdOficina = siisneIdOficina;
	}

	public String getSiisneIdPortalEmpleo() {
		return this.siisneIdPortalEmpleo;
	}

	public void setSiisneIdPortalEmpleo(String siisneIdPortalEmpleo) {
		this.siisneIdPortalEmpleo = siisneIdPortalEmpleo;
	}

	public Integer getSiisneIdSubsector() {
		return this.siisneIdSubsector;
	}

	public void setSiisneIdSubsector(Integer siisneIdSubsector) {
		this.siisneIdSubsector = siisneIdSubsector;
	}

	public Integer getSiisneIdTipoSociedad() {
		return this.siisneIdTipoSociedad;
	}

	public void setSiisneIdTipoSociedad(Integer siisneIdTipoSociedad) {
		this.siisneIdTipoSociedad = siisneIdTipoSociedad;
	}

	public Integer getSiisneNumeroEmpleados() {
		return this.siisneNumeroEmpleados;
	}

	public void setSiisneNumeroEmpleados(Integer siisneNumeroEmpleados) {
		this.siisneNumeroEmpleados = siisneNumeroEmpleados;
	}

	public String getSiisnePaginaWeb() {
		return this.siisnePaginaWeb;
	}

	public void setSiisnePaginaWeb(String siisnePaginaWeb) {
		this.siisnePaginaWeb = siisnePaginaWeb;
	}

	public Integer getSiisneRama() {
		return this.siisneRama;
	}

	public void setSiisneRama(Integer siisneRama) {
		this.siisneRama = siisneRama;
	}

	public Integer getSiisneSector() {
		return this.siisneSector;
	}

	public void setSiisneSector(Integer siisneSector) {
		this.siisneSector = siisneSector;
	}

	public Integer getSiisneTamanio() {
		return this.siisneTamanio;
	}

	public void setSiisneTamanio(Integer siisneTamanio) {
		this.siisneTamanio = siisneTamanio;
	}

	public Timestamp getUpdateAt() {
		return this.updateAt;
	}

	public void setUpdateAt(Timestamp updateAt) {
		this.updateAt = updateAt;
	}

	public Integer getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}

	public List<ContactoEmpleador> getContactoempleadors() {
		return this.contactoempleadors;
	}

	public void setContactoempleadors(List<ContactoEmpleador> contactoempleadors) {
		this.contactoempleadors = contactoempleadors;
	}

	public ContactoEmpleador addContactoempleador(ContactoEmpleador contactoempleador) {
		getContactoempleadors().add(contactoempleador);
		contactoempleador.setEmpleador(this);

		return contactoempleador;
	}

	public ContactoEmpleador removeContactoempleador(ContactoEmpleador contactoempleador) {
		getContactoempleadors().remove(contactoempleador);
		contactoempleador.setEmpleador(null);

		return contactoempleador;
	}

	public List<OfertaEmpleo> getOfertaempleos() {
		return this.ofertaempleos;
	}

	public void setOfertaempleos(List<OfertaEmpleo> ofertaempleos) {
		this.ofertaempleos = ofertaempleos;
	}

	public OfertaEmpleo addOfertaempleo(OfertaEmpleo ofertaempleo) {
		getOfertaempleos().add(ofertaempleo);
		ofertaempleo.setEmpleador(this);

		return ofertaempleo;
	}

	public OfertaEmpleo removeOfertaempleo(OfertaEmpleo ofertaempleo) {
		getOfertaempleos().remove(ofertaempleo);
		ofertaempleo.setEmpleador(null);

		return ofertaempleo;
	}

}