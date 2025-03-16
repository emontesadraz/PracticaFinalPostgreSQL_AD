package org.example.tarea5postgres.repositories;

import org.example.tarea5postgres.model.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {

    Album findByid(Integer id);
}
