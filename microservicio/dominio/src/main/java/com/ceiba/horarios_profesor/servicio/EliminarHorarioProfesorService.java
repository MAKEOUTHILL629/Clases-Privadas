package com.ceiba.horarios_profesor.servicio;

import com.ceiba.horarios_profesor.puerto.repositorio.HorariosProfesorRepositorio;

public class EliminarHorarioProfesorService {
    private final HorariosProfesorRepositorio horariosProfesorRepositorio;

    public EliminarHorarioProfesorService(HorariosProfesorRepositorio horariosProfesorRepositorio) {
        this.horariosProfesorRepositorio = horariosProfesorRepositorio;
    }

    public void ejecutar(Long id) {
        this.horariosProfesorRepositorio.eliminar(id);
    }
}
