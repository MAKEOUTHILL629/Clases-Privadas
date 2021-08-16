package com.ceiba.profesor.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.profesor.modelo.entidad.Profesor;
import com.ceiba.profesor.puerto.repositorio.ProfesorRepositorio;

public class CrearProfesorServicio {
    private static final String LA_PERSONA_YA_EXISTE_EN_EL_SISTEMA = "La persona ya existe en el sistema";

    private final ProfesorRepositorio repositorio;

    public CrearProfesorServicio(ProfesorRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Long ejecutar(Profesor profesor) {
        validarExistenciaPrevia(profesor);
        return this.repositorio.crear(profesor);
    }

    private void validarExistenciaPrevia(Profesor profesor) {
        boolean existe = this.repositorio.existe(profesor.getId());
        if (existe) {
            throw new ExcepcionDuplicidad(LA_PERSONA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

}
