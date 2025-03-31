package org.project.spring.music_album.demo.repository;

import org.project.spring.music_album.demo.model.Genere;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenereRepository extends JpaRepository<Genere, Integer> {
}
