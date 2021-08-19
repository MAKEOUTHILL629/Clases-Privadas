package com.ceiba.persona.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.persona.comando.PersonaComando;
import com.ceiba.persona.comando.fabrica.PersonaFabrica;
import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.persona.servicio.CrearPersonaServicio;

import org.springframework.stereotype.Component;

@Component
public class CrearPersonaManejador implements ManejadorComandoRespuesta<PersonaComando, ComandoRespuesta<Long>> {

    private final PersonaFabrica personaFabrica;
    private final CrearPersonaServicio crearPersonaServicio;

    public CrearPersonaManejador(PersonaFabrica personaFabrica, CrearPersonaServicio crearPersonaServicio) {
        this.personaFabrica = personaFabrica;
        this.crearPersonaServicio = crearPersonaServicio;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(PersonaComando personaComando) {
        Persona persona = this.personaFabrica.crear(personaComando);
        return new ComandoRespuesta<>(this.crearPersonaServicio.ejecutar(persona));
    }
}
