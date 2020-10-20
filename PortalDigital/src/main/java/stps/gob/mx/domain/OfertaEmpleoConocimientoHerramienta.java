package stps.gob.mx.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ofertaempleo_conocimientoherramienta database table.
 * 
 */
@Entity
@Table(name="ofertaempleo_conocimientoherramienta", schema="oferta")
//@NamedQuery(name="OfertaempleoConocimientoherramienta.findAll", query="SELECT o FROM OfertaempleoConocimientoherramienta o")
public class OfertaEmpleoConocimientoHerramienta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="anios_experiencia")
	private Integer aniosExperiencia;

	private String certificado;

	private Integer estatus;

	@Column(name="id_conocimientoherramienta")
	private Integer idConocimientoherramienta;

	//bi-directional many-to-one association to Ofertaempleo
	@ManyToOne
	@JoinColumn(name="id_ofertaempleo")
	private OfertaEmpleo ofertaempleo;

	public OfertaEmpleoConocimientoHerramienta() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAniosExperiencia() {
		return this.aniosExperiencia;
	}

	public void setAniosExperiencia(Integer aniosExperiencia) {
		this.aniosExperiencia = aniosExperiencia;
	}

	public String getCertificado() {
		return this.certificado;
	}

	public void setCertificado(String certificado) {
		this.certificado = certificado;
	}

	public Integer getEstatus() {
		return this.estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	public Integer getIdConocimientoherramienta() {
		return this.idConocimientoherramienta;
	}

	public void setIdConocimientoherramienta(Integer idConocimientoherramienta) {
		this.idConocimientoherramienta = idConocimientoherramienta;
	}

	public OfertaEmpleo getOfertaempleo() {
		return this.ofertaempleo;
	}

	public void setOfertaempleo(OfertaEmpleo ofertaempleo) {
		this.ofertaempleo = ofertaempleo;
	}

}