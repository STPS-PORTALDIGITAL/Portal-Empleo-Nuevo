package stps.gob.mx.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ofertaempleo_habilidadcompetencia database table.
 * 
 */
@Entity
@Table(name="ofertaempleo_habilidadcompetencia", schema="oferta")
//@NamedQuery(name="OfertaempleoHabilidadcompetencia.findAll", query="SELECT o FROM OfertaempleoHabilidadcompetencia o")
public class OfertaEmpleoHabilidadCompetencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String certificado;

	private Integer estatus;

	@Column(name="id_habilidadcompetencia")
	private Integer idHabilidadcompetencia;

	//bi-directional many-to-one association to Ofertaempleo
	@ManyToOne
	@JoinColumn(name="id_ofertaempleo")
	private OfertaEmpleo ofertaempleo;

	public OfertaEmpleoHabilidadCompetencia() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getIdHabilidadcompetencia() {
		return this.idHabilidadcompetencia;
	}

	public void setIdHabilidadcompetencia(Integer idHabilidadcompetencia) {
		this.idHabilidadcompetencia = idHabilidadcompetencia;
	}

	public OfertaEmpleo getOfertaempleo() {
		return this.ofertaempleo;
	}

	public void setOfertaempleo(OfertaEmpleo ofertaempleo) {
		this.ofertaempleo = ofertaempleo;
	}

}