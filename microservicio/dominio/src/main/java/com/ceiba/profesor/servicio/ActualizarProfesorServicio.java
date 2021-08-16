package com.ceiba.profesor.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.profesor.modelo.entidad.Profesor;
import com.ceiba.profesor.puerto.repositorio.ProfesorRepositorio;

public class ActualizarProfesorServicio {
    private static final String LA_PERSONA_NO_EXISTE_EN_EL_SISTEMA = "La persona no existe en el sistema";
    private final ProfesorRepositorio repositorio;

    public ActualizarProfesorServicio(ProfesorRepositorio repositorio) {
        this.repositorio = repositorio;
    }


    public void ejecutar(Profesor profesor){
        validarExistenciaPrevia(profesor);
        this.repositorio.actualizar(profesor);
    }

    private void validarExistenciaPrevia(Profesor profesor) {
        boolean existe = this.repositorio.existe(profesor.getId());
        if(existe) {
            throw new ExcepcionDuplicidad(LA_PERSONA_NO_EXISTE_EN_EL_SISTEMA);
        }
    }

}
