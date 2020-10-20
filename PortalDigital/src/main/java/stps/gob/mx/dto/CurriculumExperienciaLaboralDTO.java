package stps.gob.mx.dto;

public class CurriculumExperienciaLaboralDTO  extends RequestDTO{
	private String id;
	private String id_curriculum;
	private String empresa;
	private String cargo;
	private String descripcion_funciones;
	private String referencia;
	private String fecha_inicio;
	private String fecha_fin;
	private String salarionetomensual;
	private String documentoprobatorio;
	private String estatus;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getId_curriculum() {
		return id_curriculum;
	}
	public void setId_curriculum(String id_curriculum) {
		this.id_curriculum = id_curriculum;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getDescripcion_funciones() {
		return descripcion_funciones;
	}
	public void setDescripcion_funciones(String descripcion_funciones) {
		this.descripcion_funciones = descripcion_funciones;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public String getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public String getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	public String getSalarionetomensual() {
		return salarionetomensual;
	}
	public void setSalarionetomensual(String salarionetomensual) {
		this.salarionetomensual = salarionetomensual;
	}
	public String getDocumentoprobatorio() {
		return documentoprobatorio;
	}
	public void setDocumentoprobatorio(String documentoprobatorio) {
		this.documentoprobatorio = documentoprobatorio;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
	
}
