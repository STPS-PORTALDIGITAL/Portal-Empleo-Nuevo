package stps.gob.mx.dto;

public class CurriculumOtrosEstudiosDTO  extends RequestDTO{
private String id;
private String id_curriculum;
private String descripcion;
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
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
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
