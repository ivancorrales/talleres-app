package es.fplumara.dam1.talleres.service;


import es.fplumara.dam1.talleres.dto.CrearUsuarioDTO;
import es.fplumara.dam1.talleres.model.Usuario;
import java.util.List;

public interface UsuarioService {



    Usuario createUsuario(CrearUsuarioDTO datosUsuarioDTO);

    List<Usuario> listarusuario();

   Usuario obtenerUsuario(Long id);

   Usuario actualizarUsuario(Long id, Usuario cambiosUsuario);

   Usuario eliminarUsuario(Long id);

}


