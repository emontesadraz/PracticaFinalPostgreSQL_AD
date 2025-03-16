package org.example.tarea5postgres.service;

import org.example.tarea5postgres.comunication.ServicioMongo;
import org.example.tarea5postgres.model.dto.GrupoAuxMongoServiceDTO;
import org.example.tarea5postgres.model.dto.GrupoDTO;
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

    public void addGrupoService(GrupoDTO grupoDTO) {
        Grupo grupo = new Grupo(grupoDTO.getNome(), grupoDTO.getXenero(),
                grupoDTO.getDataFormacion());
        grupoRepository.save(grupo);
    }

    public boolean deleteGrupoByIdService(Integer id) {
        if(!grupoRepository.existsById(id)) {
            return false;
        }
        grupoRepository.deleteById(id);
        return true;
    }

    public void createGrupoService(GrupoDTO grupoDTO) {
        Grupo grupo = new Grupo(grupoDTO.getNome(), grupoDTO.getXenero(),
                grupoDTO.getDataFormacion());
        grupoRepository.save(grupo);

        Integer idGenerado = grupo.getId();
        GrupoAuxMongoServiceDTO grupoAuxMongoServiceDTO = new GrupoAuxMongoServiceDTO(idGenerado, grupoDTO.getNome(),
                grupoDTO.getXenero(), grupoDTO.getDataFormacion());
        servicioMongo.crearGrupoLlamada(grupoAuxMongoServiceDTO);
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
