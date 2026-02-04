package es.fplumara.dam1.talleres.service;

<<<<<<< HEAD

import es.fplumara.dam1.talleres.model.Usuario;
import es.fplumara.dam1.talleres.model.Usuario;
import java.util.List;

public interface UsuarioService {

    Usuario createUsuario(Usuario CrearUsuario);

    List<Usuario> listarusuario();

   Usuario obtenerUsuario(Long id);

   Usuario actualizarUsuario(Long id, Usuario cambiosUsuario);

   Usuario eliminarUsuario(Long id);


=======
import es.fplumara.dam1.talleres.dto.CrearUsuarioDTO;
import es.fplumara.dam1.talleres.model.Usuario;

public interface UsuarioService {
    Usuario crearUsuario(CrearUsuarioDTO crearUsuarioDTO);
>>>>>>> 142ea6a (Avance-Implementaciones-DTOs)
}


