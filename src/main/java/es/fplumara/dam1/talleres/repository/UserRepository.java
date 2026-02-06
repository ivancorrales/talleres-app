package es.fplumara.dam1.talleres.repository;

import es.fplumara.dam1.talleres.model.Usuario;

import java.util.List;

public interface UserRepository {

    Usuario save(Usuario usuario);

    Usuario findById(Long usuarioid);

    Usuario findByEmail(String email);

    Usuario findByDiscordUserId(String discordUserId);

    void deleteById(Long id);

    List<Usuario> findAll();

    boolean existsById(Long id);
}
