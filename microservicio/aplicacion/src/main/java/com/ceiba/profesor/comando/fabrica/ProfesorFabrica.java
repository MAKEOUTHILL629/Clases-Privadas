package com.ceiba.profesor.comando.fabrica;

import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.profesor.comando.comando.ProfesorComandoActualizar;
import com.ceiba.profesor.comando.comando.ProfesorComandoCrear;
import com.ceiba.profesor.modelo.entidad.Profesor;
import org.springframework.stereotype.Component;

@Component
public class ProfesorFabrica {
    public Profesor crear(ProfesorComandoCrear profesorComandoCrear) {

        return new Profesor(
                new Persona(profesorComandoCrear.getIdPersona()),
                profesorComandoCrear.getProfesion()
        );
    }

    public Profesor crear(ProfesorComandoActualizar profesorComandoActualizar, Long id) {
        Profesor profesor = new Profesor(profesorComandoActualizar.getProfesion());
        profesor.setId(id);
        return profesor;

    }
}
