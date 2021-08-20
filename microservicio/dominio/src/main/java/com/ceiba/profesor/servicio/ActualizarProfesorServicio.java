package com.ceiba.profesor.servicio;


import com.ceiba.dominio.excepcion.ExcepcionDatoNoEncontrado;
import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.persona.puerto.dao.PersonaDAO;
import com.ceiba.profesor.modelo.entidad.Profesor;
import com.ceiba.profesor.puerto.repositorio.ProfesorRepositorio;

public class ActualizarProfesorServicio {
    private static final String EL_PROFESOR_NO_EXISTE_EN_EL_SISTEMA = "El profesor no existe en el sistema";
    private static final String LA_PERSONA_NO_EXISTE_EN_EL_SISTEMA = "La persona no existe en el sistema";
    private final ProfesorRepositorio profesorRepositorio;
    private final PersonaDAO personaDAO;

    public ActualizarProfesorServicio(ProfesorRepositorio profesorRepositorio, PersonaDAO personaDAO) {
        this.profesorRepositorio = profesorRepositorio;
        this.personaDAO = personaDAO;
    }

    public void ejecutar(Profesor profesor) {
        validarExistenciaPrevia(profesor);
        validarExistenciaPersona(profesor.getPersona());
        this.profesorRepositorio.actualizar(profesor);
    }

    private void validarExistenciaPersona(Persona persona) {
        boolean existePersona = personaDAO.existe(persona.getId());
        if (!existePersona) {
            throw new ExcepcionDatoNoEncontrado(LA_PERSONA_NO_EXISTE_EN_EL_SISTEMA);
        }
    }

    private void validarExistenciaPrevia(Profesor profesor) {
        boolean existe = this.profesorRepositorio.existeConIdProfesor(profesor.getId());
        if (!existe) {
            throw new ExcepcionDatoNoEncontrado(EL_PROFESOR_NO_EXISTE_EN_EL_SISTEMA);
        }
    }

}
