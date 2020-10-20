package stps.gob.mx.dto;

public class ImagenStandDTO extends RequestDTO {
	private String idImagenStand;
	private String ruta;
	private String videoImagen;
	private String tipo;
	
	
	public String getIdImagenStand() {
		return idImagenStand;
	}
	public void setIdImagenStand(String idImagenStand) {
		this.idImagenStand = idImagenStand;
	}
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	public String getVideoImagen() {
		return videoImagen;
	}
	public void setVideoImagen(String videoImagen) {
		this.videoImagen = videoImagen;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
