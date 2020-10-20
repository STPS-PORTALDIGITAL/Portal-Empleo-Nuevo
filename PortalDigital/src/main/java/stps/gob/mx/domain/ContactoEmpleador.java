package stps.gob.mx.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the contactoempleador database table.
 * 
 */
@Entity
@Table(name="contactoempleador", schema="oferta")
//@NamedQuery(name="Contactoempleador.findAll", query="SELECT c FROM Contactoempleador c")
public class ContactoEmpleador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private Integer estatus;

	private String nombre;

	@Column(name="primer_apellido")
	private String primerApellido;

	@Column(name="segundo_apellido")
	private String segundoApellido;

	//bi-directional many-to-one association to Empleador
	@ManyToOne
	@JoinColumn(name="id_empleador")
	private Empleador empleador;

	//bi-directional many-to-one association to Tipocontacto
	@ManyToOne
	@JoinColumn(name="id_tipocontacto")
	private TipoContacto tipocontacto;

	public ContactoEmpleador() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEstatus() {
		return this.estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrimerApellido() {
		return this.primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return this.segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public Empleador getEmpleador() {
		return this.empleador;
	}

	public void setEmpleador(Empleador empleador) {
		this.empleador = empleador;
	}

	public TipoContacto getTipocontacto() {
		return this.tipocontacto;
	}

	public void setTipocontacto(TipoContacto tipocontacto) {
		this.tipocontacto = tipocontacto;
	}

}