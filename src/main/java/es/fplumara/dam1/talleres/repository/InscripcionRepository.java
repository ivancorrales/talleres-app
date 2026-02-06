package es.fplumara.dam1.talleres.repository;

import es.fplumara.dam1.talleres.model.Inscripcion;

import java.util.List;

public interface InscripcionRepository {


    Inscripcion save(Inscripcion inscripcion);

    Inscripcion findById(Long id);

    List<Inscripcion> findByTallerIdAndUsuarioId(Long tallerId, Long usuarioId);

    List<Inscripcion> findByTallerId(Long tallerId);

    List<Inscripcion> findByUserId(Long userId);

    Inscripcion findByTallerIdAndRol(Long tallerId, Long rol);

    Inscripcion deleteById(Long id);

    Inscripcion deleteByTallerIdAndUsuarioId(Long tallerId, Long usuarioId);

}
