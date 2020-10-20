package stps.gob.mx.domain.oferta;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the empleador database table.
 * 
 */
@Entity
@NamedQuery(name="Empleador.findAll", query="SELECT e FROM Empleador e")
@Table(name = "empleador", schema = "oferta")
public class Empleador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String descripcion;

	private Integer estatus;

	@Column(name="id_sectorgiro")
	private Integer idSectorgiro;

	@Column(name="id_tipoempresa")
	private Integer idTipoempresa;

	@Column(name="id_ubicacion")
	private Integer idUbicacion;

	@Column(name="id_usuario")
	private Integer idUsuario;

	private String nombre;

	private String rfc;

	//bi-directional many-to-one association to ContactoEmpleador
	@OneToMany(mappedBy="empleador")
	private Set<ContactoEmpleador> contactoempleadors;

	//bi-directional many-to-one association to OfertaEmpleo
	@OneToMany(mappedBy="empleador")
	private Set<OfertaEmpleo> ofertaempleos;

	public Empleador() {
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

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRfc() {
		return this.rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public Set<ContactoEmpleador> getContactoempleadors() {
		return this.contactoempleadors;
	}

	public void setContactoempleadors(Set<ContactoEmpleador> contactoempleadors) {
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

	public Set<OfertaEmpleo> getOfertaempleos() {
		return this.ofertaempleos;
	}

	public void setOfertaempleos(Set<OfertaEmpleo> ofertaempleos) {
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