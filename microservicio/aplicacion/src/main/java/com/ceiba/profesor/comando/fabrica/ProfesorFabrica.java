package com.ceiba.profesor.comando.fabrica;

import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.profesor.comando.ProfesorComando;
import com.ceiba.profesor.modelo.entidad.Profesor;

public class ProfesorFabrica {
    public Profesor crear(ProfesorComando comando){

        return new Profesor(
                comando.getId(),
                new Persona(comando.getIdPersona()),
                comando.getProfesion()
        );
    }
}
