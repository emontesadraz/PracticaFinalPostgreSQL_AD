package org.example.tarea5postgres.repositories;

import org.example.tarea5postgres.model.entity.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrupoRepository extends JpaRepository<Grupo, Integer> {

    Grupo findByid(Integer id);
}
