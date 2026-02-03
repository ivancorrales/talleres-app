package es.fplumara.dam1.talleres.service;

import es.fplumara.dam1.talleres.dto.ActualizarTallerDTO;
import es.fplumara.dam1.talleres.dto.CrearTallerDTO;
import es.fplumara.dam1.talleres.model.EstadoInscripcion;
import es.fplumara.dam1.talleres.model.Taller;

import java.util.List;

public interface TallerService {

    Taller createTaller(CrearTallerDTO crearTallerDTO);

    List<Taller> listarTalleres();

    Taller obtenerTaller(Long id);


    Taller actualizarTaller(Long id, ActualizarTallerDTO dto);

    Taller cambiarEstadoTaller(Long id, EstadoInscripcion estadoInscripcion);

    Taller eliminarTaller(Long id);
}
