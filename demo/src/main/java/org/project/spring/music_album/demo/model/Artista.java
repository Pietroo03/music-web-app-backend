package org.project.spring.music_album.demo.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "artists")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class Artista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "L'alias non può essere vuoto")
    @Size(min = 3, message = "L'alias deve essere lungo almeno 3 caratteri")
    private String alias;

    @NotBlank(message = "Inserisci un URL valido")
    private String foto;

    @NotBlank(message = "Il nome non può essere vuoto")
    @Size(min = 3, message = "Il nome deve essere lungo almeno 3 caratteri")
    private String nome;

    @NotBlank(message = "Il cognome non può essere vuoto")
    @Size(min = 3, message = "Il cognome deve essere lungo almeno 3 caratteri")
    private String cognome;

    @NotNull
    @Past(message = "Inserire una data di nascita valida")
    @Column(name = "data_di_nascita")
    private LocalDate dataNascita;

    @NotBlank(message = "L'etichetta non può essere vuota")
    @Size(min = 3, message = "L'etichetta deve essere lunga almeno 3 caratteri")
    private String etichetta;

    @NotBlank(message = "La descrizione non può essere vuota")
    @Size(max = 255, message = "La descrizione non può superare i 255 caratteri")
    private String descrizione;

}
