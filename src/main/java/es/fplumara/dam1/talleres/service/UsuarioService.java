package es.fplumara.dam1.talleres.service;


import es.fplumara.dam1.talleres.model.Usuario;
import es.fplumara.dam1.talleres.model.Usuario;
import java.util.List;

public interface UsuarioService {

    Usuario createUsuario(Usuario CrearUsuario);

    List<Usuario> listarusuario();

   Usuario obtenerUsuario(Long id);

   Usuario actualizarUsuario(Long id, Usuario cambiosUsuario);

   Usuario eliminarUsuario(Long id);


}


