package stps.gob.mx.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the oferta_tipodiscapacidad database table.
 * 
 */
@Entity
@Table(name="oferta_tipodiscapacidad", schema="oferta")
//@NamedQuery(name="OfertaTipodiscapacidad.findAll", query="SELECT o FROM OfertaTipodiscapacidad o")
public class OfertaTipoDiscapacidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String descripcion;

	private Integer estatus;

	//bi-directional many-to-one association to Ofertaempleo
	@OneToMany(mappedBy="ofertaTipodiscapacidad")
	private List<OfertaEmpleo> ofertaempleos;

	public OfertaTipoDiscapacidad() {
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

	public List<OfertaEmpleo> getOfertaempleos() {
		return this.ofertaempleos;
	}

	public void setOfertaempleos(List<OfertaEmpleo> ofertaempleos) {
		this.ofertaempleos = ofertaempleos;
	}

	public OfertaEmpleo addOfertaempleo(OfertaEmpleo ofertaempleo) {
		getOfertaempleos().add(ofertaempleo);
		ofertaempleo.setOfertaTipodiscapacidad(this);

		return ofertaempleo;
	}

	public OfertaEmpleo removeOfertaempleo(OfertaEmpleo ofertaempleo) {
		getOfertaempleos().remove(ofertaempleo);
		ofertaempleo.setOfertaTipodiscapacidad(null);

		return ofertaempleo;
	}

}