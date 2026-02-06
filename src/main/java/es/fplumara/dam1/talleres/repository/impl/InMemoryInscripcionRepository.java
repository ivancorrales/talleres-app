package es.fplumara.dam1.talleres.repository.impl;

import es.fplumara.dam1.talleres.repository.InscripcionRepository;
import es.fplumara.dam1.talleres.model.Inscripcion;

import java.util.*;

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
    public List<Inscripcion> findByTallerIdAndUsuarioId(Long tallerId, Long usuarioId) {
        /**
        String inscripcionId = tallerId.toString()+"/"+usuarioId.toString();
        return inscripciones.get(inscripcionId);
         **/
        for (Inscripcion inscripcionesId : listaId.values()) {
            if (inscripcionesId.getUsuarioId().equals(usuarioId) && inscripcionesId.getTallerId().equals(tallerId)) {
                return Collections.singletonList(inscripcionesId);
            }
        }
        /** Aqui tendria que devolver algo o no? **/
        return null;

    }

    @Override
    public List<Inscripcion> findByTallerId(Long tallerId) {
        List<Inscripcion> inscripciones = new ArrayList<>();
        for (Inscripcion inscripcion : listaId.values()) {
            if (inscripcion.getTallerId().equals(tallerId)) {
                inscripciones.add(inscripcion);
            }
        }
        return inscripciones;
    }

    @Override
    public List<Inscripcion> findByUserId(Long userId) {
        List<Inscripcion> inscripciones = new ArrayList<>();
        for (Inscripcion inscripcion : listaId.values()) {
            if (inscripcion.getUsuarioId().equals(userId)) {
                inscripciones.add(inscripcion);
            }
        }

        return inscripciones;
    }

    @Override
    public Inscripcion findByTallerIdAndRol(Long tallerId, Long rol) {
        for (Inscripcion inscripcion : listaId.values()) {
            if (inscripcion.getTallerId().equals(tallerId) && inscripcion.getRol().equals(rol)) {
                return inscripcion;
            }
        }
        return null;
    }

    @Override
    public Inscripcion deleteById(Long id) {
        return listaId.remove(id);
    }

    @Override
    public Inscripcion deleteByTallerIdAndUsuarioId(Long tallerId, Long usuarioId) {
        Inscripcion borrarInscripcionUsuario = (Inscripcion) findByTallerIdAndUsuarioId(tallerId, usuarioId);
        if (borrarInscripcionUsuario != null) {
            listaId.remove(borrarInscripcionUsuario.getId());
        }
        return null;
    }
}
