package org.example.tarea5postgres.service;

import org.example.tarea5postgres.comunication.ServicioMongo;
import org.example.tarea5postgres.model.entity.Album;
import org.example.tarea5postgres.repositories.AlbumRepository;
import org.example.tarea5postgres.repositories.GrupoRepository;
import org.springframework.stereotype.Service;

@Service
public class AlbumService {

    private final AlbumRepository albumRepository;
    private final GrupoRepository grupoRepository;
    private final ServicioMongo servicioMongo;

    public AlbumService(AlbumRepository albumRepository, GrupoRepository grupoRepository, ServicioMongo servicioMongo) {
        this.albumRepository = albumRepository;
        this.grupoRepository = grupoRepository;
        this.servicioMongo = servicioMongo;
    }

    /**
     * Metodo para crear un album
     * @param album
     */
    public void addAlbumService(Album album) {
        albumRepository.save(album);
    }

    /**
     * Metodo para borrar un album por su id
     * @param id el id del album
     * @return un mensaje indicando si se borro o no
     */
    public boolean deleteAlbumByIdService(Integer id) {
        if(!albumRepository.existsById(id)) {
            return false;
        }
        albumRepository.deleteById(id);
        return true;
    }

    /**
     * Metodo para crear un album y que se guarde en MongoDB
     * @param album
     */
    public void createAlbumService(Album album) {
        albumRepository.save(album);

        servicioMongo.crearAlbum(album);
    }

    /**
     * Metodo para borrar un album por ID en postgreSQL y mongoService
     * @param id el id del album
     * @return un mensaje indicando si se borro o no
     */
    public boolean borrarAlbumByIdService(Integer id) {
        if(!albumRepository.existsById(id)) {
            return false;
        }
        albumRepository.deleteById(id);
        servicioMongo.borrarAlbumLlamada(id);
        return true;
    }
}
