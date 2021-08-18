package com.ceiba.profesor.servicio;

import com.ceiba.profesor.puerto.repositorio.ProfesorRepositorio;

public class EliminarProfesorServicio {
    private final ProfesorRepositorio repositorio;

    public EliminarProfesorServicio(ProfesorRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void ejecutar(Long id) {
        this.repositorio.eliminar(id);
    }
}
