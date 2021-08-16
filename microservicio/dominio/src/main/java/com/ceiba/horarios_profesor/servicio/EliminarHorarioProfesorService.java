package com.ceiba.horarios_profesor.servicio;

import com.ceiba.horarios_profesor.puerto.repositorio.HorariosProfesorRepositorio;

public class EliminarHorarioProfesorService {
    private final HorariosProfesorRepositorio repositorio;

    public EliminarHorarioProfesorService(HorariosProfesorRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void ejecutar(Long id){
        this.repositorio.eliminar(id);
    }
}
