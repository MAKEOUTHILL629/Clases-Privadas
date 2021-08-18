package com.ceiba.clase.servicio;

import com.ceiba.clase.modelo.entidad.Clase;
import com.ceiba.clase.puerto.repositorio.ClaseRepositorio;
import com.ceiba.clase.servicio.utilidad.GenerarValor;
import com.ceiba.clase.servicio.utilidad.Tarifa;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.estudiante.modelo.dto.EstudianteDTO;
import com.ceiba.estudiante.modelo.entidad.Estudiante;
import com.ceiba.estudiante.puerto.dao.EstudianteDAO;
import com.ceiba.profesor.modelo.entidad.Profesor;
import com.ceiba.profesor.puerto.dao.ProfesorDAO;


public class CrearClaseServicio {

    private static final String LA_CLASE_YA_EXISTE_EN_EL_SISTEMA = "La clase ya se encuentra en el sistema";
    private static final String EL_ID_DEL_PROFESOR_NO_EXISTE_EN_EL_SISTEMA = "El id del profesor no se encuentra en el sistema";
    private static final String EL_ID_DEL_ESTUDIANTE_NO_EXISTE_EN_EL_SISTEMA = "El id del estudiante no se encuentra en el sistema";

    private final ClaseRepositorio claseRepositorio;

    private final EstudianteDAO estudianteDAO;
    private final ProfesorDAO profesorDAO;


    public CrearClaseServicio(ClaseRepositorio claseRepositorio, EstudianteDAO estudianteDAO, ProfesorDAO profesorDAO) {
        this.claseRepositorio = claseRepositorio;
        this.estudianteDAO = estudianteDAO;
        this.profesorDAO = profesorDAO;
    }

    public Long ejecutar(Clase clase) {
        esRepetido(clase);
        validarExistenciaProfesorEstudiante(clase.getProfesor(), clase.getEstudiante());
        EstudianteDTO estudianteDTO = estudianteDAO.obtener(clase.getEstudiante().getId());
        Double valorClase = GenerarValor.generarTotal(clase.getFecha(), !validarExistenciaPrevia(clase), Tarifa.generarTarifa(estudianteDTO.getNivelEstudios()));

        clase.setValor(valorClase);
        return this.claseRepositorio.crear(clase);
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

    private Boolean validarExistenciaPrevia(Clase clase) {
        return this.claseRepositorio.existe(clase);
    }

    private void esRepetido(Clase clase) {
        Boolean seRepitio = this.claseRepositorio.esRepetido(clase);

        if (seRepitio.booleanValue()) {
            throw new ExcepcionDuplicidad(LA_CLASE_YA_EXISTE_EN_EL_SISTEMA);
        }
    }


}
