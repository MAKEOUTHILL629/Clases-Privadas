package com.ceiba.profesor.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.persona.puerto.dao.PersonaDAO;
import com.ceiba.profesor.modelo.entidad.Profesor;
import com.ceiba.profesor.puerto.repositorio.ProfesorRepositorio;

public class CrearProfesorServicio {
    private static final String EL_PROFESOR_YA_EXISTE_EN_EL_SISTEMA = "El profesor ya existe en el sistema";
    private static final String EL_ID_DE_LA_PERSONA_NO_EXISTE_EN_EL_SISTEMA = "El id de la persona no se encuentra en el sistema";

    private final ProfesorRepositorio profesorRepositorio;
    private final PersonaDAO personaDAO;

    public CrearProfesorServicio(ProfesorRepositorio profesorRepositorio, PersonaDAO personaDAO) {
        this.profesorRepositorio = profesorRepositorio;
        this.personaDAO = personaDAO;
    }

    public Long ejecutar(Profesor profesor) {
        validarExistenciaPrevia(profesor);
        validarExistenciaPersona(profesor.getPersona());
        return this.profesorRepositorio.crear(profesor);
    }

    private void validarExistenciaPersona(Persona persona) {
        boolean existePersona = personaDAO.existe(persona.getId());
        if (!existePersona) {
            throw new ExcepcionSinDatos(EL_ID_DE_LA_PERSONA_NO_EXISTE_EN_EL_SISTEMA);
        }
    }

    private void validarExistenciaPrevia(Profesor profesor) {
        boolean existe = this.profesorRepositorio.existeConIdPersona(profesor.getPersona().getId());

        if (existe) {
            throw new ExcepcionDuplicidad(EL_PROFESOR_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

}
