package com.ceiba.estudiante.servicio;


import com.ceiba.dominio.excepcion.ExcepcionDatoNoEncontrado;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.estudiante.modelo.entidad.Estudiante;
import com.ceiba.estudiante.puerto.dao.EstudianteDAO;
import com.ceiba.estudiante.puerto.repositorio.EstudianteRepositorio;
import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.persona.puerto.dao.PersonaDAO;


public class ActualizarEstudianteServicio {
    private static final String EL_ESTUDIANTE_NO_EXISTE_EN_EL_SISTEMA = "El estudiante no existe en el sistema";
    private static final String LA_PERSONA_NO_EXISTE_EN_EL_SISTEMA = "La persona no existe en el sistema";

    private final EstudianteRepositorio repositorio;
    private final PersonaDAO personaDAO;

    public ActualizarEstudianteServicio(EstudianteRepositorio repositorio, PersonaDAO personaDAO) {
        this.repositorio = repositorio;
        this.personaDAO = personaDAO;
    }

    public void ejecutar(Estudiante estudiante) {
        validarExistenciaPrevia(estudiante);
        validarExistenciaPersona(estudiante.getPersona());
        this.repositorio.actualizar(estudiante);

    }

    private void validarExistenciaPersona(Persona persona) {
        boolean existePersona = personaDAO.obtener(persona.getId()) != null;
        if (!existePersona) {
            throw new ExcepcionDatoNoEncontrado(LA_PERSONA_NO_EXISTE_EN_EL_SISTEMA);
        }
    }

    private void validarExistenciaPrevia(Estudiante estudiante) {
        boolean existe = repositorio.existeConIdEstudiante(estudiante.getId());
        if (!existe) {
            throw new ExcepcionDatoNoEncontrado(EL_ESTUDIANTE_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
