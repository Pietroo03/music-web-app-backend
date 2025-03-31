package org.project.spring.music_album.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "albums")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Inserisci un URL valido")
    private String foto;

    @NotNull
    @Past(message = "Inserire una data di pubblicazione valida")
    @Column(name = "data_di_pubblicazione")
    private LocalDate dataPubblicazione;

    @NotBlank(message = "La descrizione non può essere vuota")
    @Size(max = 255, message = "La descrizione non può superare i 255 caratteri")
    private String descrizione;

    @NotNull(message = "Inserire un numero valido")
    @Min(value = 1, message = "Le tracce devono essere maggiori di 0")
    private Integer tracce;
}
