package es.fplumara.dam1.talleres.repository;

import es.fplumara.dam1.talleres.model.Inscripcion;

import javax.management.relation.Role;
import java.util.List;

public interface InscripcionRepository {
    Inscripcion save(Inscripcion inscripcion);

    Inscripcion findById(Long id);

    Inscripcion findByTallerIdAndUsuarioId(Long tallerId, Long usuarioId);

    List<Inscripcion> findByTallerId(Long tallerId);

    List<Inscripcion> findByUsuarioId(Long usuarioId);

    List<Inscripcion> finByTallerIdAndRole(Long tallerId, Role role);

    void deleteById(Long id);

    void deleteByTallerIdAndUsuarioId(Long tallerId, Long usuarioId);
}
