package stps.gob.mx.domain.catalogo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the institucioneducativa database table.
 * 
 */
@Entity
@NamedQuery(name="InstitucionEducativa.findAll", query="SELECT i FROM InstitucionEducativa i")
@Table(name = "institucioneducativa", schema = "catalogo")
public class InstitucionEducativa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String descripcion;

	private Integer estatus;

	//bi-directional many-to-one association to TipoInstitucionEducativa
	@ManyToOne
	@JoinColumn(name="id_tipo_institucioneducativa")
	private TipoInstitucionEducativa tipoInstitucioneducativa;

	public InstitucionEducativa() {
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

	public TipoInstitucionEducativa getTipoInstitucioneducativa() {
		return this.tipoInstitucioneducativa;
	}

	public void setTipoInstitucioneducativa(TipoInstitucionEducativa tipoInstitucioneducativa) {
		this.tipoInstitucioneducativa = tipoInstitucioneducativa;
	}

}