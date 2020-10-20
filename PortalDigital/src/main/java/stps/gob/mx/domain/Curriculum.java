package stps.gob.mx.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the curriculum database table.
 * 
 */
@Entity
@Table(name="curriculum", schema="persona")
//@NamedQuery(name="Curriculum.findAll", query="SELECT c FROM Curriculum c")
public class Curriculum implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="disponibilidad_movilidad")
	private Boolean disponibilidadMovilidad;

	@Column(name="disponibilidad_viajar")
	private Boolean disponibilidadViajar;

	private Integer estatus;

	@Column(name="expectativa_diaslaborales")
	private String expectativaDiaslaborales;

	@Column(name="expectativa_horario")
	private String expectativaHorario;

	@Column(name="expectativa_interesespersonales")
	private String expectativaInteresespersonales;

	@Column(name="expectativa_salarionetomensual")
	private BigDecimal expectativaSalarionetomensual;

	@Column(name="id_buscador_trabajo")
	private Integer idBuscadorTrabajo;

	@Column(name="id_niveleducativo")
	private Integer idNiveleducativo;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="id_persona")
	private Persona persona;

	//bi-directional many-to-one association to CurriculumConocimientoherramienta
	@OneToMany(mappedBy="curriculum")
	private List<CurriculumConocimientoHerramienta> curriculumConocimientoherramientas;

	//bi-directional many-to-one association to CurriculumEscolaridad
	@OneToMany(mappedBy="curriculum")
	private List<CurriculumEscolaridad> curriculumEscolaridads;

	//bi-directional many-to-one association to CurriculumExperiencialaboral
	@OneToMany(mappedBy="curriculum")
	private List<CurriculumExperienciaLaboral> curriculumExperiencialaborals;

	//bi-directional many-to-one association to CurriculumHabilidadcompetencia
	@OneToMany(mappedBy="curriculum")
	private List<CurriculumHabilidadCompetencia> curriculumHabilidadcompetencias;

	//bi-directional many-to-one association to CurriculumIdioma
	@OneToMany(mappedBy="curriculum")
	private List<CurriculumIdioma> curriculumIdiomas;

	//bi-directional many-to-one association to CurriculumOtrosestudio
	@OneToMany(mappedBy="curriculum")
	private List<CurriculumOtrosEstudios> curriculumOtrosestudios;

	public Curriculum() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getDisponibilidadMovilidad() {
		return this.disponibilidadMovilidad;
	}

	public void setDisponibilidadMovilidad(Boolean disponibilidadMovilidad) {
		this.disponibilidadMovilidad = disponibilidadMovilidad;
	}

	public Boolean getDisponibilidadViajar() {
		return this.disponibilidadViajar;
	}

	public void setDisponibilidadViajar(Boolean disponibilidadViajar) {
		this.disponibilidadViajar = disponibilidadViajar;
	}

	public Integer getEstatus() {
		return this.estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	public String getExpectativaDiaslaborales() {
		return this.expectativaDiaslaborales;
	}

	public void setExpectativaDiaslaborales(String expectativaDiaslaborales) {
		this.expectativaDiaslaborales = expectativaDiaslaborales;
	}

	public String getExpectativaHorario() {
		return this.expectativaHorario;
	}

	public void setExpectativaHorario(String expectativaHorario) {
		this.expectativaHorario = expectativaHorario;
	}

	public String getExpectativaInteresespersonales() {
		return this.expectativaInteresespersonales;
	}

	public void setExpectativaInteresespersonales(String expectativaInteresespersonales) {
		this.expectativaInteresespersonales = expectativaInteresespersonales;
	}

	public BigDecimal getExpectativaSalarionetomensual() {
		return this.expectativaSalarionetomensual;
	}

	public void setExpectativaSalarionetomensual(BigDecimal expectativaSalarionetomensual) {
		this.expectativaSalarionetomensual = expectativaSalarionetomensual;
	}

	public Integer getIdBuscadorTrabajo() {
		return this.idBuscadorTrabajo;
	}

	public void setIdBuscadorTrabajo(Integer idBuscadorTrabajo) {
		this.idBuscadorTrabajo = idBuscadorTrabajo;
	}

	public Integer getIdNiveleducativo() {
		return this.idNiveleducativo;
	}

	public void setIdNiveleducativo(Integer idNiveleducativo) {
		this.idNiveleducativo = idNiveleducativo;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<CurriculumConocimientoHerramienta> getCurriculumConocimientoherramientas() {
		return this.curriculumConocimientoherramientas;
	}

	public void setCurriculumConocimientoherramientas(List<CurriculumConocimientoHerramienta> curriculumConocimientoherramientas) {
		this.curriculumConocimientoherramientas = curriculumConocimientoherramientas;
	}

	public CurriculumConocimientoHerramienta addCurriculumConocimientoherramienta(CurriculumConocimientoHerramienta curriculumConocimientoherramienta) {
		getCurriculumConocimientoherramientas().add(curriculumConocimientoherramienta);
		curriculumConocimientoherramienta.setCurriculum(this);

		return curriculumConocimientoherramienta;
	}

	public CurriculumConocimientoHerramienta removeCurriculumConocimientoherramienta(CurriculumConocimientoHerramienta curriculumConocimientoherramienta) {
		getCurriculumConocimientoherramientas().remove(curriculumConocimientoherramienta);
		curriculumConocimientoherramienta.setCurriculum(null);

		return curriculumConocimientoherramienta;
	}

	public List<CurriculumEscolaridad> getCurriculumEscolaridads() {
		return this.curriculumEscolaridads;
	}

	public void setCurriculumEscolaridads(List<CurriculumEscolaridad> curriculumEscolaridads) {
		this.curriculumEscolaridads = curriculumEscolaridads;
	}

	public CurriculumEscolaridad addCurriculumEscolaridad(CurriculumEscolaridad curriculumEscolaridad) {
		getCurriculumEscolaridads().add(curriculumEscolaridad);
		curriculumEscolaridad.setCurriculum(this);

		return curriculumEscolaridad;
	}

	public CurriculumEscolaridad removeCurriculumEscolaridad(CurriculumEscolaridad curriculumEscolaridad) {
		getCurriculumEscolaridads().remove(curriculumEscolaridad);
		curriculumEscolaridad.setCurriculum(null);

		return curriculumEscolaridad;
	}

	public List<CurriculumExperienciaLaboral> getCurriculumExperiencialaborals() {
		return this.curriculumExperiencialaborals;
	}

	public void setCurriculumExperiencialaborals(List<CurriculumExperienciaLaboral> curriculumExperiencialaborals) {
		this.curriculumExperiencialaborals = curriculumExperiencialaborals;
	}

	public CurriculumExperienciaLaboral addCurriculumExperiencialaboral(CurriculumExperienciaLaboral curriculumExperiencialaboral) {
		getCurriculumExperiencialaborals().add(curriculumExperiencialaboral);
		curriculumExperiencialaboral.setCurriculum(this);

		return curriculumExperiencialaboral;
	}

	public CurriculumExperienciaLaboral removeCurriculumExperiencialaboral(CurriculumExperienciaLaboral curriculumExperiencialaboral) {
		getCurriculumExperiencialaborals().remove(curriculumExperiencialaboral);
		curriculumExperiencialaboral.setCurriculum(null);

		return curriculumExperiencialaboral;
	}

	public List<CurriculumHabilidadCompetencia> getCurriculumHabilidadcompetencias() {
		return this.curriculumHabilidadcompetencias;
	}

	public void setCurriculumHabilidadcompetencias(List<CurriculumHabilidadCompetencia> curriculumHabilidadcompetencias) {
		this.curriculumHabilidadcompetencias = curriculumHabilidadcompetencias;
	}

	public CurriculumHabilidadCompetencia addCurriculumHabilidadcompetencia(CurriculumHabilidadCompetencia curriculumHabilidadcompetencia) {
		getCurriculumHabilidadcompetencias().add(curriculumHabilidadcompetencia);
		curriculumHabilidadcompetencia.setCurriculum(this);

		return curriculumHabilidadcompetencia;
	}

	public CurriculumHabilidadCompetencia removeCurriculumHabilidadcompetencia(CurriculumHabilidadCompetencia curriculumHabilidadcompetencia) {
		getCurriculumHabilidadcompetencias().remove(curriculumHabilidadcompetencia);
		curriculumHabilidadcompetencia.setCurriculum(null);

		return curriculumHabilidadcompetencia;
	}

	public List<CurriculumIdioma> getCurriculumIdiomas() {
		return this.curriculumIdiomas;
	}

	public void setCurriculumIdiomas(List<CurriculumIdioma> curriculumIdiomas) {
		this.curriculumIdiomas = curriculumIdiomas;
	}

	public CurriculumIdioma addCurriculumIdioma(CurriculumIdioma curriculumIdioma) {
		getCurriculumIdiomas().add(curriculumIdioma);
		curriculumIdioma.setCurriculum(this);

		return curriculumIdioma;
	}

	public CurriculumIdioma removeCurriculumIdioma(CurriculumIdioma curriculumIdioma) {
		getCurriculumIdiomas().remove(curriculumIdioma);
		curriculumIdioma.setCurriculum(null);

		return curriculumIdioma;
	}

	public List<CurriculumOtrosEstudios> getCurriculumOtrosestudios() {
		return this.curriculumOtrosestudios;
	}

	public void setCurriculumOtrosestudios(List<CurriculumOtrosEstudios> curriculumOtrosestudios) {
		this.curriculumOtrosestudios = curriculumOtrosestudios;
	}

	public CurriculumOtrosEstudios addCurriculumOtrosestudio(CurriculumOtrosEstudios curriculumOtrosestudio) {
		getCurriculumOtrosestudios().add(curriculumOtrosestudio);
		curriculumOtrosestudio.setCurriculum(this);

		return curriculumOtrosestudio;
	}

	public CurriculumOtrosEstudios removeCurriculumOtrosestudio(CurriculumOtrosEstudios curriculumOtrosestudio) {
		getCurriculumOtrosestudios().remove(curriculumOtrosestudio);
		curriculumOtrosestudio.setCurriculum(null);

		return curriculumOtrosestudio;
	}

}