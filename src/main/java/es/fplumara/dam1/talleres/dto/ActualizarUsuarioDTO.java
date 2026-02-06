package es.fplumara.dam1.talleres.dto;

import java.util.Optional;

public class ActualizarUsuarioDTO {

    private Optional<String> nombre;
    private Optional<String> discordUserId;
    private Optional<String> email;
    private Optional<String> curso;

    public Optional<String> getNombre() {
        return nombre;
    }

    public void setNombre(Optional<String> nombre) {
        this.nombre = nombre;
    }

    public Optional<String> getDiscordUserId() {
        return discordUserId;
    }

    public void setDiscordUserId(Optional<String> discordUserId) {
        this.discordUserId = discordUserId;
    }

    public Optional<String> getEmail() {
        return email;
    }

    public void setEmail(Optional<String> email) {
        this.email = email;
    }

    public Optional<String> getCurso() {
        return curso;
    }

    public void setCurso(Optional<String> curso) {
        this.curso = curso;
    }
}
