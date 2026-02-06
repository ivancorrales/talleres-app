package es.fplumara.dam1.talleres.service.impl;

import es.fplumara.dam1.talleres.dto.ActualizarUsuarioDTO;
import es.fplumara.dam1.talleres.dto.CrearUsuarioDTO;
import es.fplumara.dam1.talleres.dto.DeleteSummaryDTO;
import es.fplumara.dam1.talleres.exception.BusinessRuleException;
import es.fplumara.dam1.talleres.exception.DatosEliminarUsuarioServiceException;
import es.fplumara.dam1.talleres.exception.DatosUsuarioServiceException;
import es.fplumara.dam1.talleres.model.Inscripcion;
import es.fplumara.dam1.talleres.model.Perfil;
import es.fplumara.dam1.talleres.model.Usuario;
import es.fplumara.dam1.talleres.repository.InscripcionRepository;
import es.fplumara.dam1.talleres.repository.UserRepository;
import es.fplumara.dam1.talleres.service.UsuarioService;

import java.util.List;
import java.util.Map;

public class UsuarioServiceImpl implements UsuarioService {

    private UserRepository userRepository;
    private InscripcionRepository inscripcionRepository;

    public UsuarioServiceImpl(UserRepository userRepository,  InscripcionRepository inscriptionRepository) {
        this.userRepository = userRepository;
        this.inscripcionRepository = inscriptionRepository;
    }

    @Override
    public Usuario createUsuario(CrearUsuarioDTO datosNuevoUsuarioDTO) {
        // 1-COMPROBAR NOMBRE INFORMADO
        if (datosNuevoUsuarioDTO.getNombre() == null || datosNuevoUsuarioDTO.getNombre().isEmpty()) {
            throw new BusinessRuleException("Nombre de usuario no reconocido");
        }
        // 2-COMPROBAR EL CURSO FUE ENCONTRADO
        if (datosNuevoUsuarioDTO.getCurso() != null && !datosNuevoUsuarioDTO.getPerfil().equals(Perfil.ALUMNO)) {
            throw new BusinessRuleException("No puedes pertenecer a otro curso");
        }
        // 3-COMPROBAR EL EMAIL ESTA INFORMADO
        if (datosNuevoUsuarioDTO.getEmail() != null) {
            Usuario usuario = userRepository.findByEmail(datosNuevoUsuarioDTO.getEmail());
            if (usuario != null) {
                throw new BusinessRuleException("Ya existe un usuario con el email");
            }

        }
        // 4-COMPROBAR USUARIO DE DISCORD
        if (datosNuevoUsuarioDTO.getDiscodUserId() != null) {
            Usuario user = userRepository.findByDiscordUserId(datosNuevoUsuarioDTO.getDiscodUserId());
            if  (user != null) {
                throw new BusinessRuleException("Usuario de Discord ya existente");
            }

        }

        Usuario newUser = new Usuario(datosNuevoUsuarioDTO.getNombre(),datosNuevoUsuarioDTO.getPerfil(),
                datosNuevoUsuarioDTO.getDiscodUserId(),datosNuevoUsuarioDTO.getCurso(),datosNuevoUsuarioDTO.getEmail());
        Usuario userCreated = userRepository.save(newUser);

        return userCreated;
    }

    @Override
    public List<Usuario> listarUsuario() {
        return userRepository.findAll();
    }


    @Override
    public Usuario obtenerUsuario(Long idUsuario) {

        Usuario user = userRepository.findById(idUsuario);
        if (user == null) {
            throw new DatosUsuarioServiceException("No existe el usuario con el id: " + idUsuario);
        }
        return user;
    }

    @Override
    public Usuario actualizarUsuario(Long idUsuario, Usuario cambiosUsuario, ActualizarUsuarioDTO datosActualizarUsuario) {
        // 1- BUSCAR USUARIO. SI NO ENCUENTRA, NOTFOUNDEXCEPTION
        Usuario userExisted = userRepository.findById(idUsuario);
        if (userExisted == null) {
            throw new DatosUsuarioServiceException("No existe el usuario con el id: " + idUsuario);
        }
        // 2- APLICAR CAMBIOS EN DTO
        // 3- SI CAMBIA CURSO O PERFIL (EN ESTE CASO, CURSO)
        if (datosActualizarUsuario.getCurso() == null || datosActualizarUsuario.getCurso().isEmpty()) {
            throw new BusinessRuleException("No puedes pertenecer a otro curso con este perfil");
        }
        // 4- SI CAMBIA EMAIL
        if (datosActualizarUsuario.getEmail() != null && !datosActualizarUsuario.getEmail().isEmpty()) {
            throw new BusinessRuleException("Email de usuario duplicado");
        }
        // 5- SI CAMBIA DATOS DEL USUARIO DISCORD
        if (datosActualizarUsuario.getDiscordUserId() != null && !datosActualizarUsuario.getDiscordUserId().isEmpty()) {
            throw new BusinessRuleException("Usuario de Discord duplicado");
        }
        // 6- GUARDAMOS USUARIO CON UserRepository.save
        Usuario updatedUser = userRepository.save(cambiosUsuario);

        // 7- DEVOLVEMOS USUARIO ACTUALIZADO
        return updatedUser;
    }

    @Override
    public DeleteSummaryDTO eliminarUsuario(Long idUsuario) {
        Usuario user = userRepository.findById(idUsuario);
        if  (user == null) {
            throw new DatosEliminarUsuarioServiceException("El usuario no fue encontrado");
        }

        List<Inscripcion> inscripcions = inscripcionRepository.findByUserId(idUsuario);
        for (Inscripcion inscripcion : inscripcions) {
            inscripcionRepository.deleteById(inscripcion.getId());
        }

        userRepository.deleteById(idUsuario.intValue());

        return new DeleteSummaryDTO(inscripcions.size());
    }
}
