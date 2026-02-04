package es.fplumara.dam1.talleres.service.impl;

import es.fplumara.dam1.talleres.dto.ActualizarTallerDTO;
import es.fplumara.dam1.talleres.dto.CrearTallerDTO;
import es.fplumara.dam1.talleres.exception.DatosTallerException;
import es.fplumara.dam1.talleres.model.EstadoInscripcion;
import es.fplumara.dam1.talleres.model.Taller;
import es.fplumara.dam1.talleres.repository.TallerRepository;
import es.fplumara.dam1.talleres.service.TallerService;

import java.util.List;

public class TallerServiceImpl implements TallerService {

    private TallerRepository tallerRepository;


    TallerServiceImpl(TallerRepository tallerRepository) {

        this.tallerRepository = tallerRepository;
    }

    @Override
    public Taller createTaller(CrearTallerDTO crearTallerDTO) {
        if(crearTallerDTO.getTitulo() == null){
            throw new DatosTallerException("titulo requerido");
        }
        if (crearTallerDTO.getDescripcion() == null){
            throw new DatosTallerException("descripcion requerida");
        }
        Taller taller = new Taller();
        taller.setTitulo(crearTallerDTO.getTitulo());
        taller.setDescripcion(crearTallerDTO.getDescripcion());
        taller.setUrl(crearTallerDTO.getUrl());
        taller.setLugar(crearTallerDTO.getLugar());
        taller.setCupo(crearTallerDTO.getCupo());
        taller.setEstadoInscripcion(EstadoInscripcion.CERRADO);

        return this.tallerRepository.save(taller);
    }

    @Override
    public List<Taller> listarTalleres() {
        return List.of();
    }

    @Override
    public Taller obtenerTaller(Long id) {
        return null;
    }

    @Override
    public Taller atualizarTaller(Long id, ActualizarTallerDTO dto) {
        return null;
    }

    @Override
    public Taller cambiarEstadoTaller(Long id, EstadoInscripcion estadoInscripcion) {
        return null;
    }

    @Override
    public void eliminarTaller(Long id) {

    }
}
