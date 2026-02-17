package es.fplumara.dam1.talleres.repository.impl;

import es.fplumara.dam1.talleres.model.Taller;
import es.fplumara.dam1.talleres.repository.InscripcionRepository;
import es.fplumara.dam1.talleres.model.Inscripcion;

import javax.management.relation.Role;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InMemoryInscripcionRepository implements InscripcionRepository {

    private Long contador = 0L;

    private Map<Long, Inscripcion> inscripciones;

    private Map<String,Long> indices;


    public InMemoryInscripcionRepository() {
        inscripciones = new HashMap<>();
    }

    private String crearIndice(Inscripcion inscripcion) {
        return inscripcion.getTallerId()+"/"+inscripcion.getUsuarioId();
    }

    @Override
    public Inscripcion save(Inscripcion inscripcion) {
        if (inscripcion.getId() == null) {
            contador++;
            inscripcion.setId(contador);
        }
        inscripciones.put(inscripcion.getId(), inscripcion);
        indices.put(crearIndice(inscripcion),inscripcion.getId());

        return inscripcion;
    }

    @Override
    public Inscripcion findById(Long id) {
        return inscripciones.get(id);
    }

    @Override
    public Inscripcion findByTallerIdAndUsuarioId(Long tallerId, Long usuarioId) {
        Long inscripcionId = indices.get(tallerId+"/"+usuarioId);

       return inscripciones.get(inscripcionId);
    }

    @Override
    public List<Inscripcion> findByTallerId(Long tallerId) {
        return inscripciones.values().stream().filter(inscripcion -> inscripcion.getId().equals(tallerId)).toList();
    }

    @Override
    public List<Inscripcion> findByUsuarioId(Long usuarioId) {
        return inscripciones.values().stream().filter(inscripcion -> inscripcion.getUsuarioId().equals(usuarioId)).toList();
    }

    @Override
    public List<Inscripcion> finByTallerIdAndRole(Long tallerId, Role role) {
        return inscripciones.values().stream().filter(inscripcion -> inscripcion.getTallerId().equals(tallerId) && inscripcion.getRol().equals(role)).toList();
    }

    @Override
    public void deleteById(Long id) {
        inscripciones.remove(id);
    }

    @Override
    public void deleteByTallerIdAndUsuarioId(Long tallerId, Long usuarioId) {
        Long inscripcionId = indices.get(tallerId+"/"+usuarioId);
        inscripciones.remove(inscripcionId);
    }
}
