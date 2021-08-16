package com.ceiba.clase.servicio;

import com.ceiba.clase.puerto.repositorio.ClaseRepositorio;

public class EliminarClaseServicio {
    private final ClaseRepositorio repositorio;

    public EliminarClaseServicio(ClaseRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void ejecutar(Long id) {
        this.repositorio.eliminar(id);

    }
}