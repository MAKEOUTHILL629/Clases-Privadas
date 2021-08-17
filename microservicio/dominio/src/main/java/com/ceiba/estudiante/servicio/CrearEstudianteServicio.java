package com.ceiba.estudiante.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.estudiante.modelo.entidad.Estudiante;
import com.ceiba.estudiante.puerto.repositorio.EstudianteRepositorio;

public class CrearEstudianteServicio {
    private static final String LA_PERSONA_YA_EXISTE_EN_EL_SISTEMA = "La persona ya existe en el sistema";

    private final EstudianteRepositorio repositorio;

    public CrearEstudianteServicio(EstudianteRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Long ejecutar(Estudiante estudiante){
        validarExistenciaPrevia(estudiante);
        return this.repositorio.crear(estudiante);
    }


    private void validarExistenciaPrevia(Estudiante estudiante) {
        boolean existe = this.repositorio.existe(estudiante.getId());
        if(!existe) {
            throw new ExcepcionDuplicidad(LA_PERSONA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
