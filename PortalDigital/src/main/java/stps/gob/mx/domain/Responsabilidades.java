package stps.gob.mx.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the responsabilidades database table.
 * 
 */
@Entity
@Table(name="responsabilidades", schema="sistema")
//@NamedQuery(name="Responsabilidade.findAll", query="SELECT r FROM Responsabilidade r")
public class Responsabilidades implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String descripcion;

	private Integer estatus;

	//bi-directional many-to-one association to RolesResponsabilidade
	@OneToMany(mappedBy="responsabilidade")
	private List<RolesResponsabilidades> rolesResponsabilidades;

	public Responsabilidades() {
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

	public List<RolesResponsabilidades> getRolesResponsabilidades() {
		return this.rolesResponsabilidades;
	}

	public void setRolesResponsabilidades(List<RolesResponsabilidades> rolesResponsabilidades) {
		this.rolesResponsabilidades = rolesResponsabilidades;
	}

	public RolesResponsabilidades addRolesResponsabilidade(RolesResponsabilidades rolesResponsabilidade) {
		getRolesResponsabilidades().add(rolesResponsabilidade);
		rolesResponsabilidade.setResponsabilidade(this);

		return rolesResponsabilidade;
	}

	public RolesResponsabilidades removeRolesResponsabilidade(RolesResponsabilidades rolesResponsabilidade) {
		getRolesResponsabilidades().remove(rolesResponsabilidade);
		rolesResponsabilidade.setResponsabilidade(null);

		return rolesResponsabilidade;
	}

}