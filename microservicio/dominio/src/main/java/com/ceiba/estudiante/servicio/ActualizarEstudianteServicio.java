package com.ceiba.estudiante.servicio;


import com.ceiba.dominio.excepcion.ExcepcionDatoNoEncontrado;
import com.ceiba.estudiante.modelo.entidad.Estudiante;
import com.ceiba.estudiante.puerto.repositorio.EstudianteRepositorio;



public class ActualizarEstudianteServicio {
    private static final String EL_ESTUDIANTE_NO_EXISTE_EN_EL_SISTEMA = "El estudiante no existe en el sistema";


    private final EstudianteRepositorio repositorio;


    public ActualizarEstudianteServicio(EstudianteRepositorio repositorio) {
        this.repositorio = repositorio;

    }

    public void ejecutar(Estudiante estudiante) {
        validarExistenciaPrevia(estudiante);
        this.repositorio.actualizar(estudiante);

    }


    private void validarExistenciaPrevia(Estudiante estudiante) {
        boolean existe = repositorio.existeConIdEstudiante(estudiante.getId());
        if (!existe) {
            throw new ExcepcionDatoNoEncontrado(EL_ESTUDIANTE_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
