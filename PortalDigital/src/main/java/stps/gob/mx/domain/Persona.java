package stps.gob.mx.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
@Table(name="persona", schema="persona")
//@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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

	private String genero;

	@Column(name="id_ubicacion")
	private Integer idUbicacion;

	@Column(name="id_usuario")
	private Integer idUsuario;

	private String nombre;

	@Column(name="primer_apellido")
	private String primerApellido;

	@Column(name="segundo_apellido")
	private String segundoApellido;

	@Column(name="telefono_celular")
	private String telefonoCelular;

	//bi-directional many-to-one association to Candidato
	@OneToMany(mappedBy="persona")
	private List<Candidato> candidatos;

	//bi-directional many-to-one association to Curriculum
	@OneToMany(mappedBy="persona")
	private List<Curriculum> curriculums;

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

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
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

	public String getTelefonoCelular() {
		return this.telefonoCelular;
	}

	public void setTelefonoCelular(String telefonoCelular) {
		this.telefonoCelular = telefonoCelular;
	}

	public List<Candidato> getCandidatos() {
		return this.candidatos;
	}

	public void setCandidatos(List<Candidato> candidatos) {
		this.candidatos = candidatos;
	}

	public Candidato addCandidato(Candidato candidato) {
		getCandidatos().add(candidato);
		candidato.setPersona(this);

		return candidato;
	}

	public Candidato removeCandidato(Candidato candidato) {
		getCandidatos().remove(candidato);
		candidato.setPersona(null);

		return candidato;
	}

	public List<Curriculum> getCurriculums() {
		return this.curriculums;
	}

	public void setCurriculums(List<Curriculum> curriculums) {
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