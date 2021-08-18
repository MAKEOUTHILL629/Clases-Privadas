package com.ceiba.temas_profesor.servicio;

import com.ceiba.temas_profesor.puerto.repositorio.TemasProfesorRepositorio;

public class EliminarTemaProfesorService {
    private final TemasProfesorRepositorio repositorio;

    public EliminarTemaProfesorService(TemasProfesorRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void ejecutar(Long id) {
        this.repositorio.eliminar(id);
    }

}

