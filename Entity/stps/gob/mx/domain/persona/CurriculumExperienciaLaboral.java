package stps.gob.mx.domain.persona;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the curriculum_experiencialaboral database table.
 * 
 */
@Entity
@Table(name="curriculum_experiencialaboral", schema = "persona")
@NamedQuery(name="CurriculumExperienciaLaboral.findAll", query="SELECT c FROM CurriculumExperienciaLaboral c")
public class CurriculumExperienciaLaboral implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String cargo;

	@Column(name="descripcion_funciones")
	private String descripcionFunciones;

	private String documentoprobatorio;

	private String empresa;

	private Integer estatus;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_fin")
	private Date fechaFin;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inicio")
	private Date fechaInicio;

	private String referencia;

	private BigDecimal salarionetomensual;

	//bi-directional many-to-one association to Curriculum
	@ManyToOne
	@JoinColumn(name="id_curriculum")
	private Curriculum curriculum;

	public CurriculumExperienciaLaboral() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getDescripcionFunciones() {
		return this.descripcionFunciones;
	}

	public void setDescripcionFunciones(String descripcionFunciones) {
		this.descripcionFunciones = descripcionFunciones;
	}

	public String getDocumentoprobatorio() {
		return this.documentoprobatorio;
	}

	public void setDocumentoprobatorio(String documentoprobatorio) {
		this.documentoprobatorio = documentoprobatorio;
	}

	public String getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public Integer getEstatus() {
		return this.estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getReferencia() {
		return this.referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public BigDecimal getSalarionetomensual() {
		return this.salarionetomensual;
	}

	public void setSalarionetomensual(BigDecimal salarionetomensual) {
		this.salarionetomensual = salarionetomensual;
	}

	public Curriculum getCurriculum() {
		return this.curriculum;
	}

	public void setCurriculum(Curriculum curriculum) {
		this.curriculum = curriculum;
	}

}