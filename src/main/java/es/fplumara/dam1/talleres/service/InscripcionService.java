package es.fplumara.dam1.talleres.service;

import es.fplumara.dam1.talleres.model.Inscripcion;

import java.util.List;

public interface InscripcionService {

<<<<<<< HEAD
    Inscripcion inscribirUsuario(Long tallerid, Long usuarioid, String rol);

    Inscripcion cambiarRol (Long tallerid, Long usuarioid, String nuevoRol);

    Inscripcion expulsarUsuario (Long tallerid, Long usuarioid);

    List<Inscripcion> listarInscripcionesDETaller (Long tallerid);

    List<Inscripcion> listarInscripcionesDeUsuario (Long Usuarioid);

    Inscripcion verMiembrosAgrupadosPorPerfil (Long tallerid);

    Inscripcion verResponsables(Long tallerid);




=======
>>>>>>> 142ea6a (Avance-Implementaciones-DTOs)
}
