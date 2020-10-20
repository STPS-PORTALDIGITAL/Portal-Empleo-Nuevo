package stps.gob.mx.domain.oferta;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the tipocontacto database table.
 * 
 */
@Entity
@NamedQuery(name="TipoContacto.findAll", query="SELECT t FROM TipoContacto t")
@Table(name = "tipocontacto", schema = "oferta")
public class TipoContacto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String descripcion;

	//bi-directional many-to-one association to ContactoEmpleador
	@OneToMany(mappedBy="tipocontacto")
	private Set<ContactoEmpleador> contactoempleadors;

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

	public Set<ContactoEmpleador> getContactoempleadors() {
		return this.contactoempleadors;
	}

	public void setContactoempleadors(Set<ContactoEmpleador> contactoempleadors) {
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