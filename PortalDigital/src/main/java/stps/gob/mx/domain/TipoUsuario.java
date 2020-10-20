package stps.gob.mx.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipousuario database table.
 * 
 */
@Entity
@Table(name="tipousuario", schema="sistema")
//@NamedQuery(name="Tipousuario.findAll", query="SELECT t FROM Tipousuario t")
public class TipoUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String descripcion;

	private Integer estatus;

	@Column(name="tabla_relacion")
	private String tablaRelacion;

	public TipoUsuario() {
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

	public String getTablaRelacion() {
		return this.tablaRelacion;
	}

	public void setTablaRelacion(String tablaRelacion) {
		this.tablaRelacion = tablaRelacion;
	}

}