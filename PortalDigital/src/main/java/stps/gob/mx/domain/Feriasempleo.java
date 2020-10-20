package stps.gob.mx.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name="feriasempleo", schema = "feria")
@NamedQuery(name="Feriasempleo.findAll", query="SELECT f FROM Feriasempleo f")
public class Feriasempleo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(unique=true, nullable=false)
    private Long id;

    @Column(length=2147483647)
    private String comentario;

    @Column(name="config_empleadores_participantes")
    private Integer configEmpleadoresParticipantes;

    @Column(name="created_at")
    private Timestamp createdAt;

    @Column(name="deleted_at")
    private Timestamp deletedAt;

    @Column(length=128)
    private String direccion;

    @Column(nullable=false)
    private Integer estatus;

    @Column(name="fecha_fin")
    private Timestamp fechaFin;

    @Column(name="fecha_ini")
    private Timestamp fechaIni;

    @Column(name="id_entidad", nullable=false)
    private Long idEntidad;

    @Column(name="id_ubicacion", nullable=false)
    private Long idUbicacion;

    @Column(name="motivos_rechazo")
    private String motivosRechazo;

    @Column(nullable=false, length=64)
    private String titulo;

    @Column(name="updated_at")
    private Timestamp updatedAt;

    @Column(name="user_create", length=32)
    private String userCreate;

    @Column(name="user_upddel", length=32)
    private String userUpddel;

    public Feriasempleo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Integer getConfigEmpleadoresParticipantes() {
        return configEmpleadoresParticipantes;
    }

    public void setConfigEmpleadoresParticipantes(Integer configEmpleadoresParticipantes) {
        this.configEmpleadoresParticipantes = configEmpleadoresParticipantes;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Timestamp deletedAt) {
        this.deletedAt = deletedAt;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getEstatus() {
        return estatus;
    }

    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
    }

    public Timestamp getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Timestamp fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Timestamp getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(Timestamp fechaIni) {
        this.fechaIni = fechaIni;
    }

    public Long getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(Long idEntidad) {
        this.idEntidad = idEntidad;
    }

    public Long getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(Long idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public String getMotivosRechazo() {
        return motivosRechazo;
    }

    public void setMotivosRechazo(String motivosRechazo) {
        this.motivosRechazo = motivosRechazo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUserCreate() {
        return userCreate;
    }

    public void setUserCreate(String userCreate) {
        this.userCreate = userCreate;
    }

    public String getUserUpddel() {
        return userUpddel;
    }

    public void setUserUpddel(String userUpddel) {
        this.userUpddel = userUpddel;
    }

    @Override
    public String toString() {
        return "Feriasempleo{" +
                "\nid=" + id +
                ", comentario='" + comentario + '\'' +
                ", configEmpleadoresParticipantes=" + configEmpleadoresParticipantes +
                "\n, createdAt=" + createdAt +
                ", deletedAt=" + deletedAt +
                ", direccion='" + direccion + '\'' +
                "\n, estatus=" + estatus +
                ", fechaFin=" + fechaFin +
                ", fechaIni=" + fechaIni +
                "\n, idEntidad=" + idEntidad +
                ", idUbicacion=" + idUbicacion +
                ", motivosRechazo='" + motivosRechazo + '\'' +
                "\n, titulo='" + titulo + '\'' +
                ", updatedAt=" + updatedAt +
                ", userCreate='" + userCreate + '\'' +
                "\n, userUpddel='" + userUpddel + '\'' +
                '}';
    }
}
