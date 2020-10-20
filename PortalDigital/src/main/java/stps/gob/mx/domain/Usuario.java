package stps.gob.mx.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name="usuarios", schema="sistema")
//@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="activation_token")
	private String activationToken;

	private Boolean active;

	private String avatar;

	@Column(name="created_at")
	private Timestamp createdAt;

	@Column(name="deleted_at")
	private Timestamp deletedAt;

	private String email;

	@Column(name="email_verified_at")
	private Timestamp emailVerifiedAt;

	private Integer estatus;

	@Column(name="id_tipousuario")
	private Integer idTipousuario;

	@Column(name="id_usuario")
	private Integer idUsuario;

	@Column(name="last_login_at")
	private Timestamp lastLoginAt;

	@Column(name="last_login_browser")
	private String lastLoginBrowser;

	@Column(name="last_login_device")
	private String lastLoginDevice;

	@Column(name="last_login_ip")
	private String lastLoginIp;

	@Column(name="last_login_ismobile")
	private Boolean lastLoginIsmobile;

	@Column(name="last_login_platform")
	private String lastLoginPlatform;

	@Column(name="last_login_version")
	private String lastLoginVersion;

	private String passwrd;

	@Column(name="remember_token")
	private String rememberToken;

	@Column(name="updated_at")
	private Timestamp updatedAt;

	@Column(name="user_create")
	private String userCreate;

	@Column(name="user_upddel")
	private String userUpddel;

	private String usuario;

	//bi-directional many-to-one association to RolesUsuario
	@OneToMany(mappedBy="usuario")
	private List<RolesUsuario> rolesUsuarios;

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

	public Integer getIdTipousuario() {
		return this.idTipousuario;
	}

	public void setIdTipousuario(Integer idTipousuario) {
		this.idTipousuario = idTipousuario;
	}

	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
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

	public String getUserCreate() {
		return this.userCreate;
	}

	public void setUserCreate(String userCreate) {
		this.userCreate = userCreate;
	}

	public String getUserUpddel() {
		return this.userUpddel;
	}

	public void setUserUpddel(String userUpddel) {
		this.userUpddel = userUpddel;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public List<RolesUsuario> getRolesUsuarios() {
		return this.rolesUsuarios;
	}

	public void setRolesUsuarios(List<RolesUsuario> rolesUsuarios) {
		this.rolesUsuarios = rolesUsuarios;
	}

	public RolesUsuario addRolesUsuario(RolesUsuario rolesUsuario) {
		getRolesUsuarios().add(rolesUsuario);
		rolesUsuario.setUsuario(this);

		return rolesUsuario;
	}

	public RolesUsuario removeRolesUsuario(RolesUsuario rolesUsuario) {
		getRolesUsuarios().remove(rolesUsuario);
		rolesUsuario.setUsuario(null);

		return rolesUsuario;
	}

}