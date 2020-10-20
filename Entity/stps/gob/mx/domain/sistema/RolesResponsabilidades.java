package stps.gob.mx.domain.sistema;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the roles_responsabilidades database table.
 * 
 */
@Entity
@Table(name="roles_responsabilidades", schema = "sistema")
@NamedQuery(name="RolesResponsabilidades.findAll", query="SELECT r FROM RolesResponsabilidades r")
public class RolesResponsabilidades implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false)
	private Integer estatus;

	//bi-directional many-to-one association to Responsabilidad
	@ManyToOne
	@JoinColumn(name="id_responsabilidad", nullable=false)
	private Responsabilidad responsabilidade;

	//bi-directional many-to-one association to Roles
	@ManyToOne
	@JoinColumn(name="id_rol", nullable=false)
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

	public Responsabilidad getResponsabilidade() {
		return this.responsabilidade;
	}

	public void setResponsabilidade(Responsabilidad responsabilidade) {
		this.responsabilidade = responsabilidade;
	}

	public Roles getRole() {
		return this.role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

}