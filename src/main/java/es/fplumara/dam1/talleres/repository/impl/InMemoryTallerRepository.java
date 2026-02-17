package es.fplumara.dam1.talleres.repository.impl;

import es.fplumara.dam1.talleres.repository.TallerRepository;
import es.fplumara.dam1.talleres.model.Taller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTallerRepository  implements TallerRepository {

    private Map<Long, Taller> talleres;

    private Long contador = 0L;

    public InMemoryTallerRepository() {
        talleres = new HashMap<Long, Taller>();
    }

    @Override
    public Taller save(Taller taller) {
        if(taller.getId()==null) {
            taller.setId(contador);
            contador++;
        }
        talleres.put(taller.getId(), taller);
        return taller;
    }

    @Override
    public Taller findById(Long id) {
        return talleres.get(id);
    }

    @Override
    public List<Taller> findAll() {
        List<Taller> listaTalleres = new ArrayList<>();
        for (Taller taller : talleres.values()) {
            listaTalleres.add(taller);
        }
        return listaTalleres;
    }

    @Override
    public void deleteById(Long id) {
        talleres.remove(id);
    }
}
