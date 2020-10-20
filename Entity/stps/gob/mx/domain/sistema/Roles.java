package stps.gob.mx.domain.sistema;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the roles database table.
 * 
 */
@Entity
@Table(name="roles", schema = "sistema")
@NamedQuery(name="Roles.findAll", query="SELECT r FROM Roles r")
public class Roles implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false, length=64)
	private String descripcion;

	@Column(nullable=false)
	private Integer estatus;

	//bi-directional many-to-one association to RolesResponsabilidades
	@OneToMany(mappedBy="role")
	private Set<RolesResponsabilidades> rolesResponsabilidades;

	//bi-directional many-to-one association to RolesUsuarios
	@OneToMany(mappedBy="role")
	private Set<RolesUsuarios> rolesUsuarios;

	public Roles() {
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

	public Set<RolesResponsabilidades> getRolesResponsabilidades() {
		return this.rolesResponsabilidades;
	}

	public void setRolesResponsabilidades(Set<RolesResponsabilidades> rolesResponsabilidades) {
		this.rolesResponsabilidades = rolesResponsabilidades;
	}

	public RolesResponsabilidades addRolesResponsabilidade(RolesResponsabilidades rolesResponsabilidade) {
		getRolesResponsabilidades().add(rolesResponsabilidade);
		rolesResponsabilidade.setRole(this);

		return rolesResponsabilidade;
	}

	public RolesResponsabilidades removeRolesResponsabilidade(RolesResponsabilidades rolesResponsabilidade) {
		getRolesResponsabilidades().remove(rolesResponsabilidade);
		rolesResponsabilidade.setRole(null);

		return rolesResponsabilidade;
	}

	public Set<RolesUsuarios> getRolesUsuarios() {
		return this.rolesUsuarios;
	}

	public void setRolesUsuarios(Set<RolesUsuarios> rolesUsuarios) {
		this.rolesUsuarios = rolesUsuarios;
	}

	public RolesUsuarios addRolesUsuario(RolesUsuarios rolesUsuario) {
		getRolesUsuarios().add(rolesUsuario);
		rolesUsuario.setRole(this);

		return rolesUsuario;
	}

	public RolesUsuarios removeRolesUsuario(RolesUsuarios rolesUsuario) {
		getRolesUsuarios().remove(rolesUsuario);
		rolesUsuario.setRole(null);

		return rolesUsuario;
	}

}