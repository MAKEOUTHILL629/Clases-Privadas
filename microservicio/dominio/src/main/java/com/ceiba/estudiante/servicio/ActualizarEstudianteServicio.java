package com.ceiba.estudiante.servicio;


import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.estudiante.modelo.entidad.Estudiante;
import com.ceiba.estudiante.puerto.repositorio.EstudianteRepositorio;


public class ActualizarEstudianteServicio {
    private static final String LA_PERSONA_NO_EXISTE_EN_EL_SISTEMA = "La persona no existe en el sistema";

    private final EstudianteRepositorio repositorio;

    public ActualizarEstudianteServicio(EstudianteRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void ejecutar(Estudiante estudiante){
        validarExistenciaPrevia(estudiante);
        this.repositorio.actualizar(estudiante);

    }

    private void validarExistenciaPrevia(Estudiante estudiante) {
        boolean existe = this.repositorio.existe(estudiante.getId());
        if(existe) {
            throw new ExcepcionDuplicidad(LA_PERSONA_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
