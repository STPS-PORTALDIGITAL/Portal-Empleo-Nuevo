package stps.gob.mx.domain.oferta;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the oferta_tipodiscapacidad database table.
 * 
 */
@Entity
@Table(name="oferta_tipodiscapacidad", schema = "oferta")
@NamedQuery(name="OfertaTipoDiscapacidad.findAll", query="SELECT o FROM OfertaTipoDiscapacidad o")
public class OfertaTipoDiscapacidad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String descripcion;

	//bi-directional many-to-one association to OfertaEmpleo
	@OneToMany(mappedBy="ofertaTipodiscapacidad")
	private Set<OfertaEmpleo> ofertaempleos;

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

	public Set<OfertaEmpleo> getOfertaempleos() {
		return this.ofertaempleos;
	}

	public void setOfertaempleos(Set<OfertaEmpleo> ofertaempleos) {
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