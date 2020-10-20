package stps.gob.mx.dto;

public class CurriculumEscolaridadDTO  extends RequestDTO{
	  private String id;
	  private String id_curriculum;
	  private String empresa;
	  private String cargo;
	  private String descripcionFunciones;
	  private String referencia;
	  private String fechaInicio;
	  private String fechaFin;
	  private String salarioNetoMensual;
	  private String documentoProbatorio;
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
	public String getDescripcionFunciones() {
		return descripcionFunciones;
	}
	public void setDescripcionFunciones(String descripcionFunciones) {
		this.descripcionFunciones = descripcionFunciones;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getSalarioNetoMensual() {
		return salarioNetoMensual;
	}
	public void setSalarioNetoMensual(String salarioNetoMensual) {
		this.salarioNetoMensual = salarioNetoMensual;
	}
	public String getDocumentoProbatorio() {
		return documentoProbatorio;
	}
	public void setDocumentoProbatorio(String documentoProbatorio) {
		this.documentoProbatorio = documentoProbatorio;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	  
	  
	  
}
