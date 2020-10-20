package stps.gob.mx.domain.sistema;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name="usuarios", schema = "sistema")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(name="activation_token", length=255)
	private String activationToken;

	private Boolean active;

	@Column(length=255)
	private String avatar;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="deleted_at")
	private Timestamp deletedAt;

	@Column(nullable=false, length=320)
	private String email;

	@Column(name="email_verified_at")
	private Timestamp emailVerifiedAt;

	@Column(nullable=false)
	private Integer estatus;

	@Column(name="id_persona", nullable=false)
	private Integer idPersona;

	@Column(name="last_login_at")
	private Timestamp lastLoginAt;

	@Column(name="last_login_browser", length=64)
	private String lastLoginBrowser;

	@Column(name="last_login_device", length=64)
	private String lastLoginDevice;

	@Column(name="last_login_ip", length=15)
	private String lastLoginIp;

	@Column(name="last_login_ismobile")
	private Boolean lastLoginIsmobile;

	@Column(name="last_login_platform", length=64)
	private String lastLoginPlatform;

	@Column(name="last_login_version", length=128)
	private String lastLoginVersion;

	@Column(nullable=false, length=32)
	private String passwrd;

	@Column(name="remember_token", length=128)
	private String rememberToken;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	@Column(nullable=false, length=32)
	private String usuario;

	//bi-directional many-to-one association to RolesUsuarios
	@OneToMany(mappedBy="usuario")
	private Set<RolesUsuarios> rolesUsuarios;

	public Usuario() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getActivationToken() {
		return this.activationToken;
	}

	public void setActivationToken(String activationToken) {
		this.activationToken = activationToken;
	}

	public Boolean getActive() {
		return this.active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getDeletedAt() {
		return this.deletedAt;
	}

	public void setDeletedAt(Timestamp deletedAt) {
		this.deletedAt = deletedAt;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getEmailVerifiedAt() {
		return this.emailVerifiedAt;
	}

	public void setEmailVerifiedAt(Timestamp emailVerifiedAt) {
		this.emailVerifiedAt = emailVerifiedAt;
	}

	public Integer getEstatus() {
		return this.estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	public Integer getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public Timestamp getLastLoginAt() {
		return this.lastLoginAt;
	}

	public void setLastLoginAt(Timestamp lastLoginAt) {
		this.lastLoginAt = lastLoginAt;
	}

	public String getLastLoginBrowser() {
		return this.lastLoginBrowser;
	}

	public void setLastLoginBrowser(String lastLoginBrowser) {
		this.lastLoginBrowser = lastLoginBrowser;
	}

	public String getLastLoginDevice() {
		return this.lastLoginDevice;
	}

	public void setLastLoginDevice(String lastLoginDevice) {
		this.lastLoginDevice = lastLoginDevice;
	}

	public String getLastLoginIp() {
		return this.lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public Boolean getLastLoginIsmobile() {
		return this.lastLoginIsmobile;
	}

	public void setLastLoginIsmobile(Boolean lastLoginIsmobile) {
		this.lastLoginIsmobile = lastLoginIsmobile;
	}

	public String getLastLoginPlatform() {
		return this.lastLoginPlatform;
	}

	public void setLastLoginPlatform(String lastLoginPlatform) {
		this.lastLoginPlatform = lastLoginPlatform;
	}

	public String getLastLoginVersion() {
		return this.lastLoginVersion;
	}

	public void setLastLoginVersion(String lastLoginVersion) {
		this.lastLoginVersion = lastLoginVersion;
	}

	public String getPasswrd() {
		return this.passwrd;
	}

	public void setPasswrd(String passwrd) {
		this.passwrd = passwrd;
	}

	public String getRememberToken() {
		return this.rememberToken;
	}

	public void setRememberToken(String rememberToken) {
		this.rememberToken = rememberToken;
	}

	public Timestamp getUpdatedAt() {
		return this.updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Set<RolesUsuarios> getRolesUsuarios() {
		return this.rolesUsuarios;
	}

	public void setRolesUsuarios(Set<RolesUsuarios> rolesUsuarios) {
		this.rolesUsuarios = rolesUsuarios;
	}

	public RolesUsuarios addRolesUsuario(RolesUsuarios rolesUsuario) {
		getRolesUsuarios().add(rolesUsuario);
		rolesUsuario.setUsuario(this);

		return rolesUsuario;
	}

	public RolesUsuarios removeRolesUsuario(RolesUsuarios rolesUsuario) {
		getRolesUsuarios().remove(rolesUsuario);
		rolesUsuario.setUsuario(null);

		return rolesUsuario;
	}

}