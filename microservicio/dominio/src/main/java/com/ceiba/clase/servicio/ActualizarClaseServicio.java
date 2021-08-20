package com.ceiba.clase.servicio;

import com.ceiba.clase.modelo.entidad.Clase;
import com.ceiba.clase.puerto.repositorio.ClaseRepositorio;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.estudiante.modelo.entidad.Estudiante;
import com.ceiba.estudiante.puerto.dao.EstudianteDAO;
import com.ceiba.profesor.modelo.entidad.Profesor;
import com.ceiba.profesor.puerto.dao.ProfesorDAO;


public class ActualizarClaseServicio {

    private static final String EL_ID_DEL_PROFESOR_NO_EXISTE_EN_EL_SISTEMA = "El id del profesor no se encuentra en el sistema";
    private static final String EL_ID_DEL_ESTUDIANTE_NO_EXISTE_EN_EL_SISTEMA = "El id del estudiante no se encuentra en el sistema";

    private final ClaseRepositorio repositorio;
    private final EstudianteDAO estudianteDAO;
    private final ProfesorDAO profesorDAO;

    public ActualizarClaseServicio(ClaseRepositorio repositorio, EstudianteDAO estudianteDAO, ProfesorDAO profesorDAO) {
        this.repositorio = repositorio;
        this.estudianteDAO = estudianteDAO;
        this.profesorDAO = profesorDAO;
    }

    public void ejecutar(Clase clase) {
        validarExistenciaProfesorEstudiante(clase.getProfesor(), clase.getEstudiante());
        this.repositorio.actualizar(clase);
    }

    private void validarExistenciaProfesorEstudiante(Profesor profesor, Estudiante estudiante){
        boolean profesorExiste =   profesorDAO.obtener(profesor.getId()) != null;
        boolean estudianteExiste = estudianteDAO.obtener(estudiante.getId())!= null;
        if(!profesorExiste){
            throw new ExcepcionSinDatos(EL_ID_DEL_PROFESOR_NO_EXISTE_EN_EL_SISTEMA);
        }else if(!estudianteExiste){
            throw new ExcepcionSinDatos(EL_ID_DEL_ESTUDIANTE_NO_EXISTE_EN_EL_SISTEMA);
        }
    }




}
