package stps.gob.mx.domain.catalogo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the tipo_institucioneducativa database table.
 * 
 */
@Entity
@Table(name="tipo_institucioneducativa", schema = "catalogo")
@NamedQuery(name="TipoInstitucionEducativa.findAll", query="SELECT t FROM TipoInstitucionEducativa t")
public class TipoInstitucionEducativa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String descripcion;

	private Integer estatus;

	//bi-directional many-to-one association to InstitucionEducativa
	@OneToMany(mappedBy="tipoInstitucioneducativa")
	private Set<InstitucionEducativa> institucioneducativas;

	public TipoInstitucionEducativa() {
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

	public Integer getEstatus() {
		return this.estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	public Set<InstitucionEducativa> getInstitucioneducativas() {
		return this.institucioneducativas;
	}

	public void setInstitucioneducativas(Set<InstitucionEducativa> institucioneducativas) {
		this.institucioneducativas = institucioneducativas;
	}

	public InstitucionEducativa addInstitucioneducativa(InstitucionEducativa institucioneducativa) {
		getInstitucioneducativas().add(institucioneducativa);
		institucioneducativa.setTipoInstitucioneducativa(this);

		return institucioneducativa;
	}

	public InstitucionEducativa removeInstitucioneducativa(InstitucionEducativa institucioneducativa) {
		getInstitucioneducativas().remove(institucioneducativa);
		institucioneducativa.setTipoInstitucioneducativa(null);

		return institucioneducativa;
	}

}