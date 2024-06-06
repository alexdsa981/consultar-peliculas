package com.aluracursos.screenmatch.test;

import com.aluracursos.screenmatch.model.DatosEpisodio;
import com.aluracursos.screenmatch.model.DatosSerie;
import com.aluracursos.screenmatch.model.DatosTemporada;
import com.aluracursos.screenmatch.service.ConsumoAPI;
import com.aluracursos.screenmatch.service.ConvierteDatos;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        ConsumoAPI consumoApi = new ConsumoAPI();
        String json = consumoApi.obtenerDatos("https://www.omdbapi.com/?apikey=7880a47c&t=breaking+bad");
        System.out.println(json);
        ConvierteDatos conversor = new ConvierteDatos();
        //var reconoce directamente el tipo de dato que se está buscando, en este
        //caso reconoce "datosSerie" como la clase DatosSerie
        var datosSerie = conversor.obtenerDatos(json, DatosSerie.class);
        System.out.println(datosSerie);

        json = consumoApi.obtenerDatos("https://www.omdbapi.com/?apikey=7880a47c&t=breaking+bad&season=1&episode=1");
        DatosEpisodio episodios = conversor.obtenerDatos(json, DatosEpisodio.class);
        System.out.println(episodios);

        List<DatosTemporada> temporadas = new ArrayList<>();
        for (int i = 1; i < datosSerie.totalTemporadas()+1; i++) {
            json = consumoApi.obtenerDatos("https://www.omdbapi.com/?apikey=7880a47c&t=breaking+bad&season="+i);
            var datosTemporadas = conversor.obtenerDatos(json, DatosTemporada.class);
            temporadas.add(datosTemporadas);
        }
        temporadas.forEach(System.out::println);
    }
}
