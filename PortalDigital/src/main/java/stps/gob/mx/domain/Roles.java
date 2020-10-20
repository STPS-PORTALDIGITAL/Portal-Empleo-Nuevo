package stps.gob.mx.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the roles database table.
 * 
 */
@Entity
@Table(name="roles", schema="sistema")
//@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Roles implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String descripcion;

	private Integer estatus;

	//bi-directional many-to-one association to RolesResponsabilidade
	@OneToMany(mappedBy="role")
	private List<RolesResponsabilidades> rolesResponsabilidades;

	//bi-directional many-to-one association to RolesUsuario
	@OneToMany(mappedBy="role")
	private List<RolesUsuario> rolesUsuarios;

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

	public List<RolesResponsabilidades> getRolesResponsabilidades() {
		return this.rolesResponsabilidades;
	}

	public void setRolesResponsabilidades(List<RolesResponsabilidades> rolesResponsabilidades) {
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

	public List<RolesUsuario> getRolesUsuarios() {
		return this.rolesUsuarios;
	}

	public void setRolesUsuarios(List<RolesUsuario> rolesUsuarios) {
		this.rolesUsuarios = rolesUsuarios;
	}

	public RolesUsuario addRolesUsuario(RolesUsuario rolesUsuario) {
		getRolesUsuarios().add(rolesUsuario);
		rolesUsuario.setRole(this);

		return rolesUsuario;
	}

	public RolesUsuario removeRolesUsuario(RolesUsuario rolesUsuario) {
		getRolesUsuarios().remove(rolesUsuario);
		rolesUsuario.setRole(null);

		return rolesUsuario;
	}

}