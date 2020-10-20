package stps.gob.mx.domain.persona;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p")
@Table(name = "persona", schema = "persona")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name="atencion_preferencial")
	private Integer atencionPreferencial;

	@Column(name="atencion_preferente")
	private Boolean atencionPreferente;

	@Column(name="correo_electronico")
	private String correoElectronico;

	private String curp;

	private Integer estatus;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_nacimiento")
	private Date fechaNacimiento;

	@Column(name="fecha_registro")
	private Timestamp fechaRegistro;

	@Column(name="id_tipo_persona")
	private Integer idTipoPersona;

	@Column(name="id_ubicacion")
	private Integer idUbicacion;

	@Column(name="id_usuario")
	private Integer idUsuario;

	private String nombre;

	@Column(name="nombre_completo")
	private String nombreCompleto;

	@Column(name="primer_apellido")
	private String primerApellido;

	@Column(name="segundo_apellido")
	private String segundoApellido;

	private String sexo;

	@Column(name="telefono_celular")
	private String telefonoCelular;

	//bi-directional many-to-one association to Curriculum
	@OneToMany(mappedBy="persona")
	private Set<Curriculum> curriculums;

	public Persona() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAtencionPreferencial() {
		return this.atencionPreferencial;
	}

	public void setAtencionPreferencial(Integer atencionPreferencial) {
		this.atencionPreferencial = atencionPreferencial;
	}

	public Boolean getAtencionPreferente() {
		return this.atencionPreferente;
	}

	public void setAtencionPreferente(Boolean atencionPreferente) {
		this.atencionPreferente = atencionPreferente;
	}

	public String getCorreoElectronico() {
		return this.correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getCurp() {
		return this.curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public Integer getEstatus() {
		return this.estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Timestamp getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Integer getIdTipoPersona() {
		return this.idTipoPersona;
	}

	public void setIdTipoPersona(Integer idTipoPersona) {
		this.idTipoPersona = idTipoPersona;
	}

	public Integer getIdUbicacion() {
		return this.idUbicacion;
	}

	public void setIdUbicacion(Integer idUbicacion) {
		this.idUbicacion = idUbicacion;
	}

	public Integer getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreCompleto() {
		return this.nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getPrimerApellido() {
		return this.primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return this.segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTelefonoCelular() {
		return this.telefonoCelular;
	}

	public void setTelefonoCelular(String telefonoCelular) {
		this.telefonoCelular = telefonoCelular;
	}

	public Set<Curriculum> getCurriculums() {
		return this.curriculums;
	}

	public void setCurriculums(Set<Curriculum> curriculums) {
		this.curriculums = curriculums;
	}

	public Curriculum addCurriculum(Curriculum curriculum) {
		getCurriculums().add(curriculum);
		curriculum.setPersona(this);

		return curriculum;
	}

	public Curriculum removeCurriculum(Curriculum curriculum) {
		getCurriculums().remove(curriculum);
		curriculum.setPersona(null);

		return curriculum;
	}

}