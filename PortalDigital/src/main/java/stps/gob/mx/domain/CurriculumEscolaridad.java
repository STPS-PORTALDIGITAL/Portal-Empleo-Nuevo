package stps.gob.mx.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the curriculum_escolaridad database table.
 * 
 */
@Entity
@Table(name="curriculum_escolaridad", schema="persona")
//@NamedQuery(name="CurriculumEscolaridad.findAll", query="SELECT c FROM CurriculumEscolaridad c")
public class CurriculumEscolaridad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String descripcion;

	private String documentoprobatorio;

	private Integer estatus;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_fin")
	private Date fechaFin;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_inicio")
	private Date fechaInicio;

	@Column(name="id_institucioneducativa")
	private String idInstitucioneducativa;

	@Column(name="situacion_academica")
	private String situacionAcademica;

	@Column(name="tiene_documentoprobatorio")
	private Boolean tieneDocumentoprobatorio;

	@Column(name="ultimo_grado_estudio")
	private String ultimoGradoEstudio;

	//bi-directional many-to-one association to Curriculum
	@ManyToOne
	@JoinColumn(name="id_curriculum")
	private Curriculum curriculum;

	public CurriculumEscolaridad() {
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

	public String getDocumentoprobatorio() {
		return this.documentoprobatorio;
	}

	public void setDocumentoprobatorio(String documentoprobatorio) {
		this.documentoprobatorio = documentoprobatorio;
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

	public String getIdInstitucioneducativa() {
		return this.idInstitucioneducativa;
	}

	public void setIdInstitucioneducativa(String idInstitucioneducativa) {
		this.idInstitucioneducativa = idInstitucioneducativa;
	}

	public String getSituacionAcademica() {
		return this.situacionAcademica;
	}

	public void setSituacionAcademica(String situacionAcademica) {
		this.situacionAcademica = situacionAcademica;
	}

	public Boolean getTieneDocumentoprobatorio() {
		return this.tieneDocumentoprobatorio;
	}

	public void setTieneDocumentoprobatorio(Boolean tieneDocumentoprobatorio) {
		this.tieneDocumentoprobatorio = tieneDocumentoprobatorio;
	}

	public String getUltimoGradoEstudio() {
		return this.ultimoGradoEstudio;
	}

	public void setUltimoGradoEstudio(String ultimoGradoEstudio) {
		this.ultimoGradoEstudio = ultimoGradoEstudio;
	}

	public Curriculum getCurriculum() {
		return this.curriculum;
	}

	public void setCurriculum(Curriculum curriculum) {
		this.curriculum = curriculum;
	}

}