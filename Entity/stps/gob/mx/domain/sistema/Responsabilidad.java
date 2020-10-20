package stps.gob.mx.domain.sistema;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the responsabilidades database table.
 * 
 */
@Entity
@Table(name="responsabilidades", schema = "sistema")
@NamedQuery(name="Responsabilidad.findAll", query="SELECT r FROM Responsabilidad r")
public class Responsabilidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false, length=64)
	private String descripcion;

	@Column(nullable=false)
	private Integer estatus;

	//bi-directional many-to-one association to RolesResponsabilidades
	@OneToMany(mappedBy="responsabilidade")
	private Set<RolesResponsabilidades> rolesResponsabilidades;

	public Responsabilidad() {
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

	public Set<RolesResponsabilidades> getRolesResponsabilidades() {
		return this.rolesResponsabilidades;
	}

	public void setRolesResponsabilidades(Set<RolesResponsabilidades> rolesResponsabilidades) {
		this.rolesResponsabilidades = rolesResponsabilidades;
	}

	public RolesResponsabilidades addRolesResponsabilidade(RolesResponsabilidades rolesResponsabilidade) {
		getRolesResponsabilidades().add(rolesResponsabilidade);
		rolesResponsabilidade.setResponsabilidade(this);

		return rolesResponsabilidade;
	}

	public RolesResponsabilidades removeRolesResponsabilidade(RolesResponsabilidades rolesResponsabilidade) {
		getRolesResponsabilidades().remove(rolesResponsabilidade);
		rolesResponsabilidade.setResponsabilidade(null);

		return rolesResponsabilidade;
	}

}