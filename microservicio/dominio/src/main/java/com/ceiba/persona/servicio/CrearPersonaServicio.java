package com.ceiba.persona.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.persona.puerto.repositorio.PersonaRepositorio;


public class CrearPersonaServicio {
    private static final String LA_PERSONA_YA_EXISTE_EN_EL_SISTEMA = "La persona ya existe en el sistema";

    private final PersonaRepositorio personaRepositorio;

    public CrearPersonaServicio(PersonaRepositorio personaRepositorio) {
        this.personaRepositorio = personaRepositorio;
    }

    public Long ejecutar(Persona persona) {
        validarExistenciaPrevia(persona);
        return this.personaRepositorio.crear(persona);
    }

    private void validarExistenciaPrevia(Persona persona) {
        boolean existe = this.personaRepositorio.existe(persona.getCedula());
        if(existe) {
            throw new ExcepcionDuplicidad(LA_PERSONA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
