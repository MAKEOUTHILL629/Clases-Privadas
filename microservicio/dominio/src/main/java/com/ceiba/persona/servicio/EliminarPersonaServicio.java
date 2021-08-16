package com.ceiba.persona.servicio;

import com.ceiba.persona.puerto.repositorio.PersonaRepositorio;

public class EliminarPersonaServicio {
    private final PersonaRepositorio personaRepositorio;

    public EliminarPersonaServicio(PersonaRepositorio personaRepositorio) {
        this.personaRepositorio = personaRepositorio;
    }

    public void ejecutar(Long id) {
        this.personaRepositorio.eliminar(id);
    }
}
