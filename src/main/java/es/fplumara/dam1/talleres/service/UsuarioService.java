package es.fplumara.dam1.talleres.service;


import es.fplumara.dam1.talleres.dto.ActualizarUsuarioDTO;
import es.fplumara.dam1.talleres.dto.CrearUsuarioDTO;
import es.fplumara.dam1.talleres.dto.DeleteSummaryDTO;
import es.fplumara.dam1.talleres.model.Usuario;
import java.util.List;

public interface UsuarioService {



    Usuario createUsuario(CrearUsuarioDTO datosUsuarioDTO);

    List<Usuario> listarUsuario();

    Usuario obtenerUsuario(Long idUsuario);

    Usuario actualizarUsuario(Long idUsuario, Usuario cambiosUsuario, ActualizarUsuarioDTO datosActualizarUsuario);

    DeleteSummaryDTO eliminarUsuario(Long id);

}


