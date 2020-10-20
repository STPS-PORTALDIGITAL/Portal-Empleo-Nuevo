package stps.gob.mx.domain.persona;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the curriculum_otrosestudios database table.
 * 
 */
@Entity
@Table(name="curriculum_otrosestudios", schema = "persona")
@NamedQuery(name="CurriculumOtrosEstudio.findAll", query="SELECT c FROM CurriculumOtrosEstudio c")
public class CurriculumOtrosEstudio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String descripcion;

	private String documentoprobatorio;

	private Integer estatus;

	//bi-directional many-to-one association to Curriculum
	@ManyToOne
	@JoinColumn(name="id_curriculum")
	private Curriculum curriculum;

	public CurriculumOtrosEstudio() {
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

	public Curriculum getCurriculum() {
		return this.curriculum;
	}

	public void setCurriculum(Curriculum curriculum) {
		this.curriculum = curriculum;
	}

}