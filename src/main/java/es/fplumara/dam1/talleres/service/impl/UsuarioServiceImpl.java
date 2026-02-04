package es.fplumara.dam1.talleres.service.impl;

import es.fplumara.dam1.talleres.model.Usuario;
import es.fplumara.dam1.talleres.repository.TallerRepository;
import es.fplumara.dam1.talleres.repository.UserRepository;
import es.fplumara.dam1.talleres.service.UsuarioService;

import java.util.List;

public class UsuarioServiceImpl implements UsuarioService {


    private UserRepository UserRepository;

    public UsuarioServiceImpl(UserRepository userRepository) {
        UserRepository = userRepository;
    }

    @Override
    public Usuario createUsuario(Usuario CrearUsuario) {
        return null;
    }

    @Override
    public List<Usuario> listarusuario() {
        return List.of();
    }

    @Override
    public Usuario obtenerUsuario(Long id) {
        return null;
    }

    @Override
    public Usuario actualizarUsuario(Long id, Usuario cambiosUsuario) {
        return null;
    }

    @Override
    public Usuario eliminarUsuario(Long id) {
        return null;
    }
}
