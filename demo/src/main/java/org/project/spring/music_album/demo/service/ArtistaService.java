package org.project.spring.music_album.demo.service;

import java.util.List;
import java.util.Optional;

import org.project.spring.music_album.demo.model.Album;
import org.project.spring.music_album.demo.model.Artista;
import org.project.spring.music_album.demo.model.Genere;
import org.project.spring.music_album.demo.repository.AlbumRepository;
import org.project.spring.music_album.demo.repository.ArtistaRepository;
import org.project.spring.music_album.demo.repository.GenereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ArtistaService {

    @Autowired
    private ArtistaRepository artistaRepository;

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    GenereRepository genereRepository;

    public List<Artista> findAll() {
        return artistaRepository.findAll();
    }

    public List<Artista> findAllSortedByName() {
        return artistaRepository.findAll(Sort.by("nome"));
    }

    public Optional<Artista> findById(Integer id) {
        return artistaRepository.findById(id);
    }

    public Artista getById(Integer id) {
        return artistaRepository.findById(id).get();
    }

    public List<Artista> findByName(String nome) {
        return artistaRepository.findByNomeContainingIgnoreCase(nome);
    }

    public Artista create(Artista artista) {
        return artistaRepository.save(artista);
    }

    public Artista update(Artista artista) {
        return artistaRepository.save(artista);
    }

    public void delete(Artista artista) {

        for (Album albumDaCancellare : artista.getAlbums()) {
            albumRepository.delete(albumDaCancellare);
        }

        for (Genere genereDaCancellare : artista.getGeneri()) {
            genereRepository.delete(genereDaCancellare);
        }

        artistaRepository.delete(artista);
    }

    public void deleteById(Integer id) {

        Artista artista = getById(id);

        for (Album albumDaCancellare : artista.getAlbums()) {
            albumRepository.delete(albumDaCancellare);
        }

        for (Genere genereDaCancellare : artista.getGeneri()) {
            genereRepository.delete(genereDaCancellare);
        }

        artistaRepository.delete(artista);
    }

}
