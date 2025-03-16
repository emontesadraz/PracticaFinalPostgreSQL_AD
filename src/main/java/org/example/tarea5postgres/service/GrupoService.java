package org.example.tarea5postgres.service;

import org.example.tarea5postgres.comunication.ServicioMongo;
import org.example.tarea5postgres.model.entity.Grupo;
import org.example.tarea5postgres.repositories.GrupoRepository;
import org.springframework.stereotype.Service;

@Service
public class GrupoService {

    private final GrupoRepository grupoRepository;
    private final ServicioMongo servicioMongo;

    public GrupoService(GrupoRepository grupoRepository, ServicioMongo servicioMongo) {
        this.grupoRepository = grupoRepository;
        this.servicioMongo = servicioMongo;
    }

    public void addGrupoService(Grupo grupo) {
        grupoRepository.save(grupo);
    }

    public boolean deleteGrupoByIdService(Integer id) {
        if(!grupoRepository.existsById(id)) {
            return false;
        }
        grupoRepository.deleteById(id);
        return true;
    }

    public void createGrupoService(Grupo grupo) {
        grupoRepository.save(grupo);
        servicioMongo.crearGrupoLlamada(grupo);
    }

    public boolean borrarGrupoByIdService(Integer id) {
        if(!grupoRepository.existsById(id)) {
            return false;
        }
        grupoRepository.deleteById(id);
        servicioMongo.borrarGrupoLlamada(id);
        return true;
    }
}
