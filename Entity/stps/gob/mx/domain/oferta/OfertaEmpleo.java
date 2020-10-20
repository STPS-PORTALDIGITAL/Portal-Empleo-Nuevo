package stps.gob.mx.domain.oferta;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the ofertaempleo database table.
 * 
 */
@Entity
@NamedQuery(name="OfertaEmpleo.findAll", query="SELECT o FROM OfertaEmpleo o")
@Table(name = "ofertaempleo", schema = "oferta")
public class OfertaEmpleo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name="acepta_persona_discapacitada")
	private Boolean aceptaPersonaDiscapacitada;

	@Column(name="anyos_experiencia")
	private Integer anyosExperiencia;

	private String areanegocio;

	private String diaslaborables;

	@Column(name="disponibilidad_movilidad")
	private Boolean disponibilidadMovilidad;

	@Column(name="disponibilidad_viajar")
	private Boolean disponibilidadViajar;

	private Integer estatus;

	private String horario;

	@Column(name="id_niveleducativo")
	private Integer idNiveleducativo;

	@Column(name="id_tipoatencionpreferencial")
	private Integer idTipoatencionpreferencial;

	@Column(name="id_ubicacion")
	private Integer idUbicacion;

	private Integer limitepostulaciones;

	private String puesto;

	@Column(name="rolar_turnos")
	private Boolean rolarTurnos;

	private BigDecimal salariomensualofertado;

	@Column(name="vacante_dela_osne")
	private Boolean vacanteDelaOsne;

	private Integer vacantesdisponibles;

	@Temporal(TemporalType.DATE)
	private Date vigencia;

	//bi-directional many-to-one association to Empleador
	@ManyToOne
	@JoinColumn(name="id_empleador")
	private Empleador empleador;

	//bi-directional many-to-one association to OfertaTipoDiscapacidad
	@ManyToOne
	@JoinColumn(name="id_oferta_tipodiscapacidad")
	private OfertaTipoDiscapacidad ofertaTipodiscapacidad;

	//bi-directional many-to-one association to OfertaEmpleoConocimientoHerramienta
	@OneToMany(mappedBy="ofertaempleo")
	private Set<OfertaEmpleoConocimientoHerramienta> ofertaempleoConocimientoherramientas;

	//bi-directional many-to-one association to OfertaEmpleoHabilidadCompetencia
	@OneToMany(mappedBy="ofertaempleo")
	private Set<OfertaEmpleoHabilidadCompetencia> ofertaempleoHabilidadcompetencias;

	public OfertaEmpleo() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getAceptaPersonaDiscapacitada() {
		return this.aceptaPersonaDiscapacitada;
	}

	public void setAceptaPersonaDiscapacitada(Boolean aceptaPersonaDiscapacitada) {
		this.aceptaPersonaDiscapacitada = aceptaPersonaDiscapacitada;
	}

	public Integer getAnyosExperiencia() {
		return this.anyosExperiencia;
	}

	public void setAnyosExperiencia(Integer anyosExperiencia) {
		this.anyosExperiencia = anyosExperiencia;
	}

	public String getAreanegocio() {
		return this.areanegocio;
	}

	public void setAreanegocio(String areanegocio) {
		this.areanegocio = areanegocio;
	}

	public String getDiaslaborables() {
		return this.diaslaborables;
	}

	public void setDiaslaborables(String diaslaborables) {
		this.diaslaborables = diaslaborables;
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

	public String getHorario() {
		return this.horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public Integer getIdNiveleducativo() {
		return this.idNiveleducativo;
	}

	public void setIdNiveleducativo(Integer idNiveleducativo) {
		this.idNiveleducativo = idNiveleducativo;
	}

	public Integer getIdTipoatencionpreferencial() {
		return this.idTipoatencionpreferencial;
	}

	public void setIdTipoatencionpreferencial(Integer idTipoatencionpreferencial) {
		this.idTipoatencionpreferencial = idTipoatencionpreferencial;
	}

	public Integer getIdUbicacion() {
		return this.idUbicacion;
	}

	public void setIdUbicacion(Integer idUbicacion) {
		this.idUbicacion = idUbicacion;
	}

	public Integer getLimitepostulaciones() {
		return this.limitepostulaciones;
	}

	public void setLimitepostulaciones(Integer limitepostulaciones) {
		this.limitepostulaciones = limitepostulaciones;
	}

	public String getPuesto() {
		return this.puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public Boolean getRolarTurnos() {
		return this.rolarTurnos;
	}

	public void setRolarTurnos(Boolean rolarTurnos) {
		this.rolarTurnos = rolarTurnos;
	}

	public BigDecimal getSalariomensualofertado() {
		return this.salariomensualofertado;
	}

	public void setSalariomensualofertado(BigDecimal salariomensualofertado) {
		this.salariomensualofertado = salariomensualofertado;
	}

	public Boolean getVacanteDelaOsne() {
		return this.vacanteDelaOsne;
	}

	public void setVacanteDelaOsne(Boolean vacanteDelaOsne) {
		this.vacanteDelaOsne = vacanteDelaOsne;
	}

	public Integer getVacantesdisponibles() {
		return this.vacantesdisponibles;
	}

	public void setVacantesdisponibles(Integer vacantesdisponibles) {
		this.vacantesdisponibles = vacantesdisponibles;
	}

	public Date getVigencia() {
		return this.vigencia;
	}

	public void setVigencia(Date vigencia) {
		this.vigencia = vigencia;
	}

	public Empleador getEmpleador() {
		return this.empleador;
	}

	public void setEmpleador(Empleador empleador) {
		this.empleador = empleador;
	}

	public OfertaTipoDiscapacidad getOfertaTipodiscapacidad() {
		return this.ofertaTipodiscapacidad;
	}

	public void setOfertaTipodiscapacidad(OfertaTipoDiscapacidad ofertaTipodiscapacidad) {
		this.ofertaTipodiscapacidad = ofertaTipodiscapacidad;
	}

	public Set<OfertaEmpleoConocimientoHerramienta> getOfertaempleoConocimientoherramientas() {
		return this.ofertaempleoConocimientoherramientas;
	}

	public void setOfertaempleoConocimientoherramientas(Set<OfertaEmpleoConocimientoHerramienta> ofertaempleoConocimientoherramientas) {
		this.ofertaempleoConocimientoherramientas = ofertaempleoConocimientoherramientas;
	}

	public OfertaEmpleoConocimientoHerramienta addOfertaempleoConocimientoherramienta(OfertaEmpleoConocimientoHerramienta ofertaempleoConocimientoherramienta) {
		getOfertaempleoConocimientoherramientas().add(ofertaempleoConocimientoherramienta);
		ofertaempleoConocimientoherramienta.setOfertaempleo(this);

		return ofertaempleoConocimientoherramienta;
	}

	public OfertaEmpleoConocimientoHerramienta removeOfertaempleoConocimientoherramienta(OfertaEmpleoConocimientoHerramienta ofertaempleoConocimientoherramienta) {
		getOfertaempleoConocimientoherramientas().remove(ofertaempleoConocimientoherramienta);
		ofertaempleoConocimientoherramienta.setOfertaempleo(null);

		return ofertaempleoConocimientoherramienta;
	}

	public Set<OfertaEmpleoHabilidadCompetencia> getOfertaempleoHabilidadcompetencias() {
		return this.ofertaempleoHabilidadcompetencias;
	}

	public void setOfertaempleoHabilidadcompetencias(Set<OfertaEmpleoHabilidadCompetencia> ofertaempleoHabilidadcompetencias) {
		this.ofertaempleoHabilidadcompetencias = ofertaempleoHabilidadcompetencias;
	}

	public OfertaEmpleoHabilidadCompetencia addOfertaempleoHabilidadcompetencia(OfertaEmpleoHabilidadCompetencia ofertaempleoHabilidadcompetencia) {
		getOfertaempleoHabilidadcompetencias().add(ofertaempleoHabilidadcompetencia);
		ofertaempleoHabilidadcompetencia.setOfertaempleo(this);

		return ofertaempleoHabilidadcompetencia;
	}

	public OfertaEmpleoHabilidadCompetencia removeOfertaempleoHabilidadcompetencia(OfertaEmpleoHabilidadCompetencia ofertaempleoHabilidadcompetencia) {
		getOfertaempleoHabilidadcompetencias().remove(ofertaempleoHabilidadcompetencia);
		ofertaempleoHabilidadcompetencia.setOfertaempleo(null);

		return ofertaempleoHabilidadcompetencia;
	}

}