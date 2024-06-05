package com.aluracursos.screenmatch.service;

public interface IConvierteDatos {
    //<T> T Indica que trabajaremos con tipos de dato genericos
    <T> T obtenerDatos(String json, Class<T> clase);
}
