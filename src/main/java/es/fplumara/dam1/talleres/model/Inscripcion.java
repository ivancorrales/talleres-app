package es.fplumara.dam1.talleres.model;

import java.time.LocalDate;

public class Inscripcion {
    private String id;
    private Long tallerId;
    private Long usuarioId;
    private String rol;
    private LocalDate fechaIncripcion;

    public Inscripcion(Long tallerId, Long usuarioId, String rol, LocalDate fechaIncripcion) {
        this.id = tallerId.toString()+"/"+usuarioId.toString();
        this.tallerId = tallerId;
        this.usuarioId = usuarioId;
        this.rol = rol;
        this.fechaIncripcion = fechaIncripcion;
    }


    public Long getId() {
        return id;
    }

    public void setId(long contarId) {
        this.id = id;
    }

    public Long getTallerId() {
        return tallerId;
    }

    public void setTallerId(Long tallerId) {
        this.tallerId = tallerId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public LocalDate getFechaIncripcion() {
        return fechaIncripcion;
    }

    public void setFechaIncripcion(LocalDate fechaIncripcion) {
        this.fechaIncripcion = fechaIncripcion;
    }
}
