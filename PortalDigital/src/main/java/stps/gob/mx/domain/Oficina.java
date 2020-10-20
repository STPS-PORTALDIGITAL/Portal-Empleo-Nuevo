package stps.gob.mx.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the oficina database table.
 * 
 */
@Entity
@Table(name="oficina", schema="vinculacion")
//@NamedQuery(name="Oficina.findAll", query="SELECT o FROM Oficina o")
public class Oficina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="correo_electronico")
	private String correoElectronico;

	private String descripcion;

	private String encargado;

	private Integer estatus;

	private String horario;

	@Column(name="id_ubicacion")
	private Integer idUbicacion;

	@Column(name="id_usuario_encargado")
	private Integer idUsuarioEncargado;

	private String oficina;

	private String telefono;

	//bi-directional many-to-one association to Citaatencion
	@OneToMany(mappedBy="oficina")
	private List<CitaAtencion> citaatencions;

	//bi-directional many-to-one association to Disponibilidad
	@OneToMany(mappedBy="oficina")
	private List<Disponibilidad> disponibilidads;

	public Oficina() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCorreoElectronico() {
		return this.correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEncargado() {
		return this.encargado;
	}

	public void setEncargado(String encargado) {
		this.encargado = encargado;
	}

	public Integer getEstatus() {
		return this.estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	public String getHorario() {
		return this.horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public Integer getIdUbicacion() {
		return this.idUbicacion;
	}

	public void setIdUbicacion(Integer idUbicacion) {
		this.idUbicacion = idUbicacion;
	}

	public Integer getIdUsuarioEncargado() {
		return this.idUsuarioEncargado;
	}

	public void setIdUsuarioEncargado(Integer idUsuarioEncargado) {
		this.idUsuarioEncargado = idUsuarioEncargado;
	}

	public String getOficina() {
		return this.oficina;
	}

	public void setOficina(String oficina) {
		this.oficina = oficina;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<CitaAtencion> getCitaatencions() {
		return this.citaatencions;
	}

	public void setCitaatencions(List<CitaAtencion> citaatencions) {
		this.citaatencions = citaatencions;
	}

	public CitaAtencion addCitaatencion(CitaAtencion citaatencion) {
		getCitaatencions().add(citaatencion);
		citaatencion.setOficina(this);

		return citaatencion;
	}

	public CitaAtencion removeCitaatencion(CitaAtencion citaatencion) {
		getCitaatencions().remove(citaatencion);
		citaatencion.setOficina(null);

		return citaatencion;
	}

	public List<Disponibilidad> getDisponibilidads() {
		return this.disponibilidads;
	}

	public void setDisponibilidads(List<Disponibilidad> disponibilidads) {
		this.disponibilidads = disponibilidads;
	}

	public Disponibilidad addDisponibilidad(Disponibilidad disponibilidad) {
		getDisponibilidads().add(disponibilidad);
		disponibilidad.setOficina(this);

		return disponibilidad;
	}

	public Disponibilidad removeDisponibilidad(Disponibilidad disponibilidad) {
		getDisponibilidads().remove(disponibilidad);
		disponibilidad.setOficina(null);

		return disponibilidad;
	}

}