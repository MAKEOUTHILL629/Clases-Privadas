package com.ceiba.estudiante.servicio;

import com.ceiba.estudiante.puerto.repositorio.EstudianteRepositorio;

public class EliminarEstudianteServicio {
    private final EstudianteRepositorio repositorio;

    public EliminarEstudianteServicio(EstudianteRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void ejecutar(Long id) {
        this.repositorio.eliminar(id);
    }
}
