package stps.gob.mx.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the roles_responsabilidades database table.
 * 
 */
@Entity
@Table(name="roles_responsabilidade", schema="sistema")
//@NamedQuery(name="RolesResponsabilidade.findAll", query="SELECT r FROM RolesResponsabilidade r")
public class RolesResponsabilidades implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private Integer estatus;

	//bi-directional many-to-one association to Responsabilidade
	@ManyToOne
	@JoinColumn(name="id_responsabilidad")
	private Responsabilidades responsabilidade;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="id_rol")
	private Roles role;

	public RolesResponsabilidades() {
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

	public Responsabilidades getResponsabilidade() {
		return this.responsabilidade;
	}

	public void setResponsabilidade(Responsabilidades responsabilidade) {
		this.responsabilidade = responsabilidade;
	}

	public Roles getRole() {
		return this.role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

}