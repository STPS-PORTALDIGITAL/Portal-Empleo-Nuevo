package stps.gob.mx.dto;

public class CandidatoDTO {
	private String id;
	private String context;
	private String type;
	private String name;
	private String datePublished;//publicado hace 3 días
	private String description;
	private String prepTime;
	private String titulo;
	private String ubicacion;
	private String salarioMensualNeto;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDatePublished() {
		return datePublished;
	}
	public void setDatePublished(String datePublished) {
		this.datePublished = datePublished;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrepTime() {
		return prepTime;
	}
	public void setPrepTime(String prepTime) {
		this.prepTime = prepTime;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public String getSalarioMensualNeto() {
		return salarioMensualNeto;
	}
	public void setSalarioMensualNeto(String salarioMensualNeto) {
		this.salarioMensualNeto = salarioMensualNeto;
	}

	
}
