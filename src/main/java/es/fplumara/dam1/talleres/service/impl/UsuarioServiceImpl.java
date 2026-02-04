package es.fplumara.dam1.talleres.service.impl;

import es.fplumara.dam1.talleres.dto.CrearUsuarioDTO;
import es.fplumara.dam1.talleres.model.Usuario;
import es.fplumara.dam1.talleres.repository.InscripcionRepository;
import es.fplumara.dam1.talleres.repository.UserRepository;
import es.fplumara.dam1.talleres.service.UsuarioService;

import java.util.List;

public class UsuarioServiceImpl implements UsuarioService {

    private UserRepository UserRepository;
    private InscripcionRepository inscriptionRepository;

    public UsuarioServiceImpl(UserRepository userRepository,  InscripcionRepository inscriptionRepository) {
        this.UserRepository = userRepository;
        this.inscriptionRepository = inscriptionRepository;
    }

    @Override
    public Usuario createUsuario(CrearUsuarioDTO datosUsuarioDTO) {
        // 1-COMPROBAR NOMBRE INFORMADO
        if (datosUsuarioDTO.getNombre() == null || datosUsuarioDTO.getNombre().isEmpty()) {

        }

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
