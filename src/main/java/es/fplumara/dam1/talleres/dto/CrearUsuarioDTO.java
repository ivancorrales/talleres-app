package es.fplumara.dam1.talleres.dto;

import es.fplumara.dam1.talleres.model.Perfil;

public class CrearUsuarioDTO {

    private Integer id;
    private String nombre;
    private String discodUserId;
    private String email;
    private String curso;
    private Perfil perfil;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDiscodUserId() {
        return discodUserId;
    }

    public void setDiscodUserId(String discodUserId) {
        this.discodUserId = discodUserId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
}
