package org.example.tarea5postgres.comunication;

import org.example.tarea5postgres.model.entity.Album;
import org.example.tarea5postgres.model.entity.Grupo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Servicio de comunicacion con mongoService
 * @version 1.0
 */
@FeignClient(name = "Practica5MongoService", url = ("http://localhost:8083")) // Esta anotación se utiliza para indicar que esta interfaz es un cliente Feign
public interface ServicioMongo {

    /**
     * Metodo para comunicarse con mongoService y crear un grupo
     * @param grupo el grupo a crear
     */
    @PostMapping("/grupo/crear") // Esta anotación se utiliza para mapear solicitudes HTTP POST a métodos de controlador y se aplica a un método de la interfaz
    void crearGrupoLlamada(@RequestBody Grupo grupo); // Método que recibe un objeto de tipo GrupoAuxMongoServiceDTO y no devuelve nada

    /**
     * Metodo para comunicarse con mongoService y borrar un grupo por su id
     * @param id
     */
    @DeleteMapping("/grupo/borrar/{id}") // Esta anotación se utiliza para mapear solicitudes HTTP DELETE a métodos de controlador y se aplica a un método de la interfaz
    void borrarGrupoLlamada(@PathVariable Integer id); // Método que recibe un objeto de tipo Integer y no devuelve nada

    /**
     * Metodo para crear un album llamando a mongoService
     * @param album
     */
    @PostMapping("/album/crear") // Esta anotación se utiliza para mapear solicitudes HTTP POST a métodos de controlador y se aplica a un método de la interfaz
    void crearAlbum(@RequestBody Album album); // Método que recibe un objeto de tipo GrupoAuxMongoServiceDTO y no devuelve nada

    /**
     * Metodo para comunicarse con mongoService y borrar un album por su id
     * @param id
     */
    @DeleteMapping("/album/borrar/{id}") // Esta anotación se utiliza para mapear solicitudes HTTP DELETE a métodos de controlador y se aplica a un método de la interfaz
    void borrarAlbumLlamada(@PathVariable Integer id); // Método que recibe un objeto de tipo Integer y no devuelve nada
}
