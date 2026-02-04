package es.fplumara.dam1.talleres.service;

import es.fplumara.dam1.talleres.model.Inscripcion;

import java.util.List;

public interface InscripcionService {

    Inscripcion inscribirUsuario(Long tallerid, Long usuarioid, String rol);

    Inscripcion cambiarRol (Long tallerid, Long usuarioid, String nuevoRol);

    Inscripcion expulsarUsuario (Long tallerid, Long usuarioid);

    List<Inscripcion> listarInscripcionesDETaller (Long tallerid);

    List<Inscripcion> listarInscripcionesDeUsuario (Long Usuarioid);

    Inscripcion verMiembrosAgrupadosPorPerfil (Long tallerid);

    Inscripcion verResponsables(Long tallerid);

}
