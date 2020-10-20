package stps.gob.mx.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the curriculum_habilidadcompetencia database table.
 * 
 */
@Entity
@Table(name="curriculum_habilidadcompetencia", schema="persona")
//@NamedQuery(name="CurriculumHabilidadcompetencia.findAll", query="SELECT c FROM CurriculumHabilidadcompetencia c")
public class CurriculumHabilidadCompetencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String certificado;

	private Integer estatus;

	@Column(name="id_habilidadcompetencia")
	private Integer idHabilidadcompetencia;

	//bi-directional many-to-one association to Curriculum
	@ManyToOne
	@JoinColumn(name="id_curriculum")
	private Curriculum curriculum;

	public CurriculumHabilidadCompetencia() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCertificado() {
		return this.certificado;
	}

	public void setCertificado(String certificado) {
		this.certificado = certificado;
	}

	public Integer getEstatus() {
		return this.estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	public Integer getIdHabilidadcompetencia() {
		return this.idHabilidadcompetencia;
	}

	public void setIdHabilidadcompetencia(Integer idHabilidadcompetencia) {
		this.idHabilidadcompetencia = idHabilidadcompetencia;
	}

	public Curriculum getCurriculum() {
		return this.curriculum;
	}

	public void setCurriculum(Curriculum curriculum) {
		this.curriculum = curriculum;
	}

}