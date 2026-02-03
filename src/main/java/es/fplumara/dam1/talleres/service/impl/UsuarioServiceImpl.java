package es.fplumara.dam1.talleres.service.impl;

<<<<<<< HEAD
public class UsuarioServiceImpl {
=======
import es.fplumara.dam1.talleres.dto.CrearUsuarioDTO;
import es.fplumara.dam1.talleres.model.Usuario;
import es.fplumara.dam1.talleres.repository.InscripcionRepository;
import es.fplumara.dam1.talleres.repository.UserRepository;
import es.fplumara.dam1.talleres.service.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService {

    private UserRepository usuarioRepository;
    private InscripcionRepository inscripcionRepository;

    public UsuarioServiceImpl(UserRepository usuarioRepository, InscripcionRepository inscripcionRepository) {
        this.usuarioRepository = usuarioRepository;
        this.inscripcionRepository = inscripcionRepository;
    }

    @Override
    public Usuario crearUsuario(CrearUsuarioDTO crearUsuarioDTO) {
      if (crearUsuarioDTO.getNombre() == null || crearUsuarioDTO.getNombre().isEmpty()) {
          throw new BusinessRuleExcepction("El nombre no esta informado");
      }
      if ()
    }
>>>>>>> 142ea6a (Avance-Implementaciones-DTOs)

}
