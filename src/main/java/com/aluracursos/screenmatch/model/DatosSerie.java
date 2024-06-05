package com.aluracursos.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//ignora las propiedades no mapeadas dentro de la clase
@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosSerie(
        //json alias solo permite leer, property permite leer y escribir
        @JsonAlias("Title") String titulo,
        @JsonAlias("totalSeasons") Integer totalTemporadas,
        @JsonAlias("imdbRating") String evaluacion) {
        //@JsonProperty("")
}
