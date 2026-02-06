package es.fplumara.dam1.talleres.repository.impl;

import es.fplumara.dam1.talleres.repository.UserRepository;
import es.fplumara.dam1.talleres.model.Usuario;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryUserRepository implements UserRepository {
    private Long contador =0L;
    private Map<Long, Usuario> usuarios;

    public InMemoryUserRepository() {
        usuarios = new HashMap<Long, Usuario>();
    }

    @Override
    public Usuario save(Usuario usuario) {
        if(usuario.getId()==null) {
            usuario.setId(contador);
            contador++;
        }
        usuarios.put(usuario.getId(), usuario);
        return usuario;
    }

    @Override
    public Usuario findById(Long id) {
        return usuarios.get(id);
    }

    @Override
    public Usuario findByEmail(String email) {
        // Recorre todos los usuarios del mapa
        for(Usuario usuario : usuarios.values()){
           if(usuario.getEmail().equals(email)){
               return usuario;
           }
       }
       return null;
    }

    @Override
    public Usuario findByDiscordUserId(String discordUserId) {
        // Recorre todos los usuarios del mapa
        for(Usuario usuario : usuarios.values()){
            if(usuario.getDiscordUserId().equals(discordUserId)){
                return usuario;
            }
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        usuarios.remove(id);
    }

    @Override
    public List<Usuario> findAll() {
        return List.of();
    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }

}
