package stps.gob.mx.domain.persona;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the perfilbusquedaempleo database table.
 * 
 */
@Entity
@NamedQuery(name="PerfilBusquedaEmpleo.findAll", query="SELECT p FROM PerfilBusquedaEmpleo p")
@Table(name = "perfilbusquedaempleo", schema = "persona")
public class PerfilBusquedaEmpleo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name="disponibilidad_movilidad")
	private Boolean disponibilidadMovilidad;

	@Column(name="disponibilidad_viajar")
	private Boolean disponibilidadViajar;

	private Integer estatus;

	@Column(name="id_escolaridad")
	private Integer idEscolaridad;

	@Column(name="id_expectativa_laboral")
	private Integer idExpectativaLaboral;

	@Column(name="id_persona")
	private Integer idPersona;

	public PerfilBusquedaEmpleo() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getDisponibilidadMovilidad() {
		return this.disponibilidadMovilidad;
	}

	public void setDisponibilidadMovilidad(Boolean disponibilidadMovilidad) {
		this.disponibilidadMovilidad = disponibilidadMovilidad;
	}

	public Boolean getDisponibilidadViajar() {
		return this.disponibilidadViajar;
	}

	public void setDisponibilidadViajar(Boolean disponibilidadViajar) {
		this.disponibilidadViajar = disponibilidadViajar;
	}

	public Integer getEstatus() {
		return this.estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	public Integer getIdEscolaridad() {
		return this.idEscolaridad;
	}

	public void setIdEscolaridad(Integer idEscolaridad) {
		this.idEscolaridad = idEscolaridad;
	}

	public Integer getIdExpectativaLaboral() {
		return this.idExpectativaLaboral;
	}

	public void setIdExpectativaLaboral(Integer idExpectativaLaboral) {
		this.idExpectativaLaboral = idExpectativaLaboral;
	}

	public Integer getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

}