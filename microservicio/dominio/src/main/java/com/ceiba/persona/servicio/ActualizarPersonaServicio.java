package com.ceiba.persona.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.persona.puerto.repositorio.PersonaRepositorio;
import com.ceiba.usuario.modelo.entidad.Usuario;

public class ActualizarPersonaServicio {
    private static final String LA_PERSONA_NO_EXISTE_EN_EL_SISTEMA = "La persona no existe en el sistema";

    private final PersonaRepositorio personaRepositorio;

    public ActualizarPersonaServicio(PersonaRepositorio personaRepositorio) {
        this.personaRepositorio = personaRepositorio;
    }

    public void ejecutar(Persona persona){
        validarExistenciaPrevia(persona);
        this.personaRepositorio.actualizar(persona);
    }


    private void validarExistenciaPrevia(Persona persona) {
        boolean existe = this.personaRepositorio.existeExcluyendoId(persona.getId());
        if(existe) {
            throw new ExcepcionDuplicidad(LA_PERSONA_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
