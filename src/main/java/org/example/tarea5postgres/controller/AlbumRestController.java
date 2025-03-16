package org.example.tarea5postgres.controller;

import org.example.tarea5postgres.model.entity.Album;
import org.example.tarea5postgres.service.AlbumService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tarea5postgres/album")
public class AlbumRestController {

    public final AlbumService albumService;

    public AlbumRestController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addNewAlbumPostgreSQLController(@RequestBody Album album) {
        try {
            albumService.addAlbumService(album);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Album añadido correctamente");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAlbumByIdPostgreSQLController(@PathVariable Integer id) {
        try {
            boolean eliminado = albumService.deleteAlbumByIdService(id);
            if (!eliminado) {
                return ResponseEntity.badRequest().body("Album no encontrado");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Album eliminado correctamente");
    }


    @PostMapping("/crear")
    public ResponseEntity<String> createNewAlbumLlamadaPostgreSQLController(@RequestBody Album album) {
        try {
            albumService.createAlbumService(album);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Album creado correctamente en llamada");
    }

    /**
     * Metodo para borrar un album en postgreSQL y mongoService
     *
     * @param id el ID del album a borrar en ambas bases de datos
     * @return un mensaje indicando si se borró o no
     */
    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> borrarAlbumByIdLlamadaPostgreSQLController(@PathVariable Integer id) {
        try {
            boolean eliminado = albumService.borrarAlbumByIdService(id);
            if (!eliminado) {
                return ResponseEntity.badRequest().body("Album no encontrado");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Album borrado correctamente en llamada");
    }
}
