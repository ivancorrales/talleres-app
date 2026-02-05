package es.fplumara.dam1.talleres.service.impl;

import es.fplumara.dam1.talleres.dto.ActualizarUsuarioDTO;
import es.fplumara.dam1.talleres.dto.CrearUsuarioDTO;
import es.fplumara.dam1.talleres.dto.DeleteSummaryDTO;
import es.fplumara.dam1.talleres.exception.BusinessRuleException;
import es.fplumara.dam1.talleres.exception.DatosUsuarioServiceException;
import es.fplumara.dam1.talleres.model.Inscripcion;
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
    public Usuario createUsuario(CrearUsuarioDTO datosNuevoUsuarioDTO) {
        // 1-COMPROBAR NOMBRE INFORMADO
        if (datosNuevoUsuarioDTO.getNombre() == null || datosNuevoUsuarioDTO.getNombre().isEmpty()) {
            throw new BusinessRuleException("Nombre de usuario no reconocido");
        }
        // 2-COMPROBAR EMAIL RECONOCIDO
        if (datosNuevoUsuarioDTO.getEmail() == null || datosNuevoUsuarioDTO.getEmail().isEmpty()) {
            throw new BusinessRuleException("Email de usuario ya existente");
        }
        // 3-COMPROBAR SI EL CURSO FUE ENCONTRADO
        if (datosNuevoUsuarioDTO.getCurso() == null || datosNuevoUsuarioDTO.getCurso().isEmpty()) {
            throw new BusinessRuleException("No puedes pertenecer a otro curso");
        }
        // 4-COMPROBAR USUARIO DE DISCORD
        if (datosNuevoUsuarioDTO.getDiscodUserId() == null || datosNuevoUsuarioDTO.getDiscodUserId().isEmpty()) {
            throw new BusinessRuleException("Usuario de Discord ya existente");
        }

        Usuario newUser = new Usuario(datosNuevoUsuarioDTO.getNombre(),datosNuevoUsuarioDTO.getPerfil(),
                datosNuevoUsuarioDTO.getDiscodUserId(),datosNuevoUsuarioDTO.getCurso(),datosNuevoUsuarioDTO.getEmail());
        Usuario userCreated = UserRepository.save(newUser);

        return userCreated;
    }

    @Override
    public List<Usuario> listarUsuario() {
        return UserRepository.findAll();
    }


    @Override
    public Usuario obtenerUsuario(Long idUsuario) {

        Usuario user = UserRepository.findById(idUsuario);
        if (user == null) {
            throw new DatosUsuarioServiceException("No existe el usuario con el id: " + idUsuario);
        }
        return user;
    }

    @Override
    public Usuario actualizarUsuario(Long idUsuario, Usuario cambiosUsuario, ActualizarUsuarioDTO datosActualizarUsuario) {
        // 1- BUSCAR USUARIO. SI NO ENCUENTRA, NOTFOUNDEXCEPTION
        Usuario userExisted = UserRepository.findById(idUsuario);
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
        Usuario updatedUser = UserRepository.save(cambiosUsuario);

        // 7- DEVOLVEMOS USUARIO ACTUALIZADO
        return updatedUser;
    }

    @Override
    public Usuario eliminarUsuario(Long id) {
        if (!UserRepository.existsById(id)) {
            throw new DatosUsuarioServiceException("No existe el usuario");
        }

        List<Inscripcion> obtenerInscripciones = inscriptionRepository.findByUserId(id);
        obtenerInscripciones.remove(inscriptionRepository.findByUserId(id));
        UserRepository.deleteById(id);

        return new DeleteSummaryDTO();
    }
}
