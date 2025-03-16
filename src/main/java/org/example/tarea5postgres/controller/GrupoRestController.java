package org.example.tarea5postgres.controller;


import org.example.tarea5postgres.model.entity.Grupo;
import org.example.tarea5postgres.service.GrupoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tarea5postgres/grupo")
public class GrupoRestController {

    private final GrupoService grupoService;


    public GrupoRestController(GrupoService grupoService) {
        this.grupoService = grupoService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addNewGrupoPostgreSQLController(@RequestBody Grupo grupo) {
        try{
            grupoService.addGrupoService(grupo);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Grupo añadido correctamente");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteGrupoByIdPostgreSQLController(@PathVariable Integer id) {
        try{
            boolean eliminado =  grupoService.deleteGrupoByIdService(id);
            if(!eliminado){
                return ResponseEntity.badRequest().body("Grupo no encontrado");
            }
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Grupo eliminado correctamente");
    }

    @PostMapping("/crear")
    public ResponseEntity<String> createGrupoLlmadaPostgreSQLController(@RequestBody Grupo grupo) {
        try{
            grupoService.createGrupoService(grupo);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Grupo creado correctamente en llamada");
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> borrarGrupoByIdLlamadaPostgreSQLController(@PathVariable Integer id) {
        try{
            boolean eliminado = grupoService.borrarGrupoByIdService(id);
            if(!eliminado){
                return ResponseEntity.badRequest().body("Grupo no encontrado");
            }
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Grupo borrado correctamente en llamada");
    }

}
