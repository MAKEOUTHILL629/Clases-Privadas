package com.ceiba.persona.comando.fabrica;

import com.ceiba.persona.comando.PersonaComando;
import com.ceiba.persona.modelo.entidad.Persona;
import org.springframework.stereotype.Component;

@Component
public class PersonaFabrica {

    public Persona crear(PersonaComando personaComando, Long id) {
        Persona persona = this.crear(personaComando);
        persona.setId(id);
        return persona;
    }

    public Persona crear(PersonaComando personaComando) {
        return new Persona(
                personaComando.getNombres(),
                personaComando.getApellidos(),
                personaComando.getCedula()
        );
    }
}
