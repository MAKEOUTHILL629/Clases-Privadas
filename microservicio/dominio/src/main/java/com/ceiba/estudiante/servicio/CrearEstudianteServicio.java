package com.ceiba.estudiante.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.estudiante.modelo.entidad.Estudiante;
import com.ceiba.estudiante.puerto.repositorio.EstudianteRepositorio;
import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.persona.puerto.dao.PersonaDAO;

public class CrearEstudianteServicio {
    private static final String EL_ESTUDIANTE_YA_EXISTE_EN_EL_SISTEMA = "El estudiante ya existe en el sistema";
    private static final String EL_ID_DE_LA_PERSONA_NO_EXISTE_EN_EL_SISTEMA = "El id de la persona no se encuentra en el sistema";

    private final EstudianteRepositorio estudianteRepositorio;
    private final PersonaDAO personaDAO;

    public CrearEstudianteServicio(EstudianteRepositorio estudianteRepositorio, PersonaDAO personaDAO) {
        this.estudianteRepositorio = estudianteRepositorio;
        this.personaDAO = personaDAO;
    }

    public Long ejecutar(Estudiante estudiante) {
        validarExistenciaPrevia(estudiante);
        validarExistenciaPersona(estudiante.getPersona());
        return this.estudianteRepositorio.crear(estudiante);
    }

    private void validarExistenciaPersona(Persona persona) {
        boolean existePersona = personaDAO.existe(persona.getId());
        if (!existePersona) {
            throw new ExcepcionSinDatos(EL_ID_DE_LA_PERSONA_NO_EXISTE_EN_EL_SISTEMA);
        }
    }


    private void validarExistenciaPrevia(Estudiante estudiante) {
        boolean existe = estudianteRepositorio.existeConIdPersona(estudiante.getPersona().getId());

        if (existe) {
            throw new ExcepcionDuplicidad(EL_ESTUDIANTE_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
