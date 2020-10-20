package stps.gob.mx.dto;

public class CatalogoRechazosDTO extends RequestDTO {
	private String idFeriaEmpleo;
	private String razonRechazo;
	
	
	
	public String getIdFeriaEmpleo() {
		return idFeriaEmpleo;
	}
	public void setIdFeriaEmpleo(String idFeriaEmpleo) {
		this.idFeriaEmpleo = idFeriaEmpleo;
	}
	public String getRazonRechazo() {
		return razonRechazo;
	}
	public void setRazonRechazo(String razonRechazo) {
		this.razonRechazo = razonRechazo;
	}
	
	
}
