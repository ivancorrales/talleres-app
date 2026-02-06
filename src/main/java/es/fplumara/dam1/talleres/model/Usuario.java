package es.fplumara.dam1.talleres.model;

/**
 * - **id**
 *
 *     Identificador interno único del usuario.
 *
 * - **nombre**
 *
 *     Nombre visible del usuario dentro del sistema.
 *
 * - **perfil**
 *
 *     Determina el perfil global del usuario: (PROFESOR, ALUMNO, INVITADO)
 *
 * - **discordUserId** (opcional)
 *
 *     Identificador único del usuario en Discord. Permite futuras integraciones con bots.
 *
 * - **curso** (opcional)
 *
 *     Si es un alumno indica en que curso se encuentra estudiando
 *
 * - **email** (opcional)
 *
 *     Correo electrónico del usuario
 */

public class Usuario {

    private Long id;

    private Perfil perfil;

    private String discordUserId;

    private String curso;

    private String email;

    public Usuario(Long id, Perfil perfil, String discordUserId, String curso, String email) {
        this.id = id;
        this.perfil = perfil;
        this.discordUserId = discordUserId;
        this.curso = curso;
        this.email = email;
    }

    public Usuario(Perfil perfil, String discordUserId, String curso, String email) {
        this.perfil = perfil;
        this.discordUserId = discordUserId;
        this.curso = curso;
        this.email = email;
    }

    public Usuario(String nombre, Perfil perfil, String discodUserId, String curso, String email) {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public String getDiscordUserId() {
        return discordUserId;
    }

    public void setDiscordUserId(String discordUserId) {
        this.discordUserId = discordUserId;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
