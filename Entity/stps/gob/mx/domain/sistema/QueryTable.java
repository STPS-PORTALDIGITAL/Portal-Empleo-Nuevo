package stps.gob.mx.domain.sistema;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the query_table database table.
 * 
 */
@Entity
@Table(name="query_table", schema = "sistema")
@NamedQuery(name="QueryTable.findAll", query="SELECT q FROM QueryTable q")
public class QueryTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(length=64)
	private String accion;

	@Column(length=64)
	private String descripcion;

	@Column(nullable=false)
	private Integer estatus;

	@Column(length=64)
	private String servicio;

	@Column(length=2147483647)
	private String textquery;

	public QueryTable() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccion() {
		return this.accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
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

	public String getServicio() {
		return this.servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	public String getTextquery() {
		return this.textquery;
	}

	public void setTextquery(String textquery) {
		this.textquery = textquery;
	}

}