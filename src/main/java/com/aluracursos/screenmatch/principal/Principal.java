package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.model.DatosSerie;
import com.aluracursos.screenmatch.model.DatosTemporada;
import com.aluracursos.screenmatch.service.ConsumoAPI;
import com.aluracursos.screenmatch.service.ConvierteDatos;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private String API_KEY = "apikey=7880a47c";
    private String URL_BASE = "https://www.omdbapi.com/?";
    private ConvierteDatos conversor = new ConvierteDatos();

    public void muestraElMenu() {
        System.out.println("Por favor escribe el nombre de la serie que deseas buscar:");
        //Busca los datos generales de la serie
        String nombreSerie = "&t=" + teclado.nextLine();
        String json = consumoAPI.obtenerDatos(URL_BASE + API_KEY + nombreSerie.replace(" ", "+"));
        DatosSerie datos = conversor.obtenerDatos(json, DatosSerie.class);
        System.out.println(datos);

        //Busca los datos de todas las temporadas
        List<DatosTemporada> temporadas = new ArrayList<>();
        for (int i = 1; i < datos.totalTemporadas() + 1; i++) {
            json = consumoAPI.obtenerDatos(URL_BASE+API_KEY+nombreSerie.replace(" ", "+")+"&season=" + i);
            DatosTemporada datosTemporadas = conversor.obtenerDatos(json, DatosTemporada.class);
            temporadas.add(datosTemporadas);
        }
        temporadas.forEach(System.out::println);
    }
}
