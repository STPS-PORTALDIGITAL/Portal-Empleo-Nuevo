package stps.gob.mx.domain.persona;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the curriculum_idioma database table.
 * 
 */
@Entity
@Table(name="curriculum_idioma", schema = "persona")
@NamedQuery(name="CurriculumIdioma.findAll", query="SELECT c FROM CurriculumIdioma c")
public class CurriculumIdioma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name="dominio_idioma")
	private String dominioIdioma;

	private Integer estatus;

	@Column(name="id_idioma")
	private Integer idIdioma;

	//bi-directional many-to-one association to Curriculum
	@ManyToOne
	@JoinColumn(name="id_curriculum")
	private Curriculum curriculum;

	public CurriculumIdioma() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDominioIdioma() {
		return this.dominioIdioma;
	}

	public void setDominioIdioma(String dominioIdioma) {
		this.dominioIdioma = dominioIdioma;
	}

	public Integer getEstatus() {
		return this.estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	public Integer getIdIdioma() {
		return this.idIdioma;
	}

	public void setIdIdioma(Integer idIdioma) {
		this.idIdioma = idIdioma;
	}

	public Curriculum getCurriculum() {
		return this.curriculum;
	}

	public void setCurriculum(Curriculum curriculum) {
		this.curriculum = curriculum;
	}

}