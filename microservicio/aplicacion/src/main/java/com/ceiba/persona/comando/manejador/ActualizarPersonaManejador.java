package com.ceiba.persona.comando.manejador;


import com.ceiba.persona.comando.PersonaComando;
import com.ceiba.persona.comando.fabrica.PersonaFabrica;
import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.persona.servicio.ActualizarPersonaServicio;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ActualizarPersonaManejador {

    private final PersonaFabrica personaFabrica;
    private final ActualizarPersonaServicio actualizarPersonaServicio;

    public ActualizarPersonaManejador(PersonaFabrica personaFabrica, ActualizarPersonaServicio actualizarPersonaServicio) {
        this.personaFabrica = personaFabrica;
        this.actualizarPersonaServicio = actualizarPersonaServicio;
    }

    @Transactional
    public void ejecutar(PersonaComando personaComando, Long id) {
        Persona persona = this.personaFabrica.crear(personaComando, id);
        this.actualizarPersonaServicio.ejecutar(persona);

    }
}
