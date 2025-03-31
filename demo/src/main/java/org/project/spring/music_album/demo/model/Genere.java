package org.project.spring.music_album.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "genres")
public class Genere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Il nome non può essere vuoto")
    @Size(min = 3, message = "Il nome deve essere lungo almeno 3 caratteri")
    private String nome;

    @ManyToMany(mappedBy = "generi")
    @JsonIgnore
    private List<Artista> artisti;

    @ManyToMany(mappedBy = "generi")
    @JsonIgnore
    private List<Album> albums;
}
