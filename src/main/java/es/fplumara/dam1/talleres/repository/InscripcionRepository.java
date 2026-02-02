package es.fplumara.dam1.talleres.repository;

import es.fplumara.dam1.talleres.model.Inscripcion;

public interface InscripcionRepository {


    Inscripcion save(Inscripcion inscripcion);

    Inscripcion findById(Long id);

    Inscripcion findByTallerIdAndUsuarioId(Long tallerId, Long usuarioId);

    Inscripcion findByTallerId(Long tallerId);

    Inscripcion findByUserId(Long userId);

    Inscripcion findByTallerIdAndRol(Long tallerId, Long rol);

    Inscripcion deleteById(Long id);

    Inscripcion deleteByTallerIdAndUsuarioId(Long tallerId, Long usuarioId);

}
