package es.fplumara.dam1.talleres.service.impl;

import es.fplumara.dam1.talleres.dto.ActualizarTallerDTO;
import es.fplumara.dam1.talleres.dto.CrearTallerDTO;
import es.fplumara.dam1.talleres.dto.DeleteSummaryDTO;
import es.fplumara.dam1.talleres.exception.*;
import es.fplumara.dam1.talleres.model.EstadoInscripcion;
import es.fplumara.dam1.talleres.model.Inscripcion;
import es.fplumara.dam1.talleres.model.Taller;
import es.fplumara.dam1.talleres.repository.InscripcionRepository;
import es.fplumara.dam1.talleres.repository.TallerRepository;
import es.fplumara.dam1.talleres.service.TallerService;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class TallerServiceImpl implements TallerService {

    private TallerRepository tallerRepository;
    private InscripcionRepository inscripcionRepository;
    private Map<String, Taller> talleres;


    public TallerServiceImpl(TallerRepository tallerRepository) {
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
        taller.setEstadoInscripcion(crearTallerDTO.getEstadoInscripcion());

        return this.tallerRepository.save(taller);
    }

    @Override
    public List<Taller> listarTalleres() {
        List<Taller> talleresDeSalida = this.tallerRepository.findAll();
        for (String taller : talleres.values()) {
            return talleresDeSalida.add(taller);
        }
        return List.of();
    }

    @Override
    public Taller obtenerTaller(Long id) {
        Taller taller = this.tallerRepository.findById(id);
        if(taller == null){
            throw new DatosObtenerTallerServiceException("Taller no obtenido");
        }
        return taller;
    }

    @Override
    public Taller actualizarTaller(Long id, ActualizarTallerDTO dto) {
        // 1-COMPROBAR SI TALLER EXISTE
        Taller taller = this.tallerRepository.findById(id);
        if(taller == null){
            throw new DatosActualizarTallerServiceException("Taller no encontrado");
        }

        // 2.1-APLICAR CAMBIOS DE DTO
        if(dto.getTitulo() == null){
            throw new BusinessRuleException("Titulo requerido esta vacio");
        }
        taller.setTitulo(dto.getTitulo());

        // 2.2
        if(dto.getDescripcion() != null){
            throw new BusinessRuleException("Cupo esta invalido");
        }
        // 2.3
        if(dto.getUrl() != null){
            throw new BusinessRuleException("Url requerido esta vacio");
        }
        // 2.4
        if(dto.getLugar() != null){
            throw new BusinessRuleException("Lugar requerido esta vacio");
        }

        // 3.1-SI CAMBIA, CALCULAR CUANTOS USUARIOS HAY INSCRITOS "PARTICIPANTES"
        if (dto.getCupo() != null) {
            if(dto.getCupo() <= 0){
                throw new BusinessRuleException("Cupo invalido");
            }
        }

        // 4-GUARDAR TALLER CON tallerRepository.save
        Taller tallerActualizado = this.tallerRepository.save(taller);
        return tallerActualizado;
    }

    @Override
    public Taller cambiarEstadoTaller(Long id, EstadoInscripcion estadoInscripcion) {

        Taller taller = this.tallerRepository.findById(id);
        if(taller == null){
            throw new DatosEstadoInscripcionTallerServiceException("Taller no encontrado");
        }
        if (estadoInscripcion == null) {
            throw new DatosEstadoInscripcionEstadoserviceException("Estado inscripcion no esta vacio");
        }

        taller.setEstadoInscripcion(estadoInscripcion.CERRADO);
        this.tallerRepository.save(taller);
        return this.tallerRepository.save(taller);
    }

    @Override
    public DeleteSummaryDTO eliminarTaller(Long id) {
        Taller taller = this.tallerRepository.findById(id);
        if(taller == null){
            throw new ExistenciaTallerServiceException("Taller no existe");
        }

        List<Inscripcion> eliminarInscripcion = Collections.singletonList(inscripcionRepository.findByTallerId(id));
        int inscripcionesEliminadas = 0;
        for(Inscripcion inscripcion : eliminarInscripcion){
            inscripcionRepository.deleteById(inscripcion.getId());
            inscripcionesEliminadas++;
        }
        tallerRepository.deleteById(id);
        return new DeleteSummaryDTO(inscripcionesEliminadas);
    }
}
