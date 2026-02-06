package es.fplumara.dam1.talleres.repository;

import es.fplumara.dam1.talleres.model.Usuario;

public interface UserRepository {

    Usuario save(Usuario usuario);

    Usuario findById(Long usuarioid);

    Usuario findByEmail(String email);

    Usuario findByDiscordUserId(String discordUserId);

    void deleteById(Long id);


}
