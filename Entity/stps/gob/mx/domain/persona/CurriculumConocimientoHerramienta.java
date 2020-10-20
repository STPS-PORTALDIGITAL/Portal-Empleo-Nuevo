package stps.gob.mx.domain.persona;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the curriculum_conocimientoherramienta database table.
 * 
 */
@Entity
@Table(name="curriculum_conocimientoherramienta", schema = "persona")
@NamedQuery(name="CurriculumConocimientoHerramienta.findAll", query="SELECT c FROM CurriculumConocimientoHerramienta c")
public class CurriculumConocimientoHerramienta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name="anios_experiencia")
	private Integer aniosExperiencia;

	private String certificado;

	private Integer estatus;

	@Column(name="id_conocimientoherramienta")
	private Integer idConocimientoherramienta;

	//bi-directional many-to-one association to Curriculum
	@ManyToOne
	@JoinColumn(name="id_curriculum")
	private Curriculum curriculum;

	public CurriculumConocimientoHerramienta() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAniosExperiencia() {
		return this.aniosExperiencia;
	}

	public void setAniosExperiencia(Integer aniosExperiencia) {
		this.aniosExperiencia = aniosExperiencia;
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

	public Integer getIdConocimientoherramienta() {
		return this.idConocimientoherramienta;
	}

	public void setIdConocimientoherramienta(Integer idConocimientoherramienta) {
		this.idConocimientoherramienta = idConocimientoherramienta;
	}

	public Curriculum getCurriculum() {
		return this.curriculum;
	}

	public void setCurriculum(Curriculum curriculum) {
		this.curriculum = curriculum;
	}

}