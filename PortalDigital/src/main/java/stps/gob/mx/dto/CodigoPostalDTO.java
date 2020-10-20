package stps.gob.mx.dto;



public class CodigoPostalDTO  extends RequestDTO{
	private String id;
	private String idEntidad;
	private String idMunicipio;
	private String idColonia;
	private String codigoPostal;
	private String zipPlus;
	private String estatus;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdEntidad() {
		return idEntidad;
	}
	public void setIdEntidad(String idEntidad) {
		this.idEntidad = idEntidad;
	}
	public String getIdMunicipio() {
		return idMunicipio;
	}
	public void setIdMunicipio(String idMunicipio) {
		this.idMunicipio = idMunicipio;
	}
	public String getIdColonia() {
		return idColonia;
	}
	public void setIdColonia(String idColonia) {
		this.idColonia = idColonia;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getZipPlus() {
		return zipPlus;
	}
	public void setZipPlus(String zipPlus) {
		this.zipPlus = zipPlus;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
	
	
}
