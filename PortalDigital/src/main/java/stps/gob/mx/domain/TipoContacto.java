package stps.gob.mx.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipocontacto database table.
 * 
 */
@Entity
@Table(name="tipocontacto", schema="oferta")
//@NamedQuery(name="Tipocontacto.findAll", query="SELECT t FROM Tipocontacto t")
public class TipoContacto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String descripcion;

	private Integer estatus;

	//bi-directional many-to-one association to Contactoempleador
	@OneToMany(mappedBy="tipocontacto")
	private List<ContactoEmpleador> contactoempleadors;

	public TipoContacto() {
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

	public List<ContactoEmpleador> getContactoempleadors() {
		return this.contactoempleadors;
	}

	public void setContactoempleadors(List<ContactoEmpleador> contactoempleadors) {
		this.contactoempleadors = contactoempleadors;
	}

	public ContactoEmpleador addContactoempleador(ContactoEmpleador contactoempleador) {
		getContactoempleadors().add(contactoempleador);
		contactoempleador.setTipocontacto(this);

		return contactoempleador;
	}

	public ContactoEmpleador removeContactoempleador(ContactoEmpleador contactoempleador) {
		getContactoempleadors().remove(contactoempleador);
		contactoempleador.setTipocontacto(null);

		return contactoempleador;
	}

}