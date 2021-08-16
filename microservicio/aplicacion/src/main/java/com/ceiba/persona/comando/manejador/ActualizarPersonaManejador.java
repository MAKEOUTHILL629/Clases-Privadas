package com.ceiba.persona.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.persona.comando.PersonaComando;
import com.ceiba.persona.comando.fabrica.PersonaFabrica;
import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.persona.servicio.ActualizarPersonaServicio;
import org.springframework.stereotype.Component;

@Component
public class ActualizarPersonaManejador implements ManejadorComando<PersonaComando> {

    private final PersonaFabrica personaFabrica;
    private final ActualizarPersonaServicio actualizarPersonaServicio;

    public ActualizarPersonaManejador(PersonaFabrica personaFabrica, ActualizarPersonaServicio actualizarPersonaServicio) {
        this.personaFabrica = personaFabrica;
        this.actualizarPersonaServicio = actualizarPersonaServicio;
    }

    @Override
    public void ejecutar(PersonaComando comando) {
        Persona persona = this.personaFabrica.crear(comando);
        this.actualizarPersonaServicio.ejecutar(persona);

    }
}
