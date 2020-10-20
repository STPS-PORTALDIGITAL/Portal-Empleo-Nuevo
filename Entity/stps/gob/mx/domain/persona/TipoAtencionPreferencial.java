package stps.gob.mx.domain.persona;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipoatencionpreferencial database table.
 * 
 */
@Entity
@NamedQuery(name="TipoAtencionPreferencial.findAll", query="SELECT t FROM TipoAtencionPreferencial t")
@Table(name = "tipoatencionpreferencial", schema = "persona")
public class TipoAtencionPreferencial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String descripcion;

	private Integer estatus;

	public TipoAtencionPreferencial() {
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

}