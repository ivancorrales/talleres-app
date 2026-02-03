package es.fplumara.dam1.talleres.repository.impl;

import es.fplumara.dam1.talleres.repository.InscripcionRepository;
import es.fplumara.dam1.talleres.model.Inscripcion;

import java.util.HashMap;
import java.util.Map;

public class InMemoryInscripcionRepository implements InscripcionRepository {

    private Map<String,Long> inscripcionesAlmacenados;

    private Map<Long,Inscripcion> listaId;

    private long contarId;

    public InMemoryInscripcionRepository() {

        this.inscripcionesAlmacenados = new HashMap<>();
        this.listaId = new HashMap<>();
    }

    @Override
    public Inscripcion save(Inscripcion inscripciones) {

        if(inscripciones.getId() == null) {
            inscripciones.setId(contarId);
            contarId++;
        }
        listaId.put(inscripciones.getId(),inscripciones);
        String claveId = inscripciones.getTallerId() + "_" + inscripciones.getUsuarioId();
        inscripcionesAlmacenados.put(claveId, inscripciones.getId());

        return inscripciones;
    }

    @Override
    public Inscripcion findById(Long id) {

        return listaId.get(id);
    }

    @Override
    public Inscripcion findByTallerIdAndUsuarioId(Long tallerId, Long usuarioId) {

        String inscripcionId = tallerId.toString()+"/"+usuarioId.toString();
        return Inscripcion.get(inscripcionId);

    }

    @Override
    public Inscripcion findByTallerId(Long tallerId) {

        for (Inscripcion inscripcion : listaId.values()) {
            if (inscripcion.getTallerId().equals(tallerId)) {
                return inscripcion;
            }
        }
        return null;
    }

    @Override
    public Inscripcion findByUserId(Long userId) {

        for (Inscripcion inscripcion : listaId.values()) {
            if (inscripcion.getUsuarioId().equals(userId)) {
                return inscripcion;
            }
        }
        return null;
    }

    @Override
    public Inscripcion findByTallerIdAndRol(Long tallerId, Long rol) {
        for (Inscripcion inscripcion : listaId.values()) {

        }
        return null;
    }

    @Override
    public Inscripcion deleteById(Long id) {
        inscripcionesAlmacenados.remove(id);
        if (listaId.containsKey(id)) {
            listaId.remove(id);
        }
        return null;
    }

    @Override
    public Inscripcion deleteByTallerIdAndUsuarioId(Long tallerId, Long usuarioId) {
        for (Inscripcion inscripcion : listaId.values()) {
            listaId.remove(inscripcion.getId());
        }
        return null;
    }
}
