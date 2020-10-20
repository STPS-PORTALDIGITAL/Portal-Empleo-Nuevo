package stps.gob.mx.domain.sistema;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the roles_usuarios database table.
 * 
 */
@Entity
@Table(name="roles_usuarios", schema = "sistema")
@NamedQuery(name="RolesUsuarios.findAll", query="SELECT r FROM RolesUsuarios r")
public class RolesUsuarios implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false)
	private Integer estatus;

	//bi-directional many-to-one association to Roles
	@ManyToOne
	@JoinColumn(name="id_rol", nullable=false)
	private Roles role;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="id_usuario", nullable=false)
	private Usuario usuario;

	public RolesUsuarios() {
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

	public Roles getRole() {
		return this.role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}