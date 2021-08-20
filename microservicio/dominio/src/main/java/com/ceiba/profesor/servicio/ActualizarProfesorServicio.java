package com.ceiba.profesor.servicio;


import com.ceiba.dominio.excepcion.ExcepcionDatoNoEncontrado;

import com.ceiba.profesor.modelo.entidad.Profesor;
import com.ceiba.profesor.puerto.repositorio.ProfesorRepositorio;

public class ActualizarProfesorServicio {
    private static final String EL_PROFESOR_NO_EXISTE_EN_EL_SISTEMA = "El profesor no existe en el sistema";

    private final ProfesorRepositorio profesorRepositorio;


    public ActualizarProfesorServicio(ProfesorRepositorio profesorRepositorio) {
        this.profesorRepositorio = profesorRepositorio;

    }

    public void ejecutar(Profesor profesor) {
        validarExistenciaPrevia(profesor);
        this.profesorRepositorio.actualizar(profesor);
    }


    private void validarExistenciaPrevia(Profesor profesor) {
        boolean existe = this.profesorRepositorio.existeConIdProfesor(profesor.getId());
        if (!existe) {
            throw new ExcepcionDatoNoEncontrado(EL_PROFESOR_NO_EXISTE_EN_EL_SISTEMA);
        }
    }

}
