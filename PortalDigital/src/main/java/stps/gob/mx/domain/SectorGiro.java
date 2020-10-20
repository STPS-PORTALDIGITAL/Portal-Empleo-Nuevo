package stps.gob.mx.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sectorgiro database table.
 * 
 */
@Entity
@Table(name="sectorgiro", schema="catalogo")
//@NamedQuery(name="Sectorgiro.findAll", query="SELECT s FROM Sectorgiro s")
public class SectorGiro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String descripcion;

	private Integer estatus;

	public SectorGiro() {
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