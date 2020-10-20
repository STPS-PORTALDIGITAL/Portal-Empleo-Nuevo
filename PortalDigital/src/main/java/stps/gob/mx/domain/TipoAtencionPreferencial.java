package stps.gob.mx.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipoatencionpreferencial database table.
 * 
 */
@Entity
@Table(name="tipoatencionpreferencial", schema="persona")
//@NamedQuery(name="Tipoatencionpreferencial.findAll", query="SELECT t FROM Tipoatencionpreferencial t")
public class TipoAtencionPreferencial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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