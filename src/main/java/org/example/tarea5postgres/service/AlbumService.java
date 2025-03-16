package org.example.tarea5postgres.service;

import org.example.tarea5postgres.comunication.ServicioMongo;
import org.example.tarea5postgres.exceptions.IdException;
import org.example.tarea5postgres.model.DTO.AlbumAuxDTO;
import org.example.tarea5postgres.model.DTO.AlbumDTO;
import org.example.tarea5postgres.model.entity.Album;
import org.example.tarea5postgres.model.entity.Grupo;
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
     * @param albumDTO
     */
    public void createAlbumService(AlbumDTO albumDTO) {
        Grupo grupo = getGrupo(albumDTO);
        Album album = new Album(grupo, albumDTO.getTitulo(),
                albumDTO.getDataLanzamento(), albumDTO.getPuntuacion());
        albumRepository.save(album);

        Integer albumID = album.getId();
        Integer grupoID = grupo.getId();
        AlbumAuxDTO albumAuxDTO = new AlbumAuxDTO(
                albumID, grupoID, albumDTO.getTitulo(), albumDTO.getDataLanzamento(),
                albumDTO.getPuntuacion()
        );
        servicioMongo.crearAlbum(albumAuxDTO);
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

    /**
     * Metodo para obtener un grupo y saber si existe por su id o no
     * @param albumDTO la DTO para buscar al grupo
     * @return el objeto Grupo
     */
    private Grupo getGrupo(AlbumDTO albumDTO) {
        Grupo grupo = grupoRepository.findByid(albumDTO.getGrupoID());
        if(grupo == null) {
            throw new IdException("El grupo con el id " + albumDTO.getGrupoID() + " no existe");
        }
        return grupo;
    }
}
